import java.util.concurrent.*;

/**
 * Answers Q3 Day-18
 * @author Gareth Moore
 */

public class ResponsiveUIExecutor implements Executor {
	private final ArrayBlockingQueue<Runnable> jobQueue = new ArrayBlockingQueue(10);
	private final ExecutorService myThreadPool = newFixedThreadPool(4);

	@Override
	public void execute(Runnable r) {
		jobQueue.add(r);
	}

	public void addToQueue(Runnable r) {


	public synchronized void runJob() {
		wait();
		Object o = take();
		Thread

}

