package com.community.xanadu.utils;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

public class ThreadUtils {

	/**
	 * if the current thread is not the EDT call SwingUtilities.invokLater
	 * </br>if the current thread is the EDT call doRun.run()
	 * 
	 * @param doRun
	 *            the code to call
	 */
	public static void invokeLater(final Runnable doRun) {
		if (doRun == null) {
			throw new IllegalArgumentException("The runnable cannot be null");
		}
		if (EventQueue.isDispatchThread()) {
			doRun.run();
		} else {
			EventQueue.invokeLater(doRun);
		}
	}

	public static void invokeAndWait(final Runnable doRun) {
		if (doRun == null) {
			throw new IllegalArgumentException("The runnable cannot be null");
		}
		if (EventQueue.isDispatchThread()) {
			doRun.run();
		} else {
			try {
				EventQueue.invokeAndWait(doRun);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * a sleep that does not throw an exception
	 * 
	 * @param duration
	 */
	public static void sleepQuietly(final long duration) {
		if (duration < 0) {
			throw new IllegalArgumentException("The duration cannot be < 0");
		}
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
		}
	}

}
