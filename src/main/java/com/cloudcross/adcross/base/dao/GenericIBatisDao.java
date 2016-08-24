package com.cloudcross.adcross.base.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class GenericIBatisDao extends SqlSessionDaoSupport {

	public void save(String key, Object object) {
		getSqlSession().insert(key, object);
	}

	public void delete(String key, Serializable id) {
		getSqlSession().delete(key, id);
	}

	public void delete(String key, Object object) {
		getSqlSession().delete(key, object);
	}

	public <T> T get(String key, Object params) {
		return (T) getSqlSession().selectOne(key, params);
	}

	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}

	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}
	
	public void update(String key, Object object) {
		getSqlSession().update(key, object);
	}
	
}
