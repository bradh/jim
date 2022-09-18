package net.frogmouth.rnd.jim.s4676.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Custom annotation support for deserialisation arguments. */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SupplementalDeserialisationInfo {
    /**
     * Element name
     *
     * @return element name to deserialise from, as a String
     */
    String elementName();
}
