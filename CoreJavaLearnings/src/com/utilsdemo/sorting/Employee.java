package com.utilsdemo.sorting;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}

	int id;
	String firstName;
	String lastName;
	int salary

	;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id - o.getId();

	}

	// using comparator

	public static final Comparator<Employee> empComparatorSalary = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o2.getSalary() - o1.getSalary();
		}
	};

	public static final Comparator<Employee> empComparatorfirstName = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.firstName.compareTo(o2.firstName);
		}

	};

	public static final Comparator<Employee> empComparatorID = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			if (o1.getId() < o2.getId())
				return -1;
			if (o1.getId() == o2.getId()) {
				return 0;
			} else
				return 1;

		}

	};

	public Employee(int id, String firstName, String lastName, int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

}
