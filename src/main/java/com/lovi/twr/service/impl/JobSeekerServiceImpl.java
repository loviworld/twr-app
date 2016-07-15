package com.lovi.twr.service.impl;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lovi.twr.common.dao.SequenceDao;
import com.lovi.twr.common.service.impl.GenericServiceImpl;
import com.lovi.twr.dao.JobSeekerDao;
import com.lovi.twr.exception.ServiceException;
import com.lovi.twr.model.JobSeeker;
import com.lovi.twr.service.JobSeekerService;

@Service
public class JobSeekerServiceImpl extends GenericServiceImpl<JobSeeker> implements JobSeekerService {

	@Autowired
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	private SequenceDao sequenceDao;

	@PostConstruct
	void init() {
		init(JobSeeker.class, jobSeekerDao);
	}

	@Override
	public JobSeeker save(JobSeeker obj) throws ServiceException {
		if (obj != null) {
			
			if (obj.getId() == null) {
				this.add(obj);
			} else {
				this.edit(obj);
			}
		} else {
			throw new ServiceException();
		}
		return obj;
	}
	
	@Override
	public JobSeeker add(JobSeeker obj) throws ServiceException {
		try{
			obj.setId(sequenceDao.getNextSequenceId(JobSeeker.class.getSimpleName()));
			jobSeekerDao.add(obj);
			return obj;
		}catch (Exception e) {
            throw new ServiceException(e);
        }
	}

}
