/**
 * Logistics server side
 */
package com.logistics.gamelogic.organizelogiccontroller;

import java.util.Hashtable;

import com.logistics.apisystem.User;
import com.logistics.apisystem.UserInfoSubscriber;

/**
 * @author yifansun
 *
 */
public class OrganizeLogicController implements UserInfoSubscriber {
	
	/**
	 * A list of users that is connected to the server. Uses user id as index.
	 */
	protected Hashtable<Integer, User> users = new Hashtable<Integer, User>();
	
	/**
	 * The count down timer
	 */
	CountDownTimer countDownTimer;

	/**
	 * @param countDownTimer the countDownTimer to set
	 */
	public void setCountDownTimer(CountDownTimer countDownTimer) {
		this.countDownTimer = countDownTimer;
	}

	/**
	 * @param countDownTimerFactory
	 */
	public OrganizeLogicController() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.logistics.apisystem.UserInfoSubscriber#userConnect(com.logistics.apisystem.User)
	 */
	@Override
	public void userConnect(User user) {
		System.out.println("new user connected\n");
		users.put(user.getId(), user);
	}

	/* (non-Javadoc)
	 * @see com.logistics.apisystem.UserInfoSubscriber#userDisconnect(com.logistics.apisystem.User)
	 */
	@Override
	public void userDisconnect(User user) {
		users.remove(user.getId());	
	}

	/**
	 * Start game
	 */
	public void startGameWithTimer() {
		countDownTimer.startTimer();
	}
	
	
}
