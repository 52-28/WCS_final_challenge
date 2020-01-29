package com.wildCodeSchool.Wild_Circus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildCodeSchool.Wild_Circus.entities.Presentation;

@Repository
public interface PresentationRepo extends JpaRepository<Presentation, Long>{

}
