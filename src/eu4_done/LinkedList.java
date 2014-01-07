package eu4_done;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedList<E> implements Set<E>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2491681505586452698L;

	private class Node implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -1913301836074733030L;
		public Node nextNode;
		public E element;	

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
		Node newNode = null;
		for (E element : set)
		{
			newNode = new Node (element);
			newNode.nextNode = firstNode;
			firstNode = newNode;
		}
	}

	/**
	 * Lägger till argumentet i mängden.
	 * @return True
	 */
	@Override
	public boolean add(E element) 
	{
		if(!this.contains(element))
		{
			Node node = new Node(element);

			node.nextNode = firstNode;
		}
		return true;
	}

	/**
	 * Vandrar igenom listan och 'nollställer' den.
	 */
	@Override
	public void clear() 
	{
		Node currentNode = firstNode;
		Node nextNode;
		while (currentNode != null)
		{
			nextNode = currentNode.nextNode;
			currentNode.nextNode = null;
			currentNode.element = null;
			currentNode = nextNode;
		}
	}

	/**
	 * Går igenom mängden och kollar om elementet finns eller ej.
	 * @return Returnerar sant om elementet hittas annars false.
	 */
	@Override
	public boolean contains(Object element)
	{
		Node currentNode = firstNode;
		boolean elementIsInSet = false;
		while (currentNode != null)
		{
			if (element.equals(currentNode.element))
			{
				elementIsInSet = true;
				break;
			} else 
			{
				currentNode = currentNode.nextNode;
			}
		}
		return elementIsInSet;
	}

	/**
	 * Kollar om första noden är tom (då är hela mängden tom)
	 * @return Sant om mängden är tom annars falskt.
	 */
	@Override
	public boolean isEmpty() 
	{
		if(firstNode == null)
		{
			return true;
		}
		return false;
	}

	private class SetIterator implements Iterator<E>
	{
		private Node nextNode;

		private Node lastReturnedNode;

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
			if (!this.hasNext()) 
			{
				throw new NoSuchElementException("Finns inget element..");
			}

			E element = nextNode.element;
			lastReturnedNode = nextNode;
			nextNode = nextNode.nextNode;

			return element;
		}

		public void remove () throws IllegalStateException
		{
			if (lastReturnedNode == null) 
			{
				throw new IllegalStateException("Noden går inte att tas bort då den inte existerar..!");
			}

			LinkedList.this.remove (lastReturnedNode.element);

			lastReturnedNode = null;
		}
	}

	/**
	 * Skapar en ny iterator.
	 * @retun En ny iterator över mängden.
	 */
	@Override
	public Iterator<E> iterator() {
		return this. new SetIterator();
	}

	/**
	 * Går igenom mängden och räknar.
	 * @return Antalet object i den länkade listan.
	 */
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
	public boolean addAll(Collection<? extends E> c)
	{
		// Används ej
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) 
	{
		// Används ej
		return false;
	}

	@Override
	public boolean remove(Object o) 
	{
		// Används ej
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) 
	{
		// Används ej
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) 
	{
		// Används ej
		return false;
	}

	@Override
	public Object[] toArray()
	{
		// Används ej
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) 
	{
		// Används ej
		return null;
	}
}