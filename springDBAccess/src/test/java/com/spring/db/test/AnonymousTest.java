package com.spring.db.test;

public class AnonymousTest {

	public static void main(String[] args) {
		//방법1.
		//인터페이스와 구현관계에 있는 클래스 객체를 선언
		Car c = new Sonata();
		c.run();
		
		//방법2.
		//페라리 클래스를 새로 만들지 않고 한번만 사용하기위해 익명클래스를 활용했다
		//익명클래스는 클래스를 생성하기가 애매할때 한번만 사용하고자 할때 인터페이스 타입의 객체를 생성하겠다고 말해주고 객체안에서 메소드를 오버라이딩 해준다
		//강제로 오버라이딩을 해야 하기때문에 부피를 어느정도 차지하게된다
		Car ferrai = new Car() {

			@Override
			public void run() {
				System.out.println("페라리는 쌩쌩 달린다");
				
			}
			
		};
		ferrai.run();
		
		
		//방법3.
		new Car() {

			@Override
			public void run() {
				System.out.println("포르쉐는 꽉꽉 달립니다");
				
			}
			
		}.run();
		
		
		//방법4. 
		//lambda식 적용: 인터페이스 안에 추상메서드가 단 하나일 경우에만 가능!
		//람다식: 인터페이스의 추상메서드가 단 하나밖에 없을때 사용가능하다
		Car morning = () -> {System.out.println("모닝이 뽈뽈뽈 달립니다.");};
		morning.run();
		
		
		///////////////////////////////////////////////////////////////////////
		//계산기 인터페이스와 람다식
		Calculator sharp = new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("사프계산기 덧셈!");
				return (n1 + n2);
			}
		};
		
		
		System.out.println("===============");
		System.out.println(sharp.add(10, 15));
		
		
		
		//람다식 적용
		Calculator cal = (n1, n2) -> {
			System.out.println("계산기의 덧심!");
			return n1 + n2;
		};
		System.out.println(cal.add(100, 200));
		
		
		//리턴만 하려는 경우 괄호는 생략가능하다
		Calculator c2 = (x,y) -> x + y;
		System.out.println("계산결과:" + c2.add(10, 20));
		
		
		
	}

}
