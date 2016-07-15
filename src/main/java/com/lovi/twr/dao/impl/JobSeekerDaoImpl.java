package com.lovi.twr.dao.impl;

import org.springframework.stereotype.Repository;
import com.lovi.twr.common.dao.impl.GenericDaoImpl;
import com.lovi.twr.dao.JobSeekerDao;
import com.lovi.twr.model.JobSeeker;

@Repository
public class JobSeekerDaoImpl extends GenericDaoImpl<JobSeeker> implements JobSeekerDao{
	
	public JobSeekerDaoImpl() {
		super(JobSeeker.class);
	}
}
