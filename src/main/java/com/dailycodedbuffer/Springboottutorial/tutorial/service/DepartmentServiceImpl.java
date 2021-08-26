package com.dailycodedbuffer.Springboottutorial.tutorial.service;

import com.dailycodedbuffer.Springboottutorial.tutorial.entity.Department;
import com.dailycodedbuffer.Springboottutorial.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Service // we tell this is a service implementation
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department); // save method is accepting entity. our entity is department.
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

          Department deDB = departmentRepository.findById(departmentId).get();

          if(Objects.nonNull(department.getDepartmentName()) &&
          !"".equalsIgnoreCase(department.getDepartmentName())){
              deDB.setDepartmentName(department.getDepartmentName());
          }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            deDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            deDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(deDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return null;
    }


}
