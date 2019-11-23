package upc.edu.pe.webdevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.edu.pe.webdevs.model.Artist;

public interface IArtistRepository extends JpaRepository<Artist, Integer>{

}
