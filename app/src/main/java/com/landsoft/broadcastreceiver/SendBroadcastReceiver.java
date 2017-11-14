package com.landsoft.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SendBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if (intent.getAction().equals(MainActivity.STRING_ACTION) ) {
            String title = intent.getStringExtra(MainActivity.STRING_ACTION);
            Toast.makeText(context, "Send Broadcast Receiver:" + title, Toast.LENGTH_LONG).show();
        }
    }
}
