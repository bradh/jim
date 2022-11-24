package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.DateWithOptionalUTCTime;

/**
 * Status.
 *
 * <p>The most current reported satellite operational status or orbital status.
 */
public class Status {
    @JacksonXmlProperty(isAttribute = true)
    private DateWithOptionalUTCTime statusDate;

    @JacksonXmlText private StatusType value;

    /**
     * Constructor.
     *
     * <p>This is only for the deserialiser. Use the form that takes a date and value in order to
     * provide the required values.
     */
    private Status() {}

    /**
     * Constructor.
     *
     * @param statusDate
     * @param value
     */
    public Status(DateWithOptionalUTCTime statusDate, StatusType value) {
        this.statusDate = statusDate;
        this.value = value;
    }

    /**
     * Copy constructor.
     *
     * @param other the source object to copy from.
     */
    public Status(Status other) {
        this.statusDate = other.statusDate;
        this.value = other.value;
    }

    /**
     * Status date.
     *
     * <p>The UTC date and time or just the date (only when time isn’t available to the data
     * provider) the functional status was assessed for the first time or subsequently updated.
     *
     * @return the status date
     */
    public DateWithOptionalUTCTime getStatusDate() {
        return statusDate;
    }

    /**
     * Status value.
     *
     * @return the status value as an enumerated type.
     */
    public StatusType getValue() {
        return value;
    }
}
