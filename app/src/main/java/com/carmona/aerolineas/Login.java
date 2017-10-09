package com.carmona.aerolineas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.onClick;

public class Login extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    private RequestQueue qSolicitudes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEntrar)
    public void clickValido(){
        valUsuarioRequest();
    }

    @Override
    protected void onStart() {
        super.onStart();
        qSolicitudes = Volley.newRequestQueue(this);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,error.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        try{
            String token = response.getString("token");
            if(!token.equals("Sesion no valida")){
                Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show();
                Intent intDash = new Intent(this,Dashboard.class);
                startActivity(intDash);
            }else{
                Toast.makeText(this,"Acceso no valido",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }

    }

    private void valUsuarioRequest() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nomusr","rubensin");
            jsonObject.put("passuser","Elpass");
        }catch (JSONException e){
            Log.e("Error",e.toString());
        }

        String URL = "http://192.168.43.183:8080/PATM17A/apirest/usuario/validar/rubensin/hola";
        JsonObjectRequest solValCte = new JsonObjectRequest(Request.Method.POST,URL,jsonObject,this,this){
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(
                        "Authorization",
                        String.format("Basic %s", Base64.encodeToString(
                                String.format("%s:%s", "root", "root").getBytes(), Base64.DEFAULT)));
                return params;
            }

        };
        qSolicitudes.add(solValCte);

    }
}
