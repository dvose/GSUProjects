/*
 * Name: Dustin Vose
 * CSC3410 - Fall 2012
 * DateDue: 12-03-12  
 * Assignment:  HW5
 * File:  	RedBlackTree.java
 * 
 * Purpose: Creates a Red Black Tree that self-balances with each insertion/deletion.   
 * 	
 * Solution, algorithms and data structures:   
 * 			Date Structures: Red Black Tree, Nodes
 * 
 *          Nodes were generated using the Node class in the Node.java file. Nodes act as containers of
 *          the elements inside the tree. 
 *          
 *          Red Black rules were tested after each insertion and deletion case by recursing through each case.
 *          
 *          Helper methods were added to the insert and delete methods to recurse through the tree.
 *          
 * Major classes:  Node.java is used to create the Nodes of the Tree, 
 * test.java is used to test inserting, deleting, and balancing of the Tree.  
 * 
 * Use, I/O expected:  
 * 			Inputs: The user is not prompted to enter input in the console. To change input, the user 
 * 			must enter different parameters in the test.java class
 * 			
 * 			Outputs: printList prints the Tree's elements to console inorder with the printtree method
 */
public class RedBlackTree<E extends Comparable<? super E>> {
	private Node<E> root;
	//Constructor
	//Provided:  Sets up an empty tree
	public RedBlackTree() {
		root = null;
	}

	// Insertion starts with binary insertion of a new red node and then adjusting the tree to make sure none of the rules are violated
	// Adjustments are handled by the insert case methods, as the rules are threatened only under certain conditions.
	// These conditions are discussed in detail below
	// The insertion cases start with the node we are currently inserting
	// but they can recursively apply to other nodes up the tree.
	public void insert(E e){
		//if e is null, prints error
		if(e == null){
			System.err.println("ERROR: can not insert null pointer");
			return;
		}//end if
		Node<E> addNode = new Node<E>(e);
		if(root != null){
			//compares if the element e is < then the root 
			if(e.compareTo(root.getElement()) == -1){
				if(root.hasLeft()){
					insert(root.getLeft(), e);//calls an override insert method that can recurse through the levels of the tree  
				}//end if
				else{
					root.setLeft(addNode);
					addNode.setParent(root);
					//System.out.println("root L child: " + addNode.getElement());//debug
				}//end else
			}//end if
			
			//if the element e is > or = to root, duplicates default to the right  
			else{
				if(root.hasRight()){
					insert(root.getRight(), e);
				}//end if
				else{
					root.setRight(addNode);
					addNode.setParent(root);
					//System.out.println("root R child: " + addNode.getElement());//debug
				}//end else
			}//end else
		}//end if	
		else{
			root = addNode; //root DNE, the new node is now the root 
			//System.out.println("root: " + root.getElement());//debug
		}//end else
		
		//checks Red Black Tree rules
		insertCase1(addNode);
	}//end insert
	
	private void insert(Node<E> current, E e){
		Node<E> addNode = new Node<E>(e);
		if(e.compareTo(current.getElement()) == -1){
			if(current.hasLeft()){
				insert(current.getLeft(), e);
			}//end if
			else{
				current.setLeft(addNode);
				addNode.setParent(current);
				//System.out.println(current.getElement() + " L child: " + addNode.getElement());//debug
			}//end else
		}//end if
		else{
			if(current.hasRight()){
				insert(current.getRight(), e);
			}//end if
			else{
				current.setRight(addNode);
				addNode.setParent(current);
				//System.out.println(current.getElement() + " R child: " + addNode.getElement());//debug
			}//end else
		}//end else
		
		//checks Red Black Tree rules
		insertCase1(addNode);
	}//end insert
	
	public E delete(E e) {
		if(root == null){
			return null;
		}//end if
		else{
			return delete(root, e);
		}//end else
	}//end delete
	
	private E delete(Node<E> n, E e){
		if(n.getElement().equals(e)){
			//System.out.println("equals");
			if(n.getLeft() != null && n.getRight() != null){
				return twoChildrenDeletion(n);
			}//end if
			else if (n.getLeft() != null || n.getRight() != null){
				return oneChildDeletion(n);
			}//end else if
			else{
				return noChildrenDeletion(n);
			}//end else
		}//end if
		//if e is < n element, recurse through left subtree
		else if(n.getElement().compareTo(e) > 0){
			return delete(n.getLeft(), e);
		}//end else if
		//if e is > n element, recurse through right subtree
		else{
			return delete(n.getRight(), e);
		}//end else
	}//end delete
	
	
	private E noChildrenDeletion(Node<E> n){
		Node<E> p = n.getParent();
		//if p is null, then n is the root. To delete n, set root to null
		if(p == null){
			root = null;
			return n.getElement();
			
		}//end if
		if(p.getElement().compareTo(n.getElement()) > 0){
			p.setLeft(null);
			deleteCase1(n);
			return n.getElement();
		}//end if
		else{
			p.setRight(null);
			deleteCase1(n);
			return n.getElement();
		}//end else
	}//end noChildrenDelete
	
	private E oneChildDeletion(Node<E> n){
		Node<E> p = n.getParent();
		//if parent is null, then n is the root. Set root to n's child
		if(p == null){
			if(n.getLeft() != null){
				root = n.getLeft();
				deleteCase1(n);
				return n.getElement();
			}//end if
			else{
				root = n.getRight();
				deleteCase1(n);
				return n.getElement();
			}//end else
		}//end if
		if(p.getLeft() == n){
			if(n.getLeft() != null){
				n.getLeft().setParent(p);
				p.setLeft(n.getLeft());
				deleteCase1(n);
				return n.getElement();
			}//end if
			else{
				n.getRight().setParent(p);
				p.setLeft(n.getRight());
				deleteCase1(n);
				return n.getElement();
			}//end else
		}//end if
		else{
			if(n.getLeft() != null){
				n.getLeft().setParent(p);
				p.setRight(n.getLeft());
				deleteCase1(n);
				return n.getElement();
			}//end if
			else{
				n.getRight().setParent(p);
				p.setRight(n.getRight());
				deleteCase1(n);
				return n.getElement();
			}//end else
		}//end else
	}//end oneChildDeletion
	
	private E twoChildrenDeletion(Node<E> n){
		E nElement = n.getElement();
		Node<E> NGS = n.getRight().getLeft(); //next greater successor 
		if(NGS != null){
			while(NGS.getLeft() != null){
				NGS = NGS.getLeft();
			}//end while
		}//end if
		else{
			NGS = n.getRight();
		}//end else
		n.setElement(NGS.getElement());
		NGS.setElement(nElement);
		if(NGS.getRight() == null){
			NGS.getParent().setRight(null);
			NGS = null;
			deleteCase1(n);
			return nElement;
		}//end if
		else{
			NGS.getParent().setLeft(NGS.getRight());
			NGS.getRight().setParent(NGS.getParent());
			NGS = null;
			deleteCase1(n);
			return nElement;
		}
	}//end twoChildrenDeletion

	
	/* http://en.wikipedia.org/wiki/Tree_rotation
	 * uses the steps found on the wiki page above to rotate the tree 
	 */
	private void rotateRight(Node<E> n) {
		Node<E> nChild = n.getLeft();
		nChild.setParent(n.getParent());
		if(n.getParent() != null && n.getParent().getRight() == n){
			n.getParent().setRight(nChild);
		}//end if	
		else if(n.getParent() != null && n.getParent().getLeft() == n){
			n.getParent().setLeft(nChild);
		}
		n.setLeft(nChild.getRight());
		nChild.setRight(n);
		n.setParent(nChild);
		if(n == root){
			root = nChild;
			nChild.setParent(null);
		}//end if
	}//end rotateRight
	
	/* http://en.wikipedia.org/wiki/Tree_rotation
	 * uses the steps found on the wiki page above to rotate the tree 
	 */
	private void rotateLeft(Node<E> n) {
		Node<E> nChild = n.getRight();
		nChild.setParent(n.getParent());
		if(n.getParent() != null && n.getParent().getRight() == n){
			n.getParent().setRight(nChild);
		}//end if	
		else if(n.getParent() != null && n.getParent().getLeft() == n){
			n.getParent().setLeft(nChild);
		}//end else if
		n.setRight(nChild.getLeft());
		nChild.setLeft(n);
		n.setParent(nChild);
		if(n == root){
			root = nChild;
			nChild.setParent(null);
		}//end if
	}//end rotateLeft
	
	
	
	//On insertion: 
	/*
	 * Rules 1 and 3 describe the tree and thus are always true
	 * Rule 2 (root is black) can only be broken by when a red node becomes the root
	 * Rule 4 (red nodes only have black children) can be violated by adding a red node, changing a black node to a red node, and by rotating the tree
	 * Rule 5 (all paths from x to it's leaves have same number of black nodes) is only compromised by adding black node, switching a red to a black, and rotation
	 * 
	 * All the cases below concern adding the the red node n to the tree
	 */
	
	
	// Your first case check to see if the node is the root
	// A node is the root if it has no parent.
	// if your node is root, then we've gone all the way to the top 
	// and the only thing left is to make sure the root is black	
	// else the node is not the root, so we need to do more checks
	private void insertCase1(Node<E> n) {
		if(n.getParent() == null){
			n.setBlack();
		}//end if	
		else
			insertCase2(n);
	}//end InsertCase1

	
	// If our parent is black, then we're good
	// as black nodes can have red children
	// Otherwise, our parent must be red, which is a problem
	private void insertCase2(Node<E> n) {
		if(n.getParent().isRed()){
			insertCase3(n);
		}//end if
	}//end insertCase2

	// Okay, our parent is red and so our we.  Reds can't have red children
	// If I change to black, I change the number of black nodes in paths for my area, so that's not good. We can't do that.
	// So what to do?
	// If my parent is red and so is my uncle, 
	//	we can change them to black and my grandparent to red.
	// Because they both change to black, then the number black nodes from my grandparent down is consistent. 
	// However, because I changed my grandparent to red, we may have changed the root to red or changed the child of a red node to red
	// So we have to start over the cases with the grandparent as n
	// But if my uncle isn't red, we have to try something else
	private void insertCase3(Node<E> n) {
		if(n.getUncle()!= null && n.getUncle().isRed()){
			n.getUncle().setBlack();
			n.getParent().setBlack();
			n.getGrandparent().setRed();
			insertCase1(n.getGrandparent());
		}//end if
		else{
			insertCase4(n);
		}//end else
	}//end insertCase3
	
	// Something else is rotating around my parent and recoloring
	// Which rotation is accomplished depends on which child is being rotated.
	// Then go to case 5
	private void insertCase4(Node<E> n) {
		Node<E> g = n.getGrandparent();
		if(n == n.getParent().getRight() && n.getParent() == g.getLeft()){
			rotateLeft(n.getParent());
			n = n.getLeft();
		}//end if
		else if(n == n.getParent().getLeft() && n.getParent() == g.getRight()){
			rotateRight(n.getParent());
			n = n.getRight();
		}//end if
		insertCase5(n);
	}//end insertCase4
	
	// More rotation and we're done
	private void insertCase5(Node<E> n) {
		Node<E> g = n.getGrandparent();
		n.getParent().setBlack();
		g.setRed();
		if(n == n.getParent().getLeft()){
			rotateRight(g);
		}//end if
		else{
			rotateLeft(g);
		}//end else
	}//end insertCase5
	
	

	private void deleteCase1(Node<E> n) {
		if(n.getParent() != null){
			deleteCase2(n);
		}//end if
	}//deleteCase 1

	private void deleteCase2(Node<E> n) {
		Node<E> s = n.getSibling();
		if(s != null && s.isRed()){
			s.setBlack();
			n.getParent().setRed();
			if(n == n.getParent().getLeft()){
				rotateLeft(n.getParent());
			}//end if
			else{
				rotateRight(n.getParent());
			}//end else
		}//end if
		deleteCase3(n);
	}//end deleteCase2

	private void deleteCase3(Node<E> n) {
		Node<E> s = n.getSibling();
		if(s != null && s.getLeft() != null && s.getRight() != null && n.getParent().isBlack() && s.isBlack() && s.getLeft().isBlack() && s.getRight().isBlack()){
			s.setRed();
			deleteCase1(n.getParent());
		}//end if
		else{
			deleteCase4(n);
		}//end else
	}//end deleteCase3

	private void deleteCase4(Node<E> n) {
		Node<E> s = n.getSibling();
		if(s != null && s.getLeft() != null & s.getRight() != null && n.getParent().isRed() && s.isBlack() && s.getLeft().isBlack() && s.getRight().isBlack()){
			s.setRed();
			n.getParent().setBlack();
		}//end if
		else{
			deleteCase5(n);
		}//end else
	}//end deleteCase4

	private void deleteCase5(Node<E> n) {
		Node<E> s = n.getSibling();
		if(s != null && s.getLeft() != null && s.getRight() != null && n == n.getParent().getLeft() && s.getLeft().isRed() && s.getRight().isBlack()){
			s.setRed();
			s.getLeft().setBlack();
			rotateRight(s);
		}//end if
		else if(s != null && s.getLeft() != null && s.getRight() != null && n == n.getParent().getRight() && s.getRight().isRed() && s.getLeft().isBlack()){
			s.setRed();
			s.getRight().setBlack();
			rotateLeft(s);
		}//end else if
		deleteCase6(n);
	}//end deleteCase5

	private void deleteCase6(Node<E> n) {
		Node<E> s = n.getSibling();
		if(s != null){
			if(n.getParent().isBlack()){
				s.setBlack();
			}//end if
			else{
				s.setRed();
			}//end else
			n.getParent().setBlack();
			if(n == n.getParent().getLeft()){
				rotateLeft(n.getParent());
			}//end if
			else{
				if(s.getLeft() != null){
					s.getLeft().setBlack();
				}//end if
				rotateRight(n.getParent());
			}//end else
		}//end null check
	}//end deleteCase6

public String printTree(){
	//System.out.println("root: " + root.getElement());//debug
	return printTree(root);
}//end printTree	
public String printTree(Node<E> pivot){
	if(pivot == null){
		return " ";
	}//end if
	return printTree(pivot.getLeft()) + pivot.getElement().toString() //+" Black? " +pivot.isBlack()//debug
			+ printTree(pivot.getRight());
}//end printTree

}//end RedBlackTreeClass