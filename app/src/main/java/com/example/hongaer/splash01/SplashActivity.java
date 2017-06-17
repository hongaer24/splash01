package com.example.hongaer.splash01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
      Handler mhandler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp=getPreferences(MODE_PRIVATE);
                boolean isFirst = sp.getBoolean("isFirst", true);
                Intent intent=new Intent();
                if (isFirst){

                    sp.edit().putBoolean("isFirst", false).commit();

                     intent.setClass(SplashActivity.this,GuideActivity.class);


                }else{



                    intent.setClass(SplashActivity.this,MainActivity.class);
                }

                startActivity(intent);
                finish();



            }
        },3000);
    }
}
