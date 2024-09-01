package com.shyam.Rest_API.repository

import com.shyam.Rest_API.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepo : JpaRepository<Employee, Int>{
    fun findEmployeeByLastName(lastname : String?) : List<Employee>
    
}