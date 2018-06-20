package com.example.ppc.proyecto_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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
    public TextView tvclave,tvproveedor,tvestado,tvprecio;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().hide();


        String clave=getIntent().getExtras().getString("Producto_clave");
        tvclave=findViewById(R.id.clave);
        tvproveedor=findViewById(R.id.proveedor);
        tvestado=findViewById(R.id.estado);
        tvprecio=findViewById(R.id.precio);

        tvclave.setText(clave);

        String url  = "http://192.168.10.101/Proyecto/Consulta_provicion.php?clave=1";

        JsonObjectRequest peticion = new JsonObjectRequest
                (
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response)
                            {

                                try{
                                    String aproveedor= response.getString("proveedor");
                                    tvproveedor.setText(response.getString("proveedor"));
                                    String aestado= response.getString("estado_producto");
                                    tvestado.setText(aestado);
                                    String aprecio= response.getString("precio");
                                    tvprecio.setText(aprecio);

                                }catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // Qué hacer con el resultad
                                // El resultado viene en el objeto response
                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Mensaje de error
                    }
                });

        RequestQueue x = Volley.newRequestQueue(DetalleActivity.this); // creación de la petición
        x.add(peticion);


    }

}




