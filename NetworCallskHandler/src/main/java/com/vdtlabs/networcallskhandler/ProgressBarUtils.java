package com.vdtlabs.networcallskhandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by Vinod Dirishala on 08-06-2019
 **/
public class ProgressBarUtils {

    Context context;
    private ProgressDialog progress_dialog;

    public ProgressBarUtils(Context context) {
        this.context=context;
    }

    public static ProgressDialog createPDialog(Context mContext) {
        ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.progress_dialog);
        // dialog.setMessage(Message);
        return dialog;
    }

    public void ShowProgress(boolean isCancelable)
    {
        progress_dialog = ProgressDialog.show(context, null, null, true, isCancelable);
        progress_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progress_dialog.setContentView(R.layout.progress_dialog);
        ProgressBar progressbar=(ProgressBar)progress_dialog.findViewById(R.id.progressBar);
        progressbar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#2D9CDB"), android.graphics.PorterDuff.Mode.SRC_IN);
        progress_dialog.setCancelable(isCancelable);
        Log.d("util","show dialog");

    }

    public void CloseDIloag()
    {
        if(progress_dialog!=null&& progress_dialog.isShowing())
            progress_dialog.dismiss();
        Log.d("util","dismiss dialog");
    }

}