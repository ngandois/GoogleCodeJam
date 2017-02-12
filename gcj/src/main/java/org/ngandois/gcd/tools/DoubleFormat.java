package org.ngandois.gcd.tools;

import java.util.Locale;

public class DoubleFormat {


    /*
     * @param d The value to format
     * @return format double as Google Code Jam standard
     */
    public static String format(double d) {
        return String.format(Locale.ENGLISH, "%.8f", d);
    }

}
