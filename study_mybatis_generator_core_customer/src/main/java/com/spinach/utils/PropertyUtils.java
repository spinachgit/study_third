package com.spinach.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *  配置加载
 * @author whh
 * Apr 27, 2012 3:21:26 PM
 */
public class PropertyUtils {
    private static String fileName = "generator_conf.properties";
    private static Properties p = getProperties(fileName);
    
    
    public static final String daoInterface = p.getProperty("targetPackage.daoInterface");
    
    /**
     * 读取propertity文件的方法
     * @author whh
     * Apr 27, 2014 3:00:56 PM
     * @param fileName
     * @return
     */
    public static Properties getProperties(String fileName){
        InputStream is = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties=new Properties();
        try {
            properties.load(new InputStreamReader(is, "UTF-8"));
            if(is!=null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
}
