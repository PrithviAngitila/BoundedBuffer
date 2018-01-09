package org.knowledgehunt;

import java.util.Queue;

public class MyConsumer {

	private Queue<Integer> buffer;

	public MyConsumer(Queue<Integer> buffer) {
		super();
		this.buffer = buffer;
	}

	public void consume() {

		int var = buffer.poll();
		System.out.println("Removed data" + var);

	}

}
