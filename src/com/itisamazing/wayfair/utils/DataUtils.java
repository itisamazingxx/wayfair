package com.itisamazing.wayfair.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class DataUtils {

    // 将方法封装成静态方法, 方便使用
    public static<T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成整数
     */
    public static int parseInt(String val, int defaultVal) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultVal;
    }

}