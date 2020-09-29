package com.hong.common;

/**
 * 数据源线程安全容器
 */
public class DbContextHolder {
    /**
     * 使用ThreadLocal线程安全的保存数据源
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据源
     */
    public static void clearDbType() {
        contextHolder.remove();
    }
}
