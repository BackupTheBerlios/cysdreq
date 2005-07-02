/*
 * Created on 02/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PersistentArrayList implements List, Cloneable, java.io.Serializable {

	private ArrayList wrappedArrayList;

	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public PersistentArrayList() {
		super();
		wrappedArrayList = new ArrayList();
	}

	/**
	 * Constructs an empty list with the specified initial capacity.
	 *
	 * @param   initialCapacity   the initial capacity of the list.
	 * @exception IllegalArgumentException if the specified initial capacity
	 *            is negative
	 */
	public PersistentArrayList(int initialCapacity) {
		super();
		wrappedArrayList = new ArrayList(initialCapacity);
	}

	/**
	 * Constructs a list containing the elements of the specified
	 * collection, in the order they are returned by the collection's
	 * iterator.  The <tt>ArrayList</tt> instance has an initial capacity of
	 * 110% the size of the specified collection.
	 *
	 * @param c the collection whose elements are to be placed into this list.
	 * @throws NullPointerException if the specified collection is null.
	 */
	public PersistentArrayList(Collection c) {
		super();
		wrappedArrayList = new ArrayList(c);
	}

	/**
	 * Trims the capacity of this <tt>ArrayList</tt> instance to be the
	 * list's current size.  An application can use this operation to minimize
	 * the storage of an <tt>ArrayList</tt> instance.
	 */
	public void trimToSize() {
		wrappedArrayList.trimToSize();
	}

	/**
	 * Increases the capacity of this <tt>ArrayList</tt> instance, if
	 * necessary, to ensure  that it can hold at least the number of elements
	 * specified by the minimum capacity argument. 
	 *
	 * @param   minCapacity   the desired minimum capacity.
	 */
	public void ensureCapacity(int minCapacity) {
		wrappedArrayList.ensureCapacity(minCapacity);
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return  the number of elements in this list.
	 */
	public int size() {
		return wrappedArrayList.size();
	}

	/**
	 * Tests if this list has no elements.
	 *
	 * @return  <tt>true</tt> if this list has no elements;
	 *          <tt>false</tt> otherwise.
	 */
	public boolean isEmpty() {
		return wrappedArrayList.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 *
	 * @param elem element whose presence in this List is to be tested.
	 * @return  <code>true</code> if the specified element is present;
	 *		<code>false</code> otherwise.
	 */
	public boolean contains(Object elem) {
		return wrappedArrayList.contains(elem);
	}

	/**
	 * Searches for the first occurence of the given argument, testing 
	 * for equality using the <tt>equals</tt> method. 
	 *
	 * @param   elem   an object.
	 * @return  the index of the first occurrence of the argument in this
	 *          list; returns <tt>-1</tt> if the object is not found.
	 * @see     Object#equals(Object)
	 */
	public int indexOf(Object elem) {
		return wrappedArrayList.indexOf(elem);
	}

	/**
	 * Returns the index of the last occurrence of the specified object in
	 * this list.
	 *
	 * @param   elem   the desired element.
	 * @return  the index of the last occurrence of the specified object in
	 *          this list; returns -1 if the object is not found.
	 */
	public int lastIndexOf(Object elem) {
		return wrappedArrayList.lastIndexOf(elem);
	}

	/**
	 * Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The
	 * elements themselves are not copied.)
	 *
	 * @return  a clone of this <tt>ArrayList</tt> instance.
	 */
	public Object clone() {
		PersistentArrayList v = new PersistentArrayList(this.size());
		v.wrappedArrayList = (ArrayList) this.wrappedArrayList.clone();
		return v;
	}

	/**
	 * Returns an array containing all of the elements in this list
	 * in the correct order.
	 *
	 * @return an array containing all of the elements in this list
	 * 	       in the correct order.
	 */
	public Object[] toArray() {
		return wrappedArrayList.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this list in the
	 * correct order; the runtime type of the returned array is that of the
	 * specified array.  If the list fits in the specified array, it is
	 * returned therein.  Otherwise, a new array is allocated with the runtime
	 * type of the specified array and the size of this list.<p>
	 *
	 * If the list fits in the specified array with room to spare (i.e., the
	 * array has more elements than the list), the element in the array
	 * immediately following the end of the collection is set to
	 * <tt>null</tt>.  This is useful in determining the length of the list
	 * <i>only</i> if the caller knows that the list does not contain any
	 * <tt>null</tt> elements.
	 *
	 * @param a the array into which the elements of the list are to
	 *		be stored, if it is big enough; otherwise, a new array of the
	 * 		same runtime type is allocated for this purpose.
	 * @return an array containing the elements of the list.
	 * @throws ArrayStoreException if the runtime type of a is not a supertype
	 *         of the runtime type of every element in this list.
	 */
	public Object[] toArray(Object a[]) {
		return wrappedArrayList.toArray(a);
	}

	// Positional Access Operations

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param  index index of element to return.
	 * @return the element at the specified position in this list.
	 * @throws    IndexOutOfBoundsException if index is out of range <tt>(index
	 * 		  &lt; 0 || index &gt;= size())</tt>.
	 */
	public Object get(int index) {
		return wrappedArrayList.get(index);
	}

	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 *
	 * @param index index of element to replace.
	 * @param element element to be stored at the specified position.
	 * @return the element previously at the specified position.
	 * @throws    IndexOutOfBoundsException if index out of range
	 *		  <tt>(index &lt; 0 || index &gt;= size())</tt>.
	 */
	public Object set(int index, Object element) {
		return wrappedArrayList.set(index, element);
	}

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param o element to be appended to this list.
	 * @return <tt>true</tt> (as per the general contract of Collection.add).
	 */
	public boolean add(Object o) {
		return wrappedArrayList.add(o);
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * list. Shifts the element currently at that position (if any) and
	 * any subsequent elements to the right (adds one to their indices).
	 *
	 * @param index index at which the specified element is to be inserted.
	 * @param element element to be inserted.
	 * @throws    IndexOutOfBoundsException if index is out of range
	 *		  <tt>(index &lt; 0 || index &gt; size())</tt>.
	 */
	public void add(int index, Object element) {
		wrappedArrayList.add(index, element);
	}

	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices).
	 *
	 * @param index the index of the element to removed.
	 * @return the element that was removed from the list.
	 * @throws    IndexOutOfBoundsException if index out of range <tt>(index
	 * 		  &lt; 0 || index &gt;= size())</tt>.
	 */
	public Object remove(int index) {
		return wrappedArrayList.remove(index);
	}

	/**
	 * Removes all of the elements from this list.  The list will
	 * be empty after this call returns.
	 */
	public void clear() {
		wrappedArrayList.clear();
	}

	/**
	 * Appends all of the elements in the specified Collection to the end of
	 * this list, in the order that they are returned by the
	 * specified Collection's Iterator.  The behavior of this operation is
	 * undefined if the specified Collection is modified while the operation
	 * is in progress.  (This implies that the behavior of this call is
	 * undefined if the specified Collection is this list, and this
	 * list is nonempty.)
	 *
	 * @param c the elements to be inserted into this list.
	 * @return <tt>true</tt> if this list changed as a result of the call.
	 * @throws    NullPointerException if the specified collection is null.
	 */
	public boolean addAll(Collection c) {
		return wrappedArrayList.addAll(c);
	}

	/**
	 * Inserts all of the elements in the specified Collection into this
	 * list, starting at the specified position.  Shifts the element
	 * currently at that position (if any) and any subsequent elements to
	 * the right (increases their indices).  The new elements will appear
	 * in the list in the order that they are returned by the
	 * specified Collection's iterator.
	 *
	 * @param index index at which to insert first element
	 *		    from the specified collection.
	 * @param c elements to be inserted into this list.
	 * @return <tt>true</tt> if this list changed as a result of the call.
	 * @throws    IndexOutOfBoundsException if index out of range <tt>(index
	 *		  &lt; 0 || index &gt; size())</tt>.
	 * @throws    NullPointerException if the specified Collection is null.
	 */
	public boolean addAll(int index, Collection c) {
		return wrappedArrayList.addAll(index, c);
	}

	/* (non-Javadoc)
	 * @see java.util.List#iterator()
	 */
	public Iterator iterator() {
		return wrappedArrayList.iterator();
	}

	/* (non-Javadoc)
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return wrappedArrayList.remove(o);
	}

	/* (non-Javadoc)
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection c) {
		return wrappedArrayList.containsAll(c);
	}

	/* (non-Javadoc)
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection c) {
		return wrappedArrayList.removeAll(c);
	}

	/* (non-Javadoc)
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection c) {
		return wrappedArrayList.retainAll(c);
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	public ListIterator listIterator() {
		return wrappedArrayList.listIterator();
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator listIterator(int index) {
		return wrappedArrayList.listIterator(index);
	}

	/* (non-Javadoc)
	 * @see java.util.List#subList(int, int)
	 */
	public List subList(int fromIndex, int toIndex) {
		return wrappedArrayList.subList(fromIndex, toIndex);
	}

	/**
	 * @return
	 */
	public ArrayList getWrappedArrayList() {
		return wrappedArrayList;
	}

}
