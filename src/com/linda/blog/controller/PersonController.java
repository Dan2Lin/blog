package com.linda.blog.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.Person;
import com.linda.blog.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;

	@RequestMapping("/login")
	public String logon() {
		return "logon";
	}

	@RequestMapping(value = "/doLogin")
	public String doLogin(String username, String password) {
		if (Objects.equals(username, "admin") && Objects.equals(password, "admin")) {
			return "redirect:main";
		}
		return "redirect:logon";
	}

	@RequestMapping(value = "/main")
	public String main(Model model) {
		model.addAttribute("person", this.personService.getPersons());
		return "main";
	}

	@RequestMapping(value = "/addPromt")
	public String addPromt() {
		return "addPerson";
	}

	@RequestMapping(value = "/updatePromt")
	public String updatePromt(Model model, String id) {
		model.addAttribute("person", this.personService.getPersonById(id));
		return "updatePerson";
	}

	@RequestMapping(value = "/addPerson")
	public String addPerson(Person person) {
		personService.addPerson(person);
		return "redirect:main";
	}

	@RequestMapping(value = "/updatePerson")
	public String updatePerson(Person person) {
		personService.updatePerson(person);
		return "redirect:main";
	}

	@RequestMapping(value = "/deletePersonById")
	public String deletePersonById(String id) {
		personService.deletePersonById(id);
		return "redirect:main";
	}

	@RequestMapping(value = "/getPersons")
	@ResponseBody
	public List<Person> getPersons() {
		return personService.getPersons();
	}

	@RequestMapping(value = "/getPersonById")
	@ResponseBody
	public Person getPersonById(String id) {
		return personService.getPersonById(id);
	}
}
