package me.clock.test;

import java.time.Clock;
import java.time.Instant;
import java.time.Duration;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

// one class needs to have a main() method
public class ClockTester {
	static Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

	static int initial = 0;
	// arguments are passed using the text field below this editor
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			while (true) {
				System.out.println("Fixed clock: " + clock.instant());
				Clock delta = Clock.offset(clock, Duration.ofSeconds(initial++ * 2));
				System.out.println(delta.instant());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		t.start();
	}
}
