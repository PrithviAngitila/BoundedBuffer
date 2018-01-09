package org.knowledgehunt;

public class ExecuteMyBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBuffer buffer = new MyBuffer(5);
		// request jobs atleast one less than nthreads to avoid deadlock incase
		// of consumers acquires all  available threads
		buffer.startBuffering(9);

	}
}
