package com.arua.project.pk;

import java.util.Scanner;

/**
 * @类名 PokerPai.java
 * @作者 zhouliguo
 * @版本 V1.0
 * @日期 2019年6月26日-下午9:19:52
 * @描述
 *
 */

public class PokerPai {
	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("==             ***************        ==");
		System.out.println("==       **欢迎来到德州扑克比较大小** ==");
		System.out.println("==             ***************        ==");
		System.out.println("========================================");
		System.out.println( "游戏规则牌面数字使用：1 2 3 4 5 6 7 8 9 T J Q K"); 
		System.out.println( "花色：黑桃：B, 方块：F，棉花：M,  红桃：R");
		System.out.println( "相同手牌 比较最大牌的花色；B>F>M>R;");
		System.out.println( "一手牌就是：B2M2R3RJRK");
		System.out.println( "请严格按照规格出牌");
		System.out.println("========================================");
		TestPK t=new TestPK();
		System.out.println("是否开启游戏Y/N");
		Scanner sc=new Scanner(System.in);
		String n = sc.next();
		
		if(n.equals("Y")) {
			boolean s=true;
			while(s) {
			System.out.println("选择游戏模式1；实现目标一  2；实现目标2");
			int nextInt = sc.nextInt();
			boolean f=true;
			while(f) {
				if(nextInt==1) {
					t.show1();
				}else if(nextInt==2) {
					t.show2();
				}
		      System.out.println("是否继续游戏 Y继续 / Q 返回上一层 / N 结束");
		       String next = sc.next();
		       if(next.equals("Y")) {
		    	   continue;
		       }else if (next.equals("Q")) {
		    	   break;
		       }else if(next.equals("N")) {
		    	   System.out.println("谢谢再见");
		    	   System.exit(0);	   
		       }
				}		
			}
			}sc.close();
	}
			}
				
			



