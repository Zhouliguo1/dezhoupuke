package com.arua.project.pk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @类名 Pukerpai.java
 * @作者 zhouliguo
 * @版本 V1.0
 * @日期 2019年7月7日-上午11:20:12
 * @描述
 *
 */
//初始化一副扑克牌
public class Pukerpai {
	String[] sign = { "方片", "红桃", "黑桃", "梅花" };

	public ArrayList<String> Init() {
		ArrayList<String> list = new ArrayList<String>();
		for (String str : sign) {
			for (int i = 1; i <= 13; i++) {
				String extra_sign = "";
				if (i == 10) {
					extra_sign = "T";
					list.add(str + extra_sign);
				} else if (i == 11) {
					extra_sign = "J";
					list.add(str + extra_sign);
				} else if (i == 12) {
					extra_sign = "Q";
					list.add(str + extra_sign);
				} else if (i == 13) {
					extra_sign = "K";
					list.add(str + extra_sign);
				} else {
					list.add(str + i);
				}
			}
		}
		System.out.println(list);
		Collections.shuffle(list);
		return list;
	}
}

//德州扑克发牌
class player {

	public String playPK() {
		boolean f = true;
		boolean f1 = true;
		boolean f2 = true;
		int a = 0;
		int b = 0;
		Scanner sc = new Scanner(System.in);
		Pukerpai p = new Pukerpai();
		ArrayList<String> init = p.Init();
		player1 py = new player1();
		player1 py1 = new player1();
		String str1 = "";
		String str = "";

		
			System.out.println("是否开启游戏");
			String next2 = sc.next();
			if (next2.equals("Y")) {
				while (f1) {
					py.pk1 += init.get(a);
					a++;
					if (a == 3) {
						f1 = false;
					}
				}
				while (f2) {
					py1.pk1 += init.get(a);
					a++;
					if (a == 6) {
						f2 = false;
					}
				}
				System.out.println("你的手牌是" + py.pk1);
				System.out.println("你对手的手牌**" + init.get(5));
				while (b != 2) {
					System.out.println("是否跟牌 Y/N");
					String next = sc.next();
					if (next.equals("Y")) {
						py.pk1 += init.get(a);
						a++;
						py1.pk1 += init.get(a);
						str += init.get(a);
						System.out.println("你的手牌是" + py.pk1);
						System.out.println("你对手的手牌**" +  "" +init.get(5)+""+ str);
						a++;
						b++;
						
					} else if (next.equals("N")) {
						System.out.println("你输了");
						break;
					}
				}
				System.out.println("是否开牌Y/N");
				String next1 = sc.next();
				if (next1.equals("Y")) {
					str1 += py.pk1 + py1.pk1;
					return str1;
				} else if (next1.equals("N")) {
					System.out.println("你输了");
					System.exit(0);
				}
				sc.close();
			} else if (next2.equals("N")) {
				System.out.println("你输了");
				System.exit(0);
			}
		

		return null;
	}
}

class player1 {
	public String pk1 = "";
}


