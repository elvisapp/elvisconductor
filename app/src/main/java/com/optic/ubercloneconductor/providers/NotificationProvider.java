package com.optic.ubercloneconductor.providers;

import com.optic.ubercloneconductor.models.FCMBody;
import com.optic.ubercloneconductor.models.FCMResponse;
import com.optic.ubercloneconductor.retrofit.IFCMApi;
import com.optic.ubercloneconductor.retrofit.RetrofitClient;

import retrofit2.Call;

public class NotificationProvider {

    private String url = "https://fcm.googleapis.com";

    public NotificationProvider() {
    }
    
    public Call<FCMResponse> sendNotification(FCMBody body) {
        return RetrofitClient.getClientObject(url).create(IFCMApi.class).send(body);
    }
}
