package com.example.pcoscar.firebasepush;

import com.example.pcoscar.firebasepush.Remote.APIService;
import com.example.pcoscar.firebasepush.Remote.RetrofitClient;

public class Common {
    public static  String currentToken="";

    private static String baseUrl="https://fcm.googleapis.com/";

    public static APIService getFCMClient(){
        return RetrofitClient.getClient(baseUrl).create(APIService.class);
    }

}
