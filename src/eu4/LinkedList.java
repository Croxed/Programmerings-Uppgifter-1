package eu4;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedList<E> implements Set<E>, Serializable {

	private class Node implements Serializable
	{
		public Node    nextNode;
		public E       element;	

		public Node (E element)
		{
			this.element = element;
			this.nextNode = null;
		}
	}

	private Node firstNode;

	public LinkedList()
	{
		firstNode = null;
	}

	public LinkedList(Set<E> set)
	{
		firstNode = null;
		Node    newNode = null;
		for (E element : set)
		{
			newNode = new Node (element);
			newNode.nextNode = firstNode;
			firstNode = newNode;
		}
	}

	// Lägger till elementet till mängden
	@Override
	public boolean add(E e) {
		if(!this.contains(e))
		{
			Node node = new Node(e);

			node.nextNode = firstNode;
		}

		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() 
	{
		Node    currentNode = firstNode;
		Node    nextNode;
		while (currentNode != null)
		{
			nextNode = currentNode.nextNode;
			currentNode.nextNode = null;
			currentNode.element = null;
			currentNode = nextNode;
		}
	}

	@Override
	public boolean contains(Object element) {
		Node    currentNode = firstNode;
		boolean    compareValue = false;
		boolean    elementIsInSet = false;
		while (currentNode != null)
		{
			compareValue = element.equals (currentNode.element);
			if (compareValue == true)  // elementet hittad
			{
				elementIsInSet = true;
				break;
			} else {
				currentNode = currentNode.nextNode;
			}
		}

		return elementIsInSet;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(firstNode == null)
		{
			return true;
		}
		return false;
	}

	private class SetIterator implements Iterator<E>
	{
		private Node    nextNode;

		private Node    lastReturnedNode;

		public SetIterator ()
		{
			nextNode = firstNode;
			lastReturnedNode = null;
		}

		public boolean hasNext ()
		{
			return nextNode != null;
		}

		public E next () throws NoSuchElementException
		{
			if (!this.hasNext ()) {
				throw new NoSuchElementException (
						"end of the iteration");
			}

			E    element = nextNode.element;
			lastReturnedNode = nextNode;
			nextNode = nextNode.nextNode;

			return element;
		}

		public void remove () throws IllegalStateException
		{
			if (lastReturnedNode == null) {
				throw new IllegalStateException (
						"Noden försökes tas bort men fanns inte! Illegalstate.");
			}

			LinkedList.this.remove (lastReturnedNode.element);

			lastReturnedNode = null;
		}
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return this. new SetIterator();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size ()
	{
		int     antalElement = 0;
		Node    currentNode = firstNode;
		while (currentNode != null)
		{
			antalElement++;
			currentNode = currentNode.nextNode;
		}
		return antalElement;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}