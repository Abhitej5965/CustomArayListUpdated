package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    List<Integer> customArrayList=new CustomArrayList<Integer>();
    @Test
    public void testAddAndGet(){
        customArrayList.add(100);
        int test1=customArrayList.get(0);
        assertEquals(100,test1);
    }

    @Test
    public void testContain(){
        List<Employee> customArrayList=new CustomArrayList<>();
        Employee employee1=new Employee(1,"Rama","Swami","Backend Developer");
        Employee employee2=new Employee(2,"Ram","Laxman","Sales Manager");
        Employee employee3=new Employee(3,"Ram","Laxman","Sales Manager");
        Employee employee4=new Employee(1,"Rama","Swami","Backend Developer");
        customArrayList.add(employee1);
        customArrayList.add(employee2);
        boolean test2=customArrayList.contains(employee4);
        assertEquals(true,test2);
    }

    @Test
    public void testSet(){
        customArrayList.add(10);
        customArrayList.add(100);
        int test4=customArrayList.set(1,70);
        assertEquals(100,test4);
    }

    @Test
    public void testIndexOf(){
        List<Employee> customArrayList=new CustomArrayList<>();
        Employee employee1=new Employee(1,"Rama","Swami","Backend Developer");
        Employee employee2=new Employee(2,"Ram","Laxman","Sales Manager");
        customArrayList.add(employee1);
        customArrayList.add(employee2);
        int test5=customArrayList.indexOf(employee1);
        assertEquals(0,test5);
    }

    @Test
    public void testLastIndexOf(){
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);
        customArrayList.add(3);
        customArrayList.add(3);
        int test6=customArrayList.lastIndexOf(3);
        assertEquals(4,test6);
    }

    @Test
    public void testSize(){
        customArrayList.add(1);
        customArrayList.add(2);
        assertEquals(2,customArrayList.size());
    }

    @Test
    public void testAddAll(){
        List<Integer> checkList=new ArrayList<>();
        List<Integer> checkList2=new CustomArrayList<Integer>();
        checkList.add(9);
        checkList.add(8);
        checkList.add(7);
        checkList2.add(9);
        checkList2.add(8);
        checkList2.add(7);
        customArrayList.addAll(checkList);
        System.out.println("ArrayList After using addall method->"+customArrayList);
//        assertEquals(checkList2,customArrayList);
    }

    @Test
    public void testIsEmpty(){
        assertEquals(true,customArrayList.isEmpty());
    }

    @Test
    public void testRemove(){
        List<Employee> customArrayList=new CustomArrayList<>();
        Employee employee1=new Employee(1,"Rama","Swami","Backend Developer");
        Employee employee2=new Employee(2,"Ram","Laxman","Sales Manager");
        customArrayList.add(employee1);
        customArrayList.add(employee2);
        customArrayList.remove(0);
        System.out.println("ArrayList After removing an element at index 2->"+customArrayList);
    }

    @Test
    public void testEmployee(){
        List<Employee> listEmployess=new CustomArrayList<Employee>();
        Employee e1=new Employee(1,"Alex","John","Associative softawre Engineer");
        Employee e2=new Employee(2,"k","Tej","Associative softawre Engineer");
        Employee e3=new Employee(3,"Ram","Raj","Associative softawre Engineer");
        Employee e4=new Employee(4,"Ram","Raj","Associative softawre Engineer");
        Employee e5=new Employee(5,"Ram","Raj","Associative softawre Engineer");

        listEmployess.add(e1);
        listEmployess.add(e2);
        listEmployess.add(e3);
        listEmployess.add(e4);
//        System.out.println(listEmployess);
        assertEquals(false,listEmployess.contains(e5));
    }

    @Test
    public void testString(){
        List<String> listStrings=new CustomArrayList<String>();
        listStrings.add("abhi");
        listStrings.add("tej");
        listStrings.add("ab");
        listStrings.add("hi");
        System.out.println(listStrings);
        assertEquals(4,listStrings.size());
    }


}