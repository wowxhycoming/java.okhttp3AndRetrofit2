package me.xhy.java.s2retrofit2.s3getRequest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.xhy.java.s2retrofit2.bean.MovieBox;
import me.xhy.java.s2retrofit2.bean.MovieError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuhuaiyu on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.douban.com/")
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build();

        // querystring
        MovieGetApi movieApi = retrofit.create(MovieGetApi.class);
        movieApi.getMovieWithQueryString(0,2).enqueue(new Callback<MovieBox>() {
            @Override
            public void onResponse(Call<MovieBox> call, Response<MovieBox> response) {
                try {

                    MovieBox movieBox = response.body();
                    System.out.println("querystring MovieBox : \r\n" + movieBox);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MovieBox> call, Throwable throwable) {
                System.out.println("Failure : " + throwable.getMessage());
            }
        });

        // restful path parameter
        movieApi.getMovieWithPathParam("1").enqueue(new Callback<MovieError>() {
            @Override
            public void onResponse(Call<MovieError> call, Response<MovieError> response) {
                try {

                    System.out.println("restful path parameter MovieError : \r\n" + response.errorBody().string());
                    System.out.println("*** 返回码非 200， 不会进行 json 转 entity ***");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MovieError> call, Throwable throwable) {
                System.out.println("Failure : " + throwable.getMessage());
            }
        });

        // query map
        Map<String, String> map = new HashMap();
        map.put("start","0");
        map.put("count","2");
        movieApi.getMovieWithQueryMap(map).enqueue(new Callback<MovieBox>() {
            @Override
            public void onResponse(Call<MovieBox> call, Response<MovieBox> response) {
                try {

                    MovieBox movieBox = response.body();
                    System.out.println("query map MovieBox : \r\n" + movieBox);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MovieBox> call, Throwable throwable) {
                System.out.println("Failure : " + throwable.getMessage());
            }
        });


    }
}
