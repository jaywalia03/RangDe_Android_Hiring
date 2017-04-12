package com.challenge.rangdeapp.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.challenge.rangdeapp.ILoginCallback;
import com.challenge.rangdeapp.IRangDeServiceCommunication;
import com.challenge.rangdeapp.R;
import com.challenge.rangdeapp.services.RangDeService;
import com.challenge.rangdeapp.utils.GlobalMaintainer;

/**
 * Created by Jason on 16/01/2017.
 */
/* File has been changed*//*For demo purpose*/
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    IRangDeServiceCommunication rangDeServiceCommunication;
    Button btn_login;
    EditText editText_email,editText_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn_login=(Button)findViewById(R.id.btn_login);
        editText_email=(EditText)findViewById(R.id.editText_email);
        editText_password=(EditText)findViewById(R.id.editText_password);

        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                Intent intent = new Intent(LoginActivity.this,RangDeService.class);
                startService(intent);
                bindService(intent, new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        rangDeServiceCommunication = IRangDeServiceCommunication.Stub.asInterface(service);
                        Log.d("ADP_Service", "onserviceconnected");
                        try {
                            rangDeServiceCommunication.registerLoginCallback(new LoginCallbackStub());

                            Log.d("ADP_Service", "registering");
                            rangDeServiceCommunication.login(editText_email.getText().toString(),editText_password.getText().toString());
                            Log.d("ADP_Service", "downloadmovienames");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                }, BIND_AUTO_CREATE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    class LoginCallbackStub extends ILoginCallback.Stub{

        @Override
        public void onLoginError(final String errormsg) throws RemoteException {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(LoginActivity.this, errormsg, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onLoginSuccessful(final String apikey) throws RemoteException {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    GlobalMaintainer.getInstance().setApiKey(apikey);

                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                }
            });

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
