package com.cdac.service;

import com.cdac.dto.Admin;

public interface AdminService {
	boolean validateAdmin(Admin admin);
	
	Admin selectAdim(int adminId);
	
}
