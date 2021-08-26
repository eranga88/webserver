package com.dailycodedbuffer.Springboottutorial.tutorial.repository;

import com.dailycodedbuffer.Springboottutorial.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    /**
     * we do not do a concrete implementation here.
     * we extends JpaRepository
     * we pass Department(class) entity and type of the id field used in Department class
     * Reason for extending JpaRepository is JapaRepository contains all required functions for CRUD operations.
     * no need to create new methods.
     * **/

    public Department findByDepartmentName(String departmentName);
}
