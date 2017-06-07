package me.xhy.java.s1okhttp3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by xuhuaiyu on 2017/5/30.
 */
public class S3PostJson {

    public static void main(String[] args) throws JsonProcessingException {

        String url = "http://api.douban.com/v2/movie/top250";

        OkHttpClient client = new OkHttpClient();

        Page page = new Page();
        page.setStart("0");
        page.setCount("25");

        ObjectMapper mapper = new ObjectMapper();
        String strPage = mapper.writeValueAsString(page);
        System.out.println(strPage);


        RequestBody body = RequestBody.create(MediaType.parse("application/json"), strPage);

        Request request = new Request.Builder()
            .url(url)
            .post(body)
            .build();

        // enqueue 异步方法 ； execute 同步方位
        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                System.out.println("failure");
            }

            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    System.out.println("body = " + response.body().string());
                    System.out.println("下载文件 = " + response.body().byteStream() + " 处理这个流");
                }
            }
        });

    }
}

class Page {
    private String start;
    private String count;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
