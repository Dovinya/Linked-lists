package com.dwy.basic;

public class QueueDemo {
	public static void main(String[] args) {
		
		Queue<String> queue = new Queue<String>();
		queue.enqueue("hello1");
		queue.enqueue("hello2");
//		queue.enqueue("hello3");
//		queue.enqueue("hello4");
		System.out.println(queue.toString());

		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.size());
		
		
//		System.out.println(queue.first);
//		System.out.println(queue.last);
		
	}
}
