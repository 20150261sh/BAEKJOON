public class BSTree {
	Node root;

	BSTree() {
		this.root = null;
	}

	boolean search(int find) {
		Node cur = root;

		while (cur != null) {
			if (cur.getData() == find)
				return true;
			else if (cur.getData() > find)
				cur = cur.getLeft();
			else
				cur = cur.getRight();
		}
		return false;
	}

	void insert(int item) {
		Node input = new Node(item);
		if (root == null) {
			root = input;
			return;
		}

		if (search(item))
			return;

		Node par = null;
		Node cur = root;
		while (true) {
			par = cur;
			if (cur.getData() > item) {
				cur = cur.getLeft();
				if (cur == null) {
					par.setLeft(input);
					return;
				}
			} else {
				cur = cur.getRight();
				if (cur == null) {
					par.setRight(input);
					return;
				}
			}
		}
	}

	void delete(int item) {
		if (!search(item))
			return;

		boolean isLeftChild = false;
		Node par = null;
		Node cur = root;
		while (true) {
			if (cur.getData() == item)
				break;
			par = cur;
			if (cur.getData() > item) {
				cur = cur.getLeft();
				isLeftChild = true;
			} else {
				cur = cur.getRight();
				isLeftChild = false;
			}
			if (cur == null)
				return;
		}

		// 1. 삭제할 노드가 단말 노드인 경우
		if (cur.getLeft() == null || cur.getRight() == null) {
			if (cur == root)
				root = null;
			if (isLeftChild)
				par.setLeft(null);
			else
				par.setRight(null);
		}
		// 2. 삭제할 노드가 한 개의 서브트리를 가지는 경우
		else if (cur.getRight() == null) {
			if (cur == root)
				root = cur.getLeft();
			else if (isLeftChild)
				par.setLeft(cur.getLeft());
			else if (!isLeftChild)
				par.setRight(cur.getLeft());
		} else if (cur.getLeft() == null) {
			if (cur == root)
				root = cur.getRight();
			else if (isLeftChild)
				par.setLeft(cur.getRight());
			else if (!isLeftChild)
				par.setRight(cur.getRight());
		}
		// 3. 삭제할 노드가 두 개의 서브트리를 가지는 경우
		else if (cur.getLeft() != null && cur.getRight() != null) {
			Node sub = getSub(cur);
			if (cur == root)
				root = sub;
			else if (isLeftChild)
				par.setLeft(sub);
			else
				par.setRight(sub);
			sub.setLeft(cur.getLeft());
		}
	}

	Node getSub(Node del) {
		Node sub = null;
		Node subpar = null;
		Node cur = del.getRight();

		while (cur != null) {
			subpar = sub;
			sub = cur;
			cur = cur.getLeft();
		}

		if (del.getRight() != sub) {
			subpar.setLeft(sub.getRight());
			sub.setRight(del.getRight());
		}
		return sub;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {
	private int data;
	private Node left;
	private Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	int getData() {
		return data;
	}

	void setData(int data) {
		this.data = data;
	}

	Node getLeft() {
		return this.left;
	}

	void setLeft(Node left) {
		this.left = left;
	}

	Node getRight() {
		return this.right;
	}

	void setRight(Node right) {
		this.right = right;
	}
}