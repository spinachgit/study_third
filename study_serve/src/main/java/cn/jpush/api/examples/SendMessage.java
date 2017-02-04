package cn.jpush.api.examples;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.examples.db.JpushDao;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

/**
 * Created by zhangyong on 2015-05-01.
 */
public class SendMessage {
    private static int id;
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {

        JPushClient jpushClient = new JPushClient(Constants.masterSecret, Constants.appKey, 5);
        JpushDao jpushDao = new JpushDao();
        Map<String, String> map = new HashMap<String, String>();


//        发送通知
//        PushPayload payload = PushPayload.alertAll("notification");

//        发送消息
//        PushPayload payload = PushPayload.messageAll(msg);



        for(;;) {

            map.clear();
            try {
                int index = ++id;
                String msg = "极光推送_测试_2015-05-02---->" + index;
                PushPayload payload = PushPayload.messageAll(msg);
                long now = System.currentTimeMillis();
                PushResult result = jpushClient.sendPush(payload);
                long msg_id = result.msg_id;
                int sendno = result.sendno;

               /* map.put("id", String.valueOf(index));
                map.put("msg", msg);
                map.put("msgid", String.valueOf(msg_id));
                map.put("recTime", String.valueOf(now));
                map.put("recTime2", getFromLong(now));
                map.put("sendno", String.valueOf(sendno));

                jpushDao.insert(map);*/

                System.out.println("Got result - " + result);
                Thread.sleep(30000);

            } catch (APIConnectionException e) {
                System.out.println("Connection error, should retry later" + e);

            } catch (APIRequestException e) {
                System.out.println("Should review the error, and fix the request" + e);
                System.out.println("HTTP Status: " + e.getStatus());
                System.out.println("Error Code: " + e.getErrorCode());
                System.out.println("Error Message: " + e.getErrorMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static String getFromLong(long millis) {
        return format.format(new Date(millis));
    }
}
