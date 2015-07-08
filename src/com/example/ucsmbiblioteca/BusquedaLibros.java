package com.example.ucsmbiblioteca;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class BusquedaLibros extends MenuPrincipal{

	String[] libros =  {
			"Administraci�n de Producci�n y Operaciones",
			"Direcci�n de Operaciones",
			"Direcci�n y administraci�n de la Producci�n y de las Operaciones",
			"Dise�o de instalaciones de manufactura y manejo de materiales",
			"Estudio del Trabajo Medici�n del Trabajo",
			"Ing. Industrial. M�todos, Tiempo y Movimientos",
			"Investigacion de Operaciones",
			"Investigaci�n de Operaciones",
			"Investigaci�n de Operaciones, Aplicaciones y Algoritmos",
			"Sistemas de Informacion Gerencial"

	};
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_busqueda_libros);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,libros);
		AutoCompleteTextView textView = (AutoCompleteTextView)
				findViewById(R.id.txtLibros);
		textView.setThreshold(3);
		textView.setAdapter(adapter);
		
		}
		
}
