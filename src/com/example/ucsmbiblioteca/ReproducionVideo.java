package com.example.ucsmbiblioteca;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;
public class ReproducionVideo extends MenuPrincipal{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reproducion_video);
		VideoView videoView = (VideoView) findViewById(R.id.videoView_video);
		Uri path = Uri.parse("android.resource://com.example.ucsmbiblioteca.ReproducionVideo/"+R.raw.ucsm);
		MediaController mc = new MediaController(this);
		videoView.setMediaController(mc);
		videoView.setVideoURI(path);
		videoView.start();
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
}
