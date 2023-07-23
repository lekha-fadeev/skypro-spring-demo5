package pro.sky.skyprospringdemo5.controller;

import pro.sky.skyprospringdemo5.entity.Employee;
import pro.sky.skyprospringdemo5.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e) {
        return "Code: " + e.getStatusCode() + "Error: " + e.getMessage();
    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam Integer departamentid) {
        return employeeService.add(firstName, lastName, salary, departamentid);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam Integer departamentid) {
        return employeeService.find(firstName, lastName, salary, departamentid);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam Integer departamentid) {
        return employeeService.remove(firstName, lastName, salary, departamentid);
    }
    @GetMapping
    public List<Employee>getAll(){return employeeService.getAll();}
}


