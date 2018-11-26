package com.dailylogger.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static enum TimestampFormat{
        TIME ("HH:mm"),
        DATE ("YYYY-MM-dd");

        private final DateTimeFormatter format;
        TimestampFormat(String format) {
            this.format = DateTimeFormatter.ofPattern(format);
        }

        private DateTimeFormatter format() { return format; }
    }

    public static String getDateTimestamp(TimestampFormat format) {
        LocalDateTime datetime = LocalDateTime.now();
        return datetime.format(format.format());
    }


}

