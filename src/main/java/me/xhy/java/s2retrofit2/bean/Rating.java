package me.xhy.java.s2retrofit2.bean;

/**
 * Created by xuhuaiyu on 2017/6/1.
 */
public class Rating {
    private long max;
    private double average;
    private long stars;
    private long min;

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Rating{" +
        "max=" + max +
        ", average=" + average +
        ", stars=" + stars +
        ", min=" + min +
        '}';
    }
}
