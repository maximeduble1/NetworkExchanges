package src;

public class TaskException extends Exception {
	private String s;
	
		public TaskException(String s) {
			this.s = s;
		}
}
