package com.youngman.website.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {

	 //logback  日志测试
    private final static Logger logger = LoggerFactory.getLogger(LogBackTest.class); 
    
   public static void main(String[] args) {
       logger.info("logback 启动成功");
       logger.error("logback 启动成功");
   }
}
