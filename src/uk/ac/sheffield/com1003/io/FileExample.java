package uk.ac.sheffield.com1003.io;

import java.io.*;

public class FileExample {

	public static void main(String[] args) throws IOException {
		File f = new File("mission-impossible.txt");

		if (!f.exists()) {
			PrintWriter pw = new PrintWriter(f);
			pw.println("This message will self-destruct in less than a millisecond");
			pw.close();

			boolean result = f.delete();
			if (!result) {
				System.out.println("Could not delete the file!");
			}
		}
	}
}
