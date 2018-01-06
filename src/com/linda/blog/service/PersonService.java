package com.linda.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.PersonDAO;
import com.linda.blog.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDao;

	public void addPerson(Person person){
		personDao.addPerson(person);
	}

	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}

	public void deletePersonById(String id) {
		personDao.deletePersonById(id);
	}

	public List<Person> getPersons() {
		return personDao.getPersons();
	}

	public Person getPersonById(String id) {
		return personDao.getPersonById(id);
	}
}
