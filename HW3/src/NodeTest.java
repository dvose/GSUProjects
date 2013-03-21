
public class NodeTest<E> {
	private E item;
	private NodeTest<E> next;
	public void setItem(E newItem){
		item = newItem;
	}
	public E getItem(){
		return item;
	}
	public void setNext(NodeTest<E> nextNode){
		next = nextNode;
	}
	public NodeTest<E> getNext(){
		return next;
	}
	public String toString(){
		return item.toString();
	}
	public static void main(String[] args) {
		NodeTest<Integer> n1 = new NodeTest<Integer>();
		NodeTest<Integer> n2 = new NodeTest<Integer>();
		n1.setItem(5);
		n2.setItem(7);
		n1.setNext(n2);
		System.out.println("Linked List: " + n1.getItem() + " -> " + n1.getNext().toString());

	}

}
