package com.dwy.basic;
/**
 * 程序演示了一个双向链表的Demo
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleNode<Item> implements Iterable<Item>{
	
	public int N;
	public Node<Item> first;
	public Node<Item> last;
	
	private static class Node<Item>{
		private Item value;
		private Node<Item> next;
		private Node<Item> forward;
		
		public Node(Item value) {	
			this.value = value;
		}
	}
	
	/**
	 * 构造函数，初始化链表的首节点，尾节点以及长度
	 */
	public DoubleNode() {
		N=0;
		first = null;
		last = null;
	}
	
	/**
	 * 获取链表长度
	 * @return 链表长度
	 */
	public int size(){
		return N;
	}
	
	/**
	 * 判断链表是否为空
	 * @return 是否为空的布尔值
	 */
	public boolean isEmpty(){
		return first==null;
	}
	
	/**
	 * 从表头插入元素
	 * @param value 要插入的元素
	 */
	public void headInsert(Item value){ //表头插入
		Node<Item> oldFirst = first;
		first = new Node<Item>(value);
		first.value = value;
		first.forward= null;
		first.next = oldFirst;
		if(oldFirst==null)last = first;
		else oldFirst.forward = first;
		N++;
	}
	
	/**
	 * 从链表尾部插入节点
	 * @param value 要插入的节点元素值
	 */
	public void lastInsert(Item value){
		Node<Item> oldLast = last;
		last = new Node<Item>(value);
		last.value = value;
		last.forward = oldLast;
		last.next= null;
		if(oldLast==null) first = last;
		else oldLast.next = last;
		N++;
	}
	
	/**
	 * 从链表头部删除节点
	 * @return 删除的节点元素值
	 */
	public Item headDel(){
		if(isEmpty())
			throw new NoSuchElementException();
		else{
			Item value =first.value;
			first = first.next;
			first.forward = null;
			N--;
			return value;
		}
	}
	
	/**
	 * 从链表尾部删除节点
	 * @return 要删除的节点元素值
	 */
	public Item endDel(){
		if(isEmpty())
			throw new NoSuchElementException();
		else{
			Item value = last.value;
			last = last.forward;
			last.next =null;
			N--;
			return value;
		}
	}
	

	/**
	 * 
	 * @param target 插入该元素之后
	 * @param itemTobeIns 要插入的元素值
	 */
	public void insAfterNode(Item target, Item itemTobeIns){
		Node<Item> node = new Node<Item>(itemTobeIns);
		Node<Item> current = first;
		while(current!=null){
			if(current.value.equals(target)){
				
				node.next = current.next;
				node.forward =current;
				
				if(current.next==null) last= node;
				else current.next.forward = node;
				
				current.next = node;
				N++;
				break;
			}else{
				current = current.next;
			}
		}
	}
	
	/**
	 * 删除指定位置的节点
	 * @param target
	 * @return
	 */
	public Item delNode(Item target){
		Node<Item> current = first;
		while(current!=null){
			if(current.value.equals(target)){

				current.next.forward= current.forward ;
				current.forward.next= current.next ;
				
				current=null;
				N--;
				break;
			}else{
				current = current.next;
			}
			
		}
		return target;
	}
	
	/**
	 * 重写toString()方法，这里是为了打印出链表元素
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Item item:this){
			sb.append(item+" ");
		}
		return sb.toString();
	}
	
	/**
	 * 返回一个迭代器
	 */
	@Override
	public Iterator<Item> iterator(){
		return new ListIterator<Item>(first);
	}
	
	public class ListIterator<Item> implements Iterator<Item>{

		private Node<Item> current;
		public ListIterator(Node<Item> first) {
			current = first;
		}
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			else {
				Item item = current.value;
				current = current.next;
				return item;
			}
		}

		@Override
		public void remove() {}
	}
	
}














