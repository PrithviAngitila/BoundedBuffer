package org.knowledgehunt;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyBuffer {
	private static final int deafaultBufferSize = 10;
	private static final int nThreads = 10;
	private Queue<Integer> buffer;

	public MyBuffer() {
		super();
		this.buffer = new MyArrayQueue(deafaultBufferSize);

	}

	public MyBuffer(int bufferSize) {
		super();
		this.buffer = new MyArrayQueue(bufferSize);

	}

	public void startBuffering(int jobs) {
		int k = 0;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

		MyProducer producer = new MyProducer(buffer);
		MyConsumer consumer = new MyConsumer(buffer);

		for (k = 0; k < jobs; k++) {
			System.out.println("submittig consumer");
			executorService.submit(() -> consumer.consume());
		}
		for (k = 0; k < jobs; k++) {
			executorService.submit(() -> producer.produce());
		}

		try {
			// int j=0;
			Thread.sleep(7000);

			executorService.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
