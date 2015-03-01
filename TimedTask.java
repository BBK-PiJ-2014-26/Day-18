/**
 * Answers Q3 Day-18
 * @author Gareth Moore
 */

 public class TimedTask implements Runnable {
	 int runTime;

	 /**
	  * Creates a TimedTask.
	  * If runTime exceeds 1000 milliseconds, runTime is capped at 1000.
	  * If a negative runTim is provided, a 0 runTime is constructed.
	  */
	 public TimedTask(int runTime) {
		if (runTime > 1000) {
			this.runTime = 1000;
		} else if (runTime < 0) {
			this.runTime = 0;
		} else {
			this.runTime = runTime;
		}
	}