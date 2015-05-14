// Nick Solano nsolano
// 5-6-15

package one;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	static int numPhilosophers;
	static Lock[] forks;
	static Philosopher[] philosophers;
	
	public static void main(String[] args) {
		
		//numPhilosophers = Integer.parseInt(args[0]);
		numPhilosophers = 5;
		forks = new Lock[numPhilosophers]; 
		philosophers = new Philosopher[numPhilosophers];
		
		int i;
		for (i = 0; i < numPhilosophers; i++){
			philosophers[i] = new Philosopher(i);
			forks[i] = new ReentrantLock();
		}
		
		for (i = 0; i < numPhilosophers; i++){
			philosophers[i].start();
		}
	}
}
