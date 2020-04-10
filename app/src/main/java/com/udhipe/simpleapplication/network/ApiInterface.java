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
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("accounts/register")
    Call<ResponseBody> createAccount(@Body User user);

/*
    @FormUrlEncoded
    @POST("accounts/register")
    Call<JSONObject> createAccount(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("account_type") int accountType);
*/


    @GET("admin/accounts")
    Call<Object> getAccount();

    @GET("admin/accounts")
    Call<Object> getAccount(@Header("Authorization") String adminAuth);
//    void foo(@Header("Accept-Language") String lang, Callback<Response> cb);

//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);
}