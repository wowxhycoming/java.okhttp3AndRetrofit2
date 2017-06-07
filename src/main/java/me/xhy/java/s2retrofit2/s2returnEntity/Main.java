package me.xhy.java.s2retrofit2.s2returnEntity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.xhy.java.s2retrofit2.bean.MovieBox;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by xuhuaiyu on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 添加转换器，让返回报文转换成对象
         *
         * 以为有字段与 JSON 不是一一按名称对应，所以要自定义 mapper
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.douban.com/")
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build();

        /**
         * MovieEntityApi 不再返回 ResponseBody 而是返回更方便的 MovieBox
         */
        MovieEntityApi movieApi = retrofit.create(MovieEntityApi.class);
        Call<MovieBox> top250Movies = movieApi.getTop250Movies();
        top250Movies.enqueue(new Callback<MovieBox>() {
            @Override
            public void onResponse(Call<MovieBox> call, Response<MovieBox> response) {
                try {

                    MovieBox movieBox = response.body();
                    System.out.println("movieBox : \r\n" + movieBox);

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
