package com.example.kavya.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;

import com.example.kavya.broadcast.DBHelper;

/**
 * Created by kavya on 2/6/2018.
 */

public class Numberreceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        String state =intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING))
        {
            String number =intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            DBHelper Helper =new DBHelper(context);
            SQLiteDatabase database=Helper.getWritableDatabase();
            Helper.saveNumber(number,database);
            Helper.close();
        }



    }
}
