package com.ayoub.avions.repos;
import com.ayoub.avions.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ayoub.avions.entities.Avions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface AvionsRepository extends JpaRepository<Avions, Long> {
    List<Avions> findByNomAvions(String nom);
    List<Avions> findByNomAvionsContains(String nom);
    @Query("select a from Avions a where a.nomAvions like %:nom and a.prixAvions > :prix")
    List<Avions> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);
    @Query("select a from Avions a where a.company = ?1")
    List<Avions> findByCompany (Company company);
    List<Avions> findByCompanyIdCom(Long id);
    List<Avions> findByOrderByNomAvionsAsc();
    @Query("select a from Avions a order by a.nomAvions ASC, a.prixAvions DESC")
    List<Avions> trierAvionsNomsPrix ();
}
