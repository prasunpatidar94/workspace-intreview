package com.pp.sun.poc;

import com.pp.sun.java8Feature.EmployeeDetail;
import com.pp.sun.java8Feature.EmployeesList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetEmpNameBasedOnDeptName {
    public static void main(String[] args) {
        List<EmployeeDetail> employeesLists = EmployeesList.addEmployeesDetails();
        System.out.println("Approach # 1");
        System.out.println(
        employeesLists
                .stream().limit(10)
                .collect(
                        Collectors
                                .groupingBy(
                                        EmployeeDetail::getDepartment
                                        ,Collectors
                                                .mapping(
                                                        EmployeeDetail::getName
                                                        ,Collectors
                                                                .collectingAndThen(
                                                                        Collectors.toList()
                                                                        ,e->e))))
        );

//        System.out.println("Approach # 2");
//        Map<String,List<String>> stringListMap = new HashMap<>();
//        System.out.println(
//                employeesLists
//                        .stream().limit(10)
//                        .forEach(
//                                stringListMap.merge(employeesLists,1,e->e.)
//                        );
//        );

    }
}
