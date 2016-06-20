package com.example.nguyennghia.admobads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class FullAdsActivity extends AppCompatActivity {

    private static final String TAG = "FullAdsActivity";
    private InterstitialAd interstitialAd;
    private AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_ads);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.ad_unit_full));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.i(TAG, "onAdLoaded: ");
                interstitialAd.show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();

                Log.i(TAG, "onAdOpened: ");
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                Log.i(TAG, "onAdLeftApplication: ");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.i(TAG, "onAdFailedToLoad: ");
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.i(TAG, "onAdClosed: ");
            }
        });

        adRequest = new AdRequest.Builder().addTestDevice("9D50B2710767A863E237BDB4FC17C196").build();
        interstitialAd.loadAd(adRequest);
    }
}
