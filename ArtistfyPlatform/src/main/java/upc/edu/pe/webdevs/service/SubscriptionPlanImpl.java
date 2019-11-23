package upc.edu.pe.webdevs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upc.edu.pe.webdevs.model.SubscriptionPlan;
import upc.edu.pe.webdevs.repository.ISubscriptionPlanRepository;

@Service
public class SubscriptionPlanImpl implements ISubscriptionPlanService{
	
	
	@Autowired
	private ISubscriptionPlanRepository subscriptionPlanRepository;
	
	@Override
	public SubscriptionPlan save(SubscriptionPlan t) throws Exception{
		return subscriptionPlanRepository.save(t);	
	} 
	
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		subscriptionPlanRepository.deleteById(id);
	}
	
	@Override
	public Optional<SubscriptionPlan> findById(Integer id) throws Exception{
		return subscriptionPlanRepository.findById(id);
	}
	
	@Override
	public List<SubscriptionPlan> findAll() throws Exception{
		return subscriptionPlanRepository.findAll();
	}
	
	
	
}
