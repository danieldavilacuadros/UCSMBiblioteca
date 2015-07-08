package com.example.ucsmbiblioteca;


import android.app.NotificationManager;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;


public class NotificacionDetalles extends MenuPrincipal{
	@Override
	public void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notificacion_detalles);
		NotificationManager  nm = (NotificationManager)
				getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(getIntent().getExtras().getInt("notificationID"));
		
		TextView txt = (TextView)findViewById(R.id.text1);
		txt.setText("Fecha devolucion:" );
		
	}
	
}
