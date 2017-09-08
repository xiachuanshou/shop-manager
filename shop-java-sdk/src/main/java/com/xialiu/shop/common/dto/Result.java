package com.xialiu.shop.common.dto;

import java.io.Serializable;

public class Result<T> implements Serializable{
	
	/**
	 * 返回数据，可为基本类型（包装类），可以为其它可序列化对象
	 */
	private static final long serialVersionUID = 7327318571759901061L;
	/**
	 * 请求标识号
	 */
	private String sid;
	
	/** 成功标志*/
	private boolean success;
	
	/** 信息码 */
	private String code;
	
	/** 描述 */
	private String description;
	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	private T data;

	public static <T> Result<T> create() {
		Result<T> result = new Result<T>();
		result.setSuccess(false);
		return result;
	}

	public Result<T> success(){
		success(null);
		return this;
	}

	public Result<T> success(T data){
		this.setSuccess(true);
		this.data = data;
		return this;
	}

	public Result<T> fail(String code,String description){
		this.setSuccess(false);
		this.setCode(code);
		this.setDescription(description);
		return this;
	}

	public Result<T> fail(String code){
		fail(code, null);
		return this;
	}

	public Result<T> code(String code){
		this.setCode(code);
		return this;
	}

	public Result<T> description(String description){
		this.setDescription(description);
		return this;
	}

	public Result<T> sid(String sid){
		this.setSid(sid);
		return this;
	}

	public Result<T> data(T data){
		this.data = data;
		return this;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
