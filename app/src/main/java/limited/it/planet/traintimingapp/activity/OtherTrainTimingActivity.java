package limited.it.planet.traintimingapp.activity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.storage.FirebaseStorage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.utill.FontCustomization;
import limited.it.planet.traintimingapp.utill.TouchImageView;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.StorageReference;

public class OtherTrainTimingActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txvHead;
    ImageView imgvOtherTarin;
    FontCustomization fontCustomization;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_train_timing);
        toolbar = (Toolbar)findViewById(R.id.toolbar_Other_train_timing);
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

    @SuppressLint("ResourceType")
    public void initViews() {
        txvHead = (TextView) findViewById(R.id.txv_head);
        imgvOtherTarin = (ImageView) findViewById(R.id.img_other_train_timing);
        fontCustomization = new FontCustomization(OtherTrainTimingActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());

        downloadImage();
    }

    public void downloadImage() {
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        storageRef.child("/images").getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {

                    @Override
                    public void onSuccess(Uri uri) {
                        Glide.with(OtherTrainTimingActivity.this)
                                .load(uri)
                                .into(imgvOtherTarin);

                        Toast.makeText(OtherTrainTimingActivity.this, "Success ", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Toast.makeText(OtherTrainTimingActivity.this, "Failed "+ exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
