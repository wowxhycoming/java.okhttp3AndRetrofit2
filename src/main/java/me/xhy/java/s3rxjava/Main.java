package me.xhy.java.s3rxjava;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import me.xhy.java.s2retrofit2.bean.MovieBox;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by xuhuaiyu on 2017/5/28.
 */
public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.douban.com/")
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // RxJava 和 Retrofit 结合
            .build();

        MoviePostApi api = retrofit.create(MoviePostApi.class);

        MovieBox movieBox = new MovieBox();
        movieBox.setStart(0);
        movieBox.setCount(2);

        api.getMovies(movieBox).flatMap(new Function<MovieBox, ObservableSource<MovieBox>>() {
            @Override
            public ObservableSource<MovieBox> apply(MovieBox movieBox) throws Exception {
                // 第一次的获取回来的总数 + 10 。 当然还可以做不同类型之间的转换
                movieBox.setCount(movieBox.getCount() + 10);
                return api.getMovies(movieBox);
            }
        }).flatMap(new Function<MovieBox, ObservableSource<MovieBox>>() {
            @Override
            public ObservableSource<MovieBox> apply(MovieBox movieBox) throws Exception {
                // 第一次的获取回来的总数 + 10 。 当然还可以做不同类型之间的转换
                movieBox.setCount(movieBox.getCount() + 11);
                return api.getMovies(movieBox);
            }
        }).subscribe(new Consumer<MovieBox>() {
            @Override
            public void accept(MovieBox movieBox) throws Exception {
                System.out.println("flatMap : \r\n" + movieBox);
            }
        });

    }

}
