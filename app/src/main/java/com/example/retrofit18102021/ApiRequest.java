package com.example.retrofit18102021;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {

//    url = baseUrl + endpoint
    // Dùng dạng query : nối các key lên thanh địa chỉ
//    @GET("data/2.5/weather")
//    Call<String> getTempCity(@Query("appid")String appid,@Query("units")String units,@Query("q")String q);
    // DÙng params : để thay đổi giá trị
    @GET("data/2.5/weather?appid=86183a23377ed034aef7aad102f43d64&units=metric&q={cityName}")
    Call<String> getTempCity(@Path("cityName") String cityName);

}
