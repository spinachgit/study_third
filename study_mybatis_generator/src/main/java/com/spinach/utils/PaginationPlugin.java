package com.spinach.utils;

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

/** 
 * @项目名称：project-common 
 * @类名称：PaginationPlugin 
 * @类描述：自定义代码生成器 
 * @创建人：YangChao 
 * @作者单位：北京宝库在线网络技术有限公司 
 * @联系方式：YangChao@baoku.com 
 * @创建时间：2016年9月5日 下午3:14:38 
 * @version 1.0.0 
 */  
public class PaginationPlugin extends PluginAdapter {
	private static final String entityResultMap = "entityResultMap";
	private static final String entityColumn = "entityColumn";
	private static final String whereCondition = "whereCondition";
	private static final String mapResultMap = "mapResultMap";
	private static final String setCondition = "setCondition";
    /**
     *  生成dao 
     */
    @Override  
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("MybatisBaseDao<" + introspectedTable.getBaseRecordType()  + ">");  
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType("com.spinach.utils.MybatisBaseDao");  
        interfaze.addSuperInterface(fqjt);// 添加 extends MybatisBaseDao<User>  
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
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 数据库表名  
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();  
        XmlElement parentElement = document.getRootElement();
        
        //生成EntityResultMap
        XmlElement resultMap = generatorEntityResultMap(introspectedTable);
        parentElement.addElement(resultMap);
        //<resultMap id="mapResultMap" type="java.util.HashMap" extends="entityResultMap"></resultMap>
        XmlElement mapResultSql = new XmlElement("resultMap");  
        mapResultSql.addAttribute(new Attribute("id", mapResultMap));
        mapResultSql.addAttribute(new Attribute("type","java.util.HashMap"));
        mapResultSql.addAttribute(new Attribute("extends",entityResultMap));
        
        
        //生成selectObject
        XmlElement delete = generatorDelete(introspectedTable,"delete");
        parentElement.addElement(delete);
        //生成selectObject
        XmlElement update = generatorUpdate(introspectedTable,"update");
        parentElement.addElement(update);
        
        //生成selectObject
        XmlElement selectObject = generatorSelectObject(introspectedTable,"selectObject");
        parentElement.addElement(selectObject);
        
        
        //生成selectObjectList
        XmlElement selectObjectList = generatorSelectObjectList(introspectedTable,"selectObjectList");
        parentElement.addElement(selectObjectList);
        
        //生成selectMap
        XmlElement selectMap = generatorSelectMap(introspectedTable,"selectMap");
        parentElement.addElement(selectMap);
        
        //生成selectMapList
        XmlElement selectMapList = generatorSelectMapList(introspectedTable,"selectMapList");
        parentElement.addElement(selectMapList);
        
        //生成whereCondition
        XmlElement sql = generatorWhereSql(introspectedTable);
        parentElement.addElement(sql);
        
        return super.sqlMapDocumentGenerated(document, introspectedTable);  
    }  
    
    /**
     * <!-- 删除消息 -->
	<delete id="delete" parameterType="int">
		delete from
		business_bank
		where
		business_bank_id=#{businessBankId}
	</delete>
     * @author wanghuihui
     * @time: 2017年3月3日下午12:59:28
     * @param introspectedTable
     * @param id
     * @return
     */
    private XmlElement generatorDelete(IntrospectedTable introspectedTable, String id) {
    	IntrospectedColumn primaryKeys = introspectedTable.getPrimaryKeyColumns().get(0);
        XmlElement delete = new XmlElement("delete");  
        delete.addAttribute(new Attribute("id", id));  
        delete.addAttribute(new Attribute("parameterType", "int"));  
        
        String temp = "delete from "+introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()+"\n where "
        		+primaryKeys.getActualColumnName()+" = #{"+getColumn(primaryKeys.getActualColumnName())+",jdbcType="+primaryKeys.getJdbcType()+"}";
        delete.addElement(new TextElement(temp)); 
        return delete;
	}
    
    /**
     * 
	<!-- 更新 -->
	<update id="update" parameterType="com.bluemobi.po.business.BusinessBank">
		update business_bank
		<set>
			<include refid="setCondition"></include>
		</set>
		where business_bank_id=#{businessBankId}
	</update>
     * @author wanghuihui
     * @time: 2017年3月3日下午12:59:09
     * @param introspectedTable
     * @param string
     * @return
     */
	private XmlElement generatorUpdate(IntrospectedTable introspectedTable, String id) {
		IntrospectedColumn primaryKeys = introspectedTable.getPrimaryKeyColumns().get(0);
        XmlElement delete = new XmlElement("update");  
        delete.addAttribute(new Attribute("id", id));  
        delete.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));  
        delete.addElement(new TextElement("update "+introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        
        XmlElement set = new XmlElement("set");
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", setCondition));
        set.addElement(include);
        delete.addElement(set);
        
        String temp = "where "+primaryKeys.getActualColumnName()+" = #{"+getColumn(primaryKeys.getActualColumnName())+",jdbcType="+primaryKeys.getJdbcType()+"}";
        delete.addElement(new TextElement(temp)); 
        return delete;
	}

	/**
     * <select id="selectObject" parameterType="map" resultMap="entityResultMap">
		select
		<include refid="entityColumn"></include>
		from business_bank where
		business_bank_id=#{businessBankId}
		</select>
     * @author wanghuihui
     * @time: 2017年3月2日下午5:18:04
     * @param introspectedTable
     * @param string
     * @return
     */
    private XmlElement generatorSelectObject(IntrospectedTable introspectedTable,String id) {
    	IntrospectedColumn primaryKeys = introspectedTable.getPrimaryKeyColumns().get(0);
    	//添加getList  
        XmlElement select = new XmlElement("select");  
        select.addAttribute(new Attribute("id", id));  
        select.addAttribute(new Attribute("resultMap", entityResultMap));  
        select.addAttribute(new Attribute("parameterType", "map"));  
        select.addElement(new TextElement("select"));  
        
        XmlElement include = new XmlElement("include");  
        include.addAttribute(new Attribute("refid", entityColumn));  
        select.addElement(include);
        String temp = "from "+introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()+" where "
        		+primaryKeys.getActualColumnName()+" = #{"+getColumn(primaryKeys.getActualColumnName())+",jdbcType="+primaryKeys.getJdbcType()+"}";
        select.addElement(new TextElement(temp)); 
        return select;
	}
    
   
	/**
     *  <select id="selectObjectList" parameterType="map" resultMap="entityResultMap">
		select
		<include refid="entityColumn"></include>
		from business_bank
		<include refid="whereCondition"></include>
		</select>
     * @author wanghuihui
     * @time: 2017年3月2日下午5:18:32
     * @param introspectedTable
     * @param string
     * @return
     */
	private XmlElement generatorSelectObjectList(IntrospectedTable introspectedTable, String id) {
		IntrospectedColumn primaryKeys = introspectedTable.getPrimaryKeyColumns().get(0);
    	//添加getList  
        XmlElement select = new XmlElement("select");  
        select.addAttribute(new Attribute("id", id));  
        select.addAttribute(new Attribute("resultMap", entityResultMap));  
        select.addAttribute(new Attribute("parameterType", "map"));  
        select.addElement(new TextElement("select"));  
        
        XmlElement include = new XmlElement("include");  
        include.addAttribute(new Attribute("refid", entityColumn));  
        select.addElement(include);
        
        String temp = "from "+introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        select.addElement(new TextElement(temp)); 
        
        XmlElement where = new XmlElement("include");  
        where.addAttribute(new Attribute("refid", whereCondition));  
        select.addElement(where);
        return select;
	}
	
	/**
	 *  <select id="selectMap" parameterType="map" resultMap="mapResultMap">
		select
		<include refid="entityColumn"></include>
		from business_bank where
		business_bank_id=#{businessBankId}
		</select>
	 * @author wanghuihui
	 * @time: 2017年3月2日下午5:18:43
	 * @param introspectedTable
	 * @param string
	 * @return
	 */
	private XmlElement generatorSelectMap(IntrospectedTable introspectedTable, String id) {
		IntrospectedColumn primaryKeys = introspectedTable.getPrimaryKeyColumns().get(0);
    	//添加getList  
        XmlElement select = new XmlElement("select");  
        select.addAttribute(new Attribute("id", id));  
        select.addAttribute(new Attribute("resultMap", mapResultMap));  
        select.addAttribute(new Attribute("parameterType", "map"));  
        select.addElement(new TextElement("select"));  
        
        XmlElement include = new XmlElement("include");  
        include.addAttribute(new Attribute("refid", entityColumn));  
        select.addElement(include);
        
        String temp = "from "+introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()
        		+"\n where "+primaryKeys.getActualColumnName()+" = #{"+getColumn(primaryKeys.getActualColumnName())+",jdbcType="+primaryKeys.getJdbcType()+"}";
        select.addElement(new TextElement(temp)); 
        return select;
	}
	
	/**
	 *  <select id="selectMapList" parameterType="map" resultMap="mapResultMap">
		select
		<include refid="entityColumn"></include>
		from business_bank
		<include refid="whereCondition"></include>
		</select>
	 * @author wanghuihui
	 * @time: 2017年3月2日下午5:19:05
	 * @param introspectedTable
	 * @param string
	 * @return
	 */
	private XmlElement generatorSelectMapList(IntrospectedTable introspectedTable, String id) {
		IntrospectedColumn primaryKeys = introspectedTable.getPrimaryKeyColumns().get(0);
    	//添加getList  
        XmlElement select = new XmlElement("select");  
        select.addAttribute(new Attribute("id", id));  
        select.addAttribute(new Attribute("resultMap", mapResultMap));  
        select.addAttribute(new Attribute("parameterType", "map"));  
        select.addElement(new TextElement("select"));  
        
        XmlElement include = new XmlElement("include");  
        include.addAttribute(new Attribute("refid", entityColumn));  
        select.addElement(include);
        
        String temp = "from "+introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        select.addElement(new TextElement(temp)); 
        
        XmlElement where = new XmlElement("include");  
        where.addAttribute(new Attribute("refid", whereCondition));  
        select.addElement(where);
        return select;
	}

	/*********************************** **************************************/
    /**
     * 
    	<select id="getList" parameterType="com.test22.mysql.model.ActivityInfo" resultMap="BaseResultMap">
	     select * from activity_info
	    <include refid="sql_where" />
	  </select>
	
     * 
     * 生成结果集
    <resultMap id="entityResultMap"	type="com.bluemobi.po.business.BusinessBank">
	<id column="business_bank_id" property="businessBankId" jdbcType="INTEGER" />
	<result column="business_id" property="businessId" jdbcType="INTEGER" />
	<result column="user_id" property="userId" jdbcType="INTEGER" />
	<result column="user_name" property="userName" jdbcType="VARCHAR" />
	<result column="bank_account" property="bankAccount" jdbcType="VARCHAR" />
	<result column="bank_name" property="bankName" jdbcType="VARCHAR" />
	<result column="bank_phone" property="bankPhone" jdbcType="VARCHAR" />
	<result column="ctime" property="ctime" jdbcType="TIMESTAMP" />
	</resultMap>
	**/
	private XmlElement generatorEntityResultMap(IntrospectedTable introspectedTable) {
        XmlElement sql = new XmlElement("resultMap");  
        sql.addAttribute(new Attribute("id", entityResultMap));
        sql.addAttribute(new Attribute("type", introspectedTable.getBaseRecordType()));
        
        StringBuilder sb = new StringBuilder();
        List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
        for (int i=0;i<columnList.size();i++) {  
        	sb.setLength(0);  
        	IntrospectedColumn columnOri = columnList.get(i);
        	XmlElement element ;
        	if(i==0){
        		element = new XmlElement("id");
        	}else{
        		element = new XmlElement("result");
        	}
        	element.addAttribute(new Attribute("column",columnOri.getActualColumnName()));
        	element.addAttribute(new Attribute("property",getColumn(columnOri.getActualColumnName())));
        	element.addAttribute(new Attribute("jdbcType",columnOri.getJdbcTypeName()));
        	sql.addElement(element);  
        }  
        return sql;
	}
	
	/**
	<resultMap id="mapResultMap" type="java.util.HashMap" extends="entityResultMap"></resultMap>
	/**
         	getAliasedFullyQualifiedTableNameAtRuntime:activity_info
			getBaseColumnListId:Base_Column_List
			getBaseRecordType:com.test22.mysql.model.ActivityInfo
			getBaseResultMapId:BaseResultMap
			getBlobColumnListId:Blob_Column_List
			getCountByExampleStatementId:countByExample
			getDAOImplementationType:com.test22.mysql.dao.ActivityInfoDAOImpl
			getDAOInterfaceType:com.test22.mysql.dao.ActivityInfoDAO
			getDeleteByExampleStatementId:deleteByExample
			getDeleteByPrimaryKeyStatementId:deleteByPrimaryKey
			getExampleType:com.test22.mysql.model.ActivityInfoExample
			getExampleWhereClauseId:Example_Where_Clause
			getFullyQualifiedTableNameAtRuntime:activity_info
        System.out.println("getAliasedFullyQualifiedTableNameAtRuntime:"+introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        System.out.println("getBaseColumnListId:"+introspectedTable.getBaseColumnListId());
        System.out.println("getBaseRecordType:"+introspectedTable.getBaseRecordType());
        System.out.println("getBaseResultMapId:"+introspectedTable.getBaseResultMapId());
        System.out.println("getBlobColumnListId:"+introspectedTable.getBlobColumnListId());
        System.out.println("getCountByExampleStatementId:"+introspectedTable.getCountByExampleStatementId());
        System.out.println("getDAOImplementationType:"+introspectedTable.getDAOImplementationType());
        System.out.println("getDAOInterfaceType:"+introspectedTable.getDAOInterfaceType());
        System.out.println("getDeleteByExampleStatementId:"+introspectedTable.getDeleteByExampleStatementId());
        System.out.println("getDeleteByPrimaryKeyStatementId:"+introspectedTable.getDeleteByPrimaryKeyStatementId());
        System.out.println("getExampleType:"+introspectedTable.getExampleType());
        System.out.println("getExampleWhereClauseId:"+introspectedTable.getExampleWhereClauseId());
        System.out.println("getFullyQualifiedTableNameAtRuntime:"+introspectedTable.getFullyQualifiedTableNameAtRuntime());
	*/
	
    /*********************************** **************************************/
    
    
    
    
    /**
     * 生成结果预览：
     * <sql id="sql_where">
	   	<where>
	      <if test="activityname != null">
	         and activityname = #{activityname,jdbcType=VARCHAR}
	      </if>
	      <if test="cityid != null">
	         and cityid = #{cityid,jdbcType=INTEGER}
	      </if>
	    </where>
	  </sql>
     * @author wanghuihui
     * @time: 2017年3月2日下午3:38:22
     * @param introspectedTable
     * @return
     */
    private XmlElement generatorWhereSql(IntrospectedTable introspectedTable) {
    	// 添加sql——where  s
        XmlElement sql = new XmlElement("sql");  
        sql.addAttribute(new Attribute("id", whereCondition));  
        XmlElement where = new XmlElement("where");  
        StringBuilder sb = new StringBuilder();  
        for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {  
            XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$  
            sb.setLength(0);  
            sb.append(introspectedColumn.getJavaProperty());  
            sb.append(" != null and "); //$NON-NLS-1$  
            sb.append(introspectedColumn.getJavaProperty());  
            sb.append(" != '' "); //$NON-NLS-1$  
            isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$  
            where.addElement(isNotNullElement);  
  
            sb.setLength(0);  
            sb.append(" and ");  
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));  
            sb.append(" = "); //$NON-NLS-1$  
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));  
            isNotNullElement.addElement(new TextElement(sb.toString()));  
        }  
        sql.addElement(where);
        return sql;
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
  
    /** 
     * mapping中添加方法 
     */  
    // @Override  
    public boolean sqlMapDocumentGenerated2(Document document, IntrospectedTable introspectedTable) {  
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();// 数据库表名  
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();  
        // 添加sql  
        XmlElement sql = new XmlElement("select");  
  
        XmlElement parentElement = document.getRootElement();  
        XmlElement deleteLogicByIdsElement = new XmlElement("update");  
        deleteLogicByIdsElement.addAttribute(new Attribute("id", "deleteLogicByIds"));  
        deleteLogicByIdsElement  
                .addElement(new TextElement(  
                        "update "  
                                + tableName  
                                + " set deleteFlag = #{deleteFlag,jdbcType=INTEGER} where id in "  
                                + " <foreach item=\"item\" index=\"index\" collection=\"ids\" open=\"(\" separator=\",\" close=\")\">#{item}</foreach> "));  
  
        parentElement.addElement(deleteLogicByIdsElement);  
        XmlElement queryPage = new XmlElement("select");  
        queryPage.addAttribute(new Attribute("id", "queryPage"));  
        queryPage.addAttribute(new Attribute("resultMap", "BaseResultMap"));  
        queryPage.addElement(new TextElement("select "));  
  
        XmlElement include = new XmlElement("include");  
        include.addAttribute(new Attribute("refid", "Base_Column_List"));  
  
        queryPage.addElement(include);  
        queryPage.addElement(new TextElement(" from " + tableName + " ${sql}"));  
        parentElement.addElement(queryPage);  
        return super.sqlMapDocumentGenerated(document, introspectedTable);  
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
    /**
     * 驼峰标示
     * @author wanghuihui
     * @time: 2017年3月3日上午10:53:55
     * @param actualColumnName
     * @return
     */
    private String getColumn(String actualColumnName) {
		// TODO Auto-generated method stub
		return actualColumnName;
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