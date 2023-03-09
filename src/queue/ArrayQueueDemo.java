package queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue(3);

		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("s(show): show queue");
			System.out.println("e(exit): exit queue");
			System.out.println("a(add): add queue");
			System.out.println("g(get): get queue");
			System.out.println("h(head): queue head");

			key = scanner.next().charAt(0);

			switch (key) {
			case 's':
				aq.showQueue();
				break;

			case 'a':
				System.out.println("enter an int: ");
				int value = scanner.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try {
					int result = aq.getQueue();
					System.out.println("the result is " + result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int head = aq.showHead();
					System.out.println("the head is " + head);
				} catch (Exception e) {
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

class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int arrMaxSize) {

		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1; // 指向队列头
		rear = -1; // 指向队列尾
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("the queue is full");
		} else {
			rear++;
			arr[rear] = n;
		}

	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		front++;
		return arr[front];

	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("the queue is empty");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	public int showHead() {
		if (isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		return arr[front + 1];
	}

}