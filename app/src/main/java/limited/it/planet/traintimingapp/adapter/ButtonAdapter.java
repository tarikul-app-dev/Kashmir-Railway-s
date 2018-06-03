package limited.it.planet.traintimingapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.activity.AllStationTimingActivity;
import limited.it.planet.traintimingapp.activity.ContactUsActivity;
import limited.it.planet.traintimingapp.activity.HelpLineActivity;
import limited.it.planet.traintimingapp.activity.ListOfRailwaysStationActivity;
import limited.it.planet.traintimingapp.activity.MainActivity;
import limited.it.planet.traintimingapp.activity.OnlineBookingActivity;
import limited.it.planet.traintimingapp.activity.StatusActivity;
import limited.it.planet.traintimingapp.utill.FontCustomization;


/**
 * Created by Tarikul on 4/10/2018.
 */

public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    private String[] filesnames;
    public  int[] colors;
    GridViewButtonInterface gridViewButtonInterface;
    Drawable [] drawables;
    FontCustomization fontCustomization;
    // Gets the context so it can be used later
    public ButtonAdapter(Context c,String[] filesnames,GridViewButtonInterface gridViewButtonInterface,Drawable[] drawables,int[] colors) {
        mContext = c;
        this.filesnames = filesnames;
        this.gridViewButtonInterface = gridViewButtonInterface;
        this.drawables = drawables;
        this.colors = colors;
        fontCustomization = new FontCustomization(mContext);

    }

    // Total number of things contained within the adapter
    public int getCount() {
        return filesnames.length;
    }

    // Require for structure, not really used in my code.
    public Object getItem(int position) {
        return null;
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View getView(final int position,
                        View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        gridView =new View(mContext);

        gridView = inflater.inflate(R.layout.grid_layout, null);
        ImageButton imageButton = (ImageButton)gridView.findViewById(R.id.imgbtnDemo);
        TextView textView = (TextView) gridView.findViewById(R.id.txv_btn_name);
        final FrameLayout frameLayoutBtn = (FrameLayout)gridView.findViewById(R.id.btn_framelayout);

        imageButton.setBackgroundDrawable(drawables[position]);
        textView.setText(filesnames[position]);
        frameLayoutBtn.setBackgroundColor(colors[position]);



        textView.setTypeface(fontCustomization.getTexgyreHerosBold());



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               gridViewButtonInterface.getGridButtonPosition(position);
            }
        });

        frameLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0){ // position 0 is for language Setting
                    Intent intent = new Intent(mContext,StatusActivity.class);
                    mContext.startActivity(intent);
                }else if (position==1){
                    //Train Timing
                    Intent intent = new Intent(mContext,AllStationTimingActivity.class);
                    mContext.startActivity(intent);
                }else if (position==2){
                    Intent intent = new Intent(mContext,OnlineBookingActivity.class);
                    mContext.startActivity(intent);
                }else if (position==3){
                    Intent intent = new Intent(mContext,ListOfRailwaysStationActivity.class);
                    mContext.startActivity(intent);

                }else if (position==4){
                    Intent intent = new Intent(mContext,HelpLineActivity.class);
                    mContext.startActivity(intent);
                }else if (position==5){
                    Intent intent = new Intent(mContext,ContactUsActivity.class);
                    mContext.startActivity(intent);
                }else if(position==6){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, "http://kashmirrailways.in");
                    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this site!");
                    mContext.startActivity(Intent.createChooser(intent, "Share"));
                }
            }
        });




        return gridView;
    }

    public interface GridViewButtonInterface{
        void getGridButtonPosition(int position);
    }
}
