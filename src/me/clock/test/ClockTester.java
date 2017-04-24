package me.clock.test;

import java.time.Clock;
import java.time.Instant;
import java.time.Duration;
import java.time.ZoneId;

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
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
}
