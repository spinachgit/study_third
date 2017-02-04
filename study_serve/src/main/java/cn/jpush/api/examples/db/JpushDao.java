package cn.jpush.api.examples.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by zhangyong on 2015-05-01.
 */
public class JpushDao {
    private Connection connection;

    public static final String CREATE_TABLE = "create table if not exists jpush(" +
            "id integer primary key autoincrement," +
            "recTime varchar(50)," +
            "recTime2 varchar(50)," +
            "msgid varchar(20)," +
            "msg varchar(400)," +
            "sendno varchar(50))";

    public JpushDao() {
        connection = SqliteUtil.getConnection();

        try {
            connection.setAutoCommit(true);
            Statement stat = connection.createStatement();
            stat.executeUpdate(CREATE_TABLE); //创建一个表，两列
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void insert(Map<String, String> map) {
        try {
            String id = String.valueOf(map.get("id"));
            String recTime = String.valueOf(map.get("recTime"));
            String recTime2 = String.valueOf(map.get("recTime2"));
            String msg = String.valueOf(map.get("msg"));
            String msgid = String.valueOf(map.get("msgid"));
            String sendno = String.valueOf(map.get("sendno"));

            System.out.println(id + "," + msg + "," + recTime2);
            PreparedStatement stat = connection.prepareStatement("INSERT into jpush(id,recTime,recTime2,msgid,msg,sendno) values(?,?,?, ?,?,?)");

            stat.setString(1, id);
            stat.setString(2, recTime);
            stat.setString(3, recTime2);
            stat.setString(4, msgid);
            stat.setString(5, msg);
            stat.setString(6, sendno);
            stat.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
