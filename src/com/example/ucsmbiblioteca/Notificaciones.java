package com.example.ucsmbiblioteca;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Notificaciones extends MenuPrincipal{
	int notificationID = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notificaciones);
		
		Button button = (Button) findViewById(R.id.btn_displaynotif);
		button.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v)
			{
				displayNotification();
			}
		});
	}
	
	
	
	
	public  void displayNotification()
	{
		Intent i = new Intent(this,NotificacionDetalles.class);
		i.putExtra("notificationID", notificationID);
		PendingIntent pendingIntent = 
				PendingIntent.getActivity(this, 0, i, 0);
		NotificationManager nm = (NotificationManager)
				getSystemService(NOTIFICATION_SERVICE);
		Notification notif = new Notification(R.drawable.ic_launcher,
				"Recordatorio: Fecha Devolucion DE LIBROS",
				System.currentTimeMillis());
		CharSequence from = "30 de Junio del 2015";
		CharSequence message = "5:30 pm";
		notif.setLatestEventInfo(this,from, message,pendingIntent);
		notif.vibrate = new long[] {100,250,100,500};
		nm.notify(notificationID, notif);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_principal, menu);
		return true;
	}
}
