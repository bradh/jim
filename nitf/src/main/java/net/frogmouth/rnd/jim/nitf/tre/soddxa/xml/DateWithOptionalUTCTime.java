package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@JsonSerialize(using = DateWithOptionalUTCTimeSerializer.class)
public class DateWithOptionalUTCTime {
    private LocalDate date;
    private LocalTime time;

    public DateWithOptionalUTCTime(String s) {
        try {
            ZonedDateTime zdt = ZonedDateTime.parse(s, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            date = zdt.toLocalDate();
            time = zdt.toLocalTime();
        } catch (Exception ex) {
            date = LocalDate.parse(s, DateTimeFormatter.ISO_DATE);
            time = null;
        }
    }

    /**
     * Date part.
     *
     * @return the date part, implicitly in UTC.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Time part.
     *
     * @return the time part implicitly in UTC, or null if not specified.
     */
    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        if (time != null) {
            ZonedDateTime zdt = ZonedDateTime.of(date, time, ZoneOffset.UTC);
            return zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }
        return date.format(DateTimeFormatter.ISO_DATE) + "Z";
    }
}
