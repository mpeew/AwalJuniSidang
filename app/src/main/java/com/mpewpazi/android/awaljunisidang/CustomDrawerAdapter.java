package com.mpewpazi.android.awaljunisidang;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

import java.util.List;

public class CustomDrawerAdapter extends ArrayAdapter<SingleMenuChecking> {

    Context context;
    List<SingleMenuChecking> drawerItemList;
    int layoutResID;
    boolean isIndustriGalpal;

    public CustomDrawerAdapter(Context context, int layoutResourceID,
                               List<SingleMenuChecking> listItems,boolean isIndustriGalpal) {
        super(context, layoutResourceID, listItems);
        this.context = context;
        this.drawerItemList = listItems;
        this.layoutResID = layoutResourceID;
        this.isIndustriGalpal=isIndustriGalpal;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        DrawerItemHolder drawerHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            drawerHolder = new DrawerItemHolder();

            view = inflater.inflate(layoutResID, parent, false);

            drawerHolder.mNoTextView=(TextView) view.findViewById(R.id.list_item_single_form_no);
            drawerHolder.mTittleTextView=(TextView) view.findViewById(R.id.list_item_single_form_title);
            drawerHolder.mStatusFillTextView=(ImageView) view.findViewById(R.id.list_item_single_form_status_fill);
            drawerHolder.mStatusCompleteTextView=(ImageView) view.findViewById(R.id.list_item_single_form_status_complete);
            drawerHolder.mStatusVerifiedTextView=(ImageView)view.findViewById(R.id.list_item_single_form_status_verified);

            view.setTag(drawerHolder);

        } else {
            drawerHolder = (DrawerItemHolder) view.getTag();

        }

        SingleMenuChecking singleMenuChecking = (SingleMenuChecking) this.drawerItemList.get(position);
        Menu menu;
        if(isIndustriGalpal) {
            menu=DummyMaker.get(context).getMenuF1(singleMenuChecking.getIdMenu());
        }else{
            menu=DummyMaker.get(context).getMenuF2(singleMenuChecking.getIdMenu());
        }

        drawerHolder.mTittleTextView.setText(menu.getNamaMenu());
        drawerHolder.mNoTextView.setText(String.valueOf(menu.getNumber()));
        if(singleMenuChecking.isFill()){
            drawerHolder.mStatusFillTextView.setImageResource(R.drawable.ok_icon);
        }
        if(singleMenuChecking.isComplete()){
            drawerHolder.mStatusCompleteTextView.setImageResource(R.drawable.ok_icon);
        }
        if(singleMenuChecking.isVerified()){
            drawerHolder.mStatusVerifiedTextView.setImageResource(R.drawable.ok_icon);
        }


        return view;
    }

    private static class DrawerItemHolder {
        TextView mNoTextView;
        TextView mTittleTextView;
        ImageView mStatusFillTextView;
        ImageView mStatusCompleteTextView;
        ImageView mStatusVerifiedTextView;
        CustomClickListener mCustomClickListener;
    }
}