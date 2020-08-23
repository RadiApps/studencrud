package in.app.onlineassisment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.onlineassisment.dao.PersonDAO;
import in.app.onlineassisment.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDao;
	
	@Transactional
	@Override
	public List<Person> get() {
		return personDao.get();
	}

	@Transactional
	@Override
	public Person getById(int id) {
		return personDao.getById(id);
	}

	@Transactional
	@Override
	public Person getByStudentCode(int code) {
		return personDao.getByStudentCode(code);
	}

	@Transactional
	@Override
	public void save(Person p) {
		personDao.save(p);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		personDao.delete(id);		
	}

	@Transactional
	@Override
	public void update(Person updated, Person p) {
		
		if(updated.getPersonType() != null)
			p.setPersonType(updated.getPersonType());
		if(updated.getStudentCode() != 0)
			p.setStudentCode(updated.getStudentCode());
		if(updated.getFname() != null)
			p.setFname(updated.getFname());
		if(updated.getLname() != null)
			p.setLname(updated.getLname());
		if(updated.getGender() != 0)
			p.setGender(updated.getGender());
		if(updated.getIsUser() != 0)
			p.setIsUser(updated.getIsUser());
		if(updated.getGradeYear() != 0)
			p.setGradeYear(updated.getGradeYear());
		if(updated.getEmail() != null)
			p.setEmail(updated.getEmail());
		if(updated.getPassword() != null)
			p.setPassword(updated.getPassword());
		if(updated.getPhoneNum() != null)
			p.setPhoneNum(updated.getPhoneNum());
		if(updated.getBirthDate() != null)
			p.setBirthDate(updated.getBirthDate());
		if(updated.getCreatedDate() != null)
			p.setCreatedDate(updated.getCreatedDate());
		
		personDao.save(p);
	}

}
