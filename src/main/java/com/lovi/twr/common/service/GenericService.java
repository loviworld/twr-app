package com.lovi.twr.common.service;

import java.util.List;
import com.lovi.twr.exception.ServiceException;

public interface GenericService<T>{

	T getById(int id) throws ServiceException;

    T add(T obj) throws ServiceException;

    T edit(T obj) throws ServiceException;

    void delete(T object) throws ServiceException;

    List<T> getAll() throws ServiceException;
}
