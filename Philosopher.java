// Nick Solano nsolano
// 5-6-15

package one;

public class Philosopher implements Runnable{
	private Thread t;
	int index;
	
	Philosopher(int index){
		this.index = index;		
	}
	
	public void run(){
		System.out.println("Philosopher " + index + " sits down.");
		int leftForkIndex = this.index;
		int rightForkIndex;
		if (this.index != 0){
			rightForkIndex = this.index - 1;
		} else {
			rightForkIndex = one.Main.numPhilosophers - 1;
		}
		
		ForkPair forks = new ForkPair(leftForkIndex, rightForkIndex);
		
		while(true){		
			forks.pickUp();
			try{ Thread.sleep(1);}
			catch (InterruptedException e) { System.out.println(index+"interrupted");}
			
			System.out.println("Philosopher " + this.index + " eats.");
						
			forks.putDown();
			try{ Thread.sleep(1);}
			catch (InterruptedException e) { System.out.println(index+"interrupted");}
		}
	}
	
	public void start(){
		if (t == null){
			t = new Thread(this);
			t.start();
		}
	}
}