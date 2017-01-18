package com.napster.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 日志工厂类
 */
public class LoggerFactory {

    public static Logger getInfoLogger() {
        return LogManager.getLogger("info");
    }

    public static Logger getWarnLogger() {
        return LogManager.getLogger("warn");
    }

    public static Logger getErrorLogger() {
        return LogManager.getLogger("error");
    }

}
