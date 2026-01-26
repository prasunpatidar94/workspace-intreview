package com.pp.sun.poc;

import com.pp.sun.java8Feature.EmployeeDetail;
import com.pp.sun.java8Feature.EmployeesList;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindHightestPaidSalaryedOfEmpBaseOnDept {
    public static void main(String[] args) {

        List<EmployeeDetail> employeeDetailList = EmployeesList.addEmployeesDetails();

        System.out.println("#1: output");
        Map<String, Optional<EmployeeDetail>> output = employeeDetailList
                .stream()
                .collect(
                        Collectors.groupingBy(EmployeeDetail::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(EmployeeDetail::getSalary))
                        ));
        output.forEach((dept, value) ->
                value.ifPresent(System.out::println));
        System.out.println("#2: output");

        Map<String, Optional<EmployeeDetail>> hightestPaidSalaryed = employeeDetailList
                .stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(),
                        Collectors
                                .maxBy((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
                ));
        hightestPaidSalaryed.forEach(
                (dept, emp) ->
                        emp.ifPresent(e -> System.out.println(e.getDepartment() + "->" + e.getName() + ":" + e.getSalary()))
        );

        System.out.println("#3: output");

      employeeDetailList
                .stream()
                .collect(
                        Collectors.groupingBy(EmployeeDetail::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(EmployeeDetail::getSalary)),
                                        Optional::get
                                )
                        )).forEach((dept,val)-> System.out.println(dept+": "+val.getName()+","+val.getSalary()));


    }
}
