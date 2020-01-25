/**
 *Some new comments.
 *
 * */
public class BST<K extends Comparable<K>, V> {
	private class Node {
		K key;
		V val;
		Node left;
		Node right;
		
		public Node(K key, V val){
			this.key = key;
			this.val = val;
		}
	}
	
	private Node root;

	public void put(K key, V val){
		root = put(root, key, val);
	}
	
	private Node put(Node x, K key, V val){
		
		if(x == null)
			return new Node(key, val);
		
		int cmp = key.compareTo(x.key);
		
		if(cmp < 0)
			x.left = put(x.left, key, val);
		else if(cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		return x;
			
	}
	
	public V get(K key){
		
		Node x = root;
		
		while(x != null){
			int cmp = key.compareTo(x.key);
			
			if(cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.val;
		}
		
		return null;
	}

	// distance b/w two nodes
	public int distance(K k1, K k2){
		
		if(root == null)
			return -1;
		else {
			return distance(root, k1, k2);
		}
	}
	
	private int distance(Node x, K k1, K k2){
		
		if(k1 == k2)
			return 0;
		int c1 = k1.compareTo(x.key);
		int c2 = k2.compareTo(x.key);
		
		if(c1 == 0 && c2 != 0)
			return distfromroot(x, k2);
		else if (c2 == 0 && c1 != 0)
			return distfromroot(x, k1);
		else if(c1 < 0 && c2 < 0)
			return distance(x.left, k1, k2);
		else if(c1 > 0 && c2 > 0)
			return distance(x.right, k1, k2);
		else 
			return distfromroot(x, k1) + distfromroot(x, k2);
			
	}
	
	/* distance of any node from root node */
	public int distfromroot(Node x, K key){
		int count = 0;
		
		while(x != null){
			int cmp = key.compareTo(x.key);
			
			if(cmp < 0) x = x.left;
			else if(cmp > 0) x = x.right;
			else
				break;
			count++;
		}
		
		return count;
	}
	
	
	static public void main(String[] args){
		BST<Integer, String> bst = new BST<>();
		bst.put(5, "Ram");
		bst.put(2, "Shyam");
		bst.put(12, "Akbar");
		bst.put(1, "Krishna");
		bst.put(3, "Kaveri");
		bst.put(9, "Vijay");
		bst.put(21, "Prakash");
		bst.put(19, "Muthu");
		bst.put(25, "Ramesh");
		
		System.out.println(bst.get(25));
		System.out.println(bst.distance(3, 9));
		System.out.println(bst.distance(9, 25));
		
	}
	
}
