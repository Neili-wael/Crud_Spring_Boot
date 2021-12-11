package com.wael.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wael.location.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

	
}
