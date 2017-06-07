package me.xhy.java.s1okhttp3;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by xuhuaiyu on 2017/5/30.
 */
public class S1Quickstart {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        String url = "http://api.douban.com/v2/movie/top250?start=25&count=25";

        final Request request = new Request.Builder().url(url).build();

        // enqueue 异步方法 ； execute 同步方位
        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                System.out.println("failure");
            }

            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("body = " + response.body().string());
            }
        });

    }
}
