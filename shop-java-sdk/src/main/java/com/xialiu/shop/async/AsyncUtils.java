package com.xialiu.shop.async;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncUtils {
	private static Logger logger = LoggerFactory.getLogger(AsyncUtils.class);
	
	public static<T> T getAynscResult(int timeout, Future<T> future, T defaultResult){
		try {
			return future.get(timeout, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return defaultResult;
	}
}
