package ru.sky.pro;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBook {
    private final Map<String, Employee> mapEmployee = new HashMap<>();

    {
        mapEmployee.put("123450", new Employee("Pospelov Dmitriy Alexsandrovich", "1", 13.000));
        mapEmployee.put("123451", new Employee("Ivanov Ivan Ivanovich", "2", 14.0000));
        mapEmployee.put("123452", new Employee("Petrov Pety Petrovich", "3", 12.000));
        mapEmployee.put("123453", new Employee("Pogorelov Pavel Alexsandrovich", "1", 15.000));
        mapEmployee.put("123454", new Employee("Poter Gary", "2", 21.000));
        mapEmployee.put("123455", new Employee("Korostelev Alexsey Vladimirovich", "3", 4.000));
        mapEmployee.put("123456", new Employee("Luhina Anastasiya Ivanovna", "1", 5.400));
        mapEmployee.put("123457", new Employee("Romanova Anna Olegovna", "3", 12.100));
        mapEmployee.put("123458", new Employee("Pospelova Daria Alexsandrovna", "3", 11.900));
        mapEmployee.put("123459", new Employee("Anikina Olga Ivanovna", "2", 21.102));
    }


    public Map<String, Employee> getMapEmployee() {
        return mapEmployee;
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    public void getAllEmployee() {
        mapEmployee.forEach((s, employee) -> System.out.println(employee.toString()));
    }

    //Посчитать сумму затрат на зарплаты в месяц.
    public double getSumSalary() {
        return mapEmployee.values()
                .stream().mapToDouble(Employee::getSalary).sum();
    }

    //Найти сотрудника с минимальной зарплатой.
    public Employee getMinSalaryEmployee() {
        return mapEmployee.values()
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary)).get();
    }

    //Найти сотрудника с максимальной зарплатой.
    public Employee getMaxSalaryEmployee() {
        return mapEmployee.values()
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary)).get();
    }

    //Подсчитать среднее значение зарплат
    public double getAverageSalary() {
        double salary = getSumSalary();
        int count = Employee.getCount();
        return salary / count;
    }

    //Получить Ф. И. О. всех сотрудников(вывести в консоль)
    public void getFullNameEmployee() {
        mapEmployee.forEach((s, employee) -> System.out.println(employee.getFullName()));
    }


    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public void changeAllSalary(double percent) {
        double index = percent / 100 + 1;
        mapEmployee.forEach((s, employee) -> employee.setSalary(employee.getSalary() * index));
    }

    //Получить сотрудника с минимальной зарплатой.
    public Employee getEmployeesFromDepartAndMinSal(String department) {
        return mapEmployee.values()
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .min(Comparator.comparingDouble(Employee::getSalary)).get();
    }

    //Получить сотрудника с максимальной зарплатой.
    public Employee getEmployeesFromDepartAndMaxSal(String department) {
        return mapEmployee.values()
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .max(Comparator.comparingDouble(Employee::getSalary)).get();
    }

    //Получить сумму затрат на зарплату по отделу.
    public double getEmployeesFromDepartAndSumSal(String department) {
        return mapEmployee.values()
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary).sum();
    }

    //Получить cреднюю зарплату по отделу
    public double getEmployeesFromDepartAndAverageSal(String department) {
        return mapEmployee.values()
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
    public void getEmployeesFromDepartIndexSal(String department, double percent) {
        double index = percent / 100 + 1;
        mapEmployee.values()
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .forEach(x -> x.setSalary(x.getSalary() * index));
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void getEmployeesFromDepart(String department) {
        mapEmployee.values()
                .stream()
                .filter(x -> x.getDepartment().equals(department))
                .forEach(x -> System.out.println(x.getId() + " " + x.getFullName() + " " + x.getSalary()));
    }

    //Получить всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void getEmployeesWithLessSalary(double salary) {
        mapEmployee.values()
                .stream()
                .filter(c -> c != null && c.getSalary() < salary)
                .forEach(x -> System.out.println(x.getId() + " " + x.getFullName() + " " + x.getSalary()));
    }


    //Получить всех сотрудников с зарплатой больше либо равно числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void getEmployeesWithMoreSalary(double salary) {
        mapEmployee.values()
                .stream()
                .filter(c -> c != null && c.getSalary() >= salary)
                .forEach(x -> System.out.println(x.getId() + " " + x.getFullName() + " " + x.getSalary()));
    }


    //Добавить нового сотрудника
    public void addEmployee(String fullName, String department, double salary, String numPass) {
        mapEmployee.put(numPass,new Employee(fullName, department, salary));
    }

    //Удалить сотрудника
    public void deleteEmployee(String numPass) {
        mapEmployee.remove(numPass);
    }

    //Изменить отдел сотрудника
    public void changeDepartmentEmployee(String fullName, String department) {
        mapEmployee.values()
                .stream()
                .filter(c -> c.getFullName().contains(fullName))
                .findFirst()
                .get().setDepartment(department);
    }

    //Изменить зарплату сотрудника
    public void changeSalaryEmployee(String fullName, double salary) {
        mapEmployee.values()
                .stream()
                .filter(c -> c.getFullName().contains(fullName))
                .findFirst()
                .get().setSalary(salary);
    }

    //Получить Ф. И. О. всех сотрудников по отделам
    public Map<String, List<String>> getEmployeeAndDepartment() {
        Map<String, List<String>> sortedMap = new TreeMap<>();
        for (Employee employee : mapEmployee.values()) {
            if (employee != null) {
                sortedMap.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee.getFullName());
            }
        }
        return sortedMap;
    }
}
