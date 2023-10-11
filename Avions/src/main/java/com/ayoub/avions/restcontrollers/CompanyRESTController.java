package com.ayoub.avions.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ayoub.avions.entities.Company;
import com.ayoub.avions.repos.CompanyRepository;
@RestController
@RequestMapping("/api/com")
@CrossOrigin("*")
public class CompanyRESTController {
	@Autowired
	CompanyRepository companyRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Company> getAllCompany()
	{
	return companyRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Company getCompanyById(@PathVariable("id") Long id) {
	return companyRepository.findById(id).get();
	}

}
