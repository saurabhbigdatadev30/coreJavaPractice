package com.newconcurencypacke.example;

public class Test {
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.modulesCheck();
	}

	private void modulesCheck() {
		for (int i = 1 ;i<10 ; i++){
			if (i % 5 == 0) {
				System.out.println("i % 5 == 0" +"WHEN " + i);
				i = i / 0;
			}
			System.out.println("i is ++" + i);
		}
		
	}

}
