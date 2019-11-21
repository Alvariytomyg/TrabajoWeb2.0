package upc.edu.pe.webdevs.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upc.edu.pe.webdevs.model.Person;
import upc.edu.pe.webdevs.repository.IPersonRepository;

@Service
public class PersonServiceImpl implements IPersonService {

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
