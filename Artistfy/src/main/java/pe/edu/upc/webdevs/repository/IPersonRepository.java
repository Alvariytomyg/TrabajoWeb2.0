package pe.edu.upc.webdevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.webdevs.model.Person;



public interface IPersonRepository extends JpaRepository<Person, Integer>{

}
