package com.example.conect4;

import sqlite.Conexion;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;



public class Conecta3 extends ActionBarActivity {
	TextView et;
	   
    long jugador_id;

    Conexion dbcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conecta3);

        dbcon = new Conexion(this);
        dbcon.abrirBaseDeDatos();

        et = (TextView) findViewById(R.id.et_jugador_id);
        

        Intent i = getIntent();
        String jugadorID = i.getStringExtra("jugadorId");
        String jugadorName = i.getStringExtra("jugadorNombre");

        jugador_id = Long.parseLong(jugadorID);

        et.setText(jugadorName);


    }

}
