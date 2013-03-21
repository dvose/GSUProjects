
public class test {
	public static void main(String[] args) {
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		tree.insert(5);
		tree.insert(2);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.delete(7);
		System.out.println(tree.printTree());

		}

}
