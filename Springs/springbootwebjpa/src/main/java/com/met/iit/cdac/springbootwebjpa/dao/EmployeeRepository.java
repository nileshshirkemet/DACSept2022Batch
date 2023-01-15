package com.met.iit.cdac.springbootwebjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.met.iit.cdac.springbootwebjpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

//Repository			//marker interface
//CrudRepository
//PagingAndSortingRepository
//JpaRepository
