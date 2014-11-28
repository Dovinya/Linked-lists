package com.dwy.basic;

public class DoubleNodeDemo {

	public static void main(String[] args) {

		DoubleNode<String> dn = new DoubleNode<String>();
		dn.headInsert("a");
		dn.headInsert("b");
		dn.headInsert("c");
		dn.headInsert("d");
		dn.headInsert("e");
//		dn.lastInsert("sb");
//		
//		System.out.println(dn.size());
//		System.out.println(dn.toString());
//		System.out.println("-----------------------------");
//		
//		dn.insAfterNode("s2b", "duwenya");
//		System.out.println(dn.toString());
		
		System.out.println(dn.toString());
		dn.insAfterNode("c", "ssss");
		System.out.println(dn.toString());
		dn.delNode("c");
		System.out.println(dn.toString());
		System.out.println(dn.size());
	}

}
