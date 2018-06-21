package com.example.ppc.proyecto_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class ActualizarActivity extends AppCompatActivity {
    EditText etnombre,etapellido,etcelular,etdireccion,etimagen,etsexo;
    Button btaceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        etnombre=(EditText)findViewById(R.id.dnombre);
        etapellido=(EditText)findViewById(R.id.dapellido);
        etcelular=(EditText)findViewById(R.id.dcelular);
        etdireccion=(EditText)findViewById(R.id.ddireccion);
        etimagen=(EditText)findViewById(R.id.dimagen);
        etsexo=(EditText)findViewById(R.id.dsexo);
        btaceptar=(Button)findViewById(R.id.dboton);

        btaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url  = "http://192.168.10.101/Proyecto/Actualizar_cliente_nombre.php?nombre="+etnombre.getText().toString();
                JsonObjectRequest peticion = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActualizarActivity.this,"Perfil actualizado", Toast.LENGTH_LONG).show();
                    }
                }
                );
                RequestQueue x= Volley. newRequestQueue(ActualizarActivity.this);
                x.add(peticion);

                String url2  = "http://192.168.10.101/Proyecto/Actualizar_cliente_apellido.php?apellido="+etapellido.getText().toString();
                JsonObjectRequest peticion2 = new JsonObjectRequest(
                        Request.Method.GET,
                        url2,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );
                x.add(peticion2);

                String url3  = "http://192.168.10.101/Proyecto/Actualizar_cliente_celular.php?celular="+etcelular.getText().toString();
                JsonObjectRequest peticion3 = new JsonObjectRequest(
                        Request.Method.GET,
                        url3,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );
                x.add(peticion3);

                String url4  = "http://192.168.10.101/Proyecto/Actualizar_cliente_imagen.php?imagen="+etimagen.getText().toString();
                JsonObjectRequest peticion4 = new JsonObjectRequest(
                        Request.Method.GET,
                        url4,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );
                x.add(peticion4);

                String url5  = "http://192.168.10.101/Proyecto/Actualizar_cliente_sexo.php?sexo="+etsexo.getText().toString();
                JsonObjectRequest peticion5 = new JsonObjectRequest(
                        Request.Method.GET,
                        url5,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );
                x.add(peticion5);

                String url6  = "http://192.168.10.101/Proyecto/Actualizar_cliente_direccion.php?direccion="+etdireccion.getText().toString();
                JsonObjectRequest peticion6 = new JsonObjectRequest(
                        Request.Method.GET,
                        url6,
                        null,
                        null
                        ,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );
                x.add(peticion6);
            }
        });
    }
}
