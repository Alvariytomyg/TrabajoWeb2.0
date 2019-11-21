package upc.edu.pe.webdevs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upc.edu.pe.webdevs.model.Event;
import upc.edu.pe.webdevs.repository.IEventRepository;

@Service
public class EventServiceImpl implements IEventService {

	@Autowired
	private IEventRepository eventRepository;
	
	@Override
	public Event save(Event t) throws Exception {
		// TODO Auto-generated method stub
		return eventRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		eventRepository.deleteById(id);
		
	}

	@Override
	public Optional<Event> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return eventRepository.findById(id);
	}

	@Override
	public List<Event> findAll() throws Exception {
		// TODO Auto-generated method stub
		return eventRepository.findAll();
	}

	
}
