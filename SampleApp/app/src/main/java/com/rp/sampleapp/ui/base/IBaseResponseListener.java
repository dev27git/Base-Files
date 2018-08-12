package com.rp.sampleapp.ui.base;

/**
 * Created by rahul on 7/1/18.
 */

public interface IBaseResponseListener {

    void onSuccessResponse(String message);
    void onErrorResponse(String error);
    void onFailedResponse(String message);
}
