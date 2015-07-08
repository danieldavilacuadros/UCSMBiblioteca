package com.example.ucsmbiblioteca;

import android.content.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class RecebirSms extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent)
	{
		Bundle bundle = intent.getExtras();
		SmsMessage[] msgs = null;
		String str= "SMS from";
		if(bundle!=null)
		{
			Object[] pdus = (Object[]) bundle.get("pdus");
			msgs = new SmsMessage[pdus.length];
			for(int i = 0; i < msgs.length;i++)
			{
				msgs[i]= SmsMessage.createFromPdu((byte[])pdus[i]);
				if(i==0)
				{
					str += msgs[i].getOriginatingAddress();
					str += ": ";
				}
				str += msgs[i].getMessageBody().toString();
			}
			Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
			Log.d("SMSReceiver",str);
		}
		
	}
}
