package com.landsoft.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    IntentFilter intentFilter;
    NetworkChangeReceiverJava networkChangeReceiverJava;
    SendBroadcastReceiver sendBroadcastReceiver;
    Button btOpenActivity2, btSend;
    public static final  String STRING_ACTION = "thangcode.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btOpenActivity2 = findViewById(R.id.btSend);
        btSend = findViewById(R.id.btOpenActivity2);
        btOpenActivity2.setOnClickListener(this);
        btSend.setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        sendBroadcastReceiver = new SendBroadcastReceiver();
        registerBroadcastReceiver(sendBroadcastReceiver,STRING_ACTION);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "onPause: "+networkChangeReceiverJava);
//        unregisterReceiver(networkChangeReceiverJava);
        unregisterReceiver(sendBroadcastReceiver);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "onStop: "+networkChangeReceiverJava);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btOpenActivity2:
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent1);
                break;
            case R.id.btSend:
                Intent intent = new Intent();
//                intent.putExtra(STRING_ACTION,"OK BABY. I LOVE YOU");
                intent.putExtra(STRING_ACTION,"OK BABY. I LOVE YOU");
                intent.setAction(STRING_ACTION);
                sendBroadcast(intent);

        }

    }

    private void registerBroadcastReceiver(BroadcastReceiver receiver, String strAction){
        Log.i("procedue", "onStart: "+receiver);
        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(strAction);
        Log.i("procedue", "onStart: "+intentFilter);
        registerReceiver(receiver,intentFilter);
    }
}
