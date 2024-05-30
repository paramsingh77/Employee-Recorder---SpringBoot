package com.example.demo.controllers;

//Operations
//GET Employees
//POST /
//DELETE /employees{:id}

import com.example.demo.dto.EmplyeeDTO;
import com.example.demo.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.websocket.server.PathParam;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    Never use emplouyeeRepositoryy here

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public EmplyeeDTO getEmployees() {
        return new EmplyeeDTO(12l, "Param", LocalDate.of(2024, 01, 02), true);
    }

    @GetMapping(path = "/{id}")
    public EmplyeeDTO putEmployees(@PathVariable("id") Long employeeId) {
            return employeeService.getEmployeeById(employeeId);
    }

//    @PostMapping
//    public String data(@PathParam("sortBy") String sortBy ,
//                       @PathParam("limit") Integer limit){
//        return "Hello " +sortBy +" "+ limit;
//    }

    @PostMapping
    public  EmplyeeDTO createNewEmployee(@RequestBody EmplyeeDTO emplyeeDTO){
        return employeeService.createEmployee(emplyeeDTO);
    }

}
