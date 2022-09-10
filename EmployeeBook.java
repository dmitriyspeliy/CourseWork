package ru.sky.pro;

import java.util.*;

public class EmployeeBook {
    private final Employee[] arr = new Employee[10];

    {
        arr[0] = new Employee("Pospelov Dmitriy Alexsandrovich", "1", 13.000);
        arr[1] = new Employee("Ivanov Ivan Ivanovich", "2", 14.0000);
        arr[2] = new Employee("Petrov Pety Petrovich", "3", 12.000);
        arr[3] = new Employee("Pogorelov Pavel Alexsandrovich", "1", 15.000);
        arr[4] = new Employee("Poter Gary", "2", 21.000);
        arr[5] = new Employee("Korostelev Alexsey Vladimirovich", "3", 4.000);
        arr[6] = new Employee("Luhina Anastasiya Ivanovna", "1", 5.400);
        arr[7] = new Employee("Romanova Anna Olegovna", "3", 12.100);
        arr[8] = new Employee("Pospelova Daria Alexsandrovna", "3", 11.900);
        arr[9] = new Employee("Anikina Olga Ivanovna", "2", 21.102);
    }

    public Employee[] getArr() {
        return arr;
    }


    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    public void getAllEmployee() {
        for (Employee employee : arr) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    //Посчитать сумму затрат на зарплаты в месяц.
    public double getSumSalary() {
        double sum = 0;
        for (Employee employee : arr) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //Найти сотрудника с минимальной зарплатой.
    public Employee getMinSalaryEmployee() {
        double sum = Double.MAX_VALUE;
        for (Employee employee : arr) {
            if (employee != null && employee.getSalary() < sum) {
                sum = employee.getSalary();
            }
        }
        double finalSum = sum;
        return Arrays.stream(arr).filter(x -> x.getSalary() == finalSum).findAny().get();
    }

    //Найти сотрудника с максимальной зарплатой.
    public Employee getMaxSalaryEmployee() {
        double sum = 0;
        for (Employee employee : arr) {
            if (employee != null && employee.getSalary() > sum) {
                sum = employee.getSalary();
            }
        }
        double finalSum = sum;
        return Arrays.stream(arr).filter(x -> x.getSalary() == finalSum).findAny().get();
    }

    //Подсчитать среднее значение зарплат
    public double getAverageSalary() {
        double salary = getSumSalary();
        int count = Employee.getCount();
        return salary / count;
    }

    //Получить Ф. И. О. всех сотрудников(вывести в консоль)
    public void getFullNameEmployee() {
        for (Employee employee : arr) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public void changeAllSalary(double percent) {
        double index = percent / 100 + 1;
        for (Employee employee : arr) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * index);
            }
        }
    }

    //Получить сотрудника с минимальной зарплатой.
    public Employee getEmployeesFromDepartAndMinSal(String department) {
        List<Employee> arr1 = Arrays.stream(arr).filter(c -> c != null && c.getDepartment().equals(department)).toList();
        double sum = Double.MAX_VALUE;
        for (Employee employee : arr1) {
            if (employee.getSalary() < sum) {
                sum = employee.getSalary();
            }
        }
        double finalSum = sum;
        return arr1.stream().filter(x -> x.getSalary() == finalSum).findAny().get();
    }

    //Получить сотрудника с максимальной зарплатой.
    public Employee getEmployeesFromDepartAndMaxSal(String department) {
        List<Employee> arr1 = Arrays.stream(arr).filter(c -> c != null && c.getDepartment().equals(department)).toList();
        double sum = 0;
        for (Employee employee : arr1) {
            if (employee.getSalary() > sum) {
                sum = employee.getSalary();
            }
        }
        double finalSum = sum;
        return arr1.stream().filter(x -> x.getSalary() == finalSum).findAny().get();
    }

    //Получить сумму затрат на зарплату по отделу.
    public double getEmployeesFromDepartAndSumSal(String department) {
        List<Employee> arr1 = Arrays.stream(arr).filter(c -> c != null && c.getDepartment().equals(department)).toList();
        double sum = 0;
        for (Employee employee : arr1) {
            sum += employee.getSalary();
        }
        return sum;
    }

    //Получить cреднюю зарплату по отделу
    public double getEmployeesFromDepartAndAverageSal(String department) {
        List<Employee> arr1 = Arrays.stream(arr).filter(c -> c != null && c.getDepartment().equals(department)).toList();
        double sum = 0;
        for (Employee employee : arr1) {
            sum += employee.getSalary();
        }
        return sum / arr1.size();
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
    public void getEmployeesFromDepartIndexSal(String department, double percent) {
        double index = percent / 100 + 1;
        for (Employee employee : arr) {
            if (employee.getDepartment().equals(department)) {
                employee.setSalary(employee.getSalary() * index);
            }
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void getEmployeesFromDepart(String department) {
        List<Employee> arr1 = Arrays.stream(arr).filter(c -> c != null && c.getDepartment().equals(department)).toList();
        arr1.forEach(x -> System.out.println(x.getId() + " " + x.getFullName() + " " + x.getSalary()));
    }

    //Получить всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void getEmployeesWithLessSalary(double salary) {
        List<Employee> arr1 = Arrays.stream(arr).filter(c -> c != null && c.getSalary() < salary).toList();
        if (arr1.size() == 0) {
            System.out.println("Нет сотрудников с зарплатой меньше, чем " + salary);
        } else {
            arr1.forEach(x -> System.out.println(x.getId() + " " + x.getFullName() + " " + x.getSalary()));
        }
    }

    //Получить всех сотрудников с зарплатой больше либо равно числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void getEmployeesWithMoreSalary(double salary) {
        List<Employee> arr1 = Arrays.stream(arr).filter(c -> c != null && c.getSalary() >= salary).toList();
        if (arr1.size() == 0) {
            System.out.println("Нет сотрудников с зарплатой больше, чем " + salary);
        } else {
            arr1.forEach(x -> System.out.println(x.getId() + " " + x.getFullName() + " " + x.getSalary()));
        }
    }

    //Добавить нового сотрудника
    public void addEmployee(String fullName, String department, double salary) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                Employee employee = new Employee(fullName, department, salary);
                arr[i] = employee;
                employee.setId(i + 1);
                break;
            }
        }

    }

    //Удалить сотрудника
    public void deleteEmployee(int id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getId() == id) {
                arr[i] = null;
                break;
            }
        }
    }

    //Изменить отдел сотрудника
    public void changeDepartmentEmployee(String fullName, String department) {
        for (Employee employee : arr) {
            if (employee != null && employee.getFullName().contains(fullName)) {
                employee.setDepartment(department);
            }
        }

    }

    //Изменить зарплату сотрудника
    public void changeSalaryEmployee(String fullName, double salary) {
        for (Employee employee : arr) {
            if (employee != null && employee.getFullName().contains(fullName)) {
                employee.setSalary(salary);
            }
        }

    }

    //Получить Ф. И. О. всех сотрудников по отделам
    public Map<String, List<String>> getEmployeeAndDepartment() {
        Map<String, List<String>> sortedMap = new TreeMap<>();
        for (Employee employee : arr) {
            if (employee != null) {
                sortedMap.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee.getFullName());
            }
        }
        return sortedMap;
    }
}
