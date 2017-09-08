package com.xialiu.shop.exception;

import java.io.Serializable;

public class CodeMeta implements Serializable{
	/**
     * serialVersionUID
     */
	private static final long serialVersionUID = 3880506587294261864L;
    public static final String ZH_CN = "zh_CN";
    public static final String ZH_TW = "zh_TW";
    public static final String EN_US = "en_US";
    
    /**
     * 代码
     */
    private String code;
    
    /**
     * 代码的name（或者叫做title或type）
     */
    private String name;
    
    /**
     * 代码的简体中文信息
     */
    private String msgZhCN;
    
    /**
     * 代码的英文信息
     */
    private String msgEnUS;
    
    /**
     * 代码的繁体中文信息
     */
    private String msgZhTW;
    
    
    /**
     * @param code  Error Code
     * @param msgZhCN  zh_CN error message 
     */
    public CodeMeta(String code, String name, String msgZhCN) {
        super();
        this.code = code;
        this.name = name;
        this.msgZhCN = msgZhCN;
    }
    
    /**
     * @param code  Error Code
     * @param msgZhCN  zh_CN error message 
     * @param msgEnUS  en_US error message 
     * @param msgZhTW  zh_TW error message 
     */
    public CodeMeta(String code, String name, String msgZhCN, String msgEnUS) {
        super();
        this.code = code;
        this.name = name;
        this.msgZhCN = msgZhCN;
        this.msgEnUS = msgEnUS;
    }
    
    /**
     * @param code  Error Code
     * @param msgZhCN  zh_CN error message 
     * @param msgEnUS  en_US error message 
     * @param msgZhTW  zh_TW error message 
     */
    public CodeMeta(String code, String name, String msgZhCN, String msgEnUS, String msgZhTW) {
        super();
        this.code = code;
        this.name = name;
        this.msgZhCN = msgZhCN;
        this.msgEnUS = msgEnUS;
        this.msgZhTW = msgZhTW;
    }
    
    
    public String getMsg() {
        
        if(name==null) {
            if (msgZhCN != null) {
                return msgZhCN;
            }

            if (msgEnUS != null) {
                return msgEnUS;
            }

            if (msgZhTW != null) {
                return msgZhTW;
            }
            return "";
        }
        
        if (msgZhCN != null) {
            return "[" + name + "]  " + msgZhCN;
        }

        if (msgEnUS != null) {
            return "[" + name + "]  " + msgEnUS;
        }

        if (msgZhTW != null) {
            return "[" + name + "]  " + msgZhTW;
        }

        return "[" + name + "]";
    }
    
    public String getMsg(String local) {
        
        if(name==null) {
            if (ZH_CN.equals(local)) {
                return msgZhCN;
            }

            if (EN_US.equals(local)) {
                return msgEnUS;
            }

            if (ZH_TW.equals(local)) {
                return msgZhTW;
            }

            return "";
        }
        
        if (ZH_CN.equals(local)) {
            return "[" + name + "]  " + msgZhCN;
        }

        if (EN_US.equals(local)) {
            return "[" + name + "]  " + msgEnUS;
        }

        if (ZH_TW.equals(local)) {
            return "[" + name + "]  " + msgZhTW;
        }

        return "[" + name + "]";
    }
    
    
    @Override
    public String toString(){
        return code + "=[" + name + "] " + getMsg();
    }
    
    public String toString(String local){
        return code + "=[" + name + "] " + getMsg(local);
    }
    
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    /**
     * @return the msgZhCN
     */
    public String getMsgZhCN() {
        return msgZhCN;
    }

    /**
     * @param msgZhCN the msgZhCN to set
     */
    public void setMsgZhCN(String msgZhCN) {
        this.msgZhCN = msgZhCN;
    }

    /**
     * @return the msgEnUS
     */
    public String getMsgEnUS() {
        return msgEnUS;
    }

    /**
     * @param msgEnUS the msgEnUS to set
     */
    public void setMsgEnUS(String msgEnUS) {
        this.msgEnUS = msgEnUS;
    }

    /**
     * @return the msgZhTW
     */
    public String getMsgZhTW() {
        return msgZhTW;
    }

    /**
     * @param msgZhTW the msgZhTW to set
     */
    public void setMsgZhTW(String msgZhTW) {
        this.msgZhTW = msgZhTW;
    }
}
