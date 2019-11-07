package pe.edu.upc.webdevs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.webdevs.model.Person;
import pe.edu.upc.webdevs.repository.IPersonRepository;



public class PersonServiceImpl implements IPersonService  {
	@Autowired
	private IPersonRepository personRepository;
	
	@Override
	public Person save(Person t) throws Exception {
		// TODO Auto-generated method stub
		return personRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		personRepository.deleteById(id);
		
	}

	@Override
	public Optional<Person> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}

	@Override
	public List<Person> findAll() throws Exception {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}
}
