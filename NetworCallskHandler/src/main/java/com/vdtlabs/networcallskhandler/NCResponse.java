package com.vdtlabs.networcallskhandler;

import org.json.JSONObject;

/**
 * Created by Vinod Dirishala on 06,June,2019
 */
public interface NCResponse {

    // callback method on network call returns success data
    void onResponseSuccess(JSONObject successResponse);

    // callback method on network call returns failure data
    void onResponseFailure(JSONObject failureResponse);

}
