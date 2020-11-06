package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.AdminDao;
import com.cdac.dto.Admin;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public boolean validateAdmin(Admin admin) {
		
		return adminDao.checkAdmin(admin);
	}

	@Override
	public Admin selectAdim(int adminId) {
		
		return adminDao.getAdmin(adminId);
	}

}
