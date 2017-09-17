package teste;

import java.util.function.Supplier;

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
	
	public <T, R> R log(String description, Supplier<R> supplier) {
		final long start = System.currentTimeMillis();
		R r = supplier.get();
		System.out.println(description + ": " + (System.currentTimeMillis() - start));
		return r;
	}
}
