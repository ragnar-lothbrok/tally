package com.test.vizury;

import java.util.Comparator;

public class Employee {

    private Integer id;
    private Double salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    public static void main(String[] args) {
        
        Employee e = new Employee();
        e.setId(1);
        e.updateEmployee(e);
        System.out.println(e.getId());
    }
    
    public void updateEmployee(Employee e){
        e.setId(3);
        e = new Employee();
        e.setId(4);
    }

}

class EmployeeComparator implements Comparator<Employee>{

    public int compare(Employee o1, Employee o2) {
        if(o1 != null && o2 != null){
            return o1.getSalary().compareTo(o2.getSalary());
        }
        return 0;
    }
}
