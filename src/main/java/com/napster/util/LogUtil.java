package com.napster.util;

import org.apache.logging.log4j.Logger;


/**
 * 日志工具类
 */
public class LogUtil {

    private static Logger logger;

    public static void logInfo(String msg) {
        logger = LoggerFactory.getInfoLogger();
        logger.info(msg);
    }

    public static void logWarn(String msg) {
        logger = LoggerFactory.getWarnLogger();
        logger.warn(msg);
    }

    public static void logError(String msg) {
        logger = LoggerFactory.getErrorLogger();
        logger.error(msg);
    }

    public static void logError(Throwable throwable) {
        logError("", throwable);
    }

    public static void logError(String msg, Throwable throwable) {
        logger = LoggerFactory.getErrorLogger();
        logger.error(msg, throwable);
    }

}
