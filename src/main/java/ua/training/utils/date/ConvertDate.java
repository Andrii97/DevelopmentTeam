package ua.training.utils.date;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by andrii on 23.01.17.
 */
public class ConvertDate {

    public static LocalDate convertDateToLocalDate(Date date) {
        return date != null ? date.toLocalDate() : null;
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        return localDate != null ? Date.valueOf(localDate) : null;
    }

}
