package com.challenge.rangdeapp.utils;

/**
 * Created by Jason on 16/01/2017.
 */
public class GlobalMaintainer {
    private static GlobalMaintainer ourInstance = new GlobalMaintainer();
    private String apiKey;
    public static GlobalMaintainer getInstance() {
        return ourInstance;
    }

    private GlobalMaintainer() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
