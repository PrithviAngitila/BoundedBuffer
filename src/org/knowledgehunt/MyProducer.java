package org.knowledgehunt;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class MyProducer {

	public MyProducer(Queue<Integer> buffer) {
		super();
		this.buffer = buffer;
	}

	private Queue<Integer> buffer;

	AtomicInteger counter = new AtomicInteger(0);

	public void produce() {

		System.out.println("added data:" + counter.get());
		buffer.add(counter.getAndIncrement());

	}

}
