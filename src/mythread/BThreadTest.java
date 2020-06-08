package mythread;

public class BThreadTest {

	public static void main(String[] args) throws InterruptedException {
		BService service = new BService();
		ThreadA a = new ThreadA(service);
		a.start();
		Thread.sleep(1000);
		ThreadB b = new ThreadB(service);
		b.start();
	}
}

class BService {
	private boolean continueRun = true;
	private volatile long i = 0;
	public void runMethod() {
		String anyString = new String();
		while(continueRun) {
			++i;
//			synchronized(anyString) {}
		}
		System.out.println("停下来了！");
	}
	public void stop() {
		while (true) {
			if (i >= 100000) {
				continueRun = false;
				System.out.println("已经发起停止命令了！" + i);
				break;
			}
		}
	}
}

class ThreadA extends Thread {
	private BService service;
	
	public ThreadA(BService service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		service.runMethod();
	}
}

class ThreadB extends Thread {
	private BService service;
	
	public ThreadB(BService service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		service.stop();
	}
}