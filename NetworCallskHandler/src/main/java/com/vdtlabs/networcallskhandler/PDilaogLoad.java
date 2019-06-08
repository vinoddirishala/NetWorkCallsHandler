package com.vdtlabs.networcallskhandler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Vinod Dirishala on 08-06-2019
 **/
public class PDilaogLoad {

    private ProgressDialog pd;
    public static ProgressBarUtils progressUtils;

    Context context;
    Activity activity;

    public PDilaogLoad(Context context) {
        this.context = context;
        this.activity = (Activity) context;
    }

    public void pDilaogDismis() {

        if ((pd != null) && pd.isShowing())
            pd.dismiss();

        pd = null;


    }

    public void CreatePDIlog() {
        try {
            if (pd == null)
                pd = ProgressDialog.show(activity, "", "Please wait...", true);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void PDialogInstance(Activity activity, String title) {
        try {
            if (progressUtils == null) {
                progressUtils = new ProgressBarUtils(activity);
                progressUtils.ShowProgress(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void CloseDialog() {

        if (progressUtils != null) {
            progressUtils.CloseDIloag();
        }
        progressUtils = null;
    }
}