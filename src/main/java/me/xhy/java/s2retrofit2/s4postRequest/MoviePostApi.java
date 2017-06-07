package me.xhy.java.s2retrofit2.s4postRequest;

import me.xhy.java.s2retrofit2.bean.MovieBox;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by xuhuaiyu on 2017/5/31.
 */
public interface MoviePostApi {

    /**
     * 提价一个对象
     * @param movieBox 被 @Body 注解的对象，默认会转换成 JSON 对象
     * @return
     */
    @POST("v2/movie/top250")
    Call<MovieBox> getMovieWithPost(@Body MovieBox movieBox);

    /**
     * 提交 Form 表单
     * @param a @Field("start") 对应后台的字段， 而 String a 只是方法的参数可以随便写
     * @param b 同 a
     * @return
     */
    @FormUrlEncoded
    @POST("v2/movie/top250")
    Call<MovieBox> getMovieWithPostForm(@Field("start") String a, @Field("count") String b);

}
