package com.spinach.serve.jpush;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;

/**
 * 极光推送配置加载
 * @Description
 * @author haojian 309444359@qq.com
 * @date 2015-10-16 下午5:42:41 
 *
 */
public class JpushConfig {
    
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(JpushConfig.class);

    private static String configFileName = "jpush/jpush_config.properties";
    
    private static Properties config = getProperties(configFileName);
    public static final String JPUSH_CONFIG_ENV = config.getProperty("JPUSH_CONFIG_ENV");
    private static Properties p = getProperties(JPUSH_CONFIG_ENV);
    
    /** 加盟APP 应用唯一标示 和 秘钥  */
    public static final String APP_KEY_MERCHANT = p.getProperty("APP_KEY_MERCHANT");
    public static final String MASTER_SECRET_MERCHANT = p.getProperty("MASTER_SECRET_MERCHANT");
    
    
    /** 招商APP(shareTagApp-本项目) key和secret 应用唯一标示 **/
    public static final String APP_KEY_TAG = p.getProperty("APP_KEY_TAG");
    public static final String MASTER_SECRET_TAG = p.getProperty("MASTER_SECRET_TAG");
    
    /**最大重试次数*/
    public static final int MAX_RETRY_TIMES = Integer.parseInt(p.getProperty("MAX_RETRY_TIMES"));
    
    /**
     * 读取propertity文件的方法
     * @author haojian
     * Apr 27, 2012 3:00:56 PM
     * @param fileName
     * @return
     */
    public static Properties getProperties(String fileName){
        
        LOGGER.info("开始读取文件【{}】...", new Object[]{fileName} );
        
        InputStream is = JpushConfig.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties=new Properties();
        try {
            properties.load(is);
            if(is!=null){
                is.close();
            }
        } catch (IOException e) {
            LOGGER.error("Exception:【{}】"+e);
        }
        
        LOGGER.info("读取文件【{}】结束...", new Object[]{fileName} );
        
        return properties;
    }
    
    private static JPushClient jpushClient = null;
    public static synchronized  JPushClient getJPushClient(String masterSecret,String appKey){
    	if(null == jpushClient){
    		jpushClient = new JPushClient(masterSecret,appKey,JpushConfig.MAX_RETRY_TIMES);
    	}
    	return jpushClient;
    }
    
}
