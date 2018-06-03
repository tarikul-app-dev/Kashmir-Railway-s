package limited.it.planet.traintimingapp.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.model.RailwayStation;
import limited.it.planet.traintimingapp.utill.FontCustomization;

public class HelpLineActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    TableLayout tableLayout;
    static ArrayList<RailwayStation> helplineList ;
    DatabaseReference databaseReference;
    TextView txvHead;
    FontCustomization fontCustomization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line);
        toolbar = (Toolbar)findViewById(R.id.toolbar_help_line);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 onBackPressed();

            }
        });

        txvHead = (TextView)findViewById(R.id.txv_head);
        fontCustomization = new FontCustomization(HelpLineActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());
        tableLayout = findViewById(R.id.tbl_layout_helpline);
        helplineList = new ArrayList<>();
        addListItem();

        addHeaders();
        addRows();
    }

    private TextView getTextView(int id, String title, int color, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(40, 40, 40, 40);
        tv.setTypeface(fontCustomization.getTexgyreHerosBold());
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }
    private TextView getRowsTextView(int id, String title, int color, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title);
        tv.setTextColor(color);
        tv.setPadding(40, 40, 40, 40);
        tv.setTypeface(fontCustomization.getTexgyreHerosRegular());
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }

    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * This function add the headers to the table
     **/
    public void addHeaders() {

        TableLayout tl = findViewById(R.id.tbl_layout_helpline);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());

        //  tr.addView(getTextView(0, "Auditor id", Color.WHITE, Typeface.BOLD, R.color.colorAccent));
        tr.addView(getTextView(0, "STATIONS", Color.WHITE, R.color.colorAccent));
        tr.addView(getTextView(0, "HELP-LINE", Color.WHITE, R.color.colorAccent));

        tl.addView(tr, getTblLayoutParams());
    }
    public void addRows(){

        for (int i = 0; i < helplineList.size(); i++) {
            TableRow tr = new TableRow(HelpLineActivity.this);
            tr.setLayoutParams(getLayoutParams());

            tr.addView(getRowsTextView(0, helplineList.get(i).getNameOfStaion(), Color.BLACK, ContextCompat.getColor(HelpLineActivity.this, R.color.cell_background_color)));
            tr.addView(getRowsTextView(0, helplineList.get(i).getHelplineNumber(), Color.BLACK, ContextCompat.getColor(HelpLineActivity.this, R.color.cell_background_color)));


            tableLayout.addView(tr, getTblLayoutParams());

        }

    }

    public void addListItem(){
        RailwayStation railwayStation1 = new RailwayStation();
        railwayStation1.setNameOfStaion("BANIHAL");
        helplineList.add(railwayStation1);

        RailwayStation railwayStation2 = new RailwayStation();
        railwayStation2.setNameOfStaion("HILLAR");
        helplineList.add(railwayStation2);

        RailwayStation railwayStation3 = new RailwayStation();
        railwayStation3.setNameOfStaion("QUAZIGUND");
        railwayStation3.setHelplineNumber("01951-296153");
        helplineList.add(railwayStation3);

        RailwayStation railwayStation4 = new RailwayStation();
        railwayStation4.setHelplineNumber("01932-210302");
        railwayStation4.setNameOfStaion("SADURA");
        helplineList.add(railwayStation4);

        RailwayStation railwayStation5 = new RailwayStation();
        railwayStation5.setHelplineNumber("01932-228243");
        railwayStation5.setNameOfStaion("ANANTNAG");
        helplineList.add(railwayStation5);

        RailwayStation railwayStation6 = new RailwayStation();
        railwayStation6.setHelplineNumber("01932-292181");
        railwayStation6.setNameOfStaion("BIJBEHARA");
        helplineList.add(railwayStation6);

        RailwayStation railwayStation7 = new RailwayStation();
        railwayStation7.setHelplineNumber("01933-294133");
        railwayStation7.setNameOfStaion("PANZGAM");
        helplineList.add(railwayStation7);

        RailwayStation railwayStation8 = new RailwayStation();
        railwayStation8.setHelplineNumber("01933-294131");
        railwayStation8.setNameOfStaion("AWANTIPORA");
        helplineList.add(railwayStation8);


        RailwayStation railwayStation9 = new RailwayStation();
        railwayStation9.setHelplineNumber("01933-294134");
        railwayStation9.setNameOfStaion("KAKPORA");
        helplineList.add(railwayStation9);

        RailwayStation railwayStation10 = new RailwayStation();
        railwayStation10.setHelplineNumber("01933-294132");
        railwayStation10.setNameOfStaion("PAMPORE");
        helplineList.add(railwayStation10);

        RailwayStation railwayStation11 = new RailwayStation();
        railwayStation11.setHelplineNumber("0194-2103259");
        railwayStation11.setNameOfStaion("SRINAGAR");
        helplineList.add(railwayStation11);

        RailwayStation railwayStation112 = new RailwayStation();
        railwayStation112.setHelplineNumber("01951-255164");
        railwayStation112.setNameOfStaion("BUDGAM");
        helplineList.add(railwayStation112);

        RailwayStation railwayStation113 = new RailwayStation();
        railwayStation113.setHelplineNumber("01951-296208");
        railwayStation113.setNameOfStaion("MAZHOM");
        helplineList.add(railwayStation113);

        RailwayStation railwayStation114 = new RailwayStation();
        railwayStation114.setHelplineNumber("01954-293507");
        railwayStation114.setNameOfStaion("PATTAN");
        helplineList.add(railwayStation114);

        RailwayStation railwayStation115 = new RailwayStation();
        railwayStation115.setHelplineNumber("0194-2231421");
        railwayStation115.setNameOfStaion("HAMRE");
        helplineList.add(railwayStation115);

        RailwayStation railwayStation116 = new RailwayStation();
        railwayStation116.setNameOfStaion("SOPORE");
        helplineList.add(railwayStation116);

        RailwayStation railwayStation117 = new RailwayStation();
        railwayStation117.setHelplineNumber("0194-102029");
        railwayStation117.setNameOfStaion("BARAMULLA");
        helplineList.add(railwayStation117);

    }
}
