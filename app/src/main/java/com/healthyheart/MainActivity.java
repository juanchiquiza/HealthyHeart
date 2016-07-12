package com.healthyheart;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.healthyheart.ConexionBD.AdministradorBase;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nom,con;
    Button ingresar;
    String usuario,contrasena;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String AUTENTICADO = "autenticado" ;
    public static final String USUARIO = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=(EditText)findViewById(R.id.nombre);
        con=(EditText)findViewById(R.id.contrasena);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(AUTENTICADO, "false");
        editor.commit();

        SharedPreferences.Editor editorusuario = sharedpreferences.edit();
        editorusuario.putString(USUARIO, "false");
        editorusuario.commit();
        showDialogButtonClick();
    }

    public void showDialogButtonClick(){

       ingresar = (Button)findViewById(R.id.BotonPasar);
        ingresar.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v) {
                    //    Intent i = new Intent(MainActivity.this, pruebaActivity.class);
                    //    startActivity(i);

                        if (nom.getText().toString().equals("") || con.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                        } else{
                        AdministradorBase admin = new AdministradorBase(MainActivity.this, "BD", null, 1);
                        SQLiteDatabase bd = admin.getWritableDatabase();
                        usuario = nom.getText().toString();
                        contrasena = con.getText().toString();
                        Cursor fila = bd.rawQuery("select contrasena,usuario from username where contrasena='" + contrasena +
                                "' and usuario='" + usuario + "'", null);

                        if (fila.moveToFirst()) {
                            Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, NavigationActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(MainActivity.this, "No esta registrado", Toast.LENGTH_SHORT).show();

                            bd.close();
                        }
                    }
                    }
                }
        );
    }


  /*  public void ingresar(View v) throws IOException, JSONException {

        HttpClient cl =new DefaultHttpClient();

        HttpPost p = new HttpPost("http://tensionarterial.webcindario.com/login.php");

        List<NameValuePair> datos = new ArrayList<NameValuePair>();
        datos.add(new BasicNameValuePair("usuario", nom.getText().toString()));
        datos.add(new BasicNameValuePair("contrasena", con.getText().toString()));
        p.setEntity(new UrlEncodedFormEntity(datos));
        HttpResponse r = cl.execute(p);
        HttpEntity e = r.getEntity();
        String msn = EntityUtils.toString(e, "UTF-8");
        JSONArray j= new JSONArray(msn);
        if(j.length()==0){
            Toast.makeText(this, "No esta registrado", Toast.LENGTH_SHORT).show();
        }else{

            SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(AUTENTICADO, "true");
            editor.putString(USUARIO,  nom.getText().toString());
            editor.commit();

            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, NavigationActivity.class );
            startActivity(i);

        }

    }*/

    public void Registrarse(View view) {
        Intent i = new Intent(this, RegistroUsuarioActivity.class );
        startActivity(i);
    }
}
