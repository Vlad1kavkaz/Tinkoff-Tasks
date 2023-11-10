package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    private static final String LICENCE_PLATE_REGEX = "^([АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2})|(А\\d{6})|"
        + "(У\\d{6})|(О\\d{6})|(\\d{4}[АВЕКМНОРСТУХ]{2}\\d{2})|([АВЕКМНОРСТУХ]{2}\\d{5,6})|([АВЕКМНОРСТУХ]{2}\\d{3}"
        + "[АВЕКМНОРСТУХ]\\d{2})|(Т[АВЕКМНОРСТУХ]{2}\\d{5})|(\\d{3}CD\\d{3})|(\\d{3}[DT]\\d{5})$";

    private static final String LICENCE_PLATE_IS_NULL_MESSAGE = "licencePlate cannot be null";

    public static boolean isLicencePlateValid(String licencePlate) {
        if (licencePlate == null) {
            throw new IllegalArgumentException(LICENCE_PLATE_IS_NULL_MESSAGE);
        }

        return Pattern.matches(LICENCE_PLATE_REGEX, licencePlate);
    }

    private Task5() {
    }
}
