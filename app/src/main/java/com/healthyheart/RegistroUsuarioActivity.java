package com.healthyheart;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.healthyheart.ConexionBD.AdministradorBase;
import com.healthyheart.Model.UsuarioModel;
import com.healthyheart.Usuario.UsuarioConsultas;

import java.util.Calendar;

public class RegistroUsuarioActivity  extends FragmentActivity {

    private Spinner cmbOpciones;
    private Spinner cmbRaza;
    EditText Documento,Nombre,Apellido,Telefono,Direccion,Medicado,Peso,Talla,Masa_corporal,Contrasena;
    final String[] datos = new String[]{"Selecciona una Opcion","Masculino","Femenino"};
    final String[] datosraza = new String[]{"Selecciona una Opcion","Blanca","Negra"};
    ArrayAdapter<String> adaptador = null;
    ArrayAdapter<String> adaptadorRaza = null;
    UsuarioModel usuario = new UsuarioModel();
    UsuarioConsultas user = new UsuarioConsultas();

    AdministradorBase admin = new AdministradorBase(this, "BD", null, 1);

    Button btnFecha;
    static final int DIALOG_ID =0;
    int anio,mes,dia;
    String Genero,Raza,Fechafinal,fechaNacimiento,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        Documento=(EditText)findViewById(R.id.documento);
        Nombre=(EditText)findViewById(R.id.nombre);
        Apellido=(EditText)findViewById(R.id.apellido);
        Telefono=(EditText)findViewById(R.id.telefono);
        Direccion=(EditText)findViewById(R.id.direccion);
        Medicado=(EditText)findViewById(R.id.medicado);
        Peso=(EditText)findViewById(R.id.peso);
        Talla=(EditText)findViewById(R.id.talla);
        Masa_corporal=(EditText)findViewById(R.id.masa_corppral);
        Contrasena=(EditText)findViewById(R.id.contrasena);

        cmbOpciones = (Spinner)findViewById(R.id.CmbGenero);
        cmbRaza = (Spinner)findViewById(R.id.Cmbraza);

        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

        adaptadorRaza= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datosraza);
        adaptadorRaza.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbRaza.setAdapter(adaptadorRaza);



        cmbOpciones.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {

                        //  disponibilidad.setText(usuario.setDisponibles()+"");
                        if(position==1){
                            Genero="M";
                        }if(position==2){
                            Genero="F";
                        }else{
                            Toast.makeText(getApplicationContext(),"Debe escoger Genero", Toast.LENGTH_LONG).show();
                        }

                        usuario.setGenero(Genero);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        cmbRaza.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        //   Toast.makeText(getApplicationContext(), "presiono " + position, Toast.LENGTH_SHORT).show();
                        if(position==1){
                            Raza="Blanca";
                        }if(position==2){
                            Raza="Negra";
                        }else{
                            //Toast.makeText(getApplicationContext(),"Debe escoger Genero", Toast.LENGTH_LONG).show();
                        }

                        usuario.setRaza(Raza);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        showDialogButtonClick();
    }

    public void showDialogButtonClick(){

        btnFecha = (Button)findViewById(R.id.btnfecha);
        btnFecha.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    protected Dialog onCreateDialog(int id){

        if(id == DIALOG_ID )
        return new DatePickerDialog(this, dpickerListener,anio,mes,dia);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener(){
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            anio = year;
            mes = month;
            dia = dayOfMonth;
            Fechafinal=String.valueOf(anio)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
            Toast.makeText(RegistroUsuarioActivity.this, "Fecha, Dia: " + Fechafinal  , Toast.LENGTH_LONG).show();
        }
        };


    public void GuardarUsuario(View v)  {

        usuario.setIdentificacion(Integer.parseInt(Documento.getText().toString()));
        usuario.setNombre(Nombre.getText().toString());
        usuario.setApellido(Apellido.getText().toString());
        usuario.setTelefono(Integer.parseInt(Telefono.getText().toString()));
        usuario.setDireccion(Direccion.getText().toString());
        usuario.setMedicado(Medicado.getText().toString());
        usuario.setPeso(Integer.parseInt(Peso.getText().toString()));
        usuario.setNombre(Nombre.getText().toString());
        usuario.setIndiceMasaCorproral(Masa_corporal.getText().toString());
        usuario.setContrasena(Contrasena.getText().toString());

        Calendar calendar= Calendar.getInstance();
        int year= calendar.get(calendar.YEAR);
        int month=calendar.get(calendar.MONTH);
        int day=calendar.get(calendar.DAY_OF_MONTH);
        Toast.makeText(this,"Fecha, Dia: "+day+" Mes: "+month+" Año: "+year,Toast.LENGTH_LONG).show();
        fechaNacimiento=day+"/"+month+"/"+year;
        usuario.setFecha_nac(fechaNacimiento.toString());


        resultado = user.GuardarUsuario(usuario,admin);


        Toast.makeText(this, resultado,Toast.LENGTH_LONG).show();


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
