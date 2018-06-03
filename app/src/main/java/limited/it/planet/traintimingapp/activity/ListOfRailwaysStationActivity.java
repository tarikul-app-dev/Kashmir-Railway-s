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

public class ListOfRailwaysStationActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    TableLayout tableLayout;
    static ArrayList<RailwayStation> allStationList ;
    DatabaseReference databaseReference;
    TextView txvHead;
    FontCustomization fontCustomization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_railways_station);
        toolbar = (Toolbar)findViewById(R.id.toolbar_list_of_station);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txvHead = (TextView)findViewById(R.id.txv_head);
        fontCustomization = new FontCustomization(ListOfRailwaysStationActivity.this);
        txvHead.setTypeface(fontCustomization.getTexgyreHerosBold());
        tableLayout = findViewById(R.id.tbl_layout_list_station);
        allStationList = new ArrayList<>();
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

        TableLayout tl = findViewById(R.id.tbl_layout_list_station);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());

        //  tr.addView(getTextView(0, "Auditor id", Color.WHITE, Typeface.BOLD, R.color.colorAccent));
        tr.addView(getTextView(0, "Serial Number", Color.WHITE, R.color.colorAccent));
        tr.addView(getTextView(0, "Stations", Color.WHITE, R.color.colorAccent));

        tl.addView(tr, getTblLayoutParams());
    }
    public void addRows(){

        for (int i = 0; i < allStationList.size(); i++) {
            TableRow tr = new TableRow(ListOfRailwaysStationActivity.this);
            tr.setLayoutParams(getLayoutParams());

            tr.addView(getRowsTextView(0, allStationList.get(i).getSerialNumber(), Color.BLACK , ContextCompat.getColor(ListOfRailwaysStationActivity.this, R.color.cell_background_color)));
            tr.addView(getRowsTextView(0, allStationList.get(i).getNameOfStaion(), Color.BLACK , ContextCompat.getColor(ListOfRailwaysStationActivity.this, R.color.cell_background_color)));


            tableLayout.addView(tr, getTblLayoutParams());

        }

    }

    public void addListItem(){
        RailwayStation railwayStation1 = new RailwayStation();
        railwayStation1.setSerialNumber("01");
        railwayStation1.setNameOfStaion("BANIHAL");
        allStationList.add(railwayStation1);

        RailwayStation railwayStation2 = new RailwayStation();
        railwayStation2.setSerialNumber("02");
        railwayStation2.setNameOfStaion("HILLAR");
        allStationList.add(railwayStation2);

        RailwayStation railwayStation3 = new RailwayStation();
        railwayStation3.setSerialNumber("03");
        railwayStation3.setNameOfStaion("QUAZIGUND");
        allStationList.add(railwayStation3);

        RailwayStation railwayStation4 = new RailwayStation();
        railwayStation4.setSerialNumber("04");
        railwayStation4.setNameOfStaion("SADURA");
        allStationList.add(railwayStation4);

        RailwayStation railwayStation5 = new RailwayStation();
        railwayStation5.setSerialNumber("05");
        railwayStation5.setNameOfStaion("ANANTNAG");
        allStationList.add(railwayStation5);

        RailwayStation railwayStation6 = new RailwayStation();
        railwayStation6.setSerialNumber("06");
        railwayStation6.setNameOfStaion("BIJBEHARA");
        allStationList.add(railwayStation6);

        RailwayStation railwayStation7 = new RailwayStation();
        railwayStation7.setSerialNumber("07");
        railwayStation7.setNameOfStaion("PANZGAM");
        allStationList.add(railwayStation7);

        RailwayStation railwayStation8 = new RailwayStation();
        railwayStation8.setSerialNumber("08");
        railwayStation8.setNameOfStaion("AWANTIPORA");
        allStationList.add(railwayStation8);


        RailwayStation railwayStation9 = new RailwayStation();
        railwayStation9.setSerialNumber("09");
        railwayStation9.setNameOfStaion("KAKPORA");
        allStationList.add(railwayStation9);

        RailwayStation railwayStation10 = new RailwayStation();
        railwayStation10.setSerialNumber("10");
        railwayStation10.setNameOfStaion("PAMPORE");
        allStationList.add(railwayStation10);

        RailwayStation railwayStation11 = new RailwayStation();
        railwayStation11.setSerialNumber("11");
        railwayStation11.setNameOfStaion("SRINAGAR");
        allStationList.add(railwayStation11);

        RailwayStation railwayStation112 = new RailwayStation();
        railwayStation112.setSerialNumber("12");
        railwayStation112.setNameOfStaion("BUDGAM");
        allStationList.add(railwayStation112);

        RailwayStation railwayStation113 = new RailwayStation();
        railwayStation113.setSerialNumber("13");
        railwayStation113.setNameOfStaion("MAZHOM");
        allStationList.add(railwayStation113);

        RailwayStation railwayStation114 = new RailwayStation();
        railwayStation114.setSerialNumber("14");
        railwayStation114.setNameOfStaion("PATTAN");
        allStationList.add(railwayStation114);

        RailwayStation railwayStation115 = new RailwayStation();
        railwayStation115.setSerialNumber("15");
        railwayStation115.setNameOfStaion("HAMRE");
        allStationList.add(railwayStation115);

        RailwayStation railwayStation116 = new RailwayStation();
        railwayStation116.setSerialNumber("16");
        railwayStation116.setNameOfStaion("SOPORE");
        allStationList.add(railwayStation116);

        RailwayStation railwayStation117 = new RailwayStation();
        railwayStation117.setSerialNumber("17");
        railwayStation117.setNameOfStaion("BARAMULLA");
        allStationList.add(railwayStation117);

    }
}
