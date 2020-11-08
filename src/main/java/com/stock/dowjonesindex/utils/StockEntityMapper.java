package com.stock.dowjonesindex.utils;

import com.stock.dowjonesindex.model.StockEntity;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class StockEntityMapper {
    public static List<StockEntity> mapToStockEntities(final List<String> rawList) {
        final List<StockEntity> stockEntities = new ArrayList<>();
        rawList.stream().forEach(el -> {
            List<String> split = Arrays.asList(el.split(","));
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//            Date date = null;
//            try {
//                date = split.get(2) != null ? formatter.parse(split.get(2)) : null;
//            } catch (final ParseException e) {
//                e.printStackTrace();
//            }
            final BigInteger volume = !split.get(7).isEmpty() ? new BigInteger(split.get(7)) : null;
            final float percent_change_price = !split.get(8).isEmpty() ? Float.parseFloat(split.get(8)) : 0;
            final float percent_change_volume_over_last_wk = !split.get(9).isEmpty() ? Float.parseFloat(split.get(9)) : 0;
            final BigInteger previous_weeks_volume = !split.get(10).isEmpty() ? new BigInteger(split.get(10)) : null;
            final float percent_change_next_weeks_price = !split.get(13).isEmpty() ? Float.parseFloat(split.get(13)) : 0;
            final int days_to_next_dividend = !split.get(14).isEmpty() ? Integer.parseInt(split.get(14)) : 0;
            final float percent_return_next_dividend = !split.get(15).isEmpty() ? Float.parseFloat(split.get(15)) : 0;


            final StockEntity stockEntity = new StockEntity(split.get(0), split.get(1), split.get(2), split.get(3),
                    split.get(4), split.get(5), split.get(6), volume,
                    percent_change_price, percent_change_volume_over_last_wk,
                    previous_weeks_volume, split.get(11), split.get(12), percent_change_next_weeks_price
                    , days_to_next_dividend,
                    percent_return_next_dividend);
            stockEntities.add(stockEntity);

        });
        return stockEntities;
    }

    public static StockEntity mapToStockEntity(final String record) {
        final List<StockEntity> stockEntities = new ArrayList<>();

        List<String> split = Arrays.asList(record.split(","));


        /**
         *  0=String quarter, 1= String stock, 2= String date, 3= String open, 4= String high,
         *         5= String low, 6= String close, 7= BigInteger volume, 8= float percent_change_price,
         *         9= float percent_change_volume_over_last_wk, 10= BigInteger previous_weeks_volume,
         *         11= String next_weeks_open, 12= String next_weeks_close, 13= float percent_change_next_weeks_price,
         *         14= int days_to_next_dividend, 15= float percent_return_next_dividend
         */


//
//        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
//                .appendPattern("[m/dd/yyyy]")
//                .appendPattern("[mm/dd/yyyy]")
//                .appendPattern("[mm/d/yyyy]")
//                .appendPattern("[m/d/yyyy]");
//
//        DateTimeFormatter formatter= builder.toFormatter(Locale.ENGLISH);
//
//        LocalDate date = !split.get(2).isEmpty() ? LocalDate.parse(split.get(2), formatter) : null;
//        Date d = null;
//        try {
//            d = new SimpleDateFormat("m/dd/yyyy").parse(date.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        final BigInteger volume = !split.get(7).isEmpty() ? new BigInteger(split.get(7)) : null;
        final float percent_change_price = !split.get(8).isEmpty() ? Float.parseFloat(split.get(8)) : 0;
        final float percent_change_volume_over_last_wk = !split.get(9).isEmpty() ? Float.parseFloat(split.get(9)) : 0;
        final BigInteger previous_weeks_volume = !split.get(10).isEmpty() ? new BigInteger(split.get(10)) : null;
        final float percent_change_next_weeks_price = !split.get(13).isEmpty() ? Float.parseFloat(split.get(13)) : 0;
        final int days_to_next_dividend = !split.get(14).isEmpty() ? Integer.parseInt(split.get(14)) : 0;
        final float percent_return_next_dividend = !split.get(15).isEmpty() ? Float.parseFloat(split.get(15)) : 0;


        final StockEntity stockEntity = new StockEntity(split.get(0), split.get(1), split.get(2), split.get(3),
                split.get(4), split.get(5), split.get(6), volume,
                percent_change_price, percent_change_volume_over_last_wk,
                previous_weeks_volume, split.get(11), split.get(12), percent_change_next_weeks_price
                , days_to_next_dividend,
                percent_return_next_dividend);


        return stockEntity;
    }
}
