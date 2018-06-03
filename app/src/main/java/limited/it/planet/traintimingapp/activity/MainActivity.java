package limited.it.planet.traintimingapp.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.adapter.ButtonAdapter;
import limited.it.planet.traintimingapp.adapter.MainCategory;
import limited.it.planet.traintimingapp.utill.FontCustomization;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity implements ButtonAdapter.GridViewButtonInterface{
    GridView lvMainCategory;
    private String []headline = {"STATUS","TRAIN TIMING","ONLINE BOOKING","RAILWAY STATIONS","HELPLINE NUMBER","CONTACT US","SHARE"};
    AlertDialog b;
    Spinner spinner1;
    FontCustomization fontCustomization;
    TextView txvHead;
    public Drawable[] drawables = new Drawable[7];
    public int colors[] = new int[7];
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2650328417911011/5304382557");
        // Request for Ads ca-app-pub-2650328417911011/5304382557
        AdRequest adRequest = new AdRequest.Builder().build();
        requestNewInterstitial();
        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        // Prepare an Interstitial Ad Listener
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }


        });

    }

    public void initViews(){
        txvHead = (TextView)findViewById(R.id.txv_head);
        lvMainCategory = (GridView) findViewById(R.id.btn_gridview);
        //Setting List Item
        drawables[0] = this.getResources().getDrawable(R.drawable.status);
        drawables[1] = this.getResources().getDrawable(R.drawable.timing);
        drawables[2] = this.getResources().getDrawable(R.drawable.online_booking);
        drawables[3] = this.getResources().getDrawable(R.drawable.list_of_railways);
        drawables[4] = this.getResources().getDrawable(R.drawable.help_line);
        drawables[5] = this.getResources().getDrawable(R.drawable.contact_us);
        drawables[6] = this.getResources().getDrawable(R.drawable.share);

        colors[0] =ContextCompat.getColor(MainActivity.this, R.color.color_status);
        colors[1] =ContextCompat.getColor(MainActivity.this, R.color.color_timing);
        colors[2] = ContextCompat.getColor(MainActivity.this, R.color.color_online_booking);
        colors[3] =  ContextCompat.getColor(MainActivity.this, R.color.color_railways_station);
        colors[4] =  ContextCompat.getColor(MainActivity.this, R.color.color_help_line);
        colors[5] =  ContextCompat.getColor(MainActivity.this, R.color.color_contact_us);
        colors[6] =  ContextCompat.getColor(MainActivity.this, R.color.blue_500);

        lvMainCategory.setAdapter(new ButtonAdapter(MainActivity.this,headline,this,drawables,colors));

        fontCustomization = new FontCustomization(MainActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());

    }


    @Override
    public void getGridButtonPosition(int position) {
        if(position==0){ // position 0 is for language Setting
            Intent intent = new Intent(MainActivity.this,StatusActivity.class);
            startActivity(intent);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }else if (position==1){
            //Train Timing
            Intent intent = new Intent(MainActivity.this,AllStationTimingActivity.class);
            startActivity(intent);
        }else if (position==2){
            Intent intent = new Intent(MainActivity.this,OnlineBookingActivity.class);
            startActivity(intent);
        }else if (position==3){
            Intent intent = new Intent(MainActivity.this,ListOfRailwaysStationActivity.class);
            startActivity(intent);

        }else if (position==4){
            Intent intent = new Intent(MainActivity.this,HelpLineActivity.class);
            startActivity(intent);
        }else if (position==5){
            Intent intent = new Intent(MainActivity.this,ContactUsActivity.class);
            startActivity(intent);
        }else if (position==6){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "https://kashmirrailways.in");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this site!");
            startActivity(Intent.createChooser(intent, "Share"));
        }
    }
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
