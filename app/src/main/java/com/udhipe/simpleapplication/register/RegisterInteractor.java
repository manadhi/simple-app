package com.udhipe.simpleapplication.register;

import android.util.Log;

import com.udhipe.simpleapplication.network.ApiClient;
import com.udhipe.simpleapplication.network.ApiInterface;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInteractor implements RegisterContract.RegisterInteractor {

    ApiInterface apiInterface;

    public RegisterInteractor() {
        this.apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void createAccountData(String username, String password, int accountType, Listener<JSONObject> listener) {
        try {
            Call<JSONObject> postCreateAccount = apiInterface.createAccount(username, password, accountType);
            postCreateAccount.enqueue(new Callback<JSONObject>() {
                @Override
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                    Log.d("CREATEEE", "response body : " + response.body().toString());
                    Log.d("CREATEEE", "response header : " + response.headers().toString());

                    listener.onSuccess(response.body(), response.headers().toString());
                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {
                    Log.d("CREATEEE", "onFailure : " + t.getMessage());
                    listener.onError(t.getMessage());
                }
            });
        } catch (Exception exception) {
            Log.d("CREATEEE", "exception : " + exception.getMessage());
            listener.onError(exception.getMessage());
        }
    }
}
