package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
	
	@Override
	public ReportingStructure read(String id) {
		LOG.debug("ReportingStructure for employeeId [{}]", id);
		Employee employee = employeeRepository.findByEmployeeId(id);
		if(employee == null) {
			throw new RuntimeException("Invalid employeeId: " + id);
		}
		ReportingStructure reportingEmployee = new ReportingStructure(employeeRepository,employee);
		
		return reportingEmployee;
	}

}
