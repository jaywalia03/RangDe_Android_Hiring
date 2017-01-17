package com.challenge.rangdeapp.urls;

/**
 * Created by Jason on 16/01/2017.
 */
public class DashboardURL extends RangDeURL {

    public DashboardURL(String apikey){
      urlString="https://hackerearth.0x10.info/api/educorp/profile?query=list&api_key="+apikey;
    }

    public String getURL() {
        return urlString;
    }
}
