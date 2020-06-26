package com.iwhalecloud.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import org.hibernate.validator.constraints.Length;

@SuppressWarnings("serial")
public class ReportApiCatalog implements Serializable {
    // 目录的唯一ID，由DCOOS管理平台统一生成
    @NotBlank(message = "id 不能为空")
    @Length(max = 50, message = "id长度不能超过50")
    private String id;

    // 目录的节点名称
    @NotBlank(message = "name 不能为空")
    @Length(max = 200, message = "name长度不能超过200")
    private String name;

    // 目录的资源URI
    @NotBlank(message = "href 不能为空")
    @Length(max = 50, message = "href长度不能超过50")
    private String href;

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
