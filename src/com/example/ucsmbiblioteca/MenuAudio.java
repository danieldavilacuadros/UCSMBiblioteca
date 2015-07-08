package com.example.ucsmbiblioteca;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.view.View;




public class MenuAudio extends MenuPrincipal{
	static final String AUDIO_PATH = 
			Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)+"/shiver.mp3";
			private MediaPlayer mediaPlayer;
			private int playbackPosition=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_audio);
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
	public void doClick(View view)
	{
		switch (view.getId())
		{
		case R.id.startPlayerBtn:
			try
			{
				playLocalAudio();
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			break;

		case R.id.stopPlayerBtn:
		
			if(mediaPlayer!= null)
			{
				mediaPlayer.stop();
				playbackPosition= 0;
			}
			break;
		}
	}

	private void playLocalAudio() throws Exception
	{
		mediaPlayer = MediaPlayer.create(this,R.raw.shiver);
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mediaPlayer.start();
	}
	
	

}
