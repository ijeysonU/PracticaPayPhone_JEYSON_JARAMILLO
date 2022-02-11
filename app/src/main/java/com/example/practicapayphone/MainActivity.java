package com.example.practicapayphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login()
    {
        TextView us = (TextView)findViewById(R.id.txtUsuario);
        TextView ps = (TextView)findViewById(R.id.txtPass);

    }
}