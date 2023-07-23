package pro.sky.skyprospringdemo5.Service;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo5.entity.Employee;
import pro.sky.skyprospringdemo5.exception.EmployeeNotFoundException;
import pro.sky.skyprospringdemo5.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprospringdemo5.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService(){
        employees.add(new Employee("Иван","Иванов", 1000.0, 1));

        employees.add(new Employee("Олег","Олегов", 2000.0, 2));
        employees.add(new Employee("Антон","Антонов", 2500.0, 2));

        employees.add(new Employee("Петр","Петров", 3000.0, 3));
        employees.add(new Employee("Илья","Ильин", 3500.0, 3));
        employees.add(new Employee("Макар","Макаров", 4000.0, 3));
    }

    private final static int MAX_SIZE=2;

    public Employee add(String firstName, String lastName, double salary, int departamentid){

        if (employees.size()>=MAX_SIZE){
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        Employee newEmployee = new Employee(firstName, lastName, salary, departamentid);

        if (employees.contains(newEmployee)){
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }

        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee find(String firstName, String lastName, double salary, int departamentid){
        Employee employeeForFound = new Employee(firstName,lastName, salary, departamentid);
        for (Employee e: employees){
            if(e.equals(employeeForFound)){
                return e;
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }
    public Employee remove(String firstName, String lastName, double salary, int departamentid) {
        Employee employeeForRemove = new Employee(firstName, lastName, salary, departamentid);

        boolean removeResult = employees.remove(employeeForRemove);
        if (removeResult){
            return employeeForRemove;
        }else {
            throw new EmployeeNotFoundException("Сотрудник не удален - не был найден в базе");
        }
    }

    public List<Employee> getAll(){
        return employees;
    }
}
