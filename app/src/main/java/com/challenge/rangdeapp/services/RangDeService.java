package com.challenge.rangdeapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.challenge.rangdeapp.IDashboardCallback;
import com.challenge.rangdeapp.ILoginCallback;
import com.challenge.rangdeapp.IRangDeServiceCommunication;
import com.challenge.rangdeapp.urls.DashboardURL;
import com.challenge.rangdeapp.urls.LoginURL;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class RangDeService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new RangDeServiceStub().asBinder();
    }

    class RangDeServiceStub extends IRangDeServiceCommunication.Stub{
        ILoginCallback iLoginCallback;
        IDashboardCallback iDashboardCallback;

        @Override
        public void registerLoginCallback(ILoginCallback logincallback) throws RemoteException {
            iLoginCallback=logincallback;
        }

        @Override
        public void registerDashboardCallback(IDashboardCallback dashboardcallback) throws RemoteException {
            iDashboardCallback=dashboardcallback;
        }

        @Override
        public void login(final String email, final String password) throws RemoteException {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                         String receivedstring= new LoginURL(email,password).connectToRangDeServer();
                         Log.d("ADP_Service",receivedstring);
                         respondToLoginCallback(receivedstring);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        @Override
        public void getProfileList(final String apikey) throws RemoteException {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String receivedstring=new DashboardURL(apikey).connectToRangDeServer();
                        Log.d("ADP_Service",receivedstring);
                        respondToDashboardCallback(receivedstring);
                    }  catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        public void respondToLoginCallback(String jsonstring) throws JSONException, RemoteException {
            JSONObject jsonObject=new JSONObject(jsonstring);
            if(jsonstring.contains("api_key")){

                iLoginCallback.onLoginSuccessful(jsonObject.getString("api_key"));
            }
            if(jsonstring.contains("error")){
                iLoginCallback.onLoginError(jsonObject.getString("error"));
            }
        }

        public void respondToDashboardCallback(String profilejsonstring) throws RemoteException{
            iDashboardCallback.onPersonProfile(profilejsonstring);
        }


        }
    }





