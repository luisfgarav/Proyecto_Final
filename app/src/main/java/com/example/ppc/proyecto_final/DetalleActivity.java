package com.example.ppc.proyecto_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ppc.proyecto_final.R;
import com.example.ppc.proyecto_final.model.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DetalleActivity extends AppCompatActivity {
    public TextView tvproveedor,tvestado,tvprecio;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    public Button btComprar;
    String precio_p,clave,clave_provicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().hide();


        clave=getIntent().getExtras().getString("Producto_clave");

        tvproveedor=findViewById(R.id.proveedor);
        tvestado=findViewById(R.id.estado);
        tvprecio=findViewById(R.id.precio);
        btComprar=findViewById(R.id.comprar);


        String url  = "http://192.168.10.101/Proyecto/Consulta_provicion.php?clave="+clave;
        JsonObjectRequest peticion = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String aproveedor=response.getString("proveedor");
                            tvproveedor.setText("Proveedor: "+aproveedor);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetalleActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue x= Volley. newRequestQueue(DetalleActivity.this);
        x.add(peticion);
        String url2  = "http://192.168.10.101/Proyecto/Consulta_provicion_estado.php?clave="+clave;
        JsonObjectRequest peticion2 = new JsonObjectRequest(
                Request.Method.GET,
                url2,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String aestado=response.getString("estado");
                            tvestado.setText("Estado: "+aestado);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetalleActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue x2= Volley. newRequestQueue(DetalleActivity.this);
        x2.add(peticion2);
        String url3  = "http://192.168.10.101/Proyecto/Consulta_provicion_precio.php?clave="+clave;
        JsonObjectRequest peticion3 = new JsonObjectRequest(
                Request.Method.GET,
                url3,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String aprecio=response.getString("precio");
                            tvprecio.setText("Precio:  $"+aprecio);
                            precio_p=aprecio;
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetalleActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue x3= Volley. newRequestQueue(DetalleActivity.this);
        x3.add(peticion3);

        String url5  = "http://192.168.10.101/Proyecto/Consulta_provicion_clave.php?clave="+clave;
        JsonObjectRequest peticion5 = new JsonObjectRequest(
                Request.Method.GET,
                url5,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String aclave=response.getString("clave");
                            clave_provicion=aclave;
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetalleActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue x5= Volley. newRequestQueue(DetalleActivity.this);
        x5.add(peticion5);

        btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url4  = "http://192.168.10.101/Proyecto/Insertar_detalle.php?clave_producto="+clave_provicion+"&cantidad=1&precio_producto="+precio_p;
                JsonObjectRequest peticion4 = new JsonObjectRequest(
                        Request.Method.GET,
                        url4,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DetalleActivity.this,"Objeto agregado a pedido", Toast.LENGTH_LONG).show();
                    }
                }
                );
                RequestQueue x4= Volley. newRequestQueue(DetalleActivity.this);
                x4.add(peticion4);
            }
        });


    }

}




