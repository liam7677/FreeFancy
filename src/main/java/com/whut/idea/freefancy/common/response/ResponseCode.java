package com.whut.idea.freefancy.common.response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiMing
 * @date 2021/11/11 15:41
 */
public enum ResponseCode {

	/* 成功 - 失败 状态码 */
    SUCCESS(1000, "请求成功"),
    COMMON_FAILURE(1001, "请求失败"),

    /* 参数错误：1101-1199 */
    PARAM_ERROR(1101, "参数错误"),
    PARAM_IS_INVALID(1102, "参数无效"),
    PARAM_IS_BLANK(1103, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1104, "参数类型错误"),
    PARAM_NOT_COMPLETE(1105, "参数缺失"),
    PARAM_VERIFICATION_CODE_ERROR(1106,"验证码错误"),

    /* 用户错误：1201-1299*/
    USER_NOT_LOGGED_IN(1201, "用户未登录"),
    USER_LOGIN_ERROR(1202, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(1203, "账号已被禁用"),
    USER_NOT_EXIST(1204, "用户不存在"),
    USER_HAS_EXISTED(1205, "用户已存在"),
    USER_PASSWORD_ERROR(1206,"密码错误"),
    USER_TWO_PASSWORD_DIFFERENT(1206,"两次密码不同"),


    /* 业务错误：1301-1399 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(1301, "业务录入出现问题，请稍候再试"),

    /* 系统错误：1401-1499 */
    SYSTEM_INNER_ERROR(1401, "系统错误"),

    /* 数据错误：1501-1599 */
    RESULT_DATA_NONE(1501, "未找到数据"),
    DATA_IS_WRONG(1502, "数据有误"),
    DATA_ALREADY_EXISTED(1503, "数据已存在"),

    /* 接口错误：1601-1699 */
    INTERFACE_INNER_INVOKE_ERROR(1601, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(1602, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(1603, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(1604, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(1605, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(1606, "接口负载过高，请稍后再试");

    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
    	
        this.code = code;
        this.message = message;
    }

    public Integer code() {
    	
        return this.code;
    }

    public String message() {
    	
        return this.message;
    }

    public static String getMessage(String name) {
    	
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
            	
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
    	
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
            	
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
    	
        return this.name();
    }

    /**
     * 检查是否有重复的code
     * @param args
     */
    public static void main(String[] args) {
    	
        ResponseCode[] apiResultCodes = ResponseCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResponseCode apiResultCode : apiResultCodes) {
        	
            if (codeList.contains(apiResultCode.code)) {
            	
                System.out.println("重复的code值" + apiResultCode.code);
            } else {
            	
                codeList.add(apiResultCode.code());
            }
        }
    }
}
