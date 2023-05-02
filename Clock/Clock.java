import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock {
	private ClockHand hours;
	private ClockHand minutes;
	private ClockHand seconds;

	public Clock() {
		this.hours = new ClockHand(24);
		this.minutes = new ClockHand(60);
		this.seconds = new ClockHand(60);
		Runnable clockRunnable = new Runnable() {
			public void run() {
				advance();
				System.out.println("Advancing the clock!" + hours + ":" + minutes + ":" + seconds);
			}
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(clockRunnable, 0, 1, TimeUnit.SECONDS);
	}

	public void advance() {
		this.seconds.advance();
		if (this.seconds.getValue() == 0) {
			this.minutes.advance();
			if (this.minutes.getValue() == 0) {
				this.hours.advance();
			}
		}
	}

	public String toString() {
		return hours + ":" + minutes + ":" + seconds;
	}
}
