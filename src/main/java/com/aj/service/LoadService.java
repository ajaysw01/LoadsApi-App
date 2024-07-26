package com.aj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.entity.Load;
import com.aj.exceptions.ResourceNotFoundException;
import com.aj.repo.LoadRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

	 @Autowired
	    private LoadRepository loadRepository;

	    public Load addLoad(Load load) {
	        return loadRepository.save(load);
	    }

	    public List<Load> getLoadsByShipperId(UUID shipperId) {
	        return loadRepository.findByShipperId(shipperId);
	    }

	    public Load getLoadById(Long loadId) {
	        return loadRepository.findById(loadId)
	                .orElseThrow(() -> new ResourceNotFoundException("Load not found with id: " + loadId));
	    }

	    public Load updateLoad(Long loadId, Load loadDetails) {
	        Load load = getLoadById(loadId);
	        load.setLoadingPoint(loadDetails.getLoadingPoint());
	        load.setUnloadingPoint(loadDetails.getUnloadingPoint());
	        load.setProductType(loadDetails.getProductType());
	        load.setTruckType(loadDetails.getTruckType());
	        load.setNoOfTrucks(loadDetails.getNoOfTrucks());
	        load.setWeight(loadDetails.getWeight());
	        load.setComment(loadDetails.getComment());
	        load.setDate(loadDetails.getDate());
	        load.setShipperId(loadDetails.getShipperId());
	        return loadRepository.save(load);
	    }

	    public void deleteLoad(Long loadId) {
	        Load load = getLoadById(loadId);
	        loadRepository.delete(load);
	    }
}
