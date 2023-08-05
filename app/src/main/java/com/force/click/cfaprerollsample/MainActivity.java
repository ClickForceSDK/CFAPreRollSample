package com.force.click.cfaprerollsample;

import android.content.res.Configuration;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clickforce.ad.Listener.PreRollViewLinstener;
import com.clickforce.ad.PreRollAdView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private PreRollAdView preRollAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preRollAdView = (PreRollAdView) this.findViewById(R.id.preroll);
        preRollAdView.setAdTagUrl(String.valueOf("12271"));
        preRollAdView.setAdPlay(this);
        preRollAdView.setIsVolume(true);

        preRollAdView.setOnPreRollViewLoaded(new PreRollViewLinstener() {
            @Override
            public void onStartPlayVideo() {
                Log.d("CF","play");
            }

            @Override
            public void onFailedToPreRollAd() {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (preRollAdView != null) preRollAdView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (preRollAdView != null) preRollAdView.pause();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        preRollAdView.fullScreen(this);

    }
}
