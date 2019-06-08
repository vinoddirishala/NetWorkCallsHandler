package com.vdtlabs.networkhandler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.vdtlabs.networcallskhandler.NCResponse;
import com.vdtlabs.networcallskhandler.NetworkCallHandler;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Vinod Dirishala on 08-06-2019
 **/
public class OptCodeLibCheck extends AppCompatActivity implements NCResponse {


    private NetworkCallHandler ncHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ncHandler = new NetworkCallHandler(OptCodeLibCheck.this);

        ncHandler.handleSNC(Request.Method.GET,"https://www.meraevents.com/api/category/list?major=1",new HashMap<String, String>(),new HashMap<String, String>());
    }





    @Override
    public void onResponseSuccess(JSONObject successResponse) {
        try {
            Log.d("callbackResponse",successResponse.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onResponseFailure(JSONObject failureResponse) {

    }
}
