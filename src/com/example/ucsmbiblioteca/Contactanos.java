package com.example.ucsmbiblioteca;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class Contactanos extends Activity {
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.contacto);
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.menu_principal, menu);
	        return true;
	    }
	    public void onClickEmail(View v)
	    {
	    	String[] to=
	    		{
	    			"danidavicu94y@gmail.com",
	    			"anma.alzamora@gmail.com"};
	    	String[] cc= {""};
	    	sendEmail(to, cc, "CONTACTO BIBLIOTECA", "ME GUSTARIA CONTACTAR CON USTEDES PARA HACERLOS RICOS :3");
	    }
	    
	    private void sendEmail(String[] emailAddresses, String[] carbonCopies,
	    		String subject, String message)
	    {
	    	Intent emailIntent= new Intent(Intent.ACTION_SEND);
	    	emailIntent.setData(Uri.parse("mailto:"));
	    	String[] to = emailAddresses;
	    	String[] cc = carbonCopies;
	    	emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
	    	emailIntent.putExtra(Intent.EXTRA_CC, cc);
	    	emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
	    	emailIntent.putExtra(Intent.EXTRA_TEXT, message);
	    	emailIntent.setType("message/rfc822");
	    	startActivity(Intent.createChooser(emailIntent, "Email"));
	    }
	    public void onClickSend(View view)
	    {
	    	sendSMS("958483592","CONTACTO BIBLIOTECA UCSM");
	    }
	    
	    public void sendSMS(String phoneNumber, String message)
	    {
	    	SmsManager sms = SmsManager.getDefault();
	    	sms.sendTextMessage(phoneNumber, null, message, null, null);

}
}
