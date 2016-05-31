package com.mpewpazi.android.awaljunisidang.Fragment;

import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.mpewpazi.android.awaljunisidang.CustomClickListener;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class SingleFragment extends Fragment {
    protected CustomClickListener mCustomClickListener;


    public void setCustomClickListener(CustomClickListener customClickListener){
        mCustomClickListener=customClickListener;
    }

    protected void setViewEnabledFalse(View view) {

        if (view instanceof LinearLayout) {
            LinearLayout viewGroup = (LinearLayout) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof ScrollView) {
            ScrollView viewGroup = (ScrollView) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof CardView) {
            CardView viewGroup = (CardView) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof RecyclerView) {
            RecyclerView viewGroup = (RecyclerView) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof TextInputLayout) {
            TextInputLayout viewGroup = (TextInputLayout) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof EditText) {
            view.setEnabled(false);
            view.setFocusable(false);
        }else if (view instanceof Button) {
            view.setVisibility(View.GONE);
        }else if (view instanceof ImageButton) {
            view.setVisibility(View.GONE);
        }else if (view instanceof Spinner) {
            view.setEnabled(false);
        }
    }

    protected void setViewNote(KualifikasiSurvey mKualifikasiSurvey, SingleForm singleForm){
        if(mKualifikasiSurvey.getStatus()==2 && singleForm.getNote()!=null){
            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setMessage("Komentar :  " +singleForm.getNote());

            alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

}
