package me.smoov.bbqhouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Thread splashTimer = new Thread(){
            public void run(){
                try{
                    int splashTimer = 0;
                    while (splashTimer < 5000){
                        sleep(100);
                        splashTimer = splashTimer + 100;
                    }
                        Intent navMainPage = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(navMainPage);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    finish();
                }
        }
    };
    splashTimer.start();
	}
}