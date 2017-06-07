package me.xhy.java.s2retrofit2.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by xuhuaiyu on 2017/6/1.
 */
@JsonIgnoreProperties({"id","no"}) // 这些字段不需要序列化
public class MovieBox {
    private String no;
    private long count;
    private long start;
    private long total;
    private String title;

    private List<MovieSubject> movieSubjects;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieSubject> getMovieSubjects() {
        return movieSubjects;
    }

    @JsonProperty("subjects")
    public void setMovieSubjects(List<MovieSubject> movieSubjects) {
        this.movieSubjects = movieSubjects;
    }

    @Override
    public String toString() {
        return "MovieBox{" +
        "count=" + count +
        ", start=" + start +
        ", total=" + total +
        ", title='" + title + '\'' +
        ", movieSubjects=" + movieSubjects +
        '}';
    }
}
