package com.healthyheart;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class pruebaActivity extends AppCompatActivity {



    TextView capitales;
    @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_prueba);

           // capitales = (TextView) findViewById(R.id.txt_capitales);

        conectadoWifi();
        if (conectadoWifi()){
            Toast.makeText(this, "Conexion a Interne Tu Dispositivo ", Toast.LENGTH_LONG).show();
             }else{
                Toast.makeText(this, "no hay internet ", Toast.LENGTH_LONG).show();
            }
        }


      public  boolean conectadoWifi(){
            ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (info != null) {
                    if (info.isConnected()) {
                        return true;
                        //  Toast.makeText(pruebaActivity.this, "Conexion a Interne Tu Dispositivo ", Toast.LENGTH_LONG).show();
                    }

                }   //  Toast.makeText(pruebaActivity.this, "no hay", Toast.LENGTH_LONG).show();

                }// Toast.makeText(pruebaActivity.this, "no hay", Toast.LENGTH_LONG).show(); }
                return false;

           }


        /* void conectadoRedMovil(){
            ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                if (info != null) {
                    if (info.isConnected()) {
                        Toast.makeText(pruebaActivity.this, "Conexion a Interne Tu Dispositivo ", Toast.LENGTH_LONG).show();
                      //  return true;
                    }
                }
            }
           // return false;
            Toast.makeText(pruebaActivity.this, "Conexion a Interne Tu Dispositivo ", Toast.LENGTH_LONG).show();
        }

     /*   public void showAlertDialog(Context context, String title, String message, Boolean status) {
            AlertDialog alertDialog = new AlertDialog.Builder(context).create();

            alertDialog.setTitle(title);

            alertDialog.setMessage(message);

            alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            alertDialog.show();
        }*/
    }