package in.app.onlineassisment.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.app.onlineassisment.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Person> get() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Person> q=currentSession.createQuery("from Person",Person.class);
		List<Person> list=q.getResultList();	
		for(Person p : list) {
			Hibernate.initialize(p.getPersonType());
		}
		return list;
	}

	@Override
	public Person getById(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Person p=currentSession.get(Person.class, id);
		return p;
	}

	@Override
	public Person getByStudentCode(int code) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Person> q=currentSession.createQuery("from Person where STUDENT_CODE = :code",Person.class);
		q.setParameter("code", code);
		List<Person> list= q.getResultList();
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public void save(Person p) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(p);		
	}

	@Override
	public void delete(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Person p=getById(id);
		if(p != null)
			currentSession.delete(p);
		
	}

}
