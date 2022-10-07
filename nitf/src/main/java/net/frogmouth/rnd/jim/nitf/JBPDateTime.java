package net.frogmouth.rnd.jim.nitf;

import java.nio.charset.StandardCharsets;

/**
 * Joint BIFF Profile Date/Time representation.
 *
 * <p>Date and time fields within a JBP file often represent currency and sequence of information
 * critical to the exploitation and interpretation of data. For those occasions when portions of the
 * date and/or time entry are not obtainable or complete, the following convention applies: populate
 * the unknown date/time two-character subfield with two hyphen-minus characters ({@code 0x2D})
 * indicating the portion of the date or time that is unknown. For example, the Century (CC), Year
 * (YY), Month (MM), and Day (DD) are known, but the hour (hh), minute (mm), and second (ss) values
 * are unknown, appears as {@code 20020425------}. In another example such as a birthday of 14 Feb
 * 47, where the CC is unknown or not expressed by the source of the information, the value would
 * appear as {@code --470214------}.
 */
public class JBPDateTime {

    private static final String HYPHEN_MINUS_FILL = "--";
    private final Integer centuries;
    private final Integer years;
    private final Integer months;
    private final Integer days;
    private final Integer hours;
    private final Integer minutes;
    private final Integer seconds;

    /**
     * Constructor.
     *
     * <p>This creates an instance that has all unspecified values, indicating that the date time is
     * conceptually unknown.
     */
    public JBPDateTime() {
        this.centuries = null;
        this.years = null;
        this.months = null;
        this.days = null;
        this.hours = null;
        this.minutes = null;
        this.seconds = null;
    }

    /**
     * Constructor.
     *
     * <p>This creates an instance that can have none, some or all values specified. If specified,
     * times are UTC.
     *
     * @param centuries century count (two digits max)
     * @param years year count (two digits max, centuries specified above)
     * @param months month count (two digits max, 1-12)
     * @param days day count (two digit max, starting from 1)
     * @param hours hour count (two digits max, 24 hour time)
     * @param minutes minute count (two digits max)
     * @param seconds seconds count (two digits max)
     */
    public JBPDateTime(
            Integer centuries,
            Integer years,
            Integer months,
            Integer days,
            Integer hours,
            Integer minutes,
            Integer seconds) {
        // TODO: validate values.
        this.centuries = centuries;
        this.years = years;
        this.months = months;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Century count.
     *
     * @return the number of centuries
     */
    public Integer getCenturies() {
        return centuries;
    }

    /**
     * Year count.
     *
     * <p>Note that this is two digit year count, and centuries may be specified separately.
     *
     * @return the number of years
     */
    public Integer getYears() {
        return years;
    }

    /**
     * Month count.
     *
     * @return the number of months (1-12)
     */
    public Integer getMonths() {
        return months;
    }

    /**
     * Day count.
     *
     * @return the number of days
     */
    public Integer getDays() {
        return days;
    }

    /**
     * Hour count.
     *
     * @return the number of hours.
     */
    public Integer getHours() {
        return hours;
    }

    /**
     * Minute count.
     *
     * @return the number of minutes.
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * Second count.
     *
     * @return the number of seconds.
     */
    public Integer getSeconds() {
        return seconds;
    }

    /**
     * Get the byte-encoded form of this date-time.
     *
     * <p>This handles the case where part or all of the date-time is not known, and is hyphen-minus
     * filled.
     *
     * @return 14-byte array
     */
    public byte[] asBytes() {
        StringBuilder sb = new StringBuilder();
        if (centuries == null) {
            sb.append(HYPHEN_MINUS_FILL);
        } else {
            sb.append(String.format("%02d", centuries));
        }
        if (years == null) {
            sb.append(HYPHEN_MINUS_FILL);
        } else {
            sb.append(String.format("%02d", years));
        }
        if (months == null) {
            sb.append(HYPHEN_MINUS_FILL);
        } else {
            sb.append(String.format("%02d", months));
        }
        if (days == null) {
            sb.append(HYPHEN_MINUS_FILL);
        } else {
            sb.append(String.format("%02d", days));
        }
        if (hours == null) {
            sb.append(HYPHEN_MINUS_FILL);
        } else {
            sb.append(String.format("%02d", hours));
        }
        if (minutes == null) {
            sb.append(HYPHEN_MINUS_FILL);
        } else {
            sb.append(String.format("%02d", minutes));
        }
        if (seconds == null) {
            sb.append(HYPHEN_MINUS_FILL);
        } else {
            sb.append(String.format("%02d", seconds));
        }

        return sb.toString().getBytes(StandardCharsets.US_ASCII);
    }
}
