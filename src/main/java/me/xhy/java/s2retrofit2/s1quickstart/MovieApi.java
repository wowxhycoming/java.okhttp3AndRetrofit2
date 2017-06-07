package me.xhy.java.s2retrofit2.s1quickstart;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by xuhuaiyu on 2017/5/31.
 */
public interface MovieApi {

    @GET("v2/movie/top250/1/")
    Call<ResponseBody> getTop250Movies();
}
