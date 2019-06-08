package com.vdtlabs.networcallskhandler;

import android.content.Context;
import android.util.Log;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vinod Dirishala on 06,June,2019
 */
public class NetworkCallHandler {
    private static Context mContext;


    public NetworkCallHandler(Context mContext) {
      this.mContext = mContext;
    }


    // a method which handles string network calls and returns the response in json format
    /**
     * @callType - Type of NETWORK call
     * @ncAPI - the resource API to hit
     * @params - params in hashmap which needs to send to server to get response
     * @authHeaders - headers to autheticate the client in hashmap which needs to send to server to get response
     */
    public static void handleSNC(int methodType, String ncAPI,final HashMap<String,String > params,final HashMap<String,String > authHeaders){
        StringRequest netwrokCallRequest = new StringRequest(methodType, ncAPI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ((NCResponse)mContext).onResponseSuccess(new JSONObject(response));
                }catch (JSONException e){
                    e.printStackTrace();
                    e.getMessage();
                }catch (Exception e){
                    e.printStackTrace();
                    e.getMessage();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return authHeaders;
            }
        };
        RequestQueue networkRequest = Volley.newRequestQueue(mContext);
        networkRequest.add(netwrokCallRequest);
    }






    private void handleJONC(){

    }

    private void handleJANC(){

    }


}
