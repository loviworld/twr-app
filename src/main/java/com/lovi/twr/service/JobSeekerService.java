package com.lovi.twr.service;

import com.lovi.twr.common.service.GenericService;
import com.lovi.twr.exception.ServiceException;
import com.lovi.twr.model.JobSeeker;

public interface JobSeekerService extends GenericService<JobSeeker>{
	JobSeeker save(JobSeeker obj) throws ServiceException;
}
