package testpackages.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Hanterar konverteringen från strängar till date.
 */
public class DatumUtil {

    public enum DateFormat {
        YYYYMMDD("yyyyMMdd"),
        YYYY_MM_DD_HHMMSS("yyyyMMddHHmmss");

        private String pattern;

        private DateFormat(String pattern){
            this.pattern = pattern;
        }

        public String getPattern(){
            return pattern;
        }
    }

    public static LocalDateTime formateraDatumString(String datumString, DateFormat format) throws Exception {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(datumString, DateTimeFormatter.ofPattern(format.getPattern()));
            return dateTime;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage() + "\nDatumstring:" + datumString + " format:" + format.getPattern());
        }
    }

    public Date getIdagIFormAvDateAvNgnAnledning(){
        return new Date();
    }
}
