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

import com.cdac.dto.Faculty;


@Repository
public class FacultyDaoImplementation implements FacultyDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertFaculty(Faculty faculty) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				session.save(faculty);
				
				transaction.commit();
				
				session.flush();
				
				session.close();
				
				return null;
			}
		
		});

	}

	@Override
	public boolean checkFaculty(Faculty faculty) {
		
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createQuery("from Faculty where facultyEmail = ? and facultyPassword = ?");
				
				query.setString(0, faculty.getFacultyEmail());
				query.setString(1, faculty.getFacultyPassword());
				
				
				List<Faculty> list = query.list();
				
				boolean flag = !list.isEmpty();
				
				if(flag) {
					faculty.setFacultyId( list.get(0).getFacultyId());
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
	public Faculty getFaculty(int facultyId) {
		
		return hibernateTemplate.execute(new HibernateCallback<Faculty>() {

			@Override
			public Faculty doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				Faculty faculty = (Faculty) session.get(Faculty.class, facultyId);
				
				transaction.commit();
				session.flush();
				session.close();
				return faculty;
			}
			
			
		});
	}

	@Override
	public String forgotPassword(String facultyEmail) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Faculty where facultyEmail = ?");
				//System.out.println("email : "+email);
				q.setString(0, facultyEmail);
				List<Faculty> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getFacultyPassword();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;
		
	}

	@Override
	public void uploadImage(String profilePic, int facultyId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Faculty user = (Faculty)session.get(Faculty.class, facultyId);
				user.setProfilePic(profilePic); 
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

}
