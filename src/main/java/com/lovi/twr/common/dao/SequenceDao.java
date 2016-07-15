package com.lovi.twr.common.dao;

import com.lovi.twr.common.model.Sequence;
import com.lovi.twr.exception.DataAccessException;

public interface SequenceDao  extends GenericDao<Sequence>{

	int getNextSequenceId(String key) throws DataAccessException;
}
