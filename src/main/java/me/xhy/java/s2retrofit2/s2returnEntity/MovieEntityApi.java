package me.xhy.java.s2retrofit2.s2returnEntity;

import me.xhy.java.s2retrofit2.bean.MovieBox;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by xuhuaiyu on 2017/5/31.
 */
public interface MovieEntityApi {

    @GET("v2/movie/top250")
    Call<MovieBox> getTop250Movies();
}
