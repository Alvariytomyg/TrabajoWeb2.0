package upc.edu.pe.webdevs.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upc.edu.pe.webdevs.model.Organizer;
import upc.edu.pe.webdevs.repository.IOrganizerRepository;
import upc.edu.pe.webdevs.service.IOrganizerService;

@Service
public class OrganizerServiceImpl implements IOrganizerService{

	@Autowired
	private IOrganizerRepository organizeRepository;
	
	@Override
	public Organizer save(Organizer t) throws Exception {
		// TODO Auto-generated method stub
		return organizeRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		organizeRepository.deleteById(id);
	}

	@Override
	public Optional<Organizer> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return organizeRepository.findById(id);
	}

	@Override
	public List<Organizer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return organizeRepository.findAll();
	}

}
