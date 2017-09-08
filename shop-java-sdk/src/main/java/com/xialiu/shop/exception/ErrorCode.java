package com.xialiu.shop.exception;

public class ErrorCode {
    /** 未知错误，参见：{}！ */
    public static final CodeMeta UNKNOWN_ERROR = new CodeMeta("000000", "UNKNOWN_ERROR",
            "未知错误，参见：{}！", "Unknown error, see: {}");
    
    /** UNDEFINED_ERROR */
    public static final CodeMeta UNDEFINED_ERROR = new CodeMeta("000001", "UNDEFINED_ERROR",
            "{}", "{}");
    
    /** 无效的参数：{} */
    public static final CodeMeta INVALID_PARAM = new CodeMeta("000002", "UNVALID_PARAM",
            "无效的参数：{}", "unvalid param: {}");
    
    /** 参数({})不能为空！ */
    public static final CodeMeta PARAM_NULL = new CodeMeta("000003", "PARAM_ERROR",
            "参数({})不能为空！", "this argument ({}) is required; it must not be null");
    
    
    
    /** 数据({})状态不正常！ */
    public static final CodeMeta DATA_STATE_NOT_NORMAL = new CodeMeta("000011", 
            "BUSINESS_CHECK_ERROR", "数据({})状态不正常！", "");
    
    /** 数据({})不存在！ */
    public static final CodeMeta DATA_NOT_EXIST = new CodeMeta("000012", "DATA_NOT_EXIST",
            "数据({})不存在！", " Data ({}) is not exist!");
    
    
    
    /** 删除数据({})失败! */
    public static final CodeMeta DB_DELETE_FAILED = new CodeMeta("000030", 
            "DB_ERROR", "数据({})删除失败!", "data ({}) delete failed!");
    
    /** 更新数据({})失败! */
    public static final CodeMeta DB_UPDATE_FAILED = new CodeMeta("000031", 
            "DB_ERROR", "数据({})更新失败!", "data ({}) update failed!");
    
    /** 插入数据({})失败! */
    public static final CodeMeta DB_INSERT_FAILED = new CodeMeta("000032", 
            "DB_ERROR", "数据({})插入失败!", "data ({}) insert failed!");
    
    /** 数据表中没有找到该记录({})! */
    public static final CodeMeta DB_DATA_NOT_FOUND = new CodeMeta("000033", 
            "DB_ERROR", "数据表中没有找到该记录({})!", "data ({}) not found!");
    
    /** 用户没有登录! */
    public static final CodeMeta NOT_LOGIN = new CodeMeta("800000", 
            "NOT_LOGIN", "用户没有登录{}!", "user not login ({})");
}
