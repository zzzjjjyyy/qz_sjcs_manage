package com.chuangyun.common.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期处理
 *
 * @author Jerry Yu
 * @date 2017-10-29 23:30
 */
public class DateUtils {
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转字符串
     * 默认格式yyyy-MM-dd
     *
     * @param date 日期
     * @return
     */
    public static String formatToString(Date date) {
        return formatToString(date, DATE_PATTERN);
    }

    /**
     * 日期转字符串
     *
     * @param date    日期
     * @param pattern 字符串格式
     * @return
     */
    public static String formatToString(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串轉日期
     * 默认格式yyyy-MM-dd
     *
     * @param dateStr 日期
     * @return
     */
    public static Date formatToDate(String dateStr) {
        if (StringUtils.isNotBlank(dateStr)) {
            return formatToDate(dateStr, DATE_PATTERN);
        }
        return null;
    }

    /**
     * 字符串转日期
     *
     * @param dateStr     日期
     * @param datePattern 日期格式
     * @return
     */
    public static Date formatToDate(String dateStr, String datePattern) {
        Date ref = null;

        /**
         *获取日期
         */
        String rule = "^\\d{4}[-.]\\d{1,2}[-.]\\d{1,2}$";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(dateStr);

        while (matcher.find()) {
            dateStr = dateStr.replaceAll("\\.", "-").replaceAll("/", "-");
            // 小写的mm表示的是分钟
            SimpleDateFormat df = new SimpleDateFormat(datePattern);
            try {
                if (!StringUtils.isBlank(dateStr)) {
                    Date date = df.parse(dateStr);
                    return date;
                }
            } catch (ParseException e) {
                return null;
            }
            break;
        }
        return ref;
    }

    private static int outDay(int year, int month, int day) {

        //定义数组，这里2月的天数取28，假设是平年。
        int[] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //如果是闰年，那么2月应该有29天。
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            Day[1] = 29;
        }

        //进行判断
        if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > Day[month - 1]){
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += Day[i];
        }

        //最后sum需要加上当前月份的日期。
        return sum + day;
    }
}
