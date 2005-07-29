/*
 * Created on 28/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PersistentMap implements Map, Cloneable, Serializable {

	private HashMap wrappedHashMap;

	/**
	 * Constructs an empty <tt>HashMap</tt> with the specified initial
	 * capacity and load factor.
	 *
	 * @param  initialCapacity The initial capacity.
	 * @param  loadFactor      The load factor.
	 * @throws IllegalArgumentException if the initial capacity is negative
	 *         or the load factor is nonpositive.
	 */
	public PersistentMap(int initialCapacity, float loadFactor) {
		wrappedHashMap = new HashMap(initialCapacity, loadFactor);
	}
  
		/**
	 * Constructs an empty <tt>HashMap</tt> with the specified initial
	 * capacity and the default load factor (0.75).
	 *
	 * @param  initialCapacity the initial capacity.
	 * @throws IllegalArgumentException if the initial capacity is negative.
	 */
	public PersistentMap(int initialCapacity) {
		wrappedHashMap = new HashMap(initialCapacity);
	}

	/**
	 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
	 * (16) and the default load factor (0.75).
	 */
	public PersistentMap() {
		wrappedHashMap = new HashMap();
	}

	/**
	 * Constructs a new <tt>HashMap</tt> with the same mappings as the
	 * specified <tt>Map</tt>.  The <tt>HashMap</tt> is created with
	 * default load factor (0.75) and an initial capacity sufficient to
	 * hold the mappings in the specified <tt>Map</tt>.
	 *
	 * @param   m the map whose mappings are to be placed in this map.
	 * @throws  NullPointerException if the specified map is null.
	 */
	public PersistentMap(Map m) {
		wrappedHashMap = new HashMap(m);
	}

	// internal utilities

	/**
	 * Returns the number of key-value mappings in this map.
	 *
	 * @return the number of key-value mappings in this map.
	 */
	public int size() {
		return wrappedHashMap.size();
	}
  
	/**
	 * Returns <tt>true</tt> if this map contains no key-value mappings.
	 *
	 * @return <tt>true</tt> if this map contains no key-value mappings.
	 */
	public boolean isEmpty() {
		return wrappedHashMap.isEmpty();
	}

	/**
	 * Returns the value to which the specified key is mapped in this identity
	 * hash map, or <tt>null</tt> if the map contains no mapping for this key.
	 * A return value of <tt>null</tt> does not <i>necessarily</i> indicate
	 * that the map contains no mapping for the key; it is also possible that
	 * the map explicitly maps the key to <tt>null</tt>. The
	 * <tt>containsKey</tt> method may be used to distinguish these two cases.
	 *
	 * @param   key the key whose associated value is to be returned.
	 * @return  the value to which this map maps the specified key, or
	 *          <tt>null</tt> if the map contains no mapping for this key.
	 * @see #put(Object, Object)
	 */
	public Object get(Object key) {
		return wrappedHashMap.get(key);
	}

	/**
	 * Returns <tt>true</tt> if this map contains a mapping for the
	 * specified key.
	 *
	 * @param   key   The key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified
	 * key.
	 */
	public boolean containsKey(Object key) {
		return wrappedHashMap.containsKey(key);
	}

	/**
	 * Associates the specified value with the specified key in this map.
	 * If the map previously contained a mapping for this key, the old
	 * value is replaced.
	 *
	 * @param key key with which the specified value is to be associated.
	 * @param value value to be associated with the specified key.
	 * @return previous value associated with specified key, or <tt>null</tt>
	 *	       if there was no mapping for key.  A <tt>null</tt> return can
	 *	       also indicate that the HashMap previously associated
	 *	       <tt>null</tt> with the specified key.
	 */
	public Object put(Object key, Object value) {
		return wrappedHashMap.put(key, value);
	}

	/**
	 * Copies all of the mappings from the specified map to this map
	 * These mappings will replace any mappings that
	 * this map had for any of the keys currently in the specified map.
	 *
	 * @param m mappings to be stored in this map.
	 * @throws NullPointerException if the specified map is null.
	 */
	public void putAll(Map m) {
		wrappedHashMap.putAll(m);
	}
  
		/**
	 * Removes the mapping for this key from this map if present.
	 *
	 * @param  key key whose mapping is to be removed from the map.
	 * @return previous value associated with specified key, or <tt>null</tt>
	 *	       if there was no mapping for key.  A <tt>null</tt> return can
	 *	       also indicate that the map previously associated <tt>null</tt>
	 *	       with the specified key.
	 */
	public Object remove(Object key) {
		return wrappedHashMap.remove(key);
	}

	/**
	 * Removes all mappings from this map.
	 */
	public void clear() {
		wrappedHashMap.clear();
	}

	/**
	 * Returns <tt>true</tt> if this map maps one or more keys to the
	 * specified value.
	 *
	 * @param value value whose presence in this map is to be tested.
	 * @return <tt>true</tt> if this map maps one or more keys to the
	 *         specified value.
	 */
	public boolean containsValue(Object value) {
		return wrappedHashMap.containsValue(value);
	}

	/**
	 * Returns a shallow copy of this <tt>HashMap</tt> instance: the keys and
	 * values themselves are not cloned.
	 *
	 * @return a shallow copy of this map.
	 */
	public Object clone() {
		PersistentMap v = new PersistentMap(this.size());
		v.wrappedHashMap = (HashMap) this.wrappedHashMap.clone();
		return v;
	}

	/**
	 * Returns a set view of the keys contained in this map.  The set is
	 * backed by the map, so changes to the map are reflected in the set, and
	 * vice-versa.  The set supports element removal, which removes the
	 * corresponding mapping from this map, via the <tt>Iterator.remove</tt>,
	 * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt>, and
	 * <tt>clear</tt> operations.  It does not support the <tt>add</tt> or
	 * <tt>addAll</tt> operations.
	 *
	 * @return a set view of the keys contained in this map.
	 */
	public Set keySet() {
		return wrappedHashMap.keySet();
	}

	/**
	 * Returns a collection view of the values contained in this map.  The
	 * collection is backed by the map, so changes to the map are reflected in
	 * the collection, and vice-versa.  The collection supports element
	 * removal, which removes the corresponding mapping from this map, via the
	 * <tt>Iterator.remove</tt>, <tt>Collection.remove</tt>,
	 * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt> operations.
	 * It does not support the <tt>add</tt> or <tt>addAll</tt> operations.
	 *
	 * @return a collection view of the values contained in this map.
	 */
	public Collection values() {
		return wrappedHashMap.values();
	}

	/**
	 * Returns a collection view of the mappings contained in this map.  Each
	 * element in the returned collection is a <tt>Map.Entry</tt>.  The
	 * collection is backed by the map, so changes to the map are reflected in
	 * the collection, and vice-versa.  The collection supports element
	 * removal, which removes the corresponding mapping from the map, via the
	 * <tt>Iterator.remove</tt>, <tt>Collection.remove</tt>,
	 * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt> operations.
	 * It does not support the <tt>add</tt> or <tt>addAll</tt> operations.
	 *
	 * @return a collection view of the mappings contained in this map.
	 * @see Map.Entry
	 */
	public Set entrySet() {
		return wrappedHashMap.entrySet();
	}

	/**
	 * @return
	 */
	public Map getWrappedMap() {
		return wrappedHashMap;
	}

}
