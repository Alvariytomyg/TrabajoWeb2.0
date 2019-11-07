package pe.edu.upc.webdevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.webdevs.model.Event;;

@Repository
public interface IEventRepository extends JpaRepository<Event, Integer>{

}