package queue;

import java.util.Scanner;

public class CircleQueueDemo {

	public static void main(String[] args) {
		CircleArray aq = new CircleArray(4);
		
		char key = ' ' ;
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("s(show): show queue");
			System.out.println("e(exit): exit queue");
			System.out.println("a(add): add queue");
			System.out.println("g(get): get queue");
			System.out.println("h(head): queue head");
			
			key = scanner.next().charAt(0);
			
			switch(key) {
			case 's':
				aq.showQueue();
				break;
				
			case 'a':
				System.out.println("enter an int: ");
				int value = scanner.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try{
					int result = aq.getQueue();
					System.out.println("the result is "+ result);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try{
					int head = aq.showHead();
					System.out.println("the head is "+ head);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("end");
	}
}

class CircleArray{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}
	
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("the queue is full");
		}else {

			arr[rear] = n;
			rear = (rear + 1) % maxSize ;
		}

	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}

		int value = arr[front];
		front = (front + 1) % maxSize ;
		
		return value;
		
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("the queue is empty");
		}
		
		
		for(int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
		}
	}
	
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	public int showHead() {
		if(isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		return arr[front];
	}
	
}