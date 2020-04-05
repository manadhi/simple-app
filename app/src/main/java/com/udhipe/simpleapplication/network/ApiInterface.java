package com.udhipe.simpleapplication.network;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    //    @GET("kontak_android")
//    Call<GetKontak> getKontak();
    @FormUrlEncoded
    @POST("/accounts/register")
    Call<JSONObject> createAccount(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("account_type") int accountType);

//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);
}
