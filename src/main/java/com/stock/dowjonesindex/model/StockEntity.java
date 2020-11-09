package com.stock.dowjonesindex.model;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;


/*
quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend
1,AA,1/7/2011,$15.82,$16.72,$15.78,$16.42,239655616,3.79267,,,$16.71,$15.97,-4.42849,26,0.182704
 */
public class StockEntity {
    @Id
    public String id;

    //Define DataSet Schema
    public String quarter;

    public String stock;

    public String date;

    public String open;

    public String high;

    public String low;

    public String close;

    public BigInteger volume;

    public float percent_change_price;

    public float percent_change_volume_over_last_wk;

    public BigInteger previous_weeks_volume;
    public String next_weeks_open;
    public String next_weeks_close;
    //can have negative values
    public float percent_change_next_weeks_price;

    public int days_to_next_dividend;

    public float percent_return_next_dividend;

    public StockEntity() {

    }

    public StockEntity(final String quarter, final String stock, final String date, final String open, final String high, final String low, final String close, final BigInteger volume, final float percent_change_price, final float percent_change_volume_over_last_wk, final BigInteger previous_weeks_volume, final String next_weeks_open, final String next_weeks_close, final float percent_change_next_weeks_price, final int days_to_next_dividend, final float percent_return_next_dividend) {
        this.quarter = quarter;
        this.stock = stock;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
        this.previous_weeks_volume = previous_weeks_volume;
        this.next_weeks_open = next_weeks_open;
        this.next_weeks_close = next_weeks_close;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public BigInteger getVolume() {
        return volume;
    }

    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    public float getPercent_change_price() {
        return percent_change_price;
    }

    public void setPercent_change_price(float percent_change_price) {
        this.percent_change_price = percent_change_price;
    }

    public float getPercent_change_volume_over_last_wk() {
        return percent_change_volume_over_last_wk;
    }

    public void setPercent_change_volume_over_last_wk(float percent_change_volume_over_last_wk) {
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
    }

    public BigInteger getPrevious_weeks_volume() {
        return previous_weeks_volume;
    }

    public void setPrevious_weeks_volume(BigInteger previous_weeks_volume) {
        this.previous_weeks_volume = previous_weeks_volume;
    }

    public String getNext_weeks_open() {
        return next_weeks_open;
    }

    public void setNext_weeks_open(String next_weeks_open) {
        this.next_weeks_open = next_weeks_open;
    }

    public String getNext_weeks_close() {
        return next_weeks_close;
    }

    public void setNext_weeks_close(String next_weeks_close) {
        this.next_weeks_close = next_weeks_close;
    }

    public float getPercent_change_next_weeks_price() {
        return percent_change_next_weeks_price;
    }

    public void setPercent_change_next_weeks_price(float percent_change_next_weeks_price) {
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
    }

    public int getDays_to_next_dividend() {
        return days_to_next_dividend;
    }

    public void setDays_to_next_dividend(int days_to_next_dividend) {
        this.days_to_next_dividend = days_to_next_dividend;
    }

    public float getPercent_return_next_dividend() {
        return percent_return_next_dividend;
    }

    public void setPercent_return_next_dividend(float percent_return_next_dividend) {
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntity stockEntity = (StockEntity) o;
        return id.equals(stockEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "StockEntity{" +
                "id='" + id + '\'' +
                ", quarter='" + quarter + '\'' +
                ", stock='" + stock + '\'' +
                ", date=" + date +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume=" + volume +
                ", percent_change_price=" + percent_change_price +
                ", percent_change_volume_over_last_wk=" + percent_change_volume_over_last_wk +
                ", previous_weeks_volume=" + previous_weeks_volume +
                ", next_weeks_open='" + next_weeks_open + '\'' +
                ", next_weeks_close='" + next_weeks_close + '\'' +
                ", percent_change_next_weeks_price=" + percent_change_next_weeks_price +
                ", days_to_next_dividend=" + days_to_next_dividend +
                ", percent_return_next_dividend=" + percent_return_next_dividend +
                '}';
    }
}
