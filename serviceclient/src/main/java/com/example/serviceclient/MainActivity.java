package com.example.serviceclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import com.example.cdemo.IMyAidlInterface;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isBind;
    private final String SERVICE_PACKAGE_NAME = "com.example.cdemo";
    //用于启动MyService的Intent对应的action
    private final String SERVICE_ACTION_NAME = "com.example.cdemo.IMyAidlInterface";
    private IMyAidlInterface iMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bind = findViewById(R.id.bind);
        View unbind = findViewById(R.id.unbind);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bind:
                if (!isBind) {
                    Intent intent = new Intent();
                    intent.setAction(SERVICE_ACTION_NAME);
                    intent.setPackage(SERVICE_PACKAGE_NAME);
                    bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                }
                break;
            case R.id.unbind:
                if (isBind) {
                    unbindService(serviceConnection);
                    isBind = false;
                }
                break;
            default:
                break;
        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                Toast.makeText(MainActivity.this, iMyAidlInterface.getStringValue(), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMyAidlInterface = null;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
        isBind = false;
    }
}
