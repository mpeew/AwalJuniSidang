package com.mpewpazi.android.awaljunisidang.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.masterDataModel.SingleMaster;

import java.util.List;


/**
 * Created by mpewpazi on 5/30/16.
 */
public class SpinnerAdapter extends ArrayAdapter<SingleMaster> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (SingleMaster)
    private List<SingleMaster> singleMasters;


    public SpinnerAdapter(Context context, List<? extends SingleMaster> singleMasters) {
        super(context, android.R.layout.simple_spinner_item, (List<SingleMaster>) singleMasters);
        this.context = context;
        this.singleMasters = (List<SingleMaster>) singleMasters;
    }

    public int getCount(){
        return singleMasters.size();
    }

    public SingleMaster getItem(int position){
        return singleMasters.get(position);
    }

    public long getItemId(int position){
        return position;
    }


    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);

            holder = new WeatherHolder();

            holder.txtTitle = (TextView)row.findViewById(android.R.id.text1);

            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }


        holder.txtTitle.setText(singleMasters.get(position).getNama());


        return row;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);

            holder = new WeatherHolder();

            holder.txtTitle = (TextView)row.findViewById(android.R.id.text1);

            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }


        holder.txtTitle.setText(singleMasters.get(position).getNama());


        return row;
    }

    static class WeatherHolder
    {
        TextView txtTitle;
    }

    public int getIndex(int id) {
        int index = 0;
        for (int i=0;i<getCount();i++){
            if (getItem(i).getId()==id){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int getIndex(Spinner spinner, String nama) {
        int index = 0;
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equals(nama)){
                index = i;
                break;
            }
        }
        return index;
    }
}
