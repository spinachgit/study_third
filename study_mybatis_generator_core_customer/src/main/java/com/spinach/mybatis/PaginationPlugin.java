package com.spinach.mybatis;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import com.spinach.mybatis.generator.GeneratorXML;

/**
 * 自定义代码生成器 
 * @author wanghuihui
 * @time: 2017年3月9日上午10:49:08
 */
public class PaginationPlugin extends PluginAdapter {
	
    /**
     *  生成dao 
     */
    @Override  
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        FullyQualifiedJavaType extend = new FullyQualifiedJavaType("MybatisBaseDao<" + introspectedTable.getBaseRecordType()  + ">");  
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(Constants.IMPORT_PATH);  
        interfaze.addSuperInterface(extend);// 添加 extends MybatisBaseDao<User>  
        interfaze.addImportedType(imp);// 添加import com.spinach.utils;  
        interfaze.getMethods().clear();
        return true;  
    }  
  
    /** 
     * 生成实体中每个属性 
     */  
    @Override  
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,  
            IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {  
        return true;  
    }  
  
    /** 
     * 生成实体  model
     */  
    @Override  
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        addSerialVersionUID(topLevelClass, introspectedTable);  
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);  
    }  
  
    /** 
     * 生成mapping 
     */  
    @Override  
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {  
        return super.sqlMapGenerated(sqlMap, introspectedTable);  
    }  
  
    /** 
     * 生成mapping 添加自定义sql 
     * 
     * 
     */  
    @Override  
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {  
        //String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 数据库表名  
        //List<IntrospectedColumn> columns = introspectedTable.getAllColumns();  
       
        /*if(null != introspectedTable.getPrimaryKeyColumns()|| introspectedTable.getPrimaryKeyColumns().size()<=0){
        	return super.sqlMapDocumentGenerated(document, introspectedTable);
        }*/
    	GeneratorXML xml = new GeneratorXML();
    	xml.configXML(document,introspectedTable);
        
        
        return super.sqlMapDocumentGenerated(document, introspectedTable);  
    }  
    
	
	/*@Override  
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,  
            IntrospectedTable introspectedTable) {  
        return false;  
    }  
  
    @Override  
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {  
        return false;  
    }*/  
  
    @Override  
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,  
            IntrospectedTable introspectedTable) {  
        // LIMIT5,10; // 检索记录行 6-15  
        //      XmlElement isNotNullElement = new XmlElement("if");//$NON-NLS-1$  
        //      isNotNullElement.addAttribute(new Attribute("test", "limitStart != null and limitStart >=0"));//$NON-NLS-1$ //$NON-NLS-2$  
        // isNotNullElement.addElement(new  
        // TextElement("limit ${limitStart} , ${limitEnd}"));  
        // element.addElement(isNotNullElement);  
        // LIMIT 5;//检索前 5个记录行  
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);  
    }  
  
    private void addSerialVersionUID(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        CommentGenerator commentGenerator = context.getCommentGenerator();  
        Field field = new Field();  
        field.setVisibility(JavaVisibility.PRIVATE);  
        field.setType(new FullyQualifiedJavaType("long"));  
        field.setStatic(true);  
        field.setFinal(true);  
        field.setName("serialVersionUID");  
        field.setInitializationString("1L");  
        commentGenerator.addFieldComment(field, introspectedTable);  
        topLevelClass.addField(field);  
    }  
  
    /* 
     * Dao中添加方法 
     */  
    private Method generateDeleteLogicByIds(Method method, IntrospectedTable introspectedTable) {  
        Method m = new Method("deleteLogicByIds");  
        m.setVisibility(method.getVisibility());  
        m.setReturnType(FullyQualifiedJavaType.getIntInstance());  
        m.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "deleteFlag", "@Param(\"deleteFlag\")"));  
        m.addParameter(new Parameter(new FullyQualifiedJavaType("Integer[]"), "ids", "@Param(\"ids\")"));  
        context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);  
        return m;  
    }  
  
    /* 
     * 实体中添加属性 
     */  
    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {  
        CommentGenerator commentGenerator = context.getCommentGenerator();  
        Field field = new Field();  
        field.setVisibility(JavaVisibility.PROTECTED);  
        field.setType(FullyQualifiedJavaType.getIntInstance());  
        field.setName(name);  
        field.setInitializationString("-1");  
        commentGenerator.addFieldComment(field, introspectedTable);  
        topLevelClass.addField(field);  
        char c = name.charAt(0);  
        String camel = Character.toUpperCase(c) + name.substring(1);  
        Method method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setName("set" + camel);  
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), name));  
        method.addBodyLine("this." + name + "=" + name + ";");  
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
        method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());  
        method.setName("get" + camel);  
        method.addBodyLine("return " + name + ";");  
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
    }  

    public boolean validate(List<String> arg0) {  
        return true;  
    }  
  
    public static void generate() {  
        String config = PaginationPlugin.class.getClassLoader().getResource("mybatisConfig.xml").getFile();  
        String[] arg = { "-configfile", config, "-overwrite" };  
        ShellRunner.main(arg);  
    }  
  
    public static void main(String[] args) {  
        generate();  
    }  
}  