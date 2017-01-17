package com.challenge.rangdeapp.urls;


/**
 * Created by Jason on 16/01/2017.
 */
public class LoginURL extends RangDeURL {
    String email,password;
    public LoginURL(String email,String password){
        this.email=email;
        this.password=password;
        urlString="http://hackerearth.0x10.info/api/educorp/auth?query=login&type=0&email="+email+"&password="+password;
    }


    public String getURL() {
        return "http://hackerearth.0x10.info/api/educorp/auth?query=login&type=0&email="+email+"&password="+password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
