package upc.edu.pe.webdevs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.edu.pe.webdevs.model.SubscriptionPlan;


@Repository
public interface ISubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Integer>{

}
