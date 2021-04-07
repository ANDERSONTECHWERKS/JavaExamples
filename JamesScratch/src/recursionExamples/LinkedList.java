package recursionExamples;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class LinkedList<T extends Comparable<T>>{
	private class Node {
		private T data;
		private Node next;
		
		private Node(T Data) {
			this.data = Data;
			next = null;
		}
	}
	
	private Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public LinkedList(TreeSet<T> tree) {
		
		for(T currT : tree) {
			this.add(currT);
		}
	}
	
	public void add(T data) {

		Node newNode = new Node(data);
		
		if(this.head == null) {
			this.head = newNode;
		} else {

			int compareValue = data.compareTo(head.data);
			
			if(compareValue == 0) {
				newNode.next = head;
				this.head = newNode;
			}
			
			if(compareValue < 0) {
				newNode.next = head;
				this.head = newNode;
			}
			
			if(compareValue > 0) {
				Node prev = this.head;
				Node curr = this.head.next;

				while(curr != null) {
					int compareValue2 = data.compareTo(curr.data);

					
					if(compareValue2 == 0) {
						prev.next = newNode;
						newNode.next = curr;
						break;
					}
					
					if(compareValue2 < 0) {
						prev.next = newNode;
						newNode.next = curr;
						break;
					}

					prev = curr;
					curr = curr.next;

				}
			}
		}
	}
	
	public int size() {
		if(this.head == null) {
			return 0;
		} else {
			return sizeHelper(head);
		}
	}
	
	private int sizeHelper(Node localRoot) {
		if(localRoot.next == null) {
			return 1;
		} else {
			return 1 + sizeHelper(localRoot.next);
		}
	}
	
	public HashSet<T> inRange(T lowerBound, T upperBound){
		HashSet<T> retHashSet = new HashSet<T>();
		
		inRangeHelper(retHashSet, head, lowerBound, upperBound);
		return retHashSet;
	}
	
	private void inRangeHelper(HashSet<T> hashSet, Node localHead, T lowerBound, T upperBound) {
		if(localHead == null) {
			return;
		}
		
		int compareValUpper = localHead.data.compareTo(upperBound);
 		int compareValLower = localHead.data.compareTo(lowerBound);

		if((compareValUpper < 0 && compareValLower > 0) || compareValUpper == 0 || compareValLower == 0) {
			hashSet.add(localHead.data);
		}
		
		inRangeHelper(hashSet,localHead.next, lowerBound,upperBound);
	}
	public void remove(T target) {
		removeHelper(target, head, null);
	}
	
	private void removeHelper(T target, Node localHead, Node localPrev) {
		if(localHead == null) {
			return;
		}
		
		
		//General case. Handles finding target node mid-list.
		if(localHead.data.compareTo(target)==0) {
			
			//Case where the next node is our target data, and the node after that is null. Special!

			if(localHead.next == null) {
				localPrev.next = null;
				return;
			}

			localHead.data = localHead.next.data;
			localHead.next = localHead.next.next;
		}
		
		removeHelper(target,localHead.next, localHead);
	}
	
	public TreeMap<T,Integer> positionOfElementInList(){
		TreeMap<T,Integer> retTreeMap = new TreeMap<T,Integer>();

		positionOfElementInListHelper(head,0,retTreeMap);

		return retTreeMap;
	}
	
	private void positionOfElementInListHelper(Node localHead, int pos,TreeMap<T, Integer> retTreeMap) {
		if(localHead == null) {
			return;
		}
		
		retTreeMap.put(localHead.data, pos);
		positionOfElementInListHelper(localHead.next, pos++, retTreeMap);
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof LinkedList<?>)) {
			return false;
		}
		LinkedList<T> thatList = (LinkedList<T>)obj;

		int thisSize = this.size();
		int thatSize = thatList.size();		

		if(thisSize == thatSize) {
			Node curr = head;
			Node prev = null;
			
			return equalsHelper(this.head,thatList.head);
		}


		return false;
	}
	
	private boolean equalsHelper(Node head1, Node head2) {
		if(head1 == null && head2 == null) {
			return true;
		}
		
		if(head1.data.compareTo(head2.data) == 0) {
			equalsHelper(head1.next,head2.next);
		}

		return false;
	}
}
