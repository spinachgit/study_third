package com.spinach.utils;

import java.io.File;  
import java.io.IOException;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
import org.mybatis.generator.api.MyBatisGenerator;  
import org.mybatis.generator.config.Configuration;  
import org.mybatis.generator.config.xml.ConfigurationParser;  
import org.mybatis.generator.exception.InvalidConfigurationException;  
import org.mybatis.generator.exception.XMLParserException;  
import org.mybatis.generator.internal.DefaultShellCallback;  
 
/**
 *  生成有四种方法：命令生成（最简单）、Java生成、ant生成、maven生成。
 *  这里说两种，有兴趣其余的可以在mybatis官网去学习。 
 * @author wanghuihui
 *  cmd:  java -jar E:\Websoft\mybaits\mybatis-generator-core-1.3.2\lib\mybatis-generator-core-1.3.2.jar -configfile 
 *  			E:\WebWorkSpace\workspace_js\downAttachdemo\src\com\mochasoft\down\generator.xml -overwrite
 *  cmd: java -jar mybatis-generator-core-1.3.2.jar -configfile generator.xml -overwrite
 */
public class MyBatisGeneratorUtils {  
  
    public static void main(String[] args) {  
        try {  
            System.out.println("start generator ...");  
            List<String> warnings = new ArrayList<String>();  
            boolean overwrite = true; 
            //String oracle_path = MyBatisGeneratorUtils.class.getResource("/generator_oracle.xml").getFile();
            String mysql_path = MyBatisGeneratorUtils.class.getResource("/generator_mysql.xml").getFile();
            File configFile = new File(mysql_path); 
            ConfigurationParser cp = new ConfigurationParser(warnings);  
            Configuration config = cp.parseConfiguration(configFile);  
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
            myBatisGenerator.generate(null);  
            System.out.println("end generator!");  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (XMLParserException e) {  
            e.printStackTrace();  
        } catch (InvalidConfigurationException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
      
}  
