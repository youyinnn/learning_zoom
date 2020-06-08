package mythread;

public class VolatileExample {
	
	public static void main(String[] args) throws InterruptedException {
		V v = new V();
		Runnable reader = v::reader;
		Thread rt = new Thread(reader);
		Runnable wirter = v::wirter;
		Thread wt = new Thread(wirter);
		wt.start();
		rt.start();
	}
}

class V{
	int a = 0;
	boolean flag1 = false;
	boolean flag2 = false;
	
	public void wirter() {
		a = 999;
		flag1 = true;
	}
	
	public void reader() {
		if (a == 999) {
			System.out.println("a = 999");
		}
	}
}
