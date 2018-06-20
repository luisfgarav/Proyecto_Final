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
import com.example.ppc.proyecto_final.adapters.RecyclerViewAdapter;
import com.example.ppc.proyecto_final.model.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductosAc extends AppCompatActivity {

    private final String JSON_URL = "http://192.168.10.101/Proyecto/Consulta_producto.php";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Producto> lstProducto;
    private RecyclerView recyclerView;
    public String producto_clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        getSupportActionBar().hide();

        lstProducto=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerviewid);
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
                        Producto producto=new Producto();
                        producto.setNombre(jsonObject.getString("nombre"));
                        if(jsonObject.getString("disponibilidad").toString()=="N"){
                            producto.setDisponibilidad("No disponible");
                        }else{
                            producto.setDisponibilidad("Disponible");
                        }
                        producto_clave=jsonObject.getString("clave").toString();
                        producto.setClave(producto_clave);
                        producto.setCategoria(jsonObject.getString("categoria"));
                        producto.setImagen(jsonObject.getString("imagen"));
                        lstProducto.add(producto);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstProducto);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(ProductosAc.this);
        requestQueue.add(request);


    }

    private void setuprecyclerview(List<Producto> lstProducto) {

        RecyclerViewAdapter myadapter=new RecyclerViewAdapter(this,lstProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}