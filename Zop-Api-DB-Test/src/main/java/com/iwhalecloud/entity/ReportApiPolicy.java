package com.iwhalecloud.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import org.hibernate.validator.constraints.Length;

@SuppressWarnings("serial")
public class ReportApiPolicy implements Serializable {
    // API策略ID，唯一标识
    @NotBlank(message = "policy_id不能为空")
    @Length(max = 15, message = "policy_id长度不能超过15")
    private String policy_id;

    // API关联的业务ID，如果是属性信息，则为属性ID。
    @NotBlank(message = "biz_id不能为空")
    @Length(max = 15, message = "biz_id长度不能超过15")
    private String biz_id;

    // 关于管控策略信息的简要说明
    @NotBlank(message = "name不能为空")
    @Length(max = 50, message = "name长度不能超过50")
    private String name;

    // 策略管控的基本类型，API层面目前支持rate_limit(速率限制)
    @NotBlank(message = "type不能为空")
    @Length(max = 50, message = "type长度不能超过50")
    private String type;

    //策略启用的时间，时间格式为yyyy-MM-dd'T'HH:mm:ss.SSS'Z'，如果为空，就和签约信息的时间一致
    @Length(max = 50, message = "start_dt长度不能超过50")
    private String start_dt;

    // 策略结束的时间，时间格式为yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
    @Length(max = 50, message = "end_dt长度不能超过50")
    private String end_dt;

    // 策略管控的具体的内容配置
    private List<ReportApiCharacteristic> characteristics;

    public String getPolicy_id() {
        return policy_id;
    }

    public void setPolicy_id(String policy_id) {
        this.policy_id = policy_id;
    }

    public String getBiz_id() {
        return biz_id;
    }

    public void setBiz_id(String biz_id) {
        this.biz_id = biz_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_dt() {
        return start_dt;
    }

    public void setStart_dt(String start_dt) {
        this.start_dt = start_dt;
    }

    public String getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(String end_dt) {
        this.end_dt = end_dt;
    }

    public List<ReportApiCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<ReportApiCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }
}
