package org.knowledgehunt;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyArrayQueue implements Queue<Integer> {

	private Object lock = new Object();
	private int queue[];
	private int capacity;
	private int arrpointer;

	public MyArrayQueue(int capacity) {
		super();
		this.capacity = capacity;
		this.queue = new int[capacity];
		this.arrpointer = 0;

	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		synchronized (lock) {
			if (arrpointer == 0) {
				return true;
			}

			return false;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	public int size() {
		// TODO Auto-generated method stub
		synchronized (lock) {
			return this.arrpointer;
		}

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

	@Override
	public boolean add(Integer e) {
		// TODO Auto-generated method stub
		synchronized (lock) {
			System.out.println("Entered sync add block to add element");
			while (this.arrpointer == this.capacity) {
				System.out.println("Queue is full ,Wait for space to be available for adding:" + e + " by "
						+ Thread.currentThread());
				try {
					lock.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println("current position of i before adding" + this.arrpointer);

			queue[arrpointer] = e;
			arrpointer++;
			System.out.println("current position of i is" + this.arrpointer);
			lock.notify();

			return true;
		}
	}

	@Override
	public Integer element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(Integer e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer poll() {
		// TODO Auto-generated method stub
		System.out.println("Entered poll method");
		synchronized (lock) {
			System.out.println("Entered sync block to remove element");
			while (this.arrpointer == 0) {

				System.out.println("Queue is empty lets wait for element to be available" + Thread.currentThread());
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			int k;
			int element = queue[0];
			System.out.println("copied element:" + element + " current position of i is" + this.arrpointer);
			for (k = 0; k < this.arrpointer - 1; k++) {
				queue[k] = queue[k + 1];
			}
			this.arrpointer--;
			lock.notify();
			System.out.println(" current position of i is" + this.arrpointer);

			return element;

		}
	}

	@Override
	public Integer remove() {
		// TODO Auto-generated method stub
		return null;
	}

}
