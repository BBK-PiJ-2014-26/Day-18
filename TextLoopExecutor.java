import java.util.concurrent.*;

/**
 * Answewrs Q2 Day-18
 * @author Gareth Moore
 */

public class TextLoopExecutor implements Executor {

	@Override
	public void execute(Runnable r) {
		Thread t = new Thread(r);
		t.start();
	}
}