package com.example.conect4;

import sqlite.Conexion;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoJugador extends ActionBarActivity{
private EditText edit_nombre,edit_jugador;
private Button btn_user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nuevo_jugador);
	edit_nombre  = (EditText)findViewById(R.id.edit_nombre);
	edit_jugador = (EditText)findViewById(R.id.edit_jugador);
	btn_user     = (Button)findViewById(R.id.btn_nuevo_user);
	
	btn_user.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			String nombre  = edit_nombre.getText().toString();
			String jugador = edit_jugador.getText().toString();
		
			     
				Conexion cn =  new Conexion(getApplicationContext(), "conectat3.db",null, 1);
			     SQLiteDatabase db = cn.getWritableDatabase();
				 cn.InsertarJugador(db,nombre,jugador);
				 
		
				
								
		}
	});

	}
	
}

























