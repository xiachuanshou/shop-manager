package com.xialiu.shop.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface Login {

}
