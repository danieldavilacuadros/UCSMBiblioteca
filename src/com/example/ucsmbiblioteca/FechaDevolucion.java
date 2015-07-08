package com.example.ucsmbiblioteca;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class FechaDevolucion extends MenuPrincipal{
	int notificationID = 1;
	public TimePicker timePicker;
	public DatePicker datePicker;
	
	int hour,minute;
	static final int TIME_DIALOG_ID = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fecha_devolucion);
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		timePicker.setIs24HourView(true);
		
		datePicker = (DatePicker) findViewById(R.id.datePicker);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_principal, menu);
	
		return true;
	}
	
	protected Dialog onCreateDialog(int id)
	{
		switch(id)
		{
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeSetListener, hour,minute, false);
		}
		return null;
	}
	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
	{
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
			// TODO Auto-generated method stub
			hour = hourOfDay;
			minute = minuteOfHour;
			
			SimpleDateFormat timeFormat = new SimpleDateFormat ("hh:mm aa");
			Date date = new Date(0,0,0, hour,minute);
			String strDate = timeFormat.format(date);
			Toast.makeText(getBaseContext(),
							"Fecha de devolucion "+ strDate,
							Toast.LENGTH_SHORT).show();
		}
	};
	public void onClick(View view)
	{
		Toast.makeText(getBaseContext(),
				"Fecha devolucion:" + (datePicker.getMonth()+1)+
				"/" + datePicker.getDayOfMonth() +
				"/" + datePicker.getYear() + "\n" +
				"Hora de devolucion:"+timePicker.getCurrentHour()+
				":"+timePicker.getCurrentMinute(),
				Toast.LENGTH_SHORT).show();
		displayNotification();
		
		
	
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

	
	

	


}
