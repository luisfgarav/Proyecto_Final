package com.example.ppc.proyecto_final;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ppc.proyecto_final.activities.MainActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class PerfilActivity extends AppCompatActivity {
    TextView tvnombre,tvapellido,tvsexo,tvcelular,tvmunicipio,tvdireccion;
    ImageView ivperfil;
    Button btActualizar,btPedidos;
    String aimagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tvnombre=(TextView)findViewById(R.id.perfilnombre);
        tvapellido=(TextView)findViewById(R.id.perfilapellido);
        tvsexo=(TextView)findViewById(R.id.perfilsexo);
        tvcelular=(TextView)findViewById(R.id.perfilcelular);
        tvmunicipio=(TextView)findViewById(R.id.perfilmunicipio);
        tvdireccion=(TextView)findViewById(R.id.perfildireccion);
        btActualizar=(Button)findViewById(R.id.BotonActualizar);
        btPedidos=(Button)findViewById(R.id.BotonPedidos);
        ivperfil=(ImageView)findViewById(R.id.perfilimagen);


        String url  = "http://192.168.10.101/Proyecto/Consulta_cliente_nombre.php?clave=1";
        JsonObjectRequest peticion = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String anombre=response.getString("nombre");
                            tvnombre.setText("Nombre: "+anombre);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue x= Volley. newRequestQueue(PerfilActivity.this);
        x.add(peticion);

        String url2  = "http://192.168.10.101/Proyecto/Consulta_cliente_apellido.php?clave=1";
        JsonObjectRequest peticion2 = new JsonObjectRequest(
                Request.Method.GET,
                url2,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String aapellido=response.getString("apellido");
                            tvapellido.setText("Apellido: "+aapellido);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion2);

        String url3  = "http://192.168.10.101/Proyecto/Consulta_cliente_sexo.php?clave=1";
        JsonObjectRequest peticion3 = new JsonObjectRequest(
                Request.Method.GET,
                url3,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String asexo=response.getString("sexo");
                            tvsexo.setText("Sexo: "+asexo);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion3);

        String url4  = "http://192.168.10.101/Proyecto/Consulta_cliente_direccion.php?clave=1";
        JsonObjectRequest peticion4 = new JsonObjectRequest(
                Request.Method.GET,
                url4,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String adireccion=response.getString("direccion");
                            tvdireccion.setText("Direccion: "+adireccion);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion4);

        String url5  = "http://192.168.10.101/Proyecto/Consulta_cliente_celular.php?clave=1";
        JsonObjectRequest peticion5 = new JsonObjectRequest(
                Request.Method.GET,
                url5,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String acelular=response.getString("celular");
                            tvcelular.setText("Celular: "+acelular);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion5);

        String url6  = "http://192.168.10.101/Proyecto/Consulta_cliente_municipio.php?clave=1";
        JsonObjectRequest peticion6 = new JsonObjectRequest(
                Request.Method.GET,
                url6,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String amunicipio=response.getString("municipio");
                            tvmunicipio.setText("Municipio: "+amunicipio);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion6);

        String url7  = "http://192.168.10.101/Proyecto/Consulta_cliente_imagen.php?clave=1";
        JsonObjectRequest peticion7 = new JsonObjectRequest(
                Request.Method.GET,
                url7,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                                aimagen=response.getString("imagen");
                                Picasso.with(getApplicationContext()).load(aimagen).into(ivperfil);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }

                ,new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this,error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        x.add(peticion7);
        Picasso.with(getApplicationContext()).load(aimagen).into(ivperfil);

        btActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent segunda= new Intent(PerfilActivity.this,ActualizarActivity.class);
                startActivity(segunda);
            }
        });
    }
}
