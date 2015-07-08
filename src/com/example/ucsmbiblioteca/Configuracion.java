package com.example.ucsmbiblioteca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Configuracion extends Activity {
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.configuracion);
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.menu_principal, menu);
	        return true;
	    }
	    
	    public void onClickPreferencias(View view) {
			startActivity(new Intent("com.example.ucsmbiblioteca.PreferenciasApliacion"));
		}
	    public void onClickAudio(View view) {
			startActivity(new Intent("com.example.ucsmbiblioteca.MenuAudio"));
		}
	
	
	
	    
	    
}