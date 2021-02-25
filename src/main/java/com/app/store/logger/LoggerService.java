package com.app.store.logger;

import org.apache.log4j.Logger;
public class LoggerService {
    private Logger log;
    public LoggerService(){
         this.log= Logger.getLogger(LoggerService.class.getName());
    }
     public void setLog(String message){
        this.log.info(message);
     }
}
