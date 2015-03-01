import java.util.concurrent.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Answers Q3 Day-18
 * @author Gareth Moore
 */

public class ResponsiveUIExecutor implements Executor {
	private final Queue<Runnable> jobQueue;
	private final Thread t1 = null;
	private final Thread t2 = null;

	public ResponsiveUIExecutor() {
		this.jobQueue = new LinkedList<Runnable>();
	}

	/**
	 * Checks if threads are in use, if not, it adds the task to the queue.
	 */
	@Override
	public void execute(Runnable r) {
		if (t1 == null) {
			runJob(r, this.t1);
		} else if (t2 == null) {
			runJob(r, this.t2);
		} else {
			addToQueue(r);
		}
	}

	/**
	 * Runs the current task. Once the taks is complete, it runs the next task in the queue.
	 * Otherwise, the thread is reset to null.
	 */
	public void runJob(Runnable r, Thread t) {
		t = new Thread(r);
		t.start();
		if (!jobQueue.isEmpty()) {
			runJob(removeFromQueue(), t);
		} else {
			t = null;
		}
	}

	/**
	 * Adds a runnable object to the jobQueue.
	 */
	public synchronized void addToQueue(Runnable r) {
		jobQueue.add(r);
	}

	/**
	 * Removes the head of the queue.
	 */
	public synchronized Runnable removeFromQueue() {
		Runnable result = jobQueue.remove();
		return result;
	}

	public int getMaxPendingTime() {
		int result = 1000 * jobQueue.size();
		return result;
	}
}