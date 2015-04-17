package framework;

import org.apache.log4j.Logger;

public class LoggerWrap {
    private static Logger logger = null;

    private LoggerWrap() {
        logger = Logger.getLogger(LoggerWrap.class);
    }

    protected static LoggerWrap getLogger() {
        return new LoggerWrap();
    }

    public void logInfo(String log) {
        logger.info(log);
    }

}
