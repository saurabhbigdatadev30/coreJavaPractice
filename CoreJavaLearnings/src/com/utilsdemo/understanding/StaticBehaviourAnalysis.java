package com.utilsdemo.understanding;

public class StaticBehaviourAnalysis {
	
	public static  String var1 = "DEV";
	
	public static void main(String[] args) {
		var1 = "PROD";
		System.out.println("var>>"+ "\t" +var1 );
		StaticBehaviourAnalysis inst1 = new StaticBehaviourAnalysis();
		inst1.m2();
	}
	public void m2(){
		System.out.println("var"+ "\t" +var1 );
	}
	
}
