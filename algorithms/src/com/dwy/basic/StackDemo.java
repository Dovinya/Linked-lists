package com.dwy.basic;

import java.util.Iterator;

public class StackDemo {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		
		stack.pop();
		
		System.out.println("size of this stack: "+stack.size());
		//获取迭代器
//		Iterator<String> iterator = stack.iterator();
//		
//		
//		
//		while (iterator.hasNext()) {
//			String nextNode = iterator.next();
//			System.out.println(nextNode);
//		} 
		
//		stack.pop();
//		System.out.println("size of this stack: "+stack.size());
//		stack.pop();
//		System.out.println("size of this stack: "+stack.size());
//		stack.pop();
//		System.out.println("size of this stack: "+stack.size());
//		System.out.println(stack.peek());
//		stack.pop();
//		System.out.println("size of this stack: "+stack.size());
//		stack.pop();
//		System.out.println("size of this stack: "+stack.size());
//		
		
		
		
	}

}
