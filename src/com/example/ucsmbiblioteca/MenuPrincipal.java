package com.example.ucsmbiblioteca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public class MenuPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    //OK
    public void onClickBusqueda(View view) {
		startActivity(new Intent("com.example.ucsmbiblioteca.BusquedaLibros"));
	}
    
    public void onClickPrestamos(View view) {
    	Intent i = new Intent("com.example.ucsmbiblioteca.PrestamosLibros");
		startActivity(i);
    }
    
    public void onClickUbicanos(View view) {
		startActivity(new Intent("com.example.ucsmbiblioteca.Ubicanos"));
	}
    //OK
    public void onClickNotas(View view) {
    	startActivity(new Intent("com.example.ucsmbiblioteca.EscribirNota"));
	}       	
	
	public void onClickContacto(View view) {
		startActivity(new Intent("com.example.ucsmbiblioteca.Contactanos"));
	}
				
	public void onClickAcerca(View view) {		
			/*ACerca -> Reproducirvideo*/
		startActivity(new Intent("com.example.ucsmbiblioteca.ReproducionVideo"));
		
	}
	
	public void onClickFecha(View view) {		
		
	startActivity(new Intent("com.example.ucsmbiblioteca.FechaDevolucion"));
	
}
	public void onClickConfiguracion(View view) {		
		
	startActivity(new Intent("com.example.ucsmbiblioteca.Configuracion"));
	
}
}
