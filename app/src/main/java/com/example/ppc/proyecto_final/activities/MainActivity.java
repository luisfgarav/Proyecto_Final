package com.example.ppc.proyecto_final.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.example.ppc.proyecto_final.PerfilActivity;
import com.example.ppc.proyecto_final.ProductosAc;
import com.example.ppc.proyecto_final.R;


public class MainActivity extends AppCompatActivity {
    public Button bperfil, bproductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bperfil=(Button)findViewById(R.id.BotonPerfil);
        bproductos=(Button)findViewById(R.id.BotonProductos);
        bperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent segunda= new Intent(MainActivity.this,PerfilActivity.class);
                startActivity(segunda);
            }
        });

        bproductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tercera= new Intent(MainActivity.this,ProductosAc.class);
                startActivity(tercera);
            }
        });


    }
}