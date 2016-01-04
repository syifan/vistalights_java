/**
 * Logistics server side
 */
package com.logistics.gamelogic.organizelogiccontroller;

import com.logistics.gamelogic.EventHandler;
import com.logistics.simulator.scheduler.Clock;

/**
 * @author yifansun
 *
 */
public class CountDownTimer implements Runnable {
	
	/**
	 * Start time
	 */
	protected long startTime = 0;
	
	/**
	 * Clock to depend on
	 */
	protected Clock clock;
	
	/**
	 * Event handler for time up operation
	 */
	EventHandler timeUpEventHandler;
	
	/**
	 * Total count down time
	 */
	protected long totalCountDownTime = 0;
	
	/**
	 * Constructor
	 * @param clock
	 */
	public CountDownTimer(Clock clock, EventHandler timeUpEventHandler) {
		this.clock = clock;
		this.timeUpEventHandler = timeUpEventHandler;
	}
	
	/**
	 * Start the timer
	 */
	public void startTimer() {
		startTime = clock.getCurrentTime();
		new Thread(this).start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			// Get and output time
			long currentTime = clock.getCurrentTime();
			long timeDiff = currentTime - startTime;
			long timeLeft = totalCountDownTime - timeDiff;
			System.out.format("Time to start game: %d\n", timeLeft / 1000);
			
			// Terminate the timer
			if (timeLeft < 0) {
				timeUpEventHandler.process();
				return;
			}
			
			// Wait for 1 second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	
}
