package pro.sky.skyprospringdemo5.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo5.entity.Employee;
import pro.sky.skyprospringdemo5.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(Integer departamentid) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartamentid() == departamentid)
                .max(Comparator.comparing(Employee::getSalary))
            .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с максимальной зарплатой не найден"));
    }

    public Employee getEmployeeWithMinSalary(Integer departamentid) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartamentid() == departamentid)
                .min(Comparator.comparing(Employee::getSalary))
            .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с минимальной зарплатой не найден"));
    }
    public Map<Integer , List<Employee >> getEmployeesByDepartament (Integer departamentid){
        return employeeService.getAll().stream()
                .filter(e-> departamentid == null || e.getDepartamentid()==departamentid)
                .collect(groupingBy(Employee::getDepartamentid, toList()));
    }
}
