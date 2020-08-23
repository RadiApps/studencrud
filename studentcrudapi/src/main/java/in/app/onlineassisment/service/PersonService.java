package in.app.onlineassisment.service;

import java.util.List;

import in.app.onlineassisment.model.Person;

public interface PersonService {

	List<Person> get();
	Person getById(int id);
	Person getByStudentCode(int code);
	void save(Person p);
	void delete(int id);
	void update(Person updated,Person p);
}
