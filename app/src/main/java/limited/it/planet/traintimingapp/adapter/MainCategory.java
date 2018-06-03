package limited.it.planet.traintimingapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import limited.it.planet.traintimingapp.R;

/**
 * Created by Tarikul on 5/17/2018.
 */

public class MainCategory extends  ArrayAdapter<String>  {

    private String[] mHeadline;
    private Activity mContext;
    public MainCategory(Activity context,String[] headline ){
        super(context, R.layout.main_list_item,headline);
        this.mContext = context;
        this.mHeadline = headline;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.main_list_item, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.txv_category_name);
        textViewName.setText(mHeadline[position]);


        return  listViewItem;
    }
}
