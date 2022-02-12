package com.example.practicapayphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class item_Comprar extends AppCompatActivity {

    String code, phone, idcard;
    String total;

    RequestQueue requestQueue;
    public JSONObject params = new JSONObject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_comprar);
        TextView itm = (TextView)findViewById(R.id.lblItem);
        TextView prc = (TextView)findViewById(R.id.txtPrecio);
        Bundle b = this.getIntent().getExtras();
        itm.setText(b.getString("vItem"));
        prc.setText(b.getString("vPrecio"));
        total = b.getString("vPrecio");
        try {
            Glide.with(this)
                    .load(b.getString("vUrlImagen"))
                    .error(R.drawable.unknown)
                    .into((ImageView)findViewById(R.id.ImgItem))

            ;//(Drawable("https://evaladmin.uteq.edu.ec/adminimg/unknown.png"));
        }catch(Exception ex){

        }
        Button btnPago = (Button)findViewById(R.id.btnComprar);
        btnPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postRequest();
            }
        });
    }
    public void getParams1() {
        int clientTransctID = (int) (100000 * Math.random());
        int v_total = Integer.parseInt(total)*100;
        int result_tax = 3;
        int amountWT = v_total - result_tax;
        try {
            params.put("phoneNumber", new c_Usuarios().getnCelu());//
            params.put("countryCode", new c_Usuarios().getcPais());//
            params.put("clientUserId", new c_Usuarios().getnTarg());//
            params.put("reference", "none");
            params.put("responseUrl", "http://paystoreCZ.com/confirm.php");
            params.put("amount", v_total);//
            params.put("amountWithTax", amountWT);
            params.put("amountWithoutTax", 0);
            params.put("tax", result_tax);
            params.put("clientTransactionId", clientTransctID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void postRequest() {
        getParams1();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pay.payphonetodoesposible.com/api/Sale";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Toast toast = Toast.makeText(getApplicationContext(), (CharSequence) response, Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                headers.put("Authorization", "Bearer kd3xX0KNHe51be_F80EofwOKwZNGKCdaf632f35oR9TWMi7FH8Y2WEslItAAkEnc2QkglBKH6AdSkjlQzhhdVhp15utSKzmR_y0lZsFTcscS7ApRGAhTA8w6NpZRhbnA7y8YpyQyghC1puwq8iMp5TRRFCjRQuhkONgN69B0-KWY-gNodGOTxK-OHnQVGxdol0LHjlmava7WvtwbQGR8UIhNoExaL9jvhzix06Snh1Kqkqm8-DJCqaRinxSUaHIB8wtxoXGNLfd36URmZuiHHJ2qMn68UYjbgzHVtcF3elCNGuM2Y_FW_d5Qg1r_tN0nXrsMDA");
                return headers;
            }
        };
        queue.add(jsonObjectRequest);
    }
}