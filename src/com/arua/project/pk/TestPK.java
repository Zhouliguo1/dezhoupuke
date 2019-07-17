package com.arua.project.pk;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
4、请模拟实现德州扑克的认牌和比牌大小
牌面数字使用：1 2 3 4 5 6 7 8 9 T J Q K
花色：黑桃：B, 方块：F，棉花：M,  红桃：R,  
相同手牌 比较最大牌的花色；B>F>M>R; 
一手牌就是：
B2M2R3RJRK
（一张黑桃2，一张棉花2，一张红桃3，一张红桃J，一张红桃K）
比较规则：首先约定，这些牌面首先使用这些数字符号表示
//	单张	         一对	              两对           	三张      	顺子	           同花	     满堂红              	四张	       同花顺
//	0	    1	    2	    3	    4	    5 	    6	    7	    8 
实现两个功能：
	①假如一手牌，就是这样的包含10个字符的一个字符串，那么请实现一个方法，能判定当前这手牌是什么牌
	public int getCardSign(String cards);
	传入参数：一手牌，也就是5张牌
	返回值：该牌的数字符号

	②现在给定两手牌，请帮我比较大小
	public boolean compareCards(String cardsFirst, String cardsSecond);
	传入参数：两手牌
	返回值：布尔值，返回true表示cardsFirst大于cardsSecond，返回false，表示cardsSecond大于cardsFirst
	比较规则：
	0 < 1 < 2 < 3 < 4 < 5 < 6 < 7 < 8
	然后，出现：两手牌的数字符号一样，请按照花色等自定义规则在继续比较。一定要比出个大小。
  */

public class TestPK {
	//实现目标1
	public void show1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一手牌");
		String n = sc.next();
		String yanzheng = TestPK.yanzheng(n);
		if(yanzheng!=null) {List<Integer> c = new Poker().getCardSign(yanzheng);
		Integer i = c.get(0);
		if (i == 0) {
			System.out.println("你的手牌是单张");
			System.out.println("牌面为" + i);
		}
		if (i == 1) {
			System.out.println("你的手牌是一对");
			System.out.println("牌面为" + i);
		}
		if (i == 2) {
			System.out.println("你的手牌是两对");
			System.out.println("牌面为" + i);
		}
		if (i == 3) {
			System.out.println("你的手牌是三张");
			System.out.println("牌面为" + i);
		}
		if (i == 4) {
			System.out.println("你的手牌是顺子");
			System.out.println("牌面为" + i);
		}
		if (i == 5) {
			System.out.println("你的手牌是同花");
			System.out.println("牌面为" + i);
		}
		if (i == 6) {
			System.out.println("你的手牌是漫谈红");
			System.out.println("牌面为" + i);
		}
		if (i == 7) {
			System.out.println("你的手牌是四张");
			System.out.println("牌面为" + i);
		}
		if (i == 8) {
			System.out.println("你的手牌是同花顺");
			System.out.println("牌面为" + i);
		}
		}
		
		
	}	
	//实现目标2
	public void show2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的手牌");
		String n = sc.next();
		String yanzheng = TestPK.yanzheng(n);
		if(yanzheng==null) {
			return;
		}
		System.out.println("请输入你的对手牌");
		String m = sc.next();
		String yanzheng2 = TestPK.yanzheng(m);
		if(yanzheng2==null) {
			return;
		}
		
		if(n.equals(m)) {
			System.err.println("输入有误两幅牌相同");
			return ;
		}
		boolean twoPK = TestPK.twoPK(m, n);
		if(twoPK) {
			boolean compareCards = new PK().compareCards(yanzheng, yanzheng2);
			if (compareCards) {
				System.out.println("you win"+":"+twoPK);
			} else {
				System.out.println("you lost"+":"+twoPK);
			}
		}
		
		
	}
	
	//判定输入一手牌是否合法
	public static String yanzheng(String str) {
		boolean f=false;
		boolean f2=false;
		String s1="";
		String s2="";
		if (str.length() != 10) {
			System.err.println("输入的牌长度不符");
			return null;
		}
		for(int i=0;i<str.length();) {
			char c = str.charAt(i);
			s1+=c;
			i+=2;
			if(c=='B'||c=='M'||c=='F'||c=='R') {				
			}else {			
				System.err.println("没有按规定输入"+"错误花色"+c);
				return null;
				
				}		
		}
		    f=true;
		for(int x=1;x<str.length();) {
			char b = str.charAt(x);
			   x+=2;
			if(b=='1'||b=='2'||b=='3'||b=='4'||b=='5'||b=='6'||b=='7'||b=='8'||b=='9'||b=='T'||b=='J'||b=='Q'||b=='K') {	
				s2+=b;
			}else {
				System.err.println("没有按规定输入"+"牌面错误"+b);
				return null;
						
				}}
			f2=true;
			if(f&&f2) {
				  for(int i=0;i<s1.length();i++) {
					  char c= s1.charAt(i);
					 for(int z=1+i;z<s1.length();z++) {
						 char t = s1.charAt(z);
						 if(c==t) {
							 char charAt = s2.charAt(i);
							 char charAt2 = s2.charAt(z);
							 if(charAt==charAt2) {
								 System.err.println("输入非法相同两张牌"+charAt+":"+charAt2);
									return null;
								
							 }
						 }
					 }
				  }
				return str;
			}
	
		return null;
}
	//判断两幅牌是否合法
public static  boolean twoPK(String str1,String str2) {
	
	for(int i=0;i<str1.length();i++) {
		char c1 = str1.charAt(i);
		i++;
		for(int b=0;b<str2.length();b++) {
			char c2 = str2.charAt(b);
			b++;
			if(c1==c2) {
				char c3 = str1.charAt(i);
				char c4 = str2.charAt(b);
				if(c3==c4) {
					System.err.println("两幅手牌输入有相同"+c1+""+c3+":"+c2+""+c4);
					return false;
					
				}
			}
		}
	}
	
	
	
	return true;	
	}
}
//初始化扑克牌
	class Poker {
		public List<Integer> getCardSign(String cards) {

/////////////////////////////////////////////////////////////////		
			String str = "123456789TJQK";// 牌号
			String str1 = "BRMF"; // 花色
			
			char[] cy = cards.toCharArray();// 将输入的字符串转化为char数组
			// 将扑克牌转化为数组 吧花色和牌号提出来
			int[] hs1 = new int[5];
			int[] px1 = new int[5];
			char[] hs = new char[5]; // 花色数组
			char[] px = new char[5]; // 排序数组
			for (int i = 0, a = 1, x = 0; i < cy.length - 1;) {
				hs[x] = cy[i]; // 给花色数组赋值
				px[x] = cy[a]; // 给排序数组赋值
				i += 2;
				a += 2;
				x++;
			}
			for (int i = 0; i < px.length; i++) { // 将T J Q K 转化为计算条件
				int f = str.indexOf(px[i]);
				px1[i] = f + 1;
			}
			for (int i = 0; i < px.length; i++) { // 将花色转化为计算条件
				int f = str1.indexOf(hs[i]);
				hs1[i] = f + 1;
			}
			// 将扑克进行大小号排序;花色进行排序
			for (int i = 0; i < hs.length; i++) {
				for (int x = i + 1; x < hs.length; x++)
					if (px1[i] > px1[x]) {
						int b = px1[i];
						px1[i] = px1[x];
						px1[x] = b;
						int a = hs1[i];
						hs1[i] = hs1[x];
						hs1[x] = a;
					}
			}

			List<Integer> show = new bj().show(px1, hs1);
////////////////////////////////////////////////////////////////////////////////////		
			return show;

		}
		//实现目标1 逻辑码

		class bj {
			public List<Integer> show(int[] px, int[] hs) {

				List<Integer> list = new ArrayList<>();
				// 判断是否为同花顺/同花/顺子
				int f = 0;// 花色
				int p = 0; // 排序
				int q = 0;
//			int[] b = new int[4];
//			 b[0] 返回的是 最大值
//			 b[1] 返回牌面
//			 b[2] 返回相同大小下的牌面数字
//			 b[3] 花色
				for (int i = 0; i < px.length; i++) {
					if (hs[0] == hs[i]) {
						f++;
					} else {
						if (px[4] - px[3] == 1 && px[4] - px[2] == 2 && px[4] - px[1] == 3 && px[4] - px[0] == 4) {
							list.add(4);
							list.add(px[px.length - 1]);// 返回顺子的最大值
							list.add(hs[px.length - 1]);// 返回花色
							return list;
						} // 顺子

					}
					if (f == 5) {
						if (px[px.length - 1] - px[0] == 4) {
							list.add(8);
							list.add(px[px.length - 1]);// 返回同花顺的最大值
							list.add(hs[px.length - 1]);// 返回花色

							return list; // 同花顺
						} else {
							list.add(5);
							list.add(px[4]);// 返回同花的最大值
							list.add(px[3]);
							list.add(px[2]);
							list.add(px[1]);
							list.add(px[0]);
							list.add(hs[px.length - 1]);// 返回花色
							return list; // 同花
						}
					}
				}
				// 判断是否为四张 两对 三张 一对 单张
				for (int i = 0; i < px.length - 1; i++) {
					for (int y = i + 1; y < px.length; y++) {
						if (px[i] == px[y]) {
							p++;
						} else {
							q++;
						}
					}
				}
				if (p == 6 && q == 4) { // 4张
					if (px[1] == px[2]) {
						list.add(7);
						list.add(px[2]); // 单张最大值的下标

						return list;
					}
				}
				if (p == 0 && q == 10) { // 单张
					list.add(0); // 单张最大值下标
					list.add(px[4]);
					list.add(px[3]);
					list.add(px[2]);
					list.add(px[1]);
					list.add(px[0]);
					list.add(hs[4]);
					return list;
				}
				if (p == 1 && q == 9) { // 一对

					if (px[3] == px[4]) { // 后两个为一对
						list.add(1);
						list.add(px[3]); // 返回对的下标值
						list.add(px[2]);
						list.add(px[1]);
						list.add(px[0]);
						list.add(hs[3]);
						return list;
					} else if (px[2] == px[3]) {
						list.add(1);
						list.add(px[3]); // 返回对的下标值
						list.add(px[4]);
						list.add(px[1]);
						list.add(px[0]);
						list.add(hs[4]);
						return list;
					} else if (px[2] == px[1]) {
						list.add(1);
						list.add(px[2]); // 返回对的下标值
						list.add(px[4]);
						list.add(px[3]);
						list.add(px[0]);
						list.add(hs[4]);
						return list;
					} else if (px[1] == px[0]) {
						list.add(1);
						list.add(px[0]); // 返回对的下标值
						list.add(px[4]);
						list.add(px[3]);
						list.add(px[2]);
						list.add(hs[4]);
						return list;
					}
				}
				if (p == 2 && q == 8) { // 两对子

					if (px[0] == px[1] && px[2] == px[3]) {
						list.add(2);
						list.add(px[2]); // 前1,2 对子
						list.add(px[1]); // 后3，4 对子
						list.add(px[4]); // 单张下标
						list.add(hs[4]);
					} else if (px[1] == px[2] && px[3] == px[4]) {
						list.add(2);
						list.add(px[3]); // 后两个对子的返回值
						list.add(px[2]);// 中间对子的返回值
						list.add(px[0]); // 单张值的下标
						list.add(hs[0]);
						return list;
					} else if (px[0] == px[1] && px[3] == px[4]) {
						list.add(2);
						list.add(px[3]); // 中间对子的返回值
						list.add(px[1]); // 单张值的下标
						list.add(px[2]); // 后两个对子的返回值
						list.add(hs[2]);
						return list;
					}

				}
				if (p == 3 && q == 7) { // 三张
					list.add(3);
					list.add(2); // 返回第三张的的值
					return list;
				}
				if (p == 4 && q == 6) { // 满堂红
					list.add(6);
					list.add(2); // 返回三张的值
					return list;
				}
				return list;
			}
		}
	}
//实现目标2 逻辑码
class PK {
	public boolean compareCards(String cardsFirst, String cardsSecond) {

		Poker p1 = new Poker();
		Poker p2 = new Poker();
		List<Integer> c1 = p1.getCardSign(cardsFirst);
		List<Integer> c2 = p2.getCardSign(cardsSecond);
		// 不同情况先大小
		if (c1.get(0) != c2.get(0)) {
			if (c1.get(0) > c2.get(0)) {
				return true;
			} else {
				return false;
			}
		} // 判断相同情况下 单张的大小
		if (c1.get(0) == c2.get(0)) {
			if (c1.get(0) == 0) {
				if (c1.get(1) == c2.get(1)) {
					if (c1.get(2) == c2.get(2)) {
						if (c1.get(3) == c2.get(3)) {
							if (c1.get(4) == c2.get(4)) {
								if (c1.get(5) == c2.get(5)) {
									if (c1.get(6) < c2.get(6)) {
										return true;
									} else {
										return false;
									}

								} else {
									if (c1.get(5) > c2.get(5)) {
										return true;
									} else {
										return false;
									}
								}
							} else {
								if (c1.get(4) > c2.get(4)) {
									return true;
								} else {
									return false;
								}
							}
						} else {
							if (c1.get(3) > c2.get(3)) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						if (c1.get(2) > c2.get(2)) {
							return true;
						} else {
							return false;
						}

					}
				} else {
					if (c1.get(1) > c2.get(1)) {
						return true;
					} else {
						return false;
					}

				}
			}
			// 一对情况下判断
			if (c1.get(0) == 1) {
				if (c1.get(1) == c2.get(1)) {
					if (c1.get(2) == c2.get(2)) {
						if (c1.get(3) == c2.get(3)) {
							if (c1.get(4) == c2.get(4)) {
								if (c1.get(5) < c2.get(5)) {
									return true;
								} else {
									return false;
								}
							} else {
								if (c1.get(4) > c2.get(4)) {
									return true;
								} else {
									return false;
								}
							}
						} else {
							if (c1.get(3) > c2.get(3)) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						if (c1.get(2) > c2.get(2)) {
							return true;
						} else {
							return false;
						}
					}

				} else {
					if (c1.get(1) > c2.get(1)) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		// 两对情况下
		if(c1.get(0)==2) {
			if(c1.get(1)==c2.get(1)) {
				if(c1.get(2)==c2.get(2)) {
					if(c1.get(3)==c1.get(3)) {
						if(c1.get(4)<c2.get(4)) {
							return true;
						}else {
							return false;
						}
					}else {
						if(c1.get(3)>c2.get(3)) {
							return true;
						}else {
							return false;
						}
					}
				}else {
					if(c1.get(2)>c2.get(2)) {
						return true;
					}else {
						return false;
					}
				}
			}else {
				if(c1.get(1)>c2.get(1)) {
					return true;
				}else {
					return false;
				}
			}
		}
		//三张情况
		if(c1.get(0)==3) {
			if(c1.get(1)>c1.get(1)) {
				return true;
			}else {
				return false;
			}
		}
		//顺子
		if(c1.get(0)==4) {
			if(c1.get(1)==c2.get(1)) {
				if(c1.get(2)<c2.get(2)) {
					return true;
				}else {
					return false;
				}
			}else {
				if(c1.get(1)>c2.get(1)) {
					return true;
				}else {
					return false;
				}
			}
		}
		//同花
		if(c1.get(0)==5) {	
				if (c1.get(1) == c2.get(1)) {
					if (c1.get(2) == c2.get(2)) {
						if (c1.get(3) == c2.get(3)) {
							if (c1.get(4) == c2.get(4)) {
								if (c1.get(5) == c2.get(5)) {
									if (c1.get(6) < c2.get(6)) {
										return true;
									} else {
										return false;
									}

								} else {
									if (c1.get(5) > c2.get(5)) {
										return true;
									} else {
										return false;
									}
								}
							} else {
								if (c1.get(4) > c2.get(4)) {
									return true;
								} else {
									return false;
								}
							}
						} else {
							if (c1.get(3) > c2.get(3)) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						if (c1.get(2) > c2.get(2)) {
							return true;
						} else {
							return false;
						}

					}
				} else {
					if (c1.get(1) > c2.get(1)) {
						return true;
					} else {
						return false;
					}

				}
		}
		//满堂红
		if(c1.get(0)==6) {
			if(c1.get(1)>c2.get(1)) {
				return true;
			}else {
				return false;
			}
		}
		//四张
		if(c1.get(0)==7) {
			if(c1.get(1)>c2.get(1)) {
				return true;
			}else {
				return false;
			}
		}
		//同花顺
		if(c1.get(0)==8) {
			if(c1.get(1)==c2.get(1)) {
				if(c1.get(2)<c2.get(2)) {
					return true;
				}else {
					return false;
				}
			}else {
				if(c1.get(1)>c2.get(1)) {
					return true;
				}else {
					return false;
				}
			}
		}
		
		return false;
	}
}