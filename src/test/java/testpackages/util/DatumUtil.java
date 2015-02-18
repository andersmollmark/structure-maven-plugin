package testpackages.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.util.Arrays.asList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



/**
 * Hanterar konverteringen från strängar till date.
 */
public class DatumUtil {

    private Calendar oldUnusedObject = Calendar.getInstance();

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
            UtilUtil utilUtil = new UtilUtil();
            utilUtil.printTotallyMeaninglessMessage();
            return dateTime;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage() + "\nDatumstring:" + datumString + " format:" + format.getPattern());
        }
    }

    public Date getIdagIFormAvDateAvNgnAnledning(){
        return new Date();
    }

    public void doNothing(){
        List<String> strings = asList("2", "3");
    }
}
