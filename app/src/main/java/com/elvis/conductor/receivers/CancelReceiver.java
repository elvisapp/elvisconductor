package com.elvis.conductor.receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.elvis.conductor.providers.AuthProvider;
import com.elvis.conductor.providers.ClientBookingProvider;
import com.elvis.conductor.providers.DriversFoundProvider;

public class CancelReceiver extends BroadcastReceiver {
    private ClientBookingProvider mClientBookingProvider;
    private DriversFoundProvider mDriversFoundProvider;
    private AuthProvider mAuthProvider;

    @Override
    public void onReceive(Context context, Intent intent) {
        String idClient = intent.getExtras().getString("idClient");
        String searchById = intent.getExtras().getString("searchById");
        mClientBookingProvider = new ClientBookingProvider();
        mDriversFoundProvider = new DriversFoundProvider();
        mAuthProvider = new AuthProvider();

        if (searchById.equals("true")) {
            mClientBookingProvider.updateStatus(idClient, "cancel");
        }
        mDriversFoundProvider.delete(mAuthProvider.getId());

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(2);
    }
}
