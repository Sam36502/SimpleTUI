package ch.pearcenet.tui.time;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Timer Class
 * Provides a way to time the program. Great for benchmarking different methods.
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.1
 */
public class Timer {

	/**
	 * The time the Timer was started
	 */
	private LocalTime start;

	/**
	 * The number of milliseconds that have elapsed since the Timer was started
	 */
	private long timeElapsed = 0L;

	/**
	 * Starts the Timer.
	 */
	public void start() {
		start = LocalTime.now();
	}

	/**
	 * Stops the Timer.
	 */
	public void stop() {
		timeElapsed += start.until(LocalTime.now(), ChronoUnit.MILLIS);
	}

	/**
	 * Resets the Timer to 0 milliseconds elapsed.
	 */
	public void reset() {
		timeElapsed = 0L;
	}

	/**
	 * Gets how many milliseconds have elapsed since the timer was started and then stopped.
	 * @return Elapsed time in milliseconds
	 */
	public long getMillis() {
		return timeElapsed;
	}

	/**
	 * Returns a formatted timestamp of how many hours, minutes, and seconds have elapsed
	 * since the timer was started and then stopped.
	 * @return Elapsed time in a string timestamp
	 */
	public String getTimestamp() {
		return new Timestamp(timeElapsed - 3600000000L).toString().split(" ")[1];
	}
}
