package com.chuangyun.common.utils;

/**
 * 常量
 *
 * @author Jerry Yu
 * @date 2017-10-29 23:30
 */
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;

    /**
     * 用户ID
     */
    public static final String USER_KEY = "userId";

    /**
     * 菜单类型
     *
     * @author Jerry Yu
     * @date 2017年10月15日 下午1:24:29
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
