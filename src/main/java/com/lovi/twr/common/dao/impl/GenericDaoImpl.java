package com.lovi.twr.common.dao.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import com.lovi.twr.common.dao.GenericDao;
import com.lovi.twr.exception.DataAccessException;

public class GenericDaoImpl<T> implements GenericDao<T>{

	private final Logger logger = LoggerFactory.getLogger(GenericDao.class);
	
	@Autowired
	protected MongoOperations mongoOperations;
	
	private Class<T> type;
	
	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public T getById(Object id) throws DataAccessException {
		logger.debug("type {} getById", type);
		return mongoOperations.findById(id, type);
	}

	@Override
	public List<T> getAll() throws DataAccessException {
		logger.debug("type {} getAll", type);
		return mongoOperations.findAll(type);
	}

	@Override
	public void delete(T object) throws DataAccessException {
		logger.debug("type {} delete", type);
		mongoOperations.remove(object);
	}

	@Override
	public void add(T object) throws DataAccessException {
		logger.debug("type {} add", type);
		mongoOperations.insert(object);
	}

	@Override
	public void modify(T object) throws DataAccessException {
		logger.debug("type {} modify", type);
		mongoOperations.save(object);
	}
}
