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

public class RationActivity extends AppCompatActivity {

    AppCompatButton btnRationE, btnRationStatus, btnRationLink, btnRationEntitle, btnRationForm, btnRationNearest;
    AppCompatButton btnRationNew, btnRationMember, btnRationEdit, btnRationShift, btnRationCancel, btnRationCategory;
    AppCompatButton btnrationNon, btnRationChangeKero, btnRationMobile, btnRationDown;

    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (MyApplicationClass.getInstance().isShowAds())   {
            GoogleAds.loadGoogleFullscreen(this);
        }

        setContentView(R.layout.activity_ration);

        btnRationE = findViewById(R.id.btnRationE);
        btnRationStatus = findViewById(R.id.btnRationStatus);
        btnRationLink = findViewById(R.id.btnRationLink);
        btnRationEntitle = findViewById(R.id.btnRationEntitle);
        btnRationForm = findViewById(R.id.btnRationForm);
        btnRationNearest = findViewById(R.id.btnRationNearest);
        btnRationNew = findViewById(R.id.btnRationNew);
        btnRationMember = findViewById(R.id.btnRationMember);
        btnRationEdit = findViewById(R.id.btnRationEdit);
        btnRationShift = findViewById(R.id.btnRationShift);
        btnRationCancel = findViewById(R.id.btnRationCancel);
        btnRationCategory = findViewById(R.id.btnRationCategory);
        btnrationNon = findViewById(R.id.btnrationNon);
        btnRationChangeKero = findViewById(R.id.btnRationChangeKero);
        btnRationMobile = findViewById(R.id.btnRationMobile);
        btnRationDown = findViewById(R.id.btnRationDown);

        adContainerView = findViewById(R.id.bannerContainer);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner));
        adContainerView.addView(adView);

        if (MyApplicationClass.getInstance().isShowAds())   {
            loadBanner();
        }

        onclickImplement();
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

    private void onclickImplement() {

        btnRationE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_E;
                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_STATUS;
                    startActivity(new Intent(RationActivity.this,ResultActivity.class));

                }
            }
        });

        btnRationEntitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {

                    Common.CurrentURL = Common.RATION_ENTITLEMENT;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_AADHAAR;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });



        btnRationForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_FORMS;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationNearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_FPS;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {

                    Common.CurrentURL = Common.RATION_NEW;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {

                    Common.CurrentURL = Common.RATION_NEW_MEMBER;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {

                    Common.CurrentURL = Common.RATION_EDIT;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationShift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_SHIFT;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_CANCEL;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_CATEGORY;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnrationNon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_NON;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationChangeKero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_KEROSENE;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_MOBILE;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });

        btnRationDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GoogleAds.mInterstitialAd != null)  {
                    GoogleAds.mInterstitialAd.show(RationActivity.this);
                }
                else {
                    Common.CurrentURL = Common.RATION_E_RATION;

                    startActivity(new Intent(RationActivity.this,ResultActivity.class));
                }
            }
        });
    }

}