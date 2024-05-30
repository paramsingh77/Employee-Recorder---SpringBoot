package com.example.demo.services;

import com.example.demo.dto.EmplyeeDTO;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    public EmployeeService(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    public EmplyeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmplyeeDTO.class);
    }

    public EmplyeeDTO createEmployee(EmplyeeDTO emplyeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(emplyeeDTO, EmployeeEntity.class);
       return modelMapper.map(employeeRepository.save(employeeEntity), EmplyeeDTO.class);
    }
}
