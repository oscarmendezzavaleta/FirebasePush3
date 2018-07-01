package com.example.pcoscar.firebasepush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pcoscar.firebasepush.Model.MyResponse;
import com.example.pcoscar.firebasepush.Model.Notification;
import com.example.pcoscar.firebasepush.Model.Sender;
import com.example.pcoscar.firebasepush.Remote.APIService;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnSendData;
    EditText edTitle , edContent;

    APIService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      Common.currentToken = FirebaseInstanceId.getInstance().getToken();

        FirebaseMessaging.getInstance().subscribeToTopic("MyTopic");


        Log.d("MY TOKEN", Common.currentToken );

        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

        mService=Common.getFCMClient();

        btnSendData=findViewById(R.id.btnSendData);
        edContent=findViewById(R.id.edContent);
        edTitle=findViewById(R.id.edTitle);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification=new Notification(edTitle.getText().toString(),edContent.getText().toString());
                Sender sender=new Sender(Common.currentToken,notification);
                mService.sendNotification(sender)
                        .enqueue(new Callback<MyResponse>() {
                            @Override
                            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                if (response.body().success==1)
                                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<MyResponse> call, Throwable t) {
                                Log.e("ERROR",t.getMessage());

                            }
                        });

            }
        });



    }
}
