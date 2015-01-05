package com.example.conect4;


import java.util.ArrayList;

import sqlite.Conexion;
import Beans.BeanJugador;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


public class Jugar extends ActionBarActivity{
	 	ListView li;
	 	ArrayList<BeanJugador> lista = new ArrayList<BeanJugador>();
	 	BeanJugador jugador;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jugar);
		
		li = (ListView)findViewById(R.id.lista_jugadores);
		
		Conexion cn = new Conexion(getApplicationContext(), "conectat3.db",null,1);
		SQLiteDatabase db = cn.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM jugador", null);
		if(c.moveToFirst()){
			do{
				jugador = new BeanJugador(c.getString(1),c.getString(2));
				lista.add(jugador);
				
				
			}while(c.moveToNext());
		}
		ArrayAdapter<BeanJugador> adap = new ArrayAdapter<BeanJugador>(getApplicationContext(), android.R.layout.simple_list_item_1, lista);
		li.setAdapter(adap);
	}
	
	public void NuevoJugador(View view){
		Intent i = new Intent(Jugar.this,NuevoJugador.class);
		startActivity(i);
	}


}





















