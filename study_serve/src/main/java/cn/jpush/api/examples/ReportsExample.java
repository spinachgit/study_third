package cn.jpush.api.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.report.ReceivedsResult;


/**
 * Created by zhangyong on 2015-05-01.
 */
public class ReportsExample {
	static Logger logger = LoggerFactory.getLogger(ReportsExample.class);
    public static void main(String[] args) {

        JPushClient jpushClient = new JPushClient(Constants.masterSecret, Constants.appKey);
        try {
            ReceivedsResult result = jpushClient.getReportReceiveds("1942377665");
            //logger.debug("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            logger.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            logger.error("Should review the error, and fix the request", e);
            logger.info("HTTP Status: " + e.getStatus());
            logger.info("Error Code: " + e.getErrorCode());
            logger.info("Error Message: " + e.getErrorMessage());
        }
    }
}
