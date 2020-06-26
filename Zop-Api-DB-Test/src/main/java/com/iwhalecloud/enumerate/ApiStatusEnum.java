package com.iwhalecloud.enumerate;

public enum ApiStatusEnum {
    VALID("1000"),
    SUSPEND("1001"),
    OFFLINE("1002");

    private String value;

    ApiStatusEnum(String value) {
        this.value = value;
    }

    public static boolean isValidName(String name) {
        for (ApiStatusEnum userGenderEnum : ApiStatusEnum.values()) {
            if (userGenderEnum.getValue().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public String getValue() {
        return value;
    }
}
