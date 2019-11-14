package upc.edu.pe.webdevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.edu.pe.webdevs.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
