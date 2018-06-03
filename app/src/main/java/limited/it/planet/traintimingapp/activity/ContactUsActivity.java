package limited.it.planet.traintimingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.utill.FontCustomization;

public class ContactUsActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txvHead;
    FontCustomization fontCustomization;
    TextView txvConHead,txvContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        toolbar = (Toolbar)findViewById(R.id.toolbar_contact_us);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txvHead = (TextView)findViewById(R.id.txv_head);
        fontCustomization = new FontCustomization(ContactUsActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());
    }

    public void initViews(){
        txvConHead = (TextView)findViewById(R.id.txv_contact_head);
        txvContactUs = (TextView)findViewById(R.id.txv_contact_us);

        txvConHead.setTypeface(fontCustomization.getTexgyreHerosRegular());
        txvContactUs.setTypeface(fontCustomization.getTexgyreHerosBold());
    }

}
