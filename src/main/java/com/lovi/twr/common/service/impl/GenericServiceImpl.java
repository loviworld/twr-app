package com.lovi.twr.common.service.impl;

import java.util.List;
import com.lovi.twr.common.dao.GenericDao;
import com.lovi.twr.common.service.GenericService;
import com.lovi.twr.exception.ServiceException;

public class GenericServiceImpl<T> implements GenericService<T> {
	
	@SuppressWarnings("unused")
	private Class<? extends T> type;
	protected GenericDao<T> genericDao;
	
	protected void init(Class<? extends T> type, GenericDao<T> dao) {
        this.type = type;
        this.genericDao = dao;
    }
	
	@Override
	public T getById(int id) throws ServiceException {
		try {
            return genericDao.getById(id);
        }catch (Exception e) {
            throw new ServiceException(e);
        }
	}

	@Override
	public T add(T obj) throws ServiceException {
		try {
            genericDao.add(obj);
        } catch (Exception e) {
        	throw new ServiceException(e);
        }
        return obj;
	}

	@Override
	public T edit(T obj) throws ServiceException {
		try {
            genericDao.modify(obj);
        } catch (Exception e) {
        	throw new ServiceException(e);
        }
        return obj;
	}

	@Override
	public void delete(T object) throws ServiceException {
		try {
            genericDao.add(object);;
        } catch (Exception e) {
        	throw new ServiceException(e);
        }
	}

	@Override
	public List<T> getAll() throws ServiceException {
		try {
            return genericDao.getAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
	}

}
