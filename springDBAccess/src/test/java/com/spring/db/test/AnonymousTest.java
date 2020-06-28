package com.spring.db.test;

public class AnonymousTest {

	public static void main(String[] args) {
		//���1.
		//�������̽��� �������迡 �ִ� Ŭ���� ��ü�� ����
		Car c = new Sonata();
		c.run();
		
		//���2.
		//��� Ŭ������ ���� ������ �ʰ� �ѹ��� ����ϱ����� �͸�Ŭ������ Ȱ���ߴ�
		//�͸�Ŭ������ Ŭ������ �����ϱⰡ �ָ��Ҷ� �ѹ��� ����ϰ��� �Ҷ� �������̽� Ÿ���� ��ü�� �����ϰڴٰ� �����ְ� ��ü�ȿ��� �޼ҵ带 �������̵� ���ش�
		//������ �������̵��� �ؾ� �ϱ⶧���� ���Ǹ� ������� �����ϰԵȴ�
		Car ferrai = new Car() {

			@Override
			public void run() {
				System.out.println("��󸮴� �߽� �޸���");
				
			}
			
		};
		ferrai.run();
		
		
		//���3.
		new Car() {

			@Override
			public void run() {
				System.out.println("�������� �˲� �޸��ϴ�");
				
			}
			
		}.run();
		
		
		//���4. 
		//lambda�� ����: �������̽� �ȿ� �߻�޼��尡 �� �ϳ��� ��쿡�� ����!
		//���ٽ�: �������̽��� �߻�޼��尡 �� �ϳ��ۿ� ������ ��밡���ϴ�
		Car morning = () -> {System.out.println("����� �ʻʻ� �޸��ϴ�.");};
		morning.run();
		
		
		///////////////////////////////////////////////////////////////////////
		//���� �������̽��� ���ٽ�
		Calculator sharp = new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("�������� ����!");
				return (n1 + n2);
			}
		};
		
		
		System.out.println("===============");
		System.out.println(sharp.add(10, 15));
		
		
		
		//���ٽ� ����
		Calculator cal = (n1, n2) -> {
			System.out.println("������ ����!");
			return n1 + n2;
		};
		System.out.println(cal.add(100, 200));
		
		
		//���ϸ� �Ϸ��� ��� ��ȣ�� ���������ϴ�
		Calculator c2 = (x,y) -> x + y;
		System.out.println("�����:" + c2.add(10, 20));
		
		
		
	}

}
