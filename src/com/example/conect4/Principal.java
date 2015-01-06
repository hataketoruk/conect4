package com.example.conect4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Principal extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
	
		
	}
	public void jugar(View view){
		Intent i = new Intent(Principal.this,Jugar.class);
		startActivity(i);
	}
	public void championship(View view){
		Intent i = new Intent(Principal.this,Championship.class);
		startActivity(i);
	}
	
	public void about(View view){
		Intent i = new Intent(Principal.this,About.class);
		startActivity(i);
	}
	public void salir(View view){
	    finish();
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.informacion:
			Toast.makeText(
					 Principal.this
					,"pantalle informacion"
					,Toast.LENGTH_LONG)
					.show();
				return true;	
		case R.id.cartelera:
			Toast.makeText(
					 Principal.this
					,"pantalla cartelera"
					,Toast.LENGTH_LONG)
					.show();
			return true;
		case R.id.salir:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
    	
    	
    }

}
