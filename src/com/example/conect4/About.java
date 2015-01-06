package com.example.conect4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class About extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		
	}
	public void regresar(View view){
		Intent i = new Intent(About.this,Principal.class);
		startActivity(i);
	}
	
}
