package limited.it.planet.traintimingapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.adapter.MainCategory;
import limited.it.planet.traintimingapp.adapter.TrainTiming;
import limited.it.planet.traintimingapp.utill.FontCustomization;
import com.google.android.gms.ads.AdRequest;

public class AllStationTimingActivity extends AppCompatActivity {
    ListView lvTrainTiming;
    private String []headline = {" ALL STATIONS TIMING","BANIHAL TO BARAMULLA","BARAMULLA TO BANIHAL","ANANTNAG TO BADGAM",
            "ANANTNAG TO BARAMULLA","ANANTNAG TO BANIHAL","BANIHAL TO BADGAM","BADGAM TO BANIHAL","BADGAM TO BARAMULLA","OTHER TRAIN TIMING"};
    Toolbar toolbar;
    TextView txvHead;
    FontCustomization fontCustomization;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_station_timing);
        toolbar = (Toolbar)findViewById(R.id.toolbar_train_timing);
        setSupportActionBar(toolbar);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        initViews();
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });

    }

    public void initViews(){
        txvHead = (TextView)findViewById(R.id.txv_head);
        lvTrainTiming = (ListView)findViewById(R.id.lv_train_timing);
        //Setting List Item
        TrainTiming trainTiming = new TrainTiming(AllStationTimingActivity.this,headline);
        lvTrainTiming.setAdapter(trainTiming);
        lvTrainTiming.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int stationItem = spinner1.getSelectedItemPosition();
                switch (position) {
                    case 1:
                        Intent baniToBaram = new Intent(AllStationTimingActivity.this,BANITOBARAMActivity.class);
                        startActivity(baniToBaram);
                        // ActivityCompat.finishAffinity(MainActivity.this);
                        return;
                    case 2:
                        Intent baramToBani = new Intent(AllStationTimingActivity.this,BARAMTOBANIActivity.class);
                        startActivity(baramToBani);
                        return;
                    case 3:
                        Intent ananToBad = new Intent(AllStationTimingActivity.this,ANANTOBADGAMActivity.class);
                        startActivity(ananToBad);
                        return;
                    case 4:
                        Intent ananToBaram = new Intent(AllStationTimingActivity.this,ANANTOBARAMActivity.class);
                        startActivity(ananToBaram);
                        return;

                    case 5:
                        Intent ananToBani= new Intent(AllStationTimingActivity.this,ANANTOBANIActivity.class);
                        startActivity(ananToBani);
                        return;
                    case 6:
                        Intent banitobad= new Intent(AllStationTimingActivity.this,BANITOBADActivity.class);
                        startActivity(banitobad);
                        return;
                    case 7:
                        Intent badtobani= new Intent(AllStationTimingActivity.this,BADToBANIActivity.class);
                        startActivity(badtobani);
                        return;
                    case 8:
                        Intent badtobaram= new Intent(AllStationTimingActivity.this,BADTOBARAMActivity.class);
                        startActivity(badtobaram);
                        return;

                    case 9:
                        Intent otherTTiming= new Intent(AllStationTimingActivity.this,OtherTrainTimingActivity.class);
                        startActivity(otherTTiming);
                        return;
                    default: //By default set to english


                        return;
                }
            }
        });

        fontCustomization = new FontCustomization(AllStationTimingActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());
    }
}
