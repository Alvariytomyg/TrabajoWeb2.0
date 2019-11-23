package upc.edu.pe.webdevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.edu.pe.webdevs.model.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event, Integer>{

}
