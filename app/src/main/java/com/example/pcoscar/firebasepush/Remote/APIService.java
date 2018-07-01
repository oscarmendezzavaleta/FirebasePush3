package com.example.pcoscar.firebasepush.Remote;



import com.example.pcoscar.firebasepush.Model.MyResponse;
import com.example.pcoscar.firebasepush.Model.Sender;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAA7LssM4Y:APA91bGxUJhEDKU8mgOI1AD48FPQDnS6ncG5rmcODN-G-JvEpiZodiVithqgXdGrLhIr3Gewhqrev0fUnGgpe9dIPEpQzTpGbjh-Jy7BXz5puluuHwS9uMYN2uuLhSpowrJKd6OsxG4WpXnVYMlWD8tkK10TsyrtLQ"
    })
    @POST("fcm/send")
    retrofit2.Call<MyResponse> sendNotification(@Body Sender body);


}
