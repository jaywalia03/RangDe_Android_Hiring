package com.challenge.rangdeapp.urls;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Jason on 17/01/2017.
 */
public class SignUpURL extends RangDeURL {
    private String name,email,password,type;

    public SignUpURL(String name, String email, String password, String type) throws UnsupportedEncodingException {

        if(type.equalsIgnoreCase("Parent")){
            urlString = "http://hackerearth.0x10.info/api/educorp/auth?query=register&name="+URLEncoder.encode(name, "UTF-8").replace(" ", "%20")+"&email="+URLEncoder.encode(email, "UTF-8").replace(" ", "%20")+ "&password="+URLEncoder.encode(password, "UTF-8").replace(" ", "%20")+"&type=0";

        }
        else {
            urlString = "http://hackerearth.0x10.info/api/educorp/auth?query=register&name=" +URLEncoder.encode(name, "UTF-8").replace(" ", "%20")+"&email="+URLEncoder.encode(email, "UTF-8").replace(" ", "%20")+ "&password="+URLEncoder.encode(password, "UTF-8").replace(" ", "%20")+"&type=1";
            }
    }
}
