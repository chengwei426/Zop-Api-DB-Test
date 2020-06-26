package com.iwhalecloud.enumerate;

public enum ApiTypeEnum {
    modern("modern"),
    traditional("traditional"),
    distributed("distributed");

    private String value;

    ApiTypeEnum(String value) {
        this.value = value;
    }

    public static boolean isValidName(String name) {
        for (ApiTypeEnum userGenderEnum : ApiTypeEnum.values()) {
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
