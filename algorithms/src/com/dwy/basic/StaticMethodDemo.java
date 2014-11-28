package com.dwy.basic;

import java.math.BigDecimal;

public class StaticMethodDemo {
	
	/**
	 * 要实现重载，必须满足以下其中之一的条件：
	 *  * 参数个数不一样
	 *  * 参数类型不一样
	 */
	void show(){
		System.out.println("show1");
	}
	public int show(int m){
		return 1;
	}
	void show(String s ){
		System.out.println("show2");
	}
	
	
	public static void main(String[] args) {
//		double res = squrt(10);
//		System.out.println(res);
		
		int a[] = {1,23,4,5,66,43,654,23};
		System.out.println("a["+rank(23,a)+"]");
		System.out.println(1.0/0.0);
	}
	
	
	public static double squrt(double c){
		if(c<0) return Double.NaN;
		double err = 1e-15;
//		String s = Double.toString(err);
//		System.out.println(s);
		BigDecimal b = new BigDecimal(err);
		System.out.println(b.toPlainString());
		
		
		double t = c ;
		while(Math.abs(t-c/t)>err*t){
			t = (c/t+t)/2.0;
		}
		return t;
	}
	//二分查找
	public static int rank(int key,int [] a){
		
		return rank(key,a,0,a.length);
		
	}
	public static int rank(int key,int []a,int lo,int hi){
		if(hi<lo) return -1;
		
		int mid = lo + (hi-lo)/2;
		if (key<a[mid]) return rank(key,a,lo,mid-1);
		if (key>a[mid]) return rank(key,a,mid+1,hi);
		else  return mid;
	}
	
	
	
	
}







