package com.xialiu.shop.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringEscapeUtils;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper{

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override    
    public String getHeader(String name) {    
        return StringEscapeUtils.escapeHtml(super.getHeader(name));    
    }    
    
    @Override    
    public String getQueryString() {    
        return StringEscapeUtils.escapeHtml(super.getQueryString());    
    }    
    
    @Override    
    public String getParameter(String name) {    
        return StringEscapeUtils.escapeHtml(super.getParameter(name));    
    }    
    
    @Override    
    public String[] getParameterValues(String name) {    
        String[] values = super.getParameterValues(name);    
        if(values != null) {    
            int length = values.length;    
            String[] escapseValues = new String[length];    
            for(int i = 0; i < length; i++){    
                escapseValues[i] = StringEscapeUtils.escapeHtml(values[i]);    
            }    
            return escapseValues;    
        }    
        return super.getParameterValues(name);    
    }    
}
