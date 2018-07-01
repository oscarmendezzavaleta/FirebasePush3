package com.example.pcoscar.firebasepush.Service;

import android.util.Log;

import com.example.pcoscar.firebasepush.Common;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    
    private static final String TAG="MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        //Log.d(TAG,"Refresehd token" + refreshedToken);
        Common.currentToken=refreshedToken;

        //sendRegistrationToServer(refreshedToken);
        
    }

    private void sendRegistrationToServer(String refreshedToken) {
// TODO: Implement this method to send token to your app server.
    }
}
