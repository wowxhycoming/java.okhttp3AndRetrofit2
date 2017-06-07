package me.xhy.java.s2retrofit2.s4postRequest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.xhy.java.s2retrofit2.bean.MovieBox;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by xuhuaiyu on 2017/6/6.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 提交对象的时候，也仍然需要忽略没有值的字段
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.douban.com/")
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build();

        MovieBox movieBox = new MovieBox();
        movieBox.setStart(0);
        movieBox.setCount(2);

        MoviePostApi api = retrofit.create(MoviePostApi.class);
        api.getMovieWithPost(movieBox).enqueue(new Callback<MovieBox>() {
            @Override
            public void onResponse(Call<MovieBox> call, Response<MovieBox> response) {
                MovieBox movieBox = response.body();
                System.out.println("post MovieBox : \r\n" + movieBox);
            }

            @Override
            public void onFailure(Call<MovieBox> call, Throwable throwable) {

            }
        });

        api.getMovieWithPostForm("0","2").enqueue(new Callback<MovieBox>() {
            @Override
            public void onResponse(Call<MovieBox> call, Response<MovieBox> response) {
                MovieBox movieBox = response.body();
                System.out.println("post form MovieBox : \r\n" + movieBox);
            }

            @Override
            public void onFailure(Call<MovieBox> call, Throwable throwable) {

            }
        });

    }
}
