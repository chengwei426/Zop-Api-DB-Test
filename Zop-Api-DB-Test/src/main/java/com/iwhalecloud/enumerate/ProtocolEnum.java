package com.iwhalecloud.enumerate;

public enum ProtocolEnum {
    HTTP("http"),
    HTTPS("https");

    private String value;

    ProtocolEnum(String value) {
        this.value = value;
    }

    public static boolean isValidName(String name) {
        for (ProtocolEnum userGenderEnum : ProtocolEnum.values()) {
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
