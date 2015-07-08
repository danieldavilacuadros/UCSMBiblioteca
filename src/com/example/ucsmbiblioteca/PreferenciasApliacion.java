package com.example.ucsmbiblioteca;




import android.os.Bundle;
import android.preference.PreferenceActivity;


public class PreferenciasApliacion extends PreferenceActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//---Carga las preferencias de un archivo XML ---
		addPreferencesFromResource(R.xml.myapppreferences);
		}
	
	
}
