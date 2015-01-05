package com.example.conect4;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;


public class SplashActivity extends ActionBarActivity {
	public static final int segundos = 8;
	public static final int milisegundos = segundos*1000;
	public static final int delay = 2;
	private ProgressBar pbprogreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pbprogreso = (ProgressBar) findViewById(R.id.pbprogreso);
        pbprogreso.setMax(maximo_progreso());
        empezaranimacion();
    }
    public void empezaranimacion(){
    	
    	new CountDownTimer(milisegundos,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				pbprogreso.setProgress(establecer_progreso(millisUntilFinished));
				
			}
			
			@Override
			public void onFinish() {
				// 
				Intent nuevofrom = new Intent(SplashActivity.this,Principal.class);
				startActivity(nuevofrom);
				finish();
			}
		}.start();
    }
    public int establecer_progreso(long miliseconds){
    	
    	return (int)((milisegundos-miliseconds)/1000);
    }
    public int maximo_progreso()
    {
    		return segundos-delay;
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
					SplashActivity.this
					,"pantalle informacion"
					,Toast.LENGTH_LONG)
					.show();
				return true;	
		case R.id.cartelera:
			Toast.makeText(
					SplashActivity.this
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
