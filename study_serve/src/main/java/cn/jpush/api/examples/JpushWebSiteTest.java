package cn.jpush.api.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.report.ReceivedsResult;

import com.spinach.serve.jpush.JpushConfig;

/**
 *  这是 JPush REST API 的 Java 版本封装开发包，是由极光推送官方提供的，一般支持最新的 API 功能。
对应的 REST API 文档：REST API - Push, REST API - Report.
本开发包 Javadoc：API Docs
 * https://docs.jiguang.cn/jpush/server/3rd/java_sdk/
 * @author wanghuihui
 * @time: 2017年1月19日下午8:41:58
 */
public class JpushWebSiteTest {
		static Logger logger = LoggerFactory.getLogger(JpushWebSiteTest.class);
//	 	JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
	 	private static JPushClient jpushClient = new JPushClient(JpushConfig.MASTER_SECRET,JpushConfig.APP_KEY);
	 	private static String ALERT = "测试消息";
	 	private static String MSG_CONTENT = "信息内容测试！";
	    /**
	     * 进行推送的关键在于构建一个 PushPayload 对象。以下示例一般的构建对象的用法。快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
	     * @author wanghuihui
	     * @time: 2017年1月19日下午8:37:46
	     * @return
	     */
	    public static PushPayload buildPushObject_all_all_alert(){
	        return PushPayload.alertAll(ALERT);
	    }
	    
	    /**
	     * 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
	     * @author wanghuihui
	     * @time: 2017年1月19日下午8:37:59
	     * @return
	     */
	    public static PushPayload buildPushObject_all_alias_alert() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.alias("alias1"))
	                .setNotification(Notification.alert(ALERT))
	                .build();
	    }
	    
	    /**
	     * 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，推送内容同时包括通知与消息 - 通知信息是 ALERT，
	     * 角标数字为 5，通知声音为 "happy"，并且附加字段 from = "JPush"；消息内容是 MSG_CONTENT。通知是 APNs 推送通道的，
	     * 消息是 JPush 应用内消息通道的。APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
	     * @author wanghuihui
	     * @time: 2017年1月19日下午8:38:20
	     * @return
	     */
	    public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.ios())
	                .setAudience(Audience.tag_and("tag1", "tag_all"))
	                .setNotification(Notification.newBuilder()
	                        .addPlatformNotification(IosNotification.newBuilder()
	                                .setAlert(ALERT)
	                                .setBadge(5)
	                                .setSound("happy")
	                                .addExtra("from", "JPush")
	                                .build())
	                        .build())
	                 .setMessage(Message.content(MSG_CONTENT))
	                 .setOptions(Options.newBuilder()
	                         .setApnsProduction(true)
	                         .build())
	                 .build();
	    }
	    
	    /**
	     * 构建推送对象：平台是 Andorid 与 iOS，推送目标是 （"tag1" 与 "tag2" 的并集）交（"alias1" 与 "alias2" 的并集），
	     * 推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush。
	     * @author wanghuihui
	     * @time: 2017年1月19日下午8:39:03
	     * @return
	     */
	    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.newBuilder()
	                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
	                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))
	                        .build())
	                .setMessage(Message.newBuilder().setMsgContent(MSG_CONTENT)
	                        .addExtra("from", "JPush")
	                        .build())
	                .build();
	    }
	    
	    /**
	     * 构建推送对象：推送内容包含SMS信息
	     * @author wanghuihui
	     * @time: 2017年1月19日下午8:39:24
	     */
	    public static void testSendWithSMS() {
	        try {
	            SMS sms = SMS.content("Test SMS", 10);
	            PushResult result = jpushClient.sendAndroidMessageWithAlias("Test SMS", "test sms", sms, "alias1");
	            logger.info("Got result - " + result);
	        } catch (APIConnectionException e) {
	            logger.error("Connection error. Should retry later. ", e);
	        } catch (APIRequestException e) {
	            logger.error("Error response from JPush server. Should review and fix it. ", e);
	            logger.info("HTTP Status: " + e.getStatus());
	            logger.info("Error Code: " + e.getErrorCode());
	            logger.info("Error Message: " + e.getErrorMessage());
	        }
	    }
	    
	    /**
	     * 统计获取样例
		 *	以下片断来自项目代码里的文件：example / cn.jpush.api.examples.ReportsExample
	     */
	    public static void testReport(){
		    try {
		        ReceivedsResult result = jpushClient.getReportReceiveds("1942377665");
		        logger.debug("Got result - " + result);
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
	    
	    public static void test(){
	    	JPushClient jpushClient = new JPushClient(JpushConfig.MASTER_SECRET,JpushConfig.APP_KEY, null, ClientConfig.getInstance());
	    	// For push, all you need do is to build PushPayload object.
	        PushPayload payload = buildPushObject_all_all_alert();

	        try {
	            PushResult result = jpushClient.sendPush(payload);
	            logger.info("Got result - " + result);

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
	
	    public static void main(String[] args) {
			test();
		}
}
