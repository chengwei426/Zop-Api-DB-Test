package com.iwhalecloud.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import org.hibernate.validator.constraints.Length;

@SuppressWarnings("serial")
public class ReportApiLabel implements Serializable {

    // 标签的唯一ID，由DCOOS管理平台统一生成
    @NotBlank(message = "id 不能为空")
    @Length(max = 50, message = "id长度不能超过50")
    private String id;

    // 标签的名称
    @NotBlank(message = "name不能为空")
    @Length(max = 50, message = "name长度不能超过50")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
