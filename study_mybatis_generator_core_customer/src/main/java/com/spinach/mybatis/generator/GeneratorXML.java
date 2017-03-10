package com.spinach.mybatis.generator;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

public class GeneratorXML {
	private static final String entityResultMap = "entityResultMap";
	private static final String entityColumn = "entityColumn";
	private static final String whereCondition = "whereCondition";
	private static final String mapResultMap = "mapResultMap";
	private static final String setCondition = "setCondition";

	
	public void configXML(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		// 生成EntityResultMap
		XmlElement resultMap = generatorEntityResultMap(introspectedTable);
		parentElement.addElement(resultMap);

		// <resultMap id="mapResultMap" type="java.util.HashMap"
		// extends="entityResultMap"></resultMap>
		XmlElement mapResultSql = new XmlElement("resultMap");
		mapResultSql.addAttribute(new Attribute("id", mapResultMap));
		mapResultSql.addAttribute(new Attribute("type", "java.util.HashMap"));
		mapResultSql.addAttribute(new Attribute("extends", entityResultMap));
		parentElement.addElement(mapResultSql);

		// 生成delete
		XmlElement delete = generatorDelete(introspectedTable, "delete");
		parentElement.addElement(delete);

		// 生成update
		XmlElement update = generatorUpdate(introspectedTable, "update");
		parentElement.addElement(update);

		// 生成selectObject
		XmlElement selectObject = generatorSelectObject(introspectedTable, "selectObject");
		parentElement.addElement(selectObject);

		// 生成selectObjectList
		XmlElement selectObjectList = generatorSelectObjectList(introspectedTable, "selectObjectList");
		parentElement.addElement(selectObjectList);

		// 生成selectMap
		XmlElement selectMap = generatorSelectMap(introspectedTable, "selectMap");
		parentElement.addElement(selectMap);

		// 生成selectMapList
		XmlElement selectMapList = generatorSelectMapList(introspectedTable, "selectMapList");
		parentElement.addElement(selectMapList);

		// 生成 entityColumn setCondition whereCondition
		XmlElement columnSql = generatorColumnSql(introspectedTable);
		parentElement.addElement(columnSql);
		XmlElement setSql = generatorSetSql(introspectedTable);
		parentElement.addElement(setSql);
		XmlElement whereSql = generatorWhereSql(introspectedTable);
		parentElement.addElement(whereSql);

	}

	/**
	 * <!-- 删除消息 --> <delete id="delete" parameterType="int"> delete from
	 * business_bank where business_bank_id=#{businessBankId} </delete>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月3日下午12:59:28
	 * @param introspectedTable
	 * @param id
	 * @return
	 */
	private XmlElement generatorDelete(IntrospectedTable introspectedTable, String id) {
		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		if (null == list || list.size() == 0) {
			return null;
		}
		IntrospectedColumn primaryKeys = list.get(0);
		XmlElement delete = new XmlElement("delete");
		delete.addAttribute(new Attribute("id", id));
		delete.addAttribute(new Attribute("parameterType", "int"));

		String temp = "delete from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
		delete.addElement(new TextElement(temp));
		delete.addElement(new TextElement("where " + primaryKeys.getActualColumnName() + " = #{" + primaryKeys.getJavaProperty() + ",jdbcType=" + primaryKeys.getJdbcTypeName() + "}"));
		return delete;
	}

	/**
	 * 
	 <!-- 更新 --> <update id="update"
	 * parameterType="com.bluemobi.po.business.BusinessBank"> update
	 * business_bank <set> <include refid="setCondition"></include> </set> where
	 * business_bank_id=#{businessBankId} </update>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月3日下午12:59:09
	 * @param introspectedTable
	 * @param string
	 * @return
	 */
	private XmlElement generatorUpdate(IntrospectedTable introspectedTable, String id) {
		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		if (null == list || list.size() == 0) {
			return null;
		}
		IntrospectedColumn primaryKeys = list.get(0);
		XmlElement delete = new XmlElement("update");
		delete.addAttribute(new Attribute("id", id));
		delete.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
		delete.addElement(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));

		XmlElement set = new XmlElement("set");
		XmlElement include = new XmlElement("include");
		include.addAttribute(new Attribute("refid", setCondition));
		set.addElement(include);
		delete.addElement(set);

		String temp = "where " + primaryKeys.getActualColumnName() + " = #{" + primaryKeys.getJavaProperty() + ",jdbcType=" + primaryKeys.getJdbcTypeName() + "}";
		delete.addElement(new TextElement(temp));
		return delete;
	}

	/**
	 * <select id="selectObject" parameterType="map"
	 * resultMap="entityResultMap"> select <include
	 * refid="entityColumn"></include> from business_bank where
	 * business_bank_id=#{businessBankId} </select>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月2日下午5:18:04
	 * @param introspectedTable
	 * @param string
	 * @return
	 */
	private XmlElement generatorSelectObject(IntrospectedTable introspectedTable, String id) {
		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		if (null == list || list.size() == 0) {
			return null;
		}
		IntrospectedColumn primaryKeys = list.get(0);
		// 添加getList
		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", id));
		select.addAttribute(new Attribute("resultMap", entityResultMap));
		select.addAttribute(new Attribute("parameterType", "map"));
		select.addElement(new TextElement("select"));

		XmlElement include = new XmlElement("include");
		include.addAttribute(new Attribute("refid", entityColumn));
		select.addElement(include);
		String temp = "from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime() + " where " + primaryKeys.getActualColumnName() + " = #{" + primaryKeys.getJavaProperty() + ",jdbcType=" + primaryKeys.getJdbcTypeName() + "}";
		select.addElement(new TextElement(temp));
		return select;
	}

	/**
	 * <select id="selectObjectList" parameterType="map"
	 * resultMap="entityResultMap"> select <include
	 * refid="entityColumn"></include> from business_bank <include
	 * refid="whereCondition"></include> </select>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月2日下午5:18:32
	 * @param introspectedTable
	 * @param string
	 * @return
	 */
	private XmlElement generatorSelectObjectList(IntrospectedTable introspectedTable, String id) {
		// 添加getList
		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", id));
		select.addAttribute(new Attribute("resultMap", entityResultMap));
		select.addAttribute(new Attribute("parameterType", "map"));
		select.addElement(new TextElement("select"));

		XmlElement include = new XmlElement("include");
		include.addAttribute(new Attribute("refid", entityColumn));
		select.addElement(include);

		String temp = "from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
		select.addElement(new TextElement(temp));

		XmlElement where = new XmlElement("include");
		where.addAttribute(new Attribute("refid", whereCondition));
		select.addElement(where);
		return select;
	}

	/**
	 * <select id="selectMap" parameterType="map" resultMap="mapResultMap">
	 * select <include refid="entityColumn"></include> from business_bank where
	 * business_bank_id=#{businessBankId} </select>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月2日下午5:18:43
	 * @param introspectedTable
	 * @param string
	 * @return
	 */
	private XmlElement generatorSelectMap(IntrospectedTable introspectedTable, String id) {
		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		if (null == list || list.size() == 0) {
			return null;
		}
		IntrospectedColumn primaryKeys = list.get(0);
		// 添加getList
		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", id));
		select.addAttribute(new Attribute("resultMap", mapResultMap));
		select.addAttribute(new Attribute("parameterType", "map"));
		select.addElement(new TextElement("select"));

		XmlElement include = new XmlElement("include");
		include.addAttribute(new Attribute("refid", entityColumn));
		select.addElement(include);

		String temp = "from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
		select.addElement(new TextElement(temp));
		select.addElement(new TextElement("where " + primaryKeys.getActualColumnName() + " = #{" + primaryKeys.getJavaProperty() + ",jdbcType=" + primaryKeys.getJdbcTypeName() + "}"));
		return select;
	}

	/**
	 * <select id="selectMapList" parameterType="map" resultMap="mapResultMap">
	 * select <include refid="entityColumn"></include> from business_bank
	 * <include refid="whereCondition"></include> </select>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月2日下午5:19:05
	 * @param introspectedTable
	 * @param string
	 * @return
	 */
	private XmlElement generatorSelectMapList(IntrospectedTable introspectedTable, String id) {
		// 添加getList
		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", id));
		select.addAttribute(new Attribute("resultMap", mapResultMap));
		select.addAttribute(new Attribute("parameterType", "map"));
		select.addElement(new TextElement("select"));

		XmlElement include = new XmlElement("include");
		include.addAttribute(new Attribute("refid", entityColumn));
		select.addElement(include);

		String temp = "from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
		select.addElement(new TextElement(temp));

		XmlElement where = new XmlElement("include");
		where.addAttribute(new Attribute("refid", whereCondition));
		select.addElement(where);
		return select;
	}

	/**
	 * 
	 * 生成结果集 <resultMap id="entityResultMap"
	 * type="com.bluemobi.po.business.BusinessBank"> <id
	 * column="business_bank_id" property="businessBankId" jdbcType="INTEGER" />
	 * <result column="business_id" property="businessId" jdbcType="INTEGER" />
	 * </resultMap>
	 **/
	private XmlElement generatorEntityResultMap(IntrospectedTable introspectedTable) {
		XmlElement sql = new XmlElement("resultMap");
		sql.addAttribute(new Attribute("id", entityResultMap));
		sql.addAttribute(new Attribute("type", introspectedTable.getBaseRecordType()));

		StringBuilder sb = new StringBuilder();
		List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
		for (int i = 0; i < columnList.size(); i++) {
			sb.setLength(0);
			IntrospectedColumn columnOri = columnList.get(i);
			XmlElement element;
			if (i == 0) {
				element = new XmlElement("id");
			} else {
				element = new XmlElement("result");
			}
			element.addAttribute(new Attribute("column", columnOri.getActualColumnName()));
			element.addAttribute(new Attribute("property", columnOri.getJavaProperty()));
			element.addAttribute(new Attribute("jdbcType", columnOri.getJdbcTypeName()));
			sql.addElement(element);
		}
		return sql;
	}

	/**
	 * <sql id="entityColumn">
	 * business_bank_id,business_id,user_id,user_name,bank_account
	 * ,bank_name,ctime </sql>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月3日下午1:21:51
	 * @param introspectedTable
	 * @return
	 */
	private XmlElement generatorColumnSql(IntrospectedTable introspectedTable) {
		XmlElement sql = new XmlElement("sql");
		sql.addAttribute(new Attribute("id", entityColumn));

		StringBuilder sb = new StringBuilder();
		List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
		for (int i = 0; i < columnList.size(); i++) {
			IntrospectedColumn columnOri = columnList.get(i);
			XmlElement element;
			if (i == 0) {
				sb.append(columnOri.getActualColumnName());
			} else {
				sb.append("," + columnOri.getActualColumnName());
			}
		}
		sql.addElement(new TextElement(sb.toString()));
		;
		return sql;
	}

	/**
	 * 生成 setCondition <sql id="setCondition"> <if
	 * test="businessBankId != null"> business_bank_id =
	 * #{businessBankId,jdbcType=INTEGER}, </if> </sql>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月3日下午1:22:19
	 * @param introspectedTable
	 * @return
	 */
	private XmlElement generatorSetSql(IntrospectedTable introspectedTable) {
		XmlElement sql = new XmlElement("sql");
		sql.addAttribute(new Attribute("id", setCondition));

		StringBuilder sb = new StringBuilder();
		List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
		for (int i = 0; i < columnList.size(); i++) {
			IntrospectedColumn columnOri = columnList.get(i);
			XmlElement isNotNullElement = new XmlElement("if");
			sb.setLength(0);
			sb.append(columnOri.getJavaProperty());
			sb.append(" != null and "); //$NON-NLS-1$  
			sb.append(columnOri.getJavaProperty());
			sb.append(" != '' "); //$NON-NLS-1$  
			isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
			sql.addElement(isNotNullElement);

			sb.setLength(0);
			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(columnOri));
			sb.append(" = "); //$NON-NLS-1$  
			sb.append(MyBatis3FormattingUtilities.getParameterClause(columnOri));
			isNotNullElement.addElement(new TextElement(sb.toString() + ","));
			sb.setLength(0);
		}
		sql.addElement(new TextElement(sb.toString()));
		return sql;
	}

	/**
	 * 生成结果预览： <sql id="sql_where"> <where> <if test="activityname != null"> and
	 * activityname = #{activityname,jdbcType=VARCHAR} </if> <if
	 * test="cityid != null"> and cityid = #{cityid,jdbcType=INTEGER} </if>
	 * </where> </sql>
	 * 
	 * @author wanghuihui
	 * @time: 2017年3月2日下午3:38:22
	 * @param introspectedTable
	 * @return
	 */
	private XmlElement generatorWhereSql(IntrospectedTable introspectedTable) {
		// 添加sql——where s
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
			sb.setLength(0);
		}
		sql.addElement(where);
		return sql;
	}

}
