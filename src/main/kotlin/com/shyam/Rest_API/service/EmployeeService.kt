package com.shyam.Rest_API.service

import com.shyam.Rest_API.entity.Employee
import com.shyam.Rest_API.repository.EmployeeRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(private val repo: EmployeeRepo) {

    fun findAllEmployees(): List<Employee> {
        return repo.findAll()
    }

    fun findEmployeeById(id: Int): Optional<Employee> {
        return repo.findById(id)
    }
    fun findByLastName(lastName : String) : List<Employee>{
        return repo.findEmployeeByLastName("xyz")
    }

    fun addNewEmployee(newEmployee: Employee) {
        repo.save(newEmployee)
    }

    fun deleteEmployeeById(id: Int): String {
        repo.deleteById(id)
        return "Employee with ID $id has been deleted."
    }

    fun updateEmployeeById(id: Int, newFirstName: String?): String {
        val employee = repo.findById(id).orElseThrow { RuntimeException("Employee not found") }
        if (newFirstName != null) {
            employee.firstName = newFirstName
        }
        repo.save(employee)
        return "Employee with ID $id has been updated."
    }
}
