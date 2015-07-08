package com.example.ucsmbiblioteca;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;


public class ImagenesRecursos extends MenuPrincipal{

	ImageView img;

	private InputStream OpenHttpConnection (String urlString) throws IOException
	{
		InputStream in = null;
		int response = -1;
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		if(!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");
		try
		{
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect();
			response = httpConn.getResponseCode();
			if(response==HttpURLConnection.HTTP_OK)
			{
				in = httpConn.getInputStream();
			}
		}catch (Exception ex)
		{
			Log.d("Networking",ex.getLocalizedMessage());
			throw new IOException ("Error connecting");
		}
		return in;
	}
	
	
	private Bitmap DownloadImage(String URL)
	{
		Bitmap bitmap = null;
		InputStream in = null;
		try
		{
			in = OpenHttpConnection(URL);
			bitmap = BitmapFactory.decodeStream(in);
			in.close();
		}catch (IOException e1)
		{
			Log.d("NetworkingActivity",e1.getLocalizedMessage());
		}
		return bitmap;
	}
	private class DownloadImageTask extends AsyncTask <String,Void,Bitmap>
	{
		protected Bitmap doInBackground(String... urls)
		{
			return DownloadImage(urls[0]);
		}
		protected void onPostExecute(Bitmap result)
		{
			ImageView img = (ImageView) findViewById(R.id.img);
			img.setImageBitmap(result);
		}
	}
	String URL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagenes_recursos);
	new DownloadImageTask().execute("URL");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_principal, menu);
		return true;
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
	
	//--------------------------------------
	public void onClicSeleccion(View view) {
		
		CambiarURL(view);
		startActivity(new Intent("com.example.ucsmbiblioteca.ImagenesRecursos"));
		
	
    }
	//-------------------------------------


	private void CambiarURL(View view) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
