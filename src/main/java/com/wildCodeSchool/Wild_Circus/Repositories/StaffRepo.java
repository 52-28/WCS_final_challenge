package com.wildCodeSchool.Wild_Circus.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildCodeSchool.Wild_Circus.entities.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long>{

}
