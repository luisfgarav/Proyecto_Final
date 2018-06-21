package com.example.ppc.proyecto_final;

import android.content.Intent;
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
import com.example.ppc.proyecto_final.activities.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class PedidoActivity extends AppCompatActivity {
    TextView tvfecha_e,tvfecha_l,tvtotal,tvfecha_p;
    Button btdetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        tvfecha_e=(TextView)findViewById(R.id.apedidosfechae);
        tvfecha_l=(TextView)findViewById(R.id.apedidosfechal);
        tvfecha_p=(TextView)findViewById(R.id.apedidosfechac);
        tvtotal=(TextView)findViewById(R.id.apedidostotal);
        btdetalle=(Button)findViewById(R.id.BotonDetalles1);

        String url  = "http://192.168.10.101/Proyecto/Consulta_pedido_fechacompra.php?clave=1";
        JsonObjectRequest peticion = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String pfechap=response.getString("fecha_compra");
                            tvfecha_p.setText("Fecha de compra: "+pfechap);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PedidoActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue x= Volley. newRequestQueue(PedidoActivity.this);
        x.add(peticion);

        String url2  = "http://192.168.10.101/Proyecto/Consulta_pedido_fechaenvio.php?clave=1";
        JsonObjectRequest peticion2 = new JsonObjectRequest(
                Request.Method.GET,
                url2,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String pfechae=response.getString("fecha_envio");
                            tvfecha_e.setText("Fecha de envio: "+pfechae);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PedidoActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion2);

        String url3  = "http://192.168.10.101/Proyecto/Consulta_pedido_total.php?clave=1";
        JsonObjectRequest peticion3 = new JsonObjectRequest(
                Request.Method.GET,
                url3,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String ptotal=response.getString("total");
                            tvtotal.setText("Total: "+ptotal);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PedidoActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion3);

        btdetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent segunda= new Intent(PedidoActivity.this,DescripcionActivity.class);
                startActivity(segunda);
            }
        });
    }
}
