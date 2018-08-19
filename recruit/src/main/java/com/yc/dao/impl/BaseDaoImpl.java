package com.yc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yc.dao.BaseDao;

@Repository(value = "baseDaoImpl")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private String MapperPath = "com.yc.dao.";

	@Autowired
	private SqlSession  sqlSession;

	@Override
	public void save(T t, String sqlId) {
		System.out.println(t.getClass().getSimpleName() + "" + sqlId);
		sqlSession.insert(
				MapperPath + t.getClass().getSimpleName() + "Mapper." + sqlId,
				t);
	}

	@Override
	public void save(Class<T> cls, String sqlId,
			Map<String, Object> parameterMap) {
		sqlSession.insert(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId,
				parameterMap);

	}

	@Override
	public void save(Class<T> cls, String sqlId, List<T> list) {
		sqlSession.insert(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId, list);

	}

	@Override
	public void update(T t, String sqlId) {
		sqlSession.update(
				MapperPath + t.getClass().getSimpleName() + "Mapper." + sqlId,
				t);

	}

	@Override
	public void update(Class<T> cls, String sqlId) {
		sqlSession.update(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId);

	}

	@Override
	public void update(Class<T> cls, String sqlId,
			Map<String, Object> parameterMap) {
		sqlSession.update(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId,
				parameterMap);

	}

	@Override
	public void update(Class<T> cls, String sqlId, List<T> list) {
		sqlSession.update(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId, list);

	}

	@Override
	public void del(T t, String sqlId) {
		sqlSession.delete(
				MapperPath + t.getClass().getSimpleName() + "Mapper." + sqlId,
				t);

	}

	@Override
	public void del(Class<T> cls, String sqlId) {
		sqlSession.delete(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId);

	}

	@Override
	public void del(Class<T> cls, String sqlId, Map<String, Object> parameterMap) {
		sqlSession.delete(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId,
				parameterMap);

	}

	@Override
	public void del(Class<T> cls, String sqlId, List<Object> list) {
		sqlSession.delete(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId, list);

	}

	@Override
	public List<T> findAll(T t, String sqlId) {
		return sqlSession.selectList(
				MapperPath + t.getClass().getSimpleName() + "Mapper." + sqlId,
				t);

	}

	@Override
	public List<T> findAll(Class<T> cls, String sqlId) {
		return sqlSession.selectList(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId);

	}

	@Override
	public List<T> findAll(Class<T> cls, String sqlId,
			Map<String, Object> parameterMap) {
		return sqlSession.selectList(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId,
				parameterMap);

	}

	@Override
	public T findOne(T t, String sqlId) {
		List<T> list = sqlSession.selectList(
				MapperPath + t.getClass().getSimpleName() + "Mapper." + sqlId,
				t);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return list.get(0);
	}

	@Override
	public T findOne(Class<T> cls, String sqlId,
			Map<String, Object> parameterMap) {
		List<T> list = sqlSession.selectList(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId,
				parameterMap);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public T findOne(Class<T> cls, String sqlId) {
		List<T> list = sqlSession.selectList(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<T> findList(Class<T> cls, String sqlId,
			Map<String, Object> map, int start, int pageSize) {
		
		map.put("start", start);
		map.put("pageSize", pageSize);
		System.out.println(map);
		return sqlSession.selectList(MapperPath + cls.getSimpleName() + "Mapper." + sqlId, map);

	}

	@Override
	public double getFunc(T t, String sqlId) {
		return sqlSession.selectOne(
				MapperPath + t.getClass().getSimpleName() + "Mapper." + sqlId,
				t);

	}

	@Override
	public double getFunc(Class<T> cls, String sqlId) {
		return sqlSession.selectOne(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId);

	}

	@Override
	public double getFunc(Class<T> cls, String sqlId,
			Map<String, Object> parameterMap) {
		return sqlSession.selectOne(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId,
				parameterMap);

	}

	@Override
	public int getCount(Class<T> cls, String sqlId) {
		return sqlSession.selectOne(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId);
	}

	@Override
	public int getCount(Class<T> cls, Map<String, Object> map, String sqlId) {
		return sqlSession.selectOne(
				MapperPath + cls.getSimpleName() + "Mapper." + sqlId, map);
	}

	@Override
	public int getCount(T t, String sqlId) {
		return sqlSession.selectOne(
				MapperPath + t.getClass().getSimpleName() + "Mapper." + sqlId,
				t);
	}

}
