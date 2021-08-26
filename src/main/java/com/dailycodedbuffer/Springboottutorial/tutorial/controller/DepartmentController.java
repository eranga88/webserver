package com.dailycodedbuffer.Springboottutorial.tutorial.controller;

import com.dailycodedbuffer.Springboottutorial.tutorial.entity.Department;
import com.dailycodedbuffer.Springboottutorial.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // now we can create rest Api here
public class DepartmentController {

    /**
     * Autowiring is dependancy injection
     * There are two types of Autowiring available
     * first one is constructor based autowiring and second one is setter based autowiring (dependancy injection)
     * */

    @Autowired
    private DepartmentService departmentService;
    /**
     * This is a property based Autowiring.
     * We use @Autowired annotaion to perform following things.
     * we did not create a object from DepartmentService class.
     * we give control of creating that object to spring framework
     * we are mapping our DepartmentService type variable to auto created object in the spring framework.
     * */

    @PostMapping("/departments") // post data into this method from any rest client. that will be entire Json object
    public Department saveDepartment(@RequestBody Department department){

        /**
         * what ever data(entire json object) getting from rest client will be
         * converted to Department type when use @RequestBody annotation
         * **/

        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){

        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}") // dynamically getting the department ID
    public Department fetchDepartmentById( @PathVariable("id") Long departmentId){

        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){

        departmentService.deleteDepartmentById(departmentId);
        return  "Department deleted Succusfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.fetchDepartmentByName(departmentName);
    }
}
