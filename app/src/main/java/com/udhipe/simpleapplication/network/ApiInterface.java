package com.udhipe.simpleapplication.network;

import com.udhipe.simpleapplication.model.User;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    // register
    @Headers("Authorization: Application 92f700d86103b6bbbd228ff024f811ea")
    @POST("accounts/register")
    Call<ResponseBody> createAccount(@Body User user);

    // login
    @Headers("Authorization: Application 92f700d86103b6bbbd228ff024f811ea")
    @POST("auth/token")
    Call<ResponseBody> getToken(@Body User user);

    // get profile
    @GET("accounts/me/profiles")
    Call<ResponseBody> getProfile(@Header("Authorization") String authorization);

    // create profile
    @POST("accounts/me/profiles")
    Call<ResponseBody> createProfile(@Header("Authorization") String authorization, @Body User user);

    // admin - all accounts
    @GET("admin/accounts")
    Call<Object> getAccount();

    @GET("admin/accounts")
    Call<Object> getAccount(@Header("Authorization") String adminAuth);
//    void foo(@Header("Accept-Language") String lang, Callback<Response> cb);

//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);
}