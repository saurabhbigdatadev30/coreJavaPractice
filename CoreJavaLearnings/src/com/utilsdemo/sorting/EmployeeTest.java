package com.utilsdemo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeTest {
	public static void main(String args[]) {
		Employee emp1 = new Employee(6, "sam1", "ban1", 20000);
		Employee emp2 = new Employee(9, "ram1", "ban1", 50000);
		Employee emp3 = new Employee(7, "bam1", "ban1", 30000);
		Employee emp4 = new Employee(4, "aam1", "ban1", 10000);
		Employee emp5 = new Employee(3, "cam1", "ban1", 200);
		List<Employee> empLst = new ArrayList<Employee>();
		empLst.add(emp1);
		empLst.add(emp2);
		empLst.add(emp3);
		empLst.add(emp4);
		empLst.add(emp5);

		iterate(empLst, "ORIGINAL");
		/*
		 * Collections.sort(empLst, Employee.empComparatorfirstName); iterate(empLst,
		 * "ON FIRST NAME");
		 * 
		 * Collections.sort(empLst, Employee.empComparatorSalary); iterate(empLst,
		 * "ON SALARY");
		 * 
		 * Collections.sort(empLst, Employee.empComparatorID); iterate(empLst, "ON ID");
		 */
	}

	private static void iterate(List<Employee> empLst, String empstrdetails) {
		System.out.println("Iterating EmployeeList on ....." + "\t" + empstrdetails);
		for (Employee emp : empLst) {
			System.out.println(emp);
		}
	}
}