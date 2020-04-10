package com.udhipe.simpleapplication.register;

import android.util.Log;

import com.udhipe.simpleapplication.model.User;
import com.udhipe.simpleapplication.network.ApiClient;
import com.udhipe.simpleapplication.network.ApiInterface;

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

//                    listener.onSuccess(response.body(), response.headers().toString());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.d("CREATEEE", "onFailure : " + t.getMessage());
//                    listener.onError(t.getMessage());
                }
            });
        } catch (Exception exception) {
            Log.d("CREATEEE", "exception : " + exception.getMessage());
//            listener.onError(exception.getMessage());
        }
    }
}
