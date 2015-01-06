package com.example.conect4;



import sqlite.Conexion;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoJugador extends ActionBarActivity implements OnClickListener{
    EditText et;
    Button btnAgregar, read_bt;
    Conexion dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_jugador);
        et = (EditText) findViewById(R.id.et_jugador_id);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new Conexion(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarId:
                String name = et.getText().toString();
                dbconeccion.insertarDatos(name);
                Intent main = new Intent(NuevoJugador.this, Jugar.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;

            default:
                break;
        }
    }
	
}

























