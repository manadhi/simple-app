package com.udhipe.simpleapplication.main.account;

import android.util.Log;

import com.udhipe.simpleapplication.main.MainContract;
import com.udhipe.simpleapplication.model.User;
import com.udhipe.simpleapplication.network.ApiClient;
import com.udhipe.simpleapplication.network.ApiInterface;
import com.udhipe.simpleapplication.utility.ConstantManager;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountInteractor implements MainContract.AccountInteractor {

    ApiInterface apiInterface;

    public AccountInteractor() {
        this.apiInterface = ApiClient.getClientNew().create(ApiInterface.class);
    }

//    @Override
//    public void getProfile(String token, Listener<JSONObject> listener) {
//        Call<ResponseBody> getProfileCall = apiInterface.getProfile();
//        getProfileCall.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    try {
//                        Log.d("PROFILL", "respose body : " + response.body().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    try {
//                        Log.d("PROFILL", "response error body : " + response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("PROFILL", "failure : " + t.getMessage());
//            }
//        });
//
//    }
}
