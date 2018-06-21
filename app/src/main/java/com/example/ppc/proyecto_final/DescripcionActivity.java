package com.example.ppc.proyecto_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ppc.proyecto_final.adapters.RecyclerViewAdapter2;
import com.example.ppc.proyecto_final.model.Descripcion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DescripcionActivity extends AppCompatActivity {

    private final String JSON_URL="http://192.168.10.101/Proyecto/Consulta_detalle.php?clave=1";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Descripcion> lstDescripcion;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        lstDescripcion=new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerviewid2);
        jsonrequest();
    }

    private void jsonrequest() {

        request=new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject=null;

                for(int i=0;i<response.length();i++){

                    try{
                        jsonObject=response.getJSONObject(i);
                        Descripcion descripcion=new Descripcion();
                        descripcion.setProducto(jsonObject.getString("producto"));
                        descripcion.setCantidad(jsonObject.getString("cantidad"));
                        descripcion.setSubtotal(jsonObject.getString("subtotal"));
                        descripcion.setUbicacion(jsonObject.getString("ubicacion"));
                        descripcion.setPrecio_producto(jsonObject.getString("precio_producto"));
                        descripcion.setClave(jsonObject.getString("clave"));

                        lstDescripcion.add(descripcion);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setuprecyclerview(lstDescripcion);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(DescripcionActivity.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<Descripcion> lstDescripcion) {

        RecyclerViewAdapter2 myadapter=new RecyclerViewAdapter2(this,lstDescripcion);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);

    }
}
