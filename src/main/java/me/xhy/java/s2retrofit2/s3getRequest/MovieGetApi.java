package me.xhy.java.s2retrofit2.s3getRequest;

import me.xhy.java.s2retrofit2.bean.MovieBox;
import me.xhy.java.s2retrofit2.bean.MovieError;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * Created by xuhuaiyu on 2017/5/31.
 */
public interface MovieGetApi {

    @GET("v2/movie/top250")
    Call<MovieBox> getTop250Movies();

    /**
     * querystring 请求方式
     * 最终url v2/movie/top250?start=0&count=2
     * @param start
     * @param end
     * @return
     */
    @GET("v2/movie/top250")
    Call<MovieBox> getMovieWithQueryString(@Query("start") int start, @Query("count") int end);

    /**
     * restful path parameter 请求
     * 最终url v2/movie/top250/1
     * @param id
     * @return
     */
    @GET("v2/movie/top250/{id}")
    Call<MovieError> getMovieWithPathParam(@Path("id") String id);

    /**
     * 实质还是 querystring 请求方式
     * 最终url v2/movie/top250?start=0&count=2
     * @param param
     * @return
     */
    @GET("v2/movie/top250")
    Call<MovieBox> getMovieWithQueryMap(@QueryMap Map<String, String> param);


}
