package com.iwhalecloud.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import org.hibernate.validator.constraints.Length;
import com.iwhalecloud.annotation.EnumValue;
import com.iwhalecloud.enumerate.ResMethodEnum;

@SuppressWarnings("serial")
public class ReportApiResource implements Serializable {
	// API使用的HTTP方法，可选有GET/POST/PUT/PATCH/DELETE
	@NotBlank(message = "http_method 不能为空")
	@EnumValue(enumClass= ResMethodEnum.class, enumMethod="isValidName", message = "http_method 值错误")
	private String http_method;

	// API的资源信息
	@Length(max = 50, message="resource_name长度不能超过50")
	private String resource_name;

	// API的内容 applicaiton/json
	@NotBlank(message = "content_type 不能为空")
	@Length(max = 50, message="content_type长度不能超过50")
	private String content_type;
	
	public String getHttp_method(){
		return http_method;
	}
	
	public void setHttp_method(String http_method){
		this.http_method = http_method;
	}
	
	public String getResource_name(){
		return resource_name;
	}
	
	public void setResource_name(String resource_name){
		this.resource_name = resource_name;
	}
	
	public String getContent_type(){
		return content_type;
	}
	
	public void setContent_type(String content_type){
		this.content_type = content_type;
	}
}
