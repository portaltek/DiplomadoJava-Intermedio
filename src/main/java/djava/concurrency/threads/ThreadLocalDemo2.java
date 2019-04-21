package djava.concurrency.threads;

import java.util.Random;

/*
 * Investigate more and finish example!!!
 */
public class ThreadLocalDemo2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadLocalDemo2 t = new ThreadLocalDemo2();

	}

}

class UserContextHolder {
	private UserContextHolder() {
	}

	public static final ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
	int id;
}

class Service1 {
	static Random r = new Random();

	public void process() {
		User user = getUser();
		UserContextHolder.holder.set(user);
	}

	private User getUser() {
		User user = new User();
		int min = 0;
		int max = 100000;
		user.id = r.nextInt((max - min) + 1) + min;
		return user;
	}
}

class Service2 {

	public void process() {
		User user = UserContextHolder.holder.get();
		System.out.println(user.id);
	}

}