package com.elvis.conductor.providers;

import com.elvis.conductor.models.FCMBody;
import com.elvis.conductor.models.FCMResponse;
import com.elvis.conductor.retrofit.IFCMApi;
import com.elvis.conductor.retrofit.RetrofitClient;

import retrofit2.Call;

public class NotificationProvider {

    private String url = "https://fcm.googleapis.com";

    public NotificationProvider() {
    }
    
    public Call<FCMResponse> sendNotification(FCMBody body) {
        return RetrofitClient.getClientObject(url).create(IFCMApi.class).send(body);
    }
}
