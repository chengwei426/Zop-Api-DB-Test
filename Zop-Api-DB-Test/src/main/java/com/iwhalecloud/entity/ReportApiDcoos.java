package com.iwhalecloud.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;
import org.hibernate.validator.constraints.Length;
import com.iwhalecloud.annotation.EnumValue;
import com.iwhalecloud.enumerate.ApiPriorityEnum;
import com.iwhalecloud.enumerate.ApiStatusEnum;
import com.iwhalecloud.enumerate.ApiTypeEnum;
import com.iwhalecloud.enumerate.ProtocolEnum;
import com.iwhalecloud.enumerate.ResMethodEnum;

@SuppressWarnings("serial")
public class ReportApiDcoos implements Serializable {
	// API在网关的唯一标识，由网关生成并维护
	@NotBlank(message = "upload_api_id 不能为空")
	@Length(max = 32, message="upload_api_id长度不能大于32")
	private String upload_api_id;

	// 网关的唯一标识
	@NotBlank(message = "gateway_id 不能为空")
	private String gateway_id;

	// 一次上报使用的HTTP方法，可选有POST/PUT/DELETE
	@EnumValue(enumClass= ResMethodEnum.class, enumMethod="isValidName", message = "res_method 值错误")
	private String res_method;

	// API的名称
	@NotBlank(message = "name 不能为空")
	@Length(max = 100, message="name长度不能超过100")
	private String name;

	// API的的网关地址
	@Length(max = 50, message="base_host长度不能超过50")
	private String base_host;

	//API的基本地址
	@Length(max = 100, message="base_path长度不能超过100")
	private String base_path;

	// 服务提供方的服务提供的地址
	@Length(max = 100, message="target_host长度不能超过100")
	private String target_host;

	// 服务提供方提供的服务的基本地址
	@Length(max = 100, message="target_base_path长度不能超过100")
	private String target_base_path;

	// API提供的协议类型，可选为http和https
	@NotBlank(message = "protocol 不能为空")
	@EnumValue(enumClass= ProtocolEnum.class, enumMethod="isValidName", message = "protocol 值错误")
	private String protocol;

	// API类型，分为[modern\traditional\distributed],分别指已经纳入DCOOS管理平台管理的应用，
	// 传统的未纳入DCOOS管理平台，仅用于信息上报的API，以及分布式服务框架的API，暂时EOP发起的仅能上报为传统和分布式框架的API
	@NotBlank(message = "api_type 不能为空")
	@EnumValue(enumClass= ApiTypeEnum.class, enumMethod="isValidName", message = "api_type 值错误")
	private String api_type;

	// 服务提供方ID，填写服务提供在系统中的ID
	// 服务提供方在DCOOS管理平台的租户名称，比如上海省公司填写为“中国电信股份有限公司上海分公司”
	@NotBlank(message = "provider 不能为空")
	@Length(max = 50, message="provider长度不能超过50")
	private String provider;

	// 服务提供方在DCOOS管理平台提供API默认使用的用户ID
	@NotBlank(message = "userid 不能为空")
	@Length(max = 20, message="userid长度不能超过20")
	private String userid;

	// 服务提供方在DCOOS管理平台提供API默认使用的用户名称
	@NotBlank(message = "username 不能为空")
	@Length(max = 30, message="username长度不能超过30")
	private String username;

	// API描述信息，填写API用途及功能等的描述信息
	@NotBlank(message = "description 不能为空")
	@Length(max = 1000, message="description长度不能超过1000")
	private String description;

	// API 基于的swagger描述信息，包含资源地址、请求/响应字段等信息，目前请使用swagger2.0的json字符串。
	private String api_swagger_info;

	//上传分布式服务的时间2019-03-21T23:58:27.062Z
	@NotBlank(message = "upload_dt 不能为空")
	@Length(max = 50, message="upload_dt长度不能超过10")
	private String upload_dt;

	//API优先级，默认高、中、低三级，取值依次为1、2、3，高优先级的API，网关优先处理，默认为空
	@NotBlank(message = "api_priority 不能为空")
	@EnumValue(enumClass= ApiPriorityEnum.class, enumMethod="isValidName", message = "api_priority 值错误")
	private String api_priority;

	// API超时时长，单位为秒
	@NotBlank(message = "api_timelimit 不能为空")
	@Length(max = 10, message="api_timelimit长度不能超过10")
	private String api_timelimit;

	// API状态	1000有效；1001已暂停（已暂停的API暂不能被使用，待恢复后可继续正常使用）；1002已下线（已下线的API不再能被使用，不可恢复、可清除）。
	@NotBlank(message = "api_status 不能为空")
	@EnumValue(enumClass= ApiStatusEnum.class, enumMethod="isValidName", message = "api_status 值错误")
	private String api_status;

	// API的资源信息
	private List<ReportApiResource> api_resources;

	// 目录引用
	private ReportApiCatalog catalog;

	// 标签引用
	private List<ReportApiLabel> api_labels;

	//API的策略信息
	private List<ReportApiPolicy> api_policies;

	public String getUpload_api_id() {
		return upload_api_id;
	}

	public void setUpload_api_id(String upload_api_id) {
		this.upload_api_id = upload_api_id;
	}

	public String getGateway_id() {
		return gateway_id;
	}

	public void setGateway_id(String gateway_id) {
		this.gateway_id = gateway_id;
	}

	public String getRes_method() {
		return res_method;
	}

	public void setRes_method(String res_method) {
		this.res_method = res_method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase_host() {
		return base_host;
	}

	public void setBase_host(String base_host) {
		this.base_host = base_host;
	}

	public String getBase_path() {
		return base_path;
	}

	public void setBase_path(String base_path) {
		this.base_path = base_path;
	}

	public String getTarget_host() {
		return target_host;
	}

	public void setTarget_host(String target_host) {
		this.target_host = target_host;
	}

	public String getTarget_base_path() {
		return target_base_path;
	}

	public void setTarget_base_path(String target_base_path) {
		this.target_base_path = target_base_path;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getApi_type() {
		return api_type;
	}

	public void setApi_type(String api_type) {
		this.api_type = api_type;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApi_swagger_info() {
		return api_swagger_info;
	}

	public void setApi_swagger_info(String api_swagger_info) {
		this.api_swagger_info = api_swagger_info;
	}

	public String getUpload_dt() {
		return upload_dt;
	}

	public void setUpload_dt(String upload_dt) {
		this.upload_dt = upload_dt;
	}

	public String getApi_priority() {
		return api_priority;
	}

	public void setApi_priority(String api_priority) {
		this.api_priority = api_priority;
	}

	public String getApi_timelimit() {
		return api_timelimit;
	}

	public void setApi_timelimit(String api_timelimit) {
		this.api_timelimit = api_timelimit;
	}

	public String getApi_status() {
		return api_status;
	}

	public void setApi_status(String api_status) {
		this.api_status = api_status;
	}

	public List<ReportApiResource> getApi_resources() {
		return api_resources;
	}

	public void setApi_resources(List<ReportApiResource> api_resources) {
		this.api_resources = api_resources;
	}

	public ReportApiCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(ReportApiCatalog catalog) {
		this.catalog = catalog;
	}

	public List<ReportApiLabel> getApi_labels() {
		return api_labels;
	}

	public void setApi_labels(List<ReportApiLabel> api_labels) {
		this.api_labels = api_labels;
	}

	public List<ReportApiPolicy> getApi_policies() {
		return api_policies;
	}

	public void setApi_policies(List<ReportApiPolicy> api_policies) {
		this.api_policies = api_policies;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ReportApiDcoos.class.getSimpleName() + "[", "]")
				.add("upload_api_id='" + upload_api_id + "'")
				.add("gateway_id='" + gateway_id + "'")
				.add("res_method='" + res_method + "'")
				.add("name='" + name + "'")
				.add("base_host='" + base_host + "'")
				.add("base_path='" + base_path + "'")
				.add("target_host='" + target_host + "'")
				.add("target_base_path='" + target_base_path + "'")
				.add("protocol='" + protocol + "'")
				.add("api_type='" + api_type + "'")
				.add("provider='" + provider + "'")
				.add("userid='" + userid + "'")
				.add("username='" + username + "'")
				.add("description='" + description + "'")
				.add("api_swagger_info='" + api_swagger_info + "'")
				.add("upload_dt='" + upload_dt + "'")
				.add("api_priority='" + api_priority + "'")
				.add("api_timelimit='" + api_timelimit + "'")
				.add("api_status='" + api_status + "'")
				.add("api_resources=" + api_resources)
				.add("catalog=" + catalog)
				.add("api_labels=" + api_labels)
				.add("api_policies=" + api_policies)
				.toString();
	}
}
