package com.example.ucsmbiblioteca;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MenuPreferencias extends MenuPrincipal{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_prefencias);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_principal, menu);
		return true;
	}

	public void onClickLoad(View view) {
		Intent i = new Intent("com.example.proyecto.AppPreferenceActivity");
		startActivity(i);
	}
	public void onClickDisplay(View view) {
		SharedPreferences appPrefs =getSharedPreferences("com.example.proyecto_preferences",MODE_PRIVATE);
		DisplayText(appPrefs.getString("editTextPref",""));
	}
	private void DisplayText(String str) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
		
		
	}

	public void onClickModify(View view) {
		SharedPreferences appPrefs =getSharedPreferences("com.example.proyecto_preferences",MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = appPrefs.edit();
		prefsEditor.putString("editTextPref",
				((EditText) findViewById(R.id.txtString)).getText().toString());
		prefsEditor.commit();
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
