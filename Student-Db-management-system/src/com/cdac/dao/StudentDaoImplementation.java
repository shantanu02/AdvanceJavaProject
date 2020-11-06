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
import com.cdac.dto.Student;


@Repository
public class StudentDaoImplementation implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Override
	public boolean insertStudent(Student student) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {
			boolean var = false;
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				List<Student> list = selectAllStudent(student.getFacultyId());
				
				boolean flag = false ; 
				
				for(Student s : list) {
					if(s.getStudentRollNo()==student.getStudentRollNo()) {
						flag = true;
						break;
					}
						
				}
				
				if(flag == false) {
					session.save(student);
					transaction.commit();
					session.flush();
					session.close();
					var = true;
					return var;
					
				}
					
				return var;
			}
		
		});

	}

	@Override
	public void updateStudent(Student student) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
					
				session.update(student);
				
				transaction.commit();
				session.flush();
				session.close();
				
				return null;
			}
		
		});

	}

	@Override
	public void removeStudent(int studentId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				session.delete(new Student(studentId));
				
				transaction.commit();
				session.flush();
				session.close();
				
				return null;
			}
		
		});

	}

	
	@Override
	public List<Student> selectAllStudent(int facultyId) {
		
		return hibernateTemplate.execute(new HibernateCallback<List<Student>>() {

			@Override
			public List<Student> doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				Query query  = session.createQuery("from Student where facultyId = ? order by studentName");
				
				query.setInteger(0, facultyId);
				
				List<Student> list = query.list();
								
				
				transaction.commit();
				session.flush();
				session.close();
				
				return list;
			}
		
		});
		
		 
	}

	@Override
	public Student findStudent(int studentId) {
		return hibernateTemplate.execute(new HibernateCallback<Student>() {

		@Override
		public Student doInHibernate(Session session) throws HibernateException {
			Transaction transaction = session.beginTransaction();
			
			Student student = (Student) session.get(Student.class, studentId);
			
			transaction.commit();
			session.flush();
			session.close();
			
			return student;
		}
	
	
	});
		
	}
	
	@Override
	public Student selectStudentByRollNo(int studentRollNo) {
		
		return hibernateTemplate.execute(new HibernateCallback<Student>() {

			@Override
			public Student doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				Query query  = session.createQuery("from Student where studentRollNo = ?");
				
				query.setInteger(0, studentRollNo);
				
				List<Student> list = query.list();
				
				transaction.commit();
				session.flush();
				session.close();
				
				return list.get(0);
			}
		
		});

		
	}

	@Override
	public Student selectStudentByName(String studentName) {
		return hibernateTemplate.execute(new HibernateCallback<Student>() {

			@Override
			public Student doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				Query query  = session.createQuery("from Student where studentName = ?");
				
				query.setString(0, studentName);
				
				List<Student> list = query.list();
				
				transaction.commit();
				session.flush();
				session.close();
				
				return list.get(0);
			}
		
		});
	}

	@Override
	public boolean checkStudent(Student student) {
		
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction transaction = session.beginTransaction();
				
				Query query = session.createQuery("from Student where studentEmail = ? and studentPassword = ?");
				
				query.setString(0, student.getStudentEmail());
				query.setString(1, student.getStudentPassword());
				
				List<Student> list = query.list();
				
				boolean flag = !list.isEmpty();
				if(!list.isEmpty()) {
					student.setStudentId( list.get(0).getStudentId());
					transaction.commit();
					session.flush();
					session.close();
				}else {
					flag=false;
				}
				
				
				
				return flag;
			}
		});
	}

	@Override
	public String forgotPassword(String studentEmail) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Student where studentEmail = ?");
				//System.out.println("email : "+email);
				q.setString(0, studentEmail);
				List<Student> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getStudentPassword();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;
		
		
	}


}
