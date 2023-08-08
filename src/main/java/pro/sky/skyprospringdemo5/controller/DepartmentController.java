package pro.sky.skyprospringdemo5.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import pro.sky.skyprospringdemo5.Service.DepartmentService;
import pro.sky.skyprospringdemo5.entity.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/department")
public class DepartmentController {

    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e) {
        return "Code: " + e.getStatusCode() + "Error: " + e.getMessage();
    }
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departamentid){
        return departmentService.getEmployeeWithMaxSalary(departamentid);
    }
    @GetMapping("min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departamentid){
        return departmentService.getEmployeeWithMinSalary(departamentid);
    }
    @GetMapping("all")
    public Map<Integer , List<Employee >> getEmployeesByDepartament (@RequestParam(required = false) Integer departamentid){
        return departmentService.getEmployeesByDepartament(departamentid);
    }
}
