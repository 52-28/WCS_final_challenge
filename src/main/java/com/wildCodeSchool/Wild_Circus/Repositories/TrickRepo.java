package com.wildCodeSchool.Wild_Circus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildCodeSchool.Wild_Circus.entities.Trick;

@Repository
public interface TrickRepo extends JpaRepository<Trick, Long>{

}
