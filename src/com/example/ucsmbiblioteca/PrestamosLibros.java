package com.example.ucsmbiblioteca;



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class PrestamosLibros extends  ListActivity {

	String[] libros =  {
			"Administración de Producción y Operaciones",
			"Dirección de Operaciones",
			"Dirección y administración de la Producción y de las Operaciones",
			"Diseño de instalaciones de manufactura y manejo de materiales",
			"Estudio del Trabajo Medición del Trabajo",
			"Ing. Industrial. Métodos, Tiempo y Movimientos",
			"Investigacion de Operaciones",
			"Investigación de Operaciones",
			"Investigación de Operaciones, Aplicaciones y Algoritmos",
			"Sistemas de Informacion Gerencial"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_prestamos_libros);
		try{
		ListView lstView = getListView();
		lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lstView.setTextFilterEnabled(true);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, libros));
		
		
	}
    catch(Exception e){}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
	public void onListItemClick(ListView parent, View v , int position , long id)
	{
		Toast.makeText(this, "Te prestaste estos libros: "+libros[position],Toast.LENGTH_SHORT).show();
	}
	/*
	public void onClickFecha(View view) {
		startActivity(new Intent("com.example.ucsmbiblioteca.FechaDevolucion"));
	
	}
	*/
	
	
}
