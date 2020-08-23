package in.app.onlineassisment.dao;

import java.util.List;

import in.app.onlineassisment.model.Person;

public interface PersonDAO {
	
	List<Person> get();
	Person getById(int id);
	Person getByStudentCode(int code);
	void save(Person p);
	void delete(int id);
	
}
