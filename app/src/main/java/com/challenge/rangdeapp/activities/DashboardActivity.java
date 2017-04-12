package com.challenge.rangdeapp.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.challenge.rangdeapp.IDashboardCallback;
import com.challenge.rangdeapp.IRangDeServiceCommunication;
import com.challenge.rangdeapp.R;
import com.challenge.rangdeapp.services.RangDeService;
import com.challenge.rangdeapp.utils.GlobalMaintainer;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Jason on 16/01/2017.
 */
/** changes made by gauravseta*/
public class DashboardActivity extends AppCompatActivity {
    TextView txt_apikey,txt_profileName,txt_accounttype;
    IRangDeServiceCommunication rangDeServiceCommunication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_dashboard);
        setSupportActionBar(toolbar);

        txt_profileName=(TextView)findViewById(R.id.txt_profileName);
        txt_accounttype=(TextView)findViewById(R.id.txt_accounttype);

        Intent intent=new Intent(DashboardActivity.this,RangDeService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                try {
                    rangDeServiceCommunication = IRangDeServiceCommunication.Stub.asInterface(service);

                    rangDeServiceCommunication.registerDashboardCallback(new DashCallbackStub());
                    rangDeServiceCommunication.getProfileList(GlobalMaintainer.getInstance().getApiKey());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    class DashCallbackStub extends IDashboardCallback.Stub{

        @Override
        public void onPersonProfile(final String profilejson) throws RemoteException {

            if(profilejson.contains("account_type")){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    updateDashboardUI(profilejson);
                }
            });
            }
        }
    }

    public void updateDashboardUI(String profilejson){
        try {
            JSONObject jsonObject = new JSONObject(profilejson);
            JSONArray jsonArrayProfile = jsonObject.getJSONArray("profile");
            JSONObject jsonObjectProfile = jsonArrayProfile.getJSONObject(0);
            txt_profileName.setText(jsonObjectProfile.getString("name"));
            txt_accounttype.setText(jsonObjectProfile.getString("account_type"));
        }
        catch(Exception e){

        }
    }
}
