package com.core.threads.concurrent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class enqueue the tasks till it's size and notifies the consumers to consume. Once all tasks are
 * Dequeued then notifies the all producers to produce the tasks<p>
 * 
 * This is similar to producer and consumer problem<p>
 * 
 * The following BlockingQueue implementation shows how multiple threads work together via the wait-notify
 * pattern. If we put an element into an empty queue, all threads that were waiting in the take method wake
 * up and try to receive the value. If we put an element into a full queue, the put method waits for the call
 * to the get method. The get method removes an element and notifies the threads waiting in the put method that
 * the queue has an empty place for a new item.
 *
 * @param <T>
 *
 * @author Srinath.Rayabarapu
 */
public class BlockingQueueImpl<T> {
	
	private Queue<T> queue = new LinkedList<>();
	private int MAX_TASK_IN_QUEUE = -1;
	
	public BlockingQueueImpl(int size) {
		this.MAX_TASK_IN_QUEUE = size;
	}
	
	public synchronized void enqueue(T task) throws InterruptedException {
		
		while(this.queue.size() == this.MAX_TASK_IN_QUEUE) {
			System.out.println("enqueue: Queue is Full.. Waiting : " + task);
			wait();
		}
		
		if(this.queue.isEmpty()) {
			System.out.println("enqueue: Queue is Empty.. Notifying all Tasks");
			notifyAll();
		}
		
		//inserts in to queue
		this.queue.offer(task);
	}
	
	public synchronized T dequeue() throws InterruptedException {
		
		while(this.queue.isEmpty()) {
			System.out.println("dequeue: Queue is Empty");
			wait();
		}
		
		while(this.queue.size() == this.MAX_TASK_IN_QUEUE) {
			System.out.println("dequeue: Queue is Full. Waiting..");
			notifyAll();
		}
		
		//removes the task from queue
		return this.queue.poll();
	}
}