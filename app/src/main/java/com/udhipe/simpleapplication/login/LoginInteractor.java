package com.udhipe.simpleapplication.login;

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

public class LoginInteractor implements LoginContract.LoginInteractor {

    ApiInterface apiInterface;

    public LoginInteractor() {
        this.apiInterface = ApiClient.getClientNew().create(ApiInterface.class);
    }


    @Override
    public void getAccountSession(String username, String password, Listener<JSONObject> listener) {
        User user = new User(username, password);

        Call<ResponseBody> getAccountToken = apiInterface.getToken(user);
        getAccountToken.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.d("TOKENN", "response : " + response);
                Log.d("TOKENN", "response code : " + response.code());
                Log.d("TOKENN", "response message : " + response.message());
                Log.d("TOKENN", "response header : " + response.headers().toString());

                if (response.isSuccessful()) {

                    if (response.code() == 200) {
                        try {
                            String jsonData = response.body().string();
                            JSONObject data = new JSONObject(jsonData);
                            listener.onSuccess(data, response.message());
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if (response.code() == 400) {
                        try {
                            String jsonData = response.errorBody().string();
                            JSONObject errorData = new JSONObject(jsonData);
                            listener.onError(errorData.getString("message"));
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TOKENN", "onFailure : " + t.getMessage());
                if (t.getMessage().contains("Unable to resolve host")) {
                    listener.onError(ConstantManager.CONNECTION_PROBLEM);
                }
            }
        });

    }

    @Override
    public void getProfile(String token, Listener<JSONObject> listener) {
        Call<ResponseBody> getProfile = apiInterface.getProfile("Bearer " + token);
        getProfile.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {

                    if (response.code() == 200) {
                        try {
                            String jsonData = response.body().string();
                            JSONObject data = new JSONObject(jsonData);
                            listener.onSuccess(data, response.message());
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if (response.code() == 401) {
                        try {
                            String jsonData = response.errorBody().string();
                            JSONObject errorData = new JSONObject(jsonData);
                            listener.onError(errorData.getString("message"));
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

/*                Log.d("PROFILE", "response : " + response);
                Log.d("PROFILE", "response code : " + response.code());
                Log.d("PROFILE", "response message : " + response.message());
                Log.d("PROFILE", "response header : " + response.headers().toString());
                try {
                    if (response.isSuccessful()) {
                        Log.d("PROFILE", "response body : " + response.body().string());
                    } else {
                        Log.d("PROFILE", "response error body : " + response.errorBody().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("PROFILE", "onFailure : " + t.getMessage());
                if (t.getMessage().contains("Unable to resolve host")) {
                    listener.onError(ConstantManager.CONNECTION_PROBLEM);
                }
            }
        });
    }
}
