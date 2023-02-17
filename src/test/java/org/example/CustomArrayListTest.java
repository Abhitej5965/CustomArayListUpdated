package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    private static final Employee EMPLOYEE_1 = new Employee(1, "Alex", "John", "Associative software Engineer");
    private static final Employee EMPLOYEE_2 = new Employee(2, "k", "Tej", "Associative software Engineer");
    private static final Employee EMPLOYEE_3 = new Employee(3, "Ram", "Raj", "Associative software Engineer");
    private static final Employee EMPLOYEE_4 = new Employee(4, "Ram", "Raj", "Associative software Engineer");
    private static final Employee EMPLOYEE_5 = new Employee(5, "Ram", "Raj", "Associative software Engineer");

    private List<Employee> employeeList;

    @BeforeEach
    private void setup() {
        employeeList = new CustomArrayList<>();
        employeeList.add(EMPLOYEE_1);
        employeeList.add(EMPLOYEE_2);
        employeeList.add(EMPLOYEE_3);
        employeeList.add(EMPLOYEE_4);
        employeeList.add(EMPLOYEE_5);
    }

    @Test
    public void testAddAndSize() {
        assertEquals(5, employeeList.size());
    }

    @Test
    public void testClear() {
        employeeList.clear();
        assertEquals(0, employeeList.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(employeeList.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        List<Employee> emptyList=new ArrayList<>();
        assertEquals(true, emptyList.isEmpty());
    }

    @Test
    public void testContains() {
        assertEquals(true, employeeList.contains(EMPLOYEE_1));
    }

    @Test
    public void test2Contains() {
        Employee e6 = new Employee(6, "Ragav", "Raj", "Associative softawre Engineer");
        assertEquals(false, employeeList.contains(e6));
    }

    @Test
    public void testGet() {
        assertEquals(EMPLOYEE_1, employeeList.get(0));
    }

    @Test
    public void testSet() {
        employeeList.set(4, EMPLOYEE_1);
        assertEquals(EMPLOYEE_1, employeeList.get(4));
    }

    @Test
    public void testRemove() {
        employeeList.remove(EMPLOYEE_1);
        assertEquals(EMPLOYEE_2, employeeList.get(0));
    }

    @Test
    public void testRemoveIndex() {
        employeeList.remove(0);
        employeeList.remove(4);
        assertEquals(EMPLOYEE_2, employeeList.get(0));
    }

    @Test
    public void testAddAtIndex() {
        employeeList.add(2, EMPLOYEE_4);
        employeeList.add(3, EMPLOYEE_3);
        assertEquals(7, employeeList.size());
    }

    @Test
    public void test2AddAtIndex() {
        employeeList.add(0, EMPLOYEE_4);
        assertEquals(EMPLOYEE_4, employeeList.get(0));
    }

    @Test
    public void testAddAll() {
        List<Employee> newListToBeAdded = new ArrayList<>();
        newListToBeAdded.add(EMPLOYEE_1);
        newListToBeAdded.add(EMPLOYEE_2);
        newListToBeAdded.add(EMPLOYEE_5);
        employeeList.addAll(newListToBeAdded);
        assertEquals(8, employeeList.size());
    }

    @Test
    public void testRemoveAll() {
        List<Employee> listToBeRemoved = new ArrayList<>();
        listToBeRemoved.add(EMPLOYEE_1);
        listToBeRemoved.add(EMPLOYEE_3);
        listToBeRemoved.add(EMPLOYEE_5);
        employeeList.removeAll(listToBeRemoved);
        assertEquals(2, employeeList.size());
    }

    @Test
    public void testIndexOf() {
        employeeList.add(EMPLOYEE_1);
        assertEquals(0, employeeList.indexOf(EMPLOYEE_1));
    }

    @Test
    public void testLastIndexOf() {
        employeeList.add(EMPLOYEE_2);
        employeeList.add(EMPLOYEE_4);
        employeeList.add(EMPLOYEE_4);
        assertEquals(7, employeeList.lastIndexOf(EMPLOYEE_4));
    }

    @Test
    public void test2LastIndexOf() {
        employeeList.add(EMPLOYEE_2);
        employeeList.add(EMPLOYEE_4);
        employeeList.add(EMPLOYEE_4);
        employeeList.add(EMPLOYEE_1);
        assertEquals(8, employeeList.lastIndexOf(EMPLOYEE_1));
    }
}