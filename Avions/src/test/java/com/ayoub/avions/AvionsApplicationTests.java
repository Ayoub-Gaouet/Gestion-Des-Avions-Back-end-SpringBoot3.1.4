package com.ayoub.avions;

import java.util.Date;
import java.util.List;

import com.ayoub.avions.entities.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ayoub.avions.entities.Avions;
import com.ayoub.avions.repos.AvionsRepository;
@SpringBootTest
class AvionsApplicationTests {
    @Autowired
    private AvionsRepository avionsRepository;
    @Test
    public void testCreateAvions() {
        Avions av = new Avions("TU 002",2200.500,new Date());
        avionsRepository.save(av);
    }
    @Test
    public void testFindAvions()
    {
        Avions a = avionsRepository.findById(1L).get();
        System.out.println(a);
    }
    @Test
    public void testUpdateAvions()
    {
        Avions a = avionsRepository.findById(2L).get();
        a.setPrixAvions(1000.0);
        avionsRepository.save(a);
    }
    @Test
    public void testDeleteAvions(){
        avionsRepository.deleteById(1L);
    }
    @Test
    public void testListerTousAvions()
    {
        List<Avions> av = avionsRepository.findAll();
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
    @Test
    public void testFindByNomAvions()
    {
        List<Avions> av = avionsRepository.findByNomAvions("TU 001");
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
    @Test
    public void testFindByNomAvionsContains ()
    {
        List<Avions> av=avionsRepository.findByNomAvionsContains("T");
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
    @Test
    public void testfindByNomPrix()
    {
        List<Avions> av = avionsRepository.findByNomPrix("TU 001", 1000.0);
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
    @Test
    public void testfindByCompany()
    {
        Company com = new Company();
        com.setIdCom(1L);
        List<Avions> av = avionsRepository.findByCompany(com);
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
    @Test
    public void findByCompanyIdCom()
    {
        List<Avions> av = avionsRepository.findByCompanyIdCom(1L);
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
    @Test
    public void testfindByOrderByNomAvionsAsc()
    {
        List<Avions> av =
               avionsRepository.findByOrderByNomAvionsAsc();
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
    @Test
    public void testTrierAvionsNomsPrix()
    {
        List<Avions> av = avionsRepository.trierAvionsNomsPrix  ();
        for (Avions a : av)
        {
            System.out.println(a);
        }
    }
}
