// IRangDeServiceCommunication.aidl
package com.challenge.rangdeapp;
import com.challenge.rangdeapp.ILoginCallback;
import com.challenge.rangdeapp.IDashboardCallback;
// Declare any non-default types here with import statements

interface IRangDeServiceCommunication {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

    void registerLoginCallback(in ILoginCallback logincallback);
    void registerDashboardCallback(in IDashboardCallback dashboardcallback);

    void login(String email,String password);
    void getProfileList(String apikey);
}
