package mythread;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xixi")
public class AThreadTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Thread timer;
	private volatile boolean stoped = false;
	private volatile boolean suspended = false;
	
	@Override
	public void init() throws ServletException {
		timer = new Thread() {
			private int count = 0;
			
			@Override
			public void run() {
				if (!timer.getName().equals("Timer")) {					
					timer.setName("Timer");
				}
				System.out.println(Thread.currentThread() + " started");
				while (!stoped) {
					if (timer.isInterrupted()) {
						System.out.println("interrupted break");
						break;
					}
					try {
						if (!stoped && !suspended) {
							count += 1;
							System.out.println(Thread.currentThread() +  " " + count);
							if (suspended) {
								synchronized (timer) {
									while (suspended) {
										timer.wait();
									}
								}															
							}
						}
//						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("exception because the interrupt when thread was in sleeping");
						return;
					}
				}
			}
		};
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		switch (act) {
		case "start":
			if (timer == null) {
				init();
			}
			timer.start();
			break;
		case "stop":
			stop();
			break;
		case "pause":
			pause();
			break;
		case "resume":
			resume();
			break;
		case "state":
			state();
			break;
		default:
			break;
		}
		response.sendRedirect("/Learning_zoom");
	}

	public void stop() {
		timer.interrupt();
//		stoped = true;
		System.out.println("stop");
	}
	
	public void pause() {
		suspended = true;
		System.out.println("pause");
	}
	
	public void resume() {
		suspended = false;
		if (!suspended) {
			synchronized (timer) {
				timer.notify();
				System.out.println("resume");
			}
		}
	}
	
	public void state() {
		System.out.print("status: ");
		if (timer == null) {
			System.out.println("null");
		} else {			
			System.out.println(timer.getState());			
		}
	}
	
}
