package limited.it.planet.traintimingapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import limited.it.planet.traintimingapp.R;
import limited.it.planet.traintimingapp.utill.FontCustomization;

public class TrainTiming extends ArrayAdapter<String> {
    private String[] mHeadline;
    private Activity mContext;
    FontCustomization fontCustomization;

    public TrainTiming(Activity context,String[] headline ){
        super(context, R.layout.train_list_item,headline);
        this.mContext = context;
        this.mHeadline = headline;
        fontCustomization = new FontCustomization(mContext);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.train_list_item, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.txv_category_name);
        textViewName.setText(mHeadline[position]);

        textViewName.setTypeface(fontCustomization.getTexgyreHerosBold());

        return  listViewItem;
    }
}