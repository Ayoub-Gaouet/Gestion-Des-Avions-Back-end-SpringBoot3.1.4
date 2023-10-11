package com.ayoub.avions.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ayoub.avions.entities.Company;

@RepositoryRestResource(path = "com")
@CrossOrigin("http://localhost:4200/") 
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
