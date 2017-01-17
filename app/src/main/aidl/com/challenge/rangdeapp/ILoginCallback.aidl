// ILoginCallback.aidl
package com.challenge.rangdeapp;

// Declare any non-default types here with import statements

interface ILoginCallback {

    void onLoginSuccessful(String apikey);
    void onLoginError(String errormsg);
}
