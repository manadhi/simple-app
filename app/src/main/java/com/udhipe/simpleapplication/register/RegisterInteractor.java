package com.udhipe.simpleapplication.register;

import android.util.Log;

import com.udhipe.simpleapplication.model.User;
import com.udhipe.simpleapplication.network.ApiClient;
import com.udhipe.simpleapplication.network.ApiInterface;
import com.udhipe.simpleapplication.utility.ConstantManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInteractor implements RegisterContract.RegisterInteractor {

    ApiInterface apiInterface;

    public RegisterInteractor() {
        this.apiInterface = ApiClient.getClientNew().create(ApiInterface.class);
    }

    @Override
    public void createAccountData(String username, String password, int accountType, Listener<JSONObject> listener) {
        try {
            User user = new User(username, password, accountType);

            Call<ResponseBody> postCreateAccount = apiInterface.createAccount(user);
            postCreateAccount.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        if (response.code() == 201) {
                            listener.onSuccess(null, ConstantManager.SUCCESS_CREATE_ACCOUNT);
                        }
                    } else {
                        if (response.code() == 400) {
                            try {
                                if (response.errorBody().string().contains("Account already exist")) {
                                    listener.onError(ConstantManager.ACCOUNT_ALREADY_EXIST);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
/*
                    if (response != null) {

                        Log.d("CREATEEE", "response body : " + response.raw().toString());
                        try {
                            // response error ada di sini
                            Log.d("CREATEEE", "response error body : " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (response.body() != null) {
                            Log.d("CREATEEE", "response body : " + response.body().toString());
                        }

                        Log.d("CREATEEE", "response : " + response);
                        // code created 201 atau 400 ada di sini
                        Log.d("CREATEEE", "response code : " + response.code());
                        Log.d("CREATEEE", "response message: " + response.message());
                        Log.d("CREATEEE", "response header : " + response.headers().toString());

//                        if (response.body() != null) {
//                            try {
//                                Log.d("CREATEEE", "response body : " + response.body().getString("message"));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
                    } else {
                        Log.d("CREATEEE", "response body : null");
                    }
*/

//                    listener.onSuccess(response.body(), response.headers().toString());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.d("CREATEEE", "onFailure : " + t.getMessage());

                    if (t.getMessage().contains("Unable to resolve host")) {
                        listener.onError(ConstantManager.CONNECTION_PROBLEM);
                    }
                }
            });
        } catch (Exception exception) {
            Log.d("CREATEEE", "exception : " + exception.getMessage());
//            listener.onError(exception.getMessage());
        }
    }
}
