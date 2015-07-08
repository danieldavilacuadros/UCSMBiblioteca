package com.example.ucsmbiblioteca;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class EnvioEmail extends MenuPrincipal{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_email);
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
    			"someguy@example.com",
    			"anotherguy@example.com"};
    	String[] cc= {"busybody@example.com"};
    	sendEmail(to, cc, "Hello", "Hello my friends!");
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
}
