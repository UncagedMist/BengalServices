package tbc.uncagedmist.bengalservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import tbc.uncagedmist.bengalservices.Ads.GoogleAds;
import tbc.uncagedmist.bengalservices.Common.Common;
import tbc.uncagedmist.bengalservices.Utility.MyApplicationClass;

public class VoterActivity extends AppCompatActivity {

    AppCompatButton btnApply, btnDownload, btnEdit, btnSearch,btnTrack, btnReprint, btnServices;

    private FrameLayout adContainerView;
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (MyApplicationClass.getInstance().isShowAds())   {
            GoogleAds.loadGoogleFullscreen(this);
        }

        setContentView(R.layout.activity_voter);

        btnApply = findViewById(R.id.btnApply);
        btnDownload = findViewById(R.id.btnDownload);
        btnEdit = findViewById(R.id.btnEdit);
        btnSearch = findViewById(R.id.btnSearch);
        btnTrack = findViewById(R.id.btnTrack);
        btnReprint = findViewById(R.id.btnReprint);
        btnServices = findViewById(R.id.btnOfficial);

        adContainerView = findViewById(R.id.bannerContainer);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner));
        adContainerView.addView(adView);

        if (MyApplicationClass.getInstance().isShowAds())   {
            loadBanner();
        }

        onClickImplementation();
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

    private void onClickImplementation() {

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(VoterActivity.this);
                }
                else {


                    Common.CurrentURL = Common.APPLY_VOTER;

                    startActivity(new Intent(VoterActivity.this,ResultActivity.class));
                }
            }
        });

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(VoterActivity.this);
                }
                else {
                    Common.CurrentURL = Common.DOWNLOAD_VOTER;

                    startActivity(new Intent(VoterActivity.this,ResultActivity.class));
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(VoterActivity.this);
                }
                else {
                    Common.CurrentURL = Common.EDIT_VOTER;

                    startActivity(new Intent(VoterActivity.this,ResultActivity.class));
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(VoterActivity.this);
                }
                else {

                    Common.CurrentURL = Common.SEARCH_VOTER;

                    startActivity(new Intent(VoterActivity.this,ResultActivity.class));
                }
            }
        });

        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(VoterActivity.this);
                }
                else {
                    Common.CurrentURL = Common.TRACK_VOTER;

                    startActivity(new Intent(VoterActivity.this,ResultActivity.class));
                }
            }
        });

        btnReprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(VoterActivity.this);
                }
                else {
                    Common.CurrentURL = Common.VOTER_REPRINT;

                    startActivity(new Intent(VoterActivity.this,ResultActivity.class));
                }
            }
        });

        btnServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(VoterActivity.this);
                }
                else {
                    Common.CurrentURL = Common.VOTER_SERVICES;

                    startActivity(new Intent(VoterActivity.this,ResultActivity.class));
                }
            }
        });
    }

}