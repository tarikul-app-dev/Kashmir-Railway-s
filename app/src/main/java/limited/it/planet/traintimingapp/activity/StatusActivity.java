package limited.it.planet.traintimingapp.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.model.StatusM;
import limited.it.planet.traintimingapp.model.TrainSchedule;
import limited.it.planet.traintimingapp.utill.FontCustomization;

public class StatusActivity extends AppCompatActivity {
    Toolbar toolbar;
    DatabaseReference databaseReference;
    TextView txvHead,txvStatus;
    FontCustomization fontCustomization;
    static ArrayList<StatusM> statusList ;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        toolbar = (Toolbar)findViewById(R.id.toolbar_status);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initViews();

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initViews(){
        statusList = new ArrayList<>();
        txvHead = (TextView)findViewById(R.id.txv_head);
        txvStatus = (TextView)findViewById(R.id.txv_status);

        fontCustomization = new FontCustomization(StatusActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());
        databaseReference = FirebaseDatabase.getInstance().getReference("status");
       // DatabaseReference dr = databaseReference.child("status");

        databaseReference.addValueEventListener(new ValueEventListener() {
            // ArrayList<TrainSchedule> trainScheduleList = new ArrayList<>();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    StatusM c = snapshot.getValue(StatusM.class);
                    //Log.d("Categories: ", c.name + " " + c.food_items);
                    statusList.add(c);

                }
                txvStatus.setText(statusList.get(0).getStatus_nume());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
