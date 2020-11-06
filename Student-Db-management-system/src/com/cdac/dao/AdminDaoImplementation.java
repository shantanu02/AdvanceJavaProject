package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Admin;
import com.cdac.dto.Faculty;


@Repository
public class AdminDaoImplementation implements AdminDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Override
	public boolean checkAdmin(Admin admin) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createQuery("from Admin where adminEmail = ? and adminPassword = ?");
				
				query.setString(0,admin.getAdminEmail());
				query.setString(1,admin.getAdminPassword());
				
				List<Admin> list = query.list();
				
				boolean flag = !list.isEmpty();
				if(!list.isEmpty()) {
					//faculty.setFacultyId( list.get(0).getFacultyId());
					admin.setAdminId(list.get(0).getAdminId());
					transaction.commit();
					session.flush();
					session.close();
				}else {
					flag = false;
				}
				
				
				
				return flag;
			}
		});
	}


	@Override
	public Admin getAdmin(int adminId) {
		
		return hibernateTemplate.execute(new HibernateCallback<Admin>() {

			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				//Faculty faculty = (Faculty) session.get(Faculty.class, facultyId);
				Admin admin = (Admin) session.get(Admin.class, adminId);
				
				transaction.commit();
				session.flush();
				session.close();
				return admin;
			}
			
			
		});
		
	}

}
