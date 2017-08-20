package teste;

public class TimeLogger {
	
	private TimeLogger() {}
	
	public static TimeLogger getInstance() {
		return new TimeLogger();
	}

	public <T> void log(String description, Runnable runnable) {
		final long start = System.currentTimeMillis();
		runnable.run();
		System.out.println(description + ": " + (System.currentTimeMillis() - start));
	}
}
