package com.arua.project.pk;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名 Test.java
 * @作者 zhouliguo
 * @版本 V1.0
 * @日期 2019年7月7日-下午12:03:48
 * @描述
 *德州扑克
 */
public class Test {
	public static void main(String[] args) {
		Test t=new Test();
		t.wnayouxi();
		
		
	}
	
	public String wan() {
		   String  str1="";
		   String pl;
			player p = new player();
			 pl = p.playPK();
			
			//System.out.println(pl);
			for (int i = 0; i < pl.length(); i++) {
				String str = "";
				
					for (int b = 0; b < 2; b++) {
						str += pl.charAt(i);
						i++;
					}
				

				if (str.equals("方片")) {
					str = "F";
				}
				if (str.equals("红桃")) {
					str = "R";
				}
				if (str.equals("黑桃")) {
					str = "B";
				}
				if (str.equals("梅花")) {
					str = "M";
				}
				
				str += pl.charAt(i);
				str1+=str;
				
				
			}
			
			System.out.println(str1);
			return str1;
	}
public void wnayouxi(){
	
	
	String str1;
	String str2;
	String wan = wan();
	str1=wan.substring(0,10);
	str2=wan.substring(10,20);
	boolean compareCards = new PK().compareCards(str1, str2);
	
		if (compareCards) {
			System.out.println("you win");
			System.out.println("你的底牌"+str1);
			System.out.println("你对手的底牌"+str2);
			
		} else {
			System.out.println("你的底牌"+str1);
			System.out.println("你对手的底牌"+str2);
			System.out.println("you lost");
		}
	}
} 

