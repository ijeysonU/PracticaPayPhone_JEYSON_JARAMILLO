package com.example.practicapayphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    c_Usuarios us = new c_Usuarios();
    public String cpais, ncel, ntar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(v);
            }
        });

    }

    public void Login(View view)
    {
        TextView us = (TextView)findViewById(R.id.txtUsuario);
        TextView ps = (TextView)findViewById(R.id.txtPass);

        new c_Usuarios().setcPais(findViewById(R.id.txtcPais).toString());
        new c_Usuarios().setnCelu(findViewById(R.id.txtnCelu).toString());
        new c_Usuarios().setnCelu(findViewById(R.id.txtnTarg).toString());
        validaDatosLogin(us.toString(), ps.toString());
    }

    public void validaDatosLogin(String usr, String pss){
        Intent intent = new Intent(this, MainStore.class);
        startActivity(intent);
    }

}