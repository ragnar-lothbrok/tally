
public class ThreadCreationTest {

	static {
		new ThreadCreationTest();
	}

	private void call() {
		System.out.println("Hello guys!!!");
	}

	public ThreadCreationTest() {

		// when we use this thread it goes in deadlock kind of state
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				call();
			}
		});

		// This one works fine.
		Thread thread = new Thread(() -> call());

		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String... args) {
		System.out.println("Code finished...");
	}
}
