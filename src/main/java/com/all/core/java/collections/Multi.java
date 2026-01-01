package com.all.core.java.collections;

import java.util.logging.Logger;

public class Multi extends Thread {

	private static final Logger logger = Logger.getLogger(Multi.class.getName());

	private volatile boolean paused = false;

	@Override
	public void run() {
		System.out.println("Thread is running...");
		try {
			while (!isInterrupted()) {

				synchronized (this) {
					while (paused) {
						wait();
					}
				}

				System.out.println("Working...");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
			Thread.currentThread().interrupt();
		}
	}

	// Modern replacement for suspend()
	public void pauseThread() {
		paused = true;
	}

	// Modern replacement for resume()
	public synchronized void resumeThread() {
		paused = false;
		notify();
	}

	public static void main(String[] args) {

		Multi t = new Multi();
		t.start();

		try {
			Thread.sleep(500);

			// ✅ Safe & allowed Thread APIs
			System.out.println("Class: " + t.getClass());
			System.out.println("Context ClassLoader: " + t.getContextClassLoader());
			System.out.println("ID: " + t.getId());
			System.out.println("Name: " + t.getName());
			System.out.println("Priority: " + t.getPriority());
			System.out.println("State: " + t.getState());
			System.out.println("Thread Group: " + t.getThreadGroup());
			System.out.println("Is Alive: " + t.isAlive());
			System.out.println("Is Daemon: " + t.isDaemon());

			// Stack trace (replacement for countStackFrames)
			System.out.println("Stack depth: " + t.getStackTrace().length);

			// Pause & resume (safe)
			t.pauseThread();
			System.out.println("Thread paused");

			Thread.sleep(1000);

			t.resumeThread();
			System.out.println("Thread resumed");

			Thread.sleep(1000);

			// Stop correctly
			t.interrupt();
			t.join();

			System.out.println("Main thread exiting");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
