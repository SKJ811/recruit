package com.yc.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	/**
	 * @param t   要保存的数据对象
	 * @param sqlId    mapper 中的方法名
	 * 					"com.yc.bean.+类名+mapper.",sqlId
	 */
	public void save (T t,String sqlId);
	
	/**
	 * 
	 * @param cls
	 * @param sqlId
	 * @param parameterMap   参数
	 */
	public void save (Class<T> cls,String sqlId,Map<String,Object> parameterMap);
	/**
	 * @param cls
	 * @param sqlId
	 * @param list   批量
	 */
	public void save (Class<T> cls,String sqlId,List<T> list);
	
	/**
	 * 更新对象
	 * @param t  带有参数的待更新对象
	 * @param sqlId   mapper 中的方法名
	 * 					"com.yc.bean.+类名+mapper.",sqlId
	 */
	public void update(T t, String sqlId);
	public void update(Class<T> cls, String sqlId);
	public void update (Class<T> cls,String sqlId,Map<String,Object> parameterMap);
	public void update (Class<T> cls,String sqlId,List<T> list);
	
	public void del(T t, String sqlId);
	public void del(Class<T> cls, String sqlId);
	public void del (Class<T> cls,String sqlId,Map<String,Object> parameterMap);
	public void del (Class<T> cls,String sqlId,List<Object> list);
	
	public List<T> findAll(T t, String sqlId);
	public List<T> findAll(Class<T> cls, String sqlId);
	public List<T> findAll (Class<T> cls,String sqlId,Map<String,Object> parameterMap);
	
	public T findOne (T t,String sqlId);
	public T findOne (Class<T> cls,String sqlId,Map<String,Object> parameterMap);
	public T findOne (Class<T> cls,String sqlId);
	
	/**
	 * 分页查询
	 * @param cls 用于确定mapper位置
	 * @param map  参数 键为字段名  值为参数值
	 * @param sqlId   mapper中方法名
	 * @param offset   从第几条开始
	 * @param sizePage  每页几条
	 * @return
	 */
	public List<T> findList(Class<T> cls, String sqlId,Map<String,Object> map,int offset,int sizePage);
	/**
	 * 聚合查询
	 * @param cls
	 * @param sqlId
	 * @return
	 */
	public int getCount(Class<T> cls,String sqlId);
	
	/**
	 *  聚合查询
	 * @param cls
	 * @param map
	 * @param sqlId
	 * @return
	 */
	public int getCount(Class<T> cls,Map<String,Object> map,String sqlId);
	public int getCount( T t,String sqlId);
	
	/**
	 * 聚合查询
	 * @param cls
	 * @param sqlId
	 * @return
	 */
	public double getFunc(Class<T> cls,String sqlId);
	public double getFunc( T t,String sqlId);
	public double getFunc(Class<T> cls,String sqlId,Map<String,Object> parameterMap);
}
