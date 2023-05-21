package com.voloshyn.spring.rest;

import com.voloshyn.spring.rest.configuration.MyConfig;
import com.voloshyn.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        //отримуємо список всіх робітників
       // List<Employee> allEmployee = communication.showAllEmployee();
        //System.out.println(allEmployee);
        //отримуємо робітника за ID
       // Employee employee = communication.getEmployee(11);
       // System.out.println(employee);
        //Додаємо нового або змінюємо вже існуючого робітника в БД
//        Employee employee = new Employee("Dmytro","Voloshyn","IT",100);
//        employee.setId(18);
//        communication.save_updateEmployee(employee);
        // видаляємо співробітника за ID
        communication.deleteEmployee(18);

    }
}
