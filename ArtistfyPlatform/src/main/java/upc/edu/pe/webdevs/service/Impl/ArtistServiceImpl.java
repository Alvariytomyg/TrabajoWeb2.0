package upc.edu.pe.webdevs.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upc.edu.pe.webdevs.model.Artist;
import upc.edu.pe.webdevs.repository.IArtistRepository;
import upc.edu.pe.webdevs.service.IArtistService;

@Service
public class ArtistServiceImpl implements IArtistService {

	@Autowired
	private IArtistRepository artistRepository;
	
	@Override
	public Artist save(Artist t) throws Exception {
		// TODO Auto-generated method stub
		return artistRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		artistRepository.deleteById(id);
	}

	@Override
	public Optional<Artist> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return artistRepository.findById(id);
	}

	@Override
	public List<Artist> findAll() throws Exception {
		// TODO Auto-generated method stub
		return artistRepository.findAll();
	}

}
