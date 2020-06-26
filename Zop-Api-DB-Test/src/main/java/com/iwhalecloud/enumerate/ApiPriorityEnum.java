package com.iwhalecloud.enumerate;

public enum ApiPriorityEnum {
    HIGH("1"),
    MIDDLE("2"),
    LOW("3");

    private String value;

    ApiPriorityEnum(String value) {
        this.value = value;
    }

    public static boolean isValidName(String name) {
        for (ApiPriorityEnum userGenderEnum : ApiPriorityEnum.values()) {
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
