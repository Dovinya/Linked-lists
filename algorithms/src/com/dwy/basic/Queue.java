package com.dwy.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

	
	private int N;
	public Node<Item> first;
	public Node<Item> last;
	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
	public Queue(){
		first = null;
		last = null;
		N=0;
	}
	
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return first==null;
	}
	
	public void enqueue(Item item){
		Node<Item> oldLast = last;
		last = new Node<Item>();
		last.item= item;
		last.next = null;
		if(isEmpty()) {
			first =last;
		}
		else{
			oldLast.next = last;
			
		}N++;
			
	}
	public Item dequeue(){
		if(this.isEmpty())
			throw new NoSuchElementException("");
		else{
			Item item = first.item;//1.cannot change the location of 1 and 2.or will be "NullPointerException"
			first = first.next;    //2.
			N--;
			return item;
		}
	}
	
	
	
	public String toString() {
        StringBuilder s = new StringBuilder();
		/*
		 * 注意：一定要先实现iterator()方法，才可以使用下面的foreach
		 */
        for (Item item:this)
            s.append(item + " ");
        return s.toString();
    }
	
	
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator<Item>(first);
	}
	
	private class QueueIterator<Item> implements Iterator<Item>{
		Node<Item> current;
		public QueueIterator(Node<Item> first){
			current = first;
		}
		@Override
		public boolean hasNext() {
			return current!=null;
		}
		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException("");
			else
			{	Item item = current.item;
				current =  current.next;
				return item;
			}
		}
		@Override
		public void remove() {}
	}
	

}
