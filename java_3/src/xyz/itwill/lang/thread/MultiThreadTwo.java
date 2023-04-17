package xyz.itwill.lang.thread;

public class MultiThreadTwo implements Runnable {
	@Override
	public void run() {
		for(char i='0';i<='9';i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
