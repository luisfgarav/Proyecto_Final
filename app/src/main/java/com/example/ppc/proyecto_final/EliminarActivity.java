package com.example.ppc.proyecto_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class EliminarActivity extends AppCompatActivity {
    TextView tvproducto,tvsubtotal;
    Button bteliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);


        final String clave=getIntent().getExtras().getString("clave");
        String producto=getIntent().getExtras().getString("producto");
        String subtotal=getIntent().getExtras().getString("subtotal");

        tvproducto=(TextView)findViewById(R.id.ElProducto);
        tvsubtotal=(TextView)findViewById(R.id.ElSubtotal);
        bteliminar=(Button)findViewById(R.id.BtEliminar);

        tvproducto.setText("  Producto:  "+producto);
        tvsubtotal.setText("  Subtotal:  "+subtotal);

        bteliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url  = "http://192.168.10.101/Proyecto/Eliminar_detalle.php?clave="+clave;
                JsonObjectRequest peticion = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EliminarActivity.this,"Producto eliminado", Toast.LENGTH_LONG).show();
                    }
                }
                );
                RequestQueue x= Volley. newRequestQueue(EliminarActivity.this);
                x.add(peticion);
                finish();

            }
        });

    }
}
