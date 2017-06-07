package me.xhy.java.s2retrofit2.s1quickstart;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.xhy.java.s2retrofit2.bean.MovieBox;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * Created by xuhuaiyu on 2017/5/31.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 1. 创建 Retrofit 对象，需要提供 baseUrl 。因为接口对象中全部写 相对路径 。
         */
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.douban.com/").build();

        /**
         * 2. 创建代理对象
         */
        MovieApi movieApi = retrofit.create(MovieApi.class);

        /**
         * 3. 创建 Call
         */
        Call<ResponseBody> top250Movies = movieApi.getTop250Movies();

        /**
         * 4. 发起网络请求 。 这里就跟 okHttp3 一样了，不一样的地方是，内部类中的函数的参数增加了泛型
         */
        top250Movies.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.errorBody().string());
                    String moviesBoxStr = response.body().string();
                    System.out.println("moviesBoxStr : \r\n" + moviesBoxStr);

                    ObjectMapper mapper = new ObjectMapper();
                    // 当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，
                    // 因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
                    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    MovieBox movieBox = mapper.readValue(moviesBoxStr, MovieBox.class);
                    System.out.println("movieBox : \r\n" + movieBox);

                    System.out.println(mapper.writeValueAsString(movieBox));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                System.out.println("Failure : " + throwable.getMessage());
            }
        });

    }
}
