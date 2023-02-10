package org.example;

import java.util.ArrayList;
import java.util.List;

public class Check {
    public static void main(String[]args){
        List<Employee> listEmployees=new CustomArrayList<Employee>();
        Employee e1=new Employee(1,"Alex","John","Associative softawre Engineer");
        Employee e2=new Employee(2,"k","Tej","Associative softawre Engineer");
        Employee e3=new Employee(3,"Ram","Raj","Associative softawre Engineer");
        Employee e4=new Employee(4,"danny","lee","Associative softawre Engineer");

        listEmployees.add(e1);
        listEmployees.add(e2);
        listEmployees.add(e3);
        listEmployees.add(e4);
        System.out.println(listEmployees);
        List<Employee> actualList=new ArrayList<Employee>();
        actualList.add(e1);
        actualList.add(e2);
        actualList.add(e3);
        actualList.add(e4);
        actualList.add(null);
        actualList.add(null);
        actualList.add(null);
        actualList.add(null);
        actualList.add(null);
        actualList.add(null);
        List<Double> a=new CustomArrayList<Double>();
        a.add(0.2);
        a.add(2.3);
        a.add(2.4);
        a.add(2.4);
        System.out.println(actualList);
        System.out.println(listEmployees);
        System.out.println(listEmployees.equals(actualList));
    }
}
