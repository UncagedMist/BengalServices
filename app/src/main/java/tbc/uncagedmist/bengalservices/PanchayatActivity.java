package tbc.uncagedmist.bengalservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import tbc.uncagedmist.bengalservices.Ads.GoogleAds;
import tbc.uncagedmist.bengalservices.Common.Common;
import tbc.uncagedmist.bengalservices.Utility.MyApplicationClass;

public class PanchayatActivity extends AppCompatActivity {

    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (MyApplicationClass.getInstance().isShowAds())   {
            GoogleAds.loadGoogleFullscreen(this);
        }

        setContentView(R.layout.activity_panchayat);

        adContainerView = findViewById(R.id.bannerContainer);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner));
        adContainerView.addView(adView);

        if (MyApplicationClass.getInstance().isShowAds())   {
            loadBanner();
        }

        onCLickImplemetation();
    }

    private void loadBanner() {
        AdRequest adRequest = new AdRequest.Builder().build();

        AdSize adSize = getAdSize();
        // Step 4 - Set the adaptive ad size on the ad view.
        adView.setAdSize(adSize);

        // Step 5 - Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }

    private void onCLickImplemetation() {
        findViewById(R.id.btnSchedule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(PanchayatActivity.this);
                }
                else {
                    Common.CurrentURL = Common.P_SCHEDULE;
                    startActivity(new Intent(PanchayatActivity.this,ResultActivity.class));
                }
            }
        });

        findViewById(R.id.btnOnline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(PanchayatActivity.this);
                }
                else {
                    Common.CurrentURL = Common.P_ONLINE;
                    startActivity(new Intent(PanchayatActivity.this,ResultActivity.class));
                }
            }
        });

        findViewById(R.id.btnElectoral).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(PanchayatActivity.this);
                }
                else {
                    Common.CurrentURL = Common.P_ELECTORAL;
                    startActivity(new Intent(PanchayatActivity.this,ResultActivity.class));
                }
            }
        });

        findViewById(R.id.btnForms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(PanchayatActivity.this);
                }
                else {
                    Common.CurrentURL = Common.P_ROLL;
                    startActivity(new Intent(PanchayatActivity.this,ResultActivity.class));
                }
            }
        });

        findViewById(R.id.btnBlo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(PanchayatActivity.this);
                }
                else {
                    Common.CurrentURL = Common.P_BLO;
                    startActivity(new Intent(PanchayatActivity.this,ResultActivity.class));
                }
            }
        });

        findViewById(R.id.btnBla).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(PanchayatActivity.this);
                }
                else {
                    Common.CurrentURL = Common.P_BLA;
                    startActivity(new Intent(PanchayatActivity.this,ResultActivity.class));
                }
            }
        });

        findViewById(R.id.btnClaim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(PanchayatActivity.this);
                }
                else {
                    Common.CurrentURL = Common.P_CLAIM;
                    startActivity(new Intent(PanchayatActivity.this,ResultActivity.class));
                }
            }
        });
    }
}