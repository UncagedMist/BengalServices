package tbc.uncagedmist.bengalservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.browser.customtabs.CustomTabsIntent;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import tbc.uncagedmist.bengalservices.Common.Common;

public class RationActivity extends AppCompatActivity {

    AdView aboveBanner, bottomBanner;

    Button btnRationE, btnRationVerify, btnRationEntitle, btnRationLink, btnSearchRation, btnStatusRation;
    Button btnRationApply, btnRationForms, btnRationAdd, btnRationChange, btnDuplicate, btnRationFPS;
    Button btnDelete, btnCategory, btnNearest, btnCount, btnWhole;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_ration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(
                RationActivity.this,
                getString(R.string.fullscreen),
                adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;

                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d("TAG", "The ad was dismissed.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                Log.d("TAG", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                mInterstitialAd = null;
                                Log.d("TAG", "The ad was shown.");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });

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

        aboveBanner = findViewById(R.id.aboveBanner);
        bottomBanner = findViewById(R.id.belowBanner);

        aboveBanner.loadAd(adRequest);
        bottomBanner.loadAd(adRequest);

        onclickImplement();

        adMethod();
    }

    private void adMethod() {
        aboveBanner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        bottomBanner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

    }

    private void onclickImplement() {
        btnRationE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(RationActivity.this);
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

    private void askForPermission() {
        Dexter
                .withContext(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Toast.makeText(RationActivity.this, "Permission Granted...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(RationActivity.this, "Permission Denied!! You Can't Download Files.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    private void copyAsset(String fileName) {
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/BiharServices";
        File dir = new File(dirPath);

        if (!dir.exists())  {
            dir.mkdirs();
        }

        AssetManager assetManager = getAssets();
        InputStream in = null;
        OutputStream out = null;

        try {
            in = assetManager.open(fileName);
            File outFile = new File(dirPath, fileName);
            out = new FileOutputStream(outFile);
            copyFile(in, out);
            Toast.makeText(this, "File Saved!! Now Check in BiharService Folder.", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)   {
            e.printStackTrace();
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (IOException e)   {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                }
                catch (IOException e)   {
                    e.printStackTrace();
                }
            }
        }

    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;

        while((read = in.read(buffer)) != -1)   {
            out.write(buffer, 0 ,read);
        }
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
}