package com.shyam.Rest_API.rest

import com.shyam.Rest_API.entity.Employee
import com.shyam.Rest_API.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class EmployeeRestController(private val empService: EmployeeService) {

    @GetMapping("/employees")
    fun findAllEmployees(): List<Employee> {
        return empService.findAllEmployees()
    }

    @GetMapping("/employees/{lastName}")
    fun findByLastName(@PathVariable lastName : String) : List<Employee>{
        return empService.findByLastName(lastName);
    }

    @GetMapping("/employees/{id}")
    fun findEmployee(@PathVariable id: Int): Employee {
        return empService.findEmployeeById(id).orElseThrow { RuntimeException("Employee not found") }
    }

    @PostMapping("/employees")
    fun addEmployee(@RequestBody newEmployee: Employee): String {
        empService.addNewEmployee(newEmployee)
        return "Employee ${newEmployee.firstName} ${newEmployee.lastName} successfully added"
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Int): String {
        return empService.deleteEmployeeById(id)
    }

    @PutMapping("/employees/{id}")
    fun updateEmployee(@PathVariable id: Int, @RequestParam newFirstName: String?): String {
        return empService.updateEmployeeById(id, newFirstName)
    }
}
