package com.iwhalecloud.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import org.hibernate.validator.constraints.Length;

@SuppressWarnings("serial")
public class ReportApiCharacteristic implements Serializable {

    // 具体的策略的属性,根据不同的策略有不同的属性值可以设置,type=rate_limit时,可选值为minutes
    @NotBlank(message = "name不能为空")
    @Length(max = 50, message = "name长度不能超过50")
    private String name;

    // 具体的策略的属性值
    @NotBlank(message = "value不能为空")
    @Length(max = 50, message = "value长度不能超过50")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
