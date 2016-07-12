package com.healthyheart.Usuario;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.healthyheart.ConexionBD.AdministradorBase;
import com.healthyheart.MainActivity;
import com.healthyheart.Model.UsuarioModel;
import com.healthyheart.RegistroUsuarioActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by juank on 10/06/2016.
 */
public class UsuarioConsultas {

    public String GuardarUsuario(UsuarioModel user,AdministradorBase admin) {

            String Resultado="Se guardo exitosamente";
            SQLiteDatabase bd = admin.getWritableDatabase();

            ContentValues registro = new ContentValues();
        //    registro.put("usuario", String.valueOf(user.getIdentificacion()));
            registro.put("usuario", user.getNombre());
            registro.put("contrasena", user.getContrasena());
        //    registro.put("telefono", tel);
            bd.insert("username", null, registro);
            bd.close();


        return Resultado;
    }



    }


      /*  String Resultado = "";

            AdministradorBase admin = new AdministradorBase(UsuarioConsultas.this, "BD", null, 1);
                        SQLiteDatabase bd = admin.getWritableDatabase();
                        String user = "juan";
                        String nom = "123";

                        ContentValues registro = new ContentValues();
                        registro.put("usuario", user);
                        registro.put("contrasena", nom);

                        bd.insert("username", null, registro);
                        bd.close();

                        Toast.makeText(MainActivity.this, "Se cargaron los datos",Toast.LENGTH_SHORT).show();
*/

    /*    try{
        HttpClient cl = new DefaultHttpClient();

        HttpPost p = new HttpPost("http://tensionarterial.webcindario.com/RegistroUsuario.php");

        String fecha_creacion = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        List<NameValuePair> datos = new ArrayList<NameValuePair>();

        datos.add(new BasicNameValuePair("identificacion", String.valueOf(user.getIdentificacion())));
        datos.add(new BasicNameValuePair("nombre", user.getNombre()));
        datos.add(new BasicNameValuePair("apellido", user.getApellido()));
        datos.add(new BasicNameValuePair("telefono", String.valueOf(user.getTelefono())));
        datos.add(new BasicNameValuePair("direccion", user.getDireccion()));
        datos.add(new BasicNameValuePair("medicado", user.getMedicado()));
        datos.add(new BasicNameValuePair("peso", String.valueOf(user.getPeso())));
        datos.add(new BasicNameValuePair("talla", String.valueOf(user.getTalla())));
        datos.add(new BasicNameValuePair("masacorporal", user.getIndiceMasaCorproral()));
        datos.add(new BasicNameValuePair("contrasena", user.getContrasena()));
        datos.add(new BasicNameValuePair("fecha_creacion", fecha_creacion));


        p.setEntity(new UrlEncodedFormEntity(datos));
        HttpResponse r = cl.execute(p);
        HttpEntity e = r.getEntity();
        String msn = EntityUtils.toString(e, "UTF-8");

        if (!msn.equals("error")) {
            Resultado = "Registro Exitoso";
        } else {
            Resultado = "No se pudo guardar registro";
        }

        } catch(IOException e) {
        }// catch(JSONException e) {*/
    //    return Resultado;
   // }
//}
