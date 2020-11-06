package com.cdac.dao;

import com.cdac.dto.Admin;
import com.cdac.dto.Faculty;

public interface AdminDao {
	boolean checkAdmin (Admin admin);
	
	Admin getAdmin(int adminId);
	
}
