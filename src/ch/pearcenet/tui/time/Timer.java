package ch.pearcenet.tui.time;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Timer {
	
	private LocalTime start;
	private long timeElapsed = 0L;
	
	// Start the timer
	public void start() {
		start = LocalTime.now();
	}
	
	// Stop the timer
	public void stop() {
		timeElapsed += start.until(LocalTime.now(), ChronoUnit.MILLIS);
	}
	
	// Reset the time
	public void reset() {
		timeElapsed = 0L;
	}
	
	// Get the number of milliseconds elapsed
	public long getMillis() {
		return timeElapsed;
	}
	
	// Get the time elapsed with a timestamp
	public String getTimestamp() {
		return new Timestamp(timeElapsed - 3600000000L).toString().split(" ")[1];
	}
}
