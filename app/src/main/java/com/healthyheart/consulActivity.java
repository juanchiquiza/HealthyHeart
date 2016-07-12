package com.healthyheart;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.healthyheart.ConexionBD.AdministradorBase;

public class consulActivity extends AppCompatActivity {
    private TableLayout table_layout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consul);

        table_layout1 = (TableLayout) findViewById(R.id.table_layout1);
         mostradatos("");
    }

    private void mostradatos(String cod) {
        AdministradorBase admin = new AdministradorBase(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //String cod = et1.getText().toString();
        //  String resu = "";
        // String datos[] = new String[3];
        TextView fil = new TextView(this);
        String sql = "";
        if (cod.equals("")) {
            sql = "select * from articulos";
        } else {

            sql = "select * from articulos where codigo=" + cod;
        }
        Cursor fila = bd.rawQuery(sql, null);

        int rows = fila.getCount();
        int cols = fila.getColumnCount();
        fila.moveToFirst();
        for (int i = 0; i < rows; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < cols; j++) {
                TextView vista = new TextView(this);
                vista.setText(fila.getString(j));
                row.addView(vista);

            }

            fila.moveToNext();
            table_layout1.addView(row);
        }
        bd.close();
    }
//}

}
//}