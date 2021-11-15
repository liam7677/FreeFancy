package com.whut.idea.freefancy.common.response;

import java.io.Serializable;

/**
 * @author LiMing
 * @date 2021/11/11 15:41
 */
public class ResponseJson implements Serializable {
	/**
	 * 接口返回的状态码
	 */
	private Integer code;
	/**
	 * 接口返回操作是否成功
	 */
	private Boolean result;
	/**
	 * 接口返回的消息
	 */
	private String msg;
	/**
	 * 接口返回的数据
	 */
	private Object data;

	public ResponseJson() { }

	public ResponseJson(Integer code, Boolean result, String msg, Object data) {
		super();
		this.code = code;
		this.result = result;
		this.msg = msg;
		this.data = data;
	}

	public ResponseJson(Integer code, String msg) {

		this.code = code;
		this.msg = msg;
	}

	public ResponseJson(Integer code, Boolean result, String msg) {

		this.code = code;
		this.result = result;
		this.msg = msg;
	}

	public void setResultCode(ResponseCode code) {

		this.code = code.code();
		this.msg = code.message();
	}

	public static ResponseJson success() {

		ResponseJson result = new ResponseJson();
		result.setResultCode(ResponseCode.SUCCESS);
		result.setResult(true);
		result.setData("");
		return result;
	}

	public static ResponseJson success(Object data) {

		ResponseJson result = new ResponseJson();
		result.setResultCode(ResponseCode.SUCCESS);
		result.setResult(true);
		result.setData(data);
		return result;
	}

	public static ResponseJson success(String msg) {

		ResponseJson result = new ResponseJson();
		result.setCode(ResponseCode.SUCCESS.code());
		result.setMsg(msg);
		result.setResult(true);
		result.setData("");
		return result;
	}
	
	public static ResponseJson success(int code, String msg) {

		ResponseJson result = new ResponseJson();
		result.setCode(code);
		result.setMsg(msg);
		result.setResult(true);
		result.setData("");
		return result;
	}
	
	public static ResponseJson failure(ResponseCode resultCode) {

		ResponseJson result = new ResponseJson();
		result.setResultCode(resultCode);
		result.setResult(false);
		result.setData("");
		return result;
	}
	
	public static ResponseJson failure(String msg) {

		ResponseJson result = new ResponseJson();
		result.setCode(ResponseCode.COMMON_FAILURE.code());
		result.setMsg(msg);
		result.setResult(false);
		result.setData("");
		return result;
	}

	public static ResponseJson failure(String msg, Object data) {

		ResponseJson result = new ResponseJson();
		result.setCode(ResponseCode.COMMON_FAILURE.code());
		result.setMsg(msg);
		result.setResult(false);
		result.setData(data);
		return result;
	}
	
	public static ResponseJson failure(int code, String msg) {

		ResponseJson result = new ResponseJson();
		result.setCode(code);
		result.setMsg(msg);
		result.setResult(false);
		result.setData("");
		return result;
	}
	
	public static ResponseJson failure(ResponseCode resultCode, Object data) {

		ResponseJson result = new ResponseJson();
		result.setResultCode(resultCode);
		result.setResult(false);
		result.setData(data);
		return result;
	}

	public static ResponseJson toResult(int rows){
		
		return rows > 0 ? success() : failure(ResponseCode.INTERFACE_INNER_INVOKE_ERROR);
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
