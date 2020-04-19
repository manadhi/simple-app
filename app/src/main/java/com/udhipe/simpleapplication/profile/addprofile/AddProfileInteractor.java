package com.udhipe.simpleapplication.profile.addprofile;

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

public class AddProfileInteractor implements AddProfileContract.AddProfileInteractor {

    ApiInterface apiInterface;

    public AddProfileInteractor() {
        this.apiInterface = ApiClient.getClientNew().create(ApiInterface.class);
    }

    @Override
    public void createProfileData(String token, User user, Listener<JSONObject> listener) {
        Call<ResponseBody> createProfile = apiInterface.createProfile("Bearer " + token, user);

        createProfile.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        if (response.code() == 201) {
                            Log.d("createProfile", "response body : " + response.body().string());
                            JSONObject data = new JSONObject();
                            listener.onSuccess(data, response.message());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    try {
                        Log.d("createProfile", "response error body : " + response.errorBody().string());
                        String jsonData = response.errorBody().string();
                        JSONObject errorData = new JSONObject(jsonData);
                        listener.onError(errorData.getString("message"));
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("createProfile", "fail : " + t.getMessage());
                if (t.getMessage().contains("Unable to resolve host")) {
                    listener.onError(ConstantManager.CONNECTION_PROBLEM);
                }
            }
        });
    }
}
