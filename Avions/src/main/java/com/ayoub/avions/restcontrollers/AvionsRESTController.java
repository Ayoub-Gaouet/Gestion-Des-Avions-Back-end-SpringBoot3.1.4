package com.ayoub.avions.restcontrollers;

import java.util.List;

import com.ayoub.avions.dto.AvionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ayoub.avions.entities.Avions;
import com.ayoub.avions.service.AvionsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class AvionsRESTController {
    @Autowired
    AvionsService avionsService;
    @RequestMapping(path="all",method =RequestMethod.GET)
    public List<AvionDTO> getAllAvions() {
        return avionsService.getAllAvions();
    }

    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    public  AvionDTO getAvionsById(@PathVariable("id") Long id) {
    return avionsService.getAvions(id);
    }

    @RequestMapping(path= "/addav" , method = RequestMethod.POST)
    public AvionDTO createAvion(@RequestBody AvionDTO avionDTO) {
    return avionsService.saveAvions(avionDTO);
    }

    @RequestMapping(path= "/updateav" ,method = RequestMethod.PUT)
    public AvionDTO updateAvions(@RequestBody AvionDTO avionDTO) {
    return avionsService.updateAvions(avionDTO);
    }

    @RequestMapping(value="/delav/{id}",method = RequestMethod.DELETE)
    public void deleteAvions(@PathVariable("id") Long id)
    {
    	avionsService.deleteAvionsById(id);
    }
    @RequestMapping(value="/avcom/{idCom}",method = RequestMethod.GET)
    public List<Avions> getAvionsByCatId(@PathVariable("idCom") Long idCom) {
    return avionsService.findByCompanyIdCom(idCom);
    }
}