// Nick Solano nsolano
// 5-6-15

package one;

import java.util.concurrent.locks.Lock;

public class ForkPair {
	
	Lock forkOne, forkTwo;
	
	ForkPair(int leftForkIndex, int rightForkIndex){
		this.forkOne = one.Main.forks[leftForkIndex];
		this.forkTwo = one.Main.forks[rightForkIndex];
	}
	public void pickUp(){
		this.forkOne.lock();
		this.forkTwo.lock();		
	}
	public void putDown(){
		this.forkOne.unlock();
		this.forkTwo.unlock();		
	}
}
