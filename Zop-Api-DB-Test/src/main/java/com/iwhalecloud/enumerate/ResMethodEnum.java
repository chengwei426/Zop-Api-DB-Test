package com.iwhalecloud.enumerate;

public enum ResMethodEnum {
    POST,
    PUT,
    DELETE,
    GET,
    PATCH;

    public static boolean isValidName(String name) {
        for (ResMethodEnum userGenderEnum : ResMethodEnum.values()) {
            if (userGenderEnum.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
