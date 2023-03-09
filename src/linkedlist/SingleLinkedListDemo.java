package linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {

		HeroNode hero1 = new HeroNode(1, "song jiang", "ji shi yu");
		HeroNode hero2 = new HeroNode(5, "lu jin yi", "yu qi lin");
		HeroNode hero3 = new HeroNode(9, "wu yong", "zhi duo xing");
		HeroNode hero4 = new HeroNode(3, "lin chong", "bao zi tou");

		SingleLinkedList l = new SingleLinkedList();

		l.addByOrder(hero1);
		l.addByOrder(hero2);
		l.addByOrder(hero3);
		l.addByOrder(hero4);
		l.list();

//		reverseList(l.getHead());
//		l.list();
		reversePrint(l.getHead());
//		System.out.println("node number:" + getLength(l.getHead()));
//		HeroNode hero4_1 = new HeroNode(3,"xiao lin","bao zi");
//		l.update(hero4_1);
//		l.delete(9);
//		l.list();
//		System.out.println("node number:" + getLength(l.getHead()));
//		
//		System.out.println("last 2 node: "+findLastIndexNode(l.getHead(),2));
	}

	public static int getLength(HeroNode head) {

		if (head == null) {
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;

		while (cur != null) {
			length++;
			cur = cur.next;
		}

		return length;

	}

	public static HeroNode findLastIndexNode(HeroNode head, int index) {

		if (head.next == null) {
			return null;
		}
		int size = getLength(head);
		if (index <= 0 || index > size) {
			return null;
		}
		HeroNode cur = head.next;

		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;

	}

	// method 1: 反转单链表，但是破坏了原链表
	public static void reverseList(HeroNode head) {

		if (head.next == null || head.next.next == null) {
			return;
		}
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");

		while (cur != null) {

			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;

		}
		head.next = reverseHead.next;
	}

	// method 2：使用栈实现反转单链表
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;

		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}

	}
}

class SingleLinkedList {

	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	public void add(HeroNode node) {
		HeroNode temp = head;

		while (true) {
			if (temp.next == null) {
				break;

			} else {
				temp = temp.next;
			}
		}
		temp.next = node;
	}

	public void addByOrder(HeroNode node) {
		HeroNode temp = head;
		boolean flag = false;

		while (true) {
			if (temp.next == null) {
				break;

			}

			if (temp.next.no > node.no) {
				break;
			} else if (temp.next.no == node.no) {
				flag = true;

			}

			temp = temp.next;
		}
		if (flag) {
			System.out.println("the node exist.");
		} else {
			node.next = temp.next;
			temp.next = node;
		}
	}

	public void update(HeroNode newHeroNode) {
		HeroNode temp = head;
		boolean flag = false;

		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}

			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else {
			System.out.println("doesn't find the node");
		}
	}

	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false;

		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("doesn't find the node");
		}
	}

	public void list() {

		if (head.next == null) {
			System.out.println("list is empty");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}

	}

}

class HeroNode {

	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	public HeroNode(int hNo, String hName, String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickName = hNickname;

	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}