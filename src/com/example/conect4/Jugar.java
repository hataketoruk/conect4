package com.example.conect4;

	import android.content.Intent;
	import sqlite.Conexion;
	import android.database.Cursor;
	import android.os.Bundle;
	import android.support.v7.app.ActionBarActivity;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.AdapterView;
	import android.widget.AdapterView.OnItemClickListener;
	import android.widget.Button;
	import android.widget.ListView;
	import android.widget.SimpleCursorAdapter;
	import android.widget.TextView;

	public class Jugar extends ActionBarActivity {

	    Button btnAgregarJugador;
	    ListView lista;
	    Conexion dbconeccion;
	    TextView tv_miemID, tv_miemNombre;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.jugar);

	        dbconeccion = new Conexion(this);
	        dbconeccion.abrirBaseDeDatos();
	        btnAgregarJugador = (Button) findViewById(R.id.btnAgregarJugador);
	        lista = (ListView) findViewById(R.id.listViewJugador);

	   
	        btnAgregarJugador.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Intent iagregar = new Intent(Jugar.this, NuevoJugador.class);
	                startActivity(iagregar);
	            }
	        });

	   
	        Cursor cursor = dbconeccion.leerDatos();

	        String[] from = new String[] {
	                DBhelper.JUGADOR_ID,
	                DBhelper.JUGADOR_NOMBRE
	        };
	        int[] to = new int[] {
	                R.id.jugador_id,
	                R.id.jugador_nombre
	        };

	        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
	        		Jugar.this, R.layout.formato_fila, cursor, from, to);

	        adapter.notifyDataSetChanged();
	        lista.setAdapter(adapter);

	      
	        lista.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView parent, View view, int position, long id) {

	                tv_miemID = (TextView) view.findViewById(R.id.jugador_id);
	                tv_miemNombre = (TextView) view.findViewById(R.id.jugador_nombre);

	                String aux_jugadorId = tv_miemID.getText().toString();
	                String aux_jugadorNombre = tv_miemNombre.getText().toString();

	                Intent modify_intent = new Intent(getApplicationContext(), Conecta3.class);
	                modify_intent.putExtra("jugadorId", aux_jugadorId);
	                modify_intent.putExtra("jugadorNombre", aux_jugadorNombre);
	                startActivity(modify_intent);
	            }
	        });
	    }  //termina el onCreate
	} //termina clase
	




























