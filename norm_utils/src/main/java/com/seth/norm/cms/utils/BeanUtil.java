package com.seth.norm.cms.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * Bean 转换工具
 */

public class BeanUtil {

	private static final String JAVAP = "java.";
	private static final String JAVADATESTR = "java.util.Date";

	/**
	 * 获取利用反射获取类里面的值和名称
	 *
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object value = field.get(obj);
			map.put(fieldName, value);
		}
		return map;
	}

	/**
	 * 利用递归调用将Object中的值全部进行获取
	 *
	 * @param timeFormatStr 格式化时间字符串默认<strong>2018-05-19 14:21</strong>
	 * @param obj           对象
	 * @param excludeFields 排除的属性
	 * @return
	 * @throws IllegalAccessException
	 */
	public static Map<String, String> objectToMapString(String timeFormatStr, Object obj, String... excludeFields) throws IllegalAccessException {
		Map<String, String> map = new HashMap<>();

		if (excludeFields.length!=0){
			List<String> list = Arrays.asList(excludeFields);
			objectTransfer(timeFormatStr, obj, map, list);
		}else{
			objectTransfer(timeFormatStr, obj, map,null);
		}
		return map;
	}


	/**
	 * 递归调用函数
	 *
	 * @param obj           对象
	 * @param map           map
	 * @param excludeFields 对应参数
	 * @return
	 * @throws IllegalAccessException
	 */
	private static Map<String, String> objectTransfer(String timeFormatStr, Object obj, Map<String, String> map, List<String> excludeFields) throws IllegalAccessException {
		boolean isExclude=false;
		//默认字符串
		String formatStr = "YYYY-MM-dd HH:mm:ss";
		//设置格式化字符串
		if (timeFormatStr != null && !timeFormatStr.isEmpty()) {
			formatStr = timeFormatStr;
		}
		if (excludeFields!=null){
			isExclude=true;
		}
		Class<?> clazz = obj.getClass();
		//获取值
		for (Field field : clazz.getDeclaredFields()) {
			String fieldName = field.getName();
			//判断是不是需要跳过某个属性
			if (isExclude&&excludeFields.contains(fieldName)){
				continue;
			}
			//设置属性可以被访问
			field.setAccessible(true);
			Object value = field.get(obj);
			if(null != value){
				Class<?> valueClass = value.getClass();
				if (valueClass.isPrimitive()) {
					map.put(fieldName, value.toString());

				} else if (valueClass.getName().contains(JAVAP)) {
					//判断是不是基本类型
					if (valueClass.getName().equals(JAVADATESTR)) {
						//格式化Date类型
						SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
						Date date = (Date) value;
						String dataStr = sdf.format(date);
						map.put(fieldName, dataStr);
					} else {
						map.put(fieldName, value.toString());
					}
				} else {
					objectTransfer(timeFormatStr, value, map,excludeFields);
				}
			}
		}
		return map;
	}
	
	/**
	 * 获取所有的属性和值，包括父类的 
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> getAllFields(Object bean) {
		return getAllFields(bean,bean.getClass());
	}
	
	/**
	 * 获取所有的属性和值，包括父类的 
	 * @param bean
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getAllFields(Object bean,Class clazz) {
		if (clazz == null) {
			return null;
		}
		try{
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			Field[] fields = clazz.getDeclaredFields();
			if (fields != null) {
				for (Field field : fields) {
					 //排除肯定不持久化的部分
	                if (Modifier.isTransient(field.getModifiers())) {
						continue;
					}
	                if (Modifier.isStatic(field.getModifiers())) {
						continue;
					}
					/** 对持久化中的部分注解下的内容不进行修改 */
//	                if (field.getAnnotation(Transient.class) != null) {
//						continue;
//					}
//	                if (field.getAnnotation(Id.class) != null) {
//						continue;
//					}
	                map.put(field.getName(), PropertyUtils.getProperty(bean, field.getName()));
				}
			}
			//递归获取父类的Field
			Class superClass = clazz.getSuperclass();
			Map<String, Object> superMap = getAllFields(bean,superClass);
			if (superMap != null) {
				map.putAll(superMap);
			}
			if (map.size() == 0) {
				return null;
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//获取属性的值
	public static Object getProperty(Object bean, String fieldName)throws Exception{
		Class<?>  fieldType = PropertyUtils.getPropertyType(bean, fieldName.trim());
		if(fieldType != null){
			return PropertyUtils.getProperty(bean, fieldName.trim());
		}
		return null;
	}
	
	/**
	 * 设置property的值
	 * @param bean
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 */
	public static void setProperty(Object bean, String fieldName, Object value) throws Exception{
		Class<?>  fieldType = PropertyUtils.getPropertyType(bean, fieldName);
		
		if(value == null || "".equals(value)){
			PropertyUtils.setProperty(bean, fieldName, null);
		}else{
			Object tmpValue = null;
			if(fieldType == String.class){
				tmpValue = value.toString();
			}else if(fieldType == Double.class){
				tmpValue = new Double(value.toString());
			}else if(fieldType == Double.TYPE){
				tmpValue = Double.valueOf(new Double(value.toString()).doubleValue());
			}else if(fieldType == Float.class){
				tmpValue = new Float(value.toString());
			}else if(fieldType == Float.TYPE){
				tmpValue = Float.valueOf(new Float(value.toString()).floatValue());
			}else if(fieldType == Integer.class){
				tmpValue = new Integer(value.toString());
			}else if(fieldType == Integer.TYPE){
				tmpValue = Integer.valueOf(new Integer(value.toString()).intValue());
			}else if(fieldType == Long.class){
				tmpValue = Long.valueOf(value.toString());
			}else if(fieldType == Long.TYPE){
				tmpValue = Long.valueOf(Long.valueOf(value.toString()).longValue());
			}else if(fieldType == Boolean.class){
				tmpValue = Boolean.valueOf(value.toString());
			}else if(fieldType == Boolean.TYPE){
				tmpValue = Boolean.valueOf(Boolean.valueOf(value.toString()).booleanValue());
			}else if (fieldType == Date.class) {
				tmpValue = DateUtil.COMPAT.getTextDate((String) value);
			}else{
				tmpValue = null;
			}
			
			PropertyUtils.setProperty(bean, fieldName, tmpValue);
		}
	}
	
	/**
	 * 获取属性类型
	 * @param bean
	 * @param property
	 * @return
	 * @throws Exception
	 */
	public static Class<?> getPropertyType(Object bean,String property)throws Exception{
		try {
			Field field = bean.getClass().getDeclaredField(property);
			if(field != null) {
				return PropertyUtils.getPropertyType(bean, property);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			return null;
		}
		return null;
	}
	
}
