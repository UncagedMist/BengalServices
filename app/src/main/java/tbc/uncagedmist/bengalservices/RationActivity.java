package tbc.uncagedmist.bengalservices;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Locale;

import tbc.uncagedmist.bengalservices.Common.Common;

public class RationActivity extends AppCompatActivity {

    AdView adView;

    Button btnRationE, btnRationVerify, btnRationEntitle, btnRationLink, btnSearchRation, btnStatusRation;
    Button btnRationApply, btnRationForms, btnRationAdd, btnRationChange, btnDuplicate, btnRationFPS;
    Button btnDelete, btnCategory, btnNearest, btnCount, btnWhole;

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_ration);

        loadBanner();
        loadFullscreen();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        btnRationE = findViewById(R.id.btnRationE);
        btnRationVerify = findViewById(R.id.btnVerifyRation);
        btnRationEntitle = findViewById(R.id.btnEntitlement);
        btnRationLink = findViewById(R.id.btnRationLink);
        btnSearchRation = findViewById(R.id.btnSearchRation);
        btnStatusRation = findViewById(R.id.btnStatusRation);
        btnRationApply = findViewById(R.id.btnRationApply);
        btnRationForms = findViewById(R.id.btnForms);
        btnRationAdd = findViewById(R.id.btnRationAdd);
        btnRationChange = findViewById(R.id.btnRationChange);
        btnDuplicate = findViewById(R.id.btnRationDuplicate);
        btnRationFPS = findViewById(R.id.btnRationFPS);
        btnDelete = findViewById(R.id.btnDelete);
        btnCategory = findViewById(R.id.btnCategory);
        btnNearest = findViewById(R.id.btnNear);
        btnCount = findViewById(R.id.btnCount);
        btnWhole = findViewById(R.id.btnWhole);

        onclickImplement();
    }

    private void loadFullscreen() {
        interstitialAd = new InterstitialAd(
                this,
                getString(R.string.fb_fullscreen)
        );

        // Create listeners for the Interstitial Ad
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e("TAG", "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e("TAG", "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d("TAG", "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d("TAG", "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d("TAG", "Interstitial ad impression logged!");
            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
    }

    private void loadBanner() {
        adView = new AdView(
                this,
                getString(R.string.fb_banner),
                AdSize.BANNER_HEIGHT_50
        );

        // Find the Ad Container
        LinearLayout adContainer = findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        };

        // Request an ad
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
    }

    private void onclickImplement() {
        btnRationE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_E);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_VERIFY);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationEntitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_ENTITLEMENT);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_LINK);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnSearchRation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_SEARCH);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnStatusRation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_STATUS);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_APPLY);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_FORMS);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_ADD_MEMBER);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_CHANGE);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnDuplicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_DUPLICATE);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnRationFPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_FPS_CHANGE);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_DELETE);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_CATEGORY);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnNearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_NEAREST_FPS);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_COUNT);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnWhole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }
                else {
                    Intent intent = new Intent(RationActivity.this,ResultActivity.class);
                    intent.putExtra("url", Common.RATION_WHOLE);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void loadLocale()   {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        //shared prefs
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}