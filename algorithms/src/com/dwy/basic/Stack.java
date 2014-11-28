package com.dwy.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{
	
	private int N;//栈大小
	private  Node<Item> first;
	
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	public Stack(){
		first = null;
		N = 0;
	}
	
	//判断是否为空
	public  boolean isEmpty(){
		return first==null;
	}
	
	//栈大小
	public int size(){
		return this.N;
	}
	
	//入栈
	public void push(Item item){
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	//弹栈
	public Item pop(){
		if(this.isEmpty())  //当前元素为null
			throw new NoSuchElementException("stack is underflow!");
		else{
			Item item = first.item;
			first = first.next;			
			N--;
			return item;
		}
		
	}
	//返回栈顶元素
	public Item peek(){
		if(this.isEmpty())
			throw new NoSuchElementException("stack is empty!!");
		else{
			Item item = first.item;
			return item;
			}
	}
	public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
	
	
	public Iterator<Item> iterator(){
		return new StackIterator<Item>(first);
	}
	
	public class StackIterator<Item> implements Iterator<Item>{

		Node<Item> current;
		public StackIterator(Node<Item> first) {
			current = first;
		}
		
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException("");
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
		}
	}
	
	
}
