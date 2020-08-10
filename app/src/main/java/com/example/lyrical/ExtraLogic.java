package com.example.lyrical;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ExtraLogic {

    //method for showing the error illustration and setting the error, since that could be different from case to case
    public void setErrormsg(final String errormsg, final TextView txerror, final LinearLayout lnlayouterror, final RecyclerView rvmain) {

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

                txerror.setText(errormsg);

                lnlayouterror.setVisibility(View.VISIBLE);

                rvmain.setVisibility(View.GONE);
            }
        });


    }

}
