package com.example.practicapayphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainStore extends AppCompatActivity {

    RecyclerView recyclerView;
    RequestQueue rq;
    ArrayList<c_Items> lstItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_store);
        rq = Volley.newRequestQueue(this);
        handleSSLHandshake();
        jsonObjectRequest();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }



    private void jsonObjectRequest(){
        //Bundle bundle = this.getIntent().getExtras();

        String URL1 ="https://my-json-server.typicode.com/ijeysonU/bd_item/db";
        System.out.println(URL1);
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL1,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            int resId = R.anim.layout_animation_down_to_up;
                            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                                    resId);
                            recyclerView.setLayoutAnimation(animation);
                            lstItems = c_Items.JsonObjectsBuild(jsonArray);
                            adaptador_items adaptador_items = new adaptador_items(MainStore.this, lstItems);
                            recyclerView.setAdapter(adaptador_items);
                            adaptador_items.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String vItem = lstItems.get(recyclerView.getChildAdapterPosition(v)).getItem();
                                    String vPrecio = lstItems.get(recyclerView.getChildAdapterPosition(v)).getPrecio().toString();
                                    String vUrlImagen = lstItems.get(recyclerView.getChildAdapterPosition(v)).getImgURL();
                                    Intent intent = new Intent(MainStore.this, item_Comprar.class);
                                    Bundle b = new Bundle();
                                    b.putString("vItem", vItem);
                                    b.putString("vUrlImagen", vUrlImagen);
                                    b.putString("vPrecio", vPrecio);
                                    //Añadimos la información al intent
                                    intent.putExtras(b);
                                    // Iniciamos la nueva actividad
                                    startActivity(intent);
                                }
                            });
                            //lstOpcionesIn = (ListView)findViewById(R.id.lstOpciones);
                            //View header = getLayoutInflater().inflate(R.layout.activity_main, null);
                            //lstOpcionesIn.addHeaderView(header);

                            //adaptador_evaluadores ae = new adaptador_evaluadores(MainActivity.this, lstEval);
                            System.out.println("Data: "+lstItems);
                            //lstOpcionesIn.setAdapter(ae);
                            //System.out.println(jsonArray);
                        }catch (JSONException ex){
                            System.out.println("Error: "+ex.toString());
                            //Toast.makeText(ex.getMessage(),Toast.LENGTH_LONG);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error: "+error.toString());
            }
        }
        );

        rq.add(jsonArrayRequest);
    }

    @SuppressLint("TrulyRandom")
    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }
}

