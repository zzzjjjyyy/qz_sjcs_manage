package com.chuangyun.common.utils;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        //获取系统时间
        Date date =new Date();

        //%tj表示一年中的第几天
        String strDate =String.format("%tj",date);

        //输出时间
        System.out.println(strDate);
    }
}
