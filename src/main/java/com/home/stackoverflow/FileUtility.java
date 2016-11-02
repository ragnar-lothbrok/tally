package com.home.stackoverflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class FileUtility {

	private static String FILE_NAME = "/tmp/credentials.txt";
	private static String SEPARATOR = "#";

	// Add Null pointer check
	private static void readFromFile(String username, String password) {
		BufferedReader bufferedReader = null;
		String finalCred = null;
		try {
			String line = null;
			bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
			username = username.trim();
			password = password.trim();
			while ((line = bufferedReader.readLine()) != null) {
				String split[] = line.split(SEPARATOR);
				if (username.equals(split[0]) && password.equals(split[1])) {
					finalCred = line;
				}
			}
			String split[] = finalCred.split(SEPARATOR);
			if (username.equals(split[0]) && password.equals(split[1])) {
				Boolean admin = Boolean.parseBoolean(split[2]);
				if (admin) {
					System.out.println("User is admin");
				} else {
					System.out.println("Not admin");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void writeInFile(String username, String password, Boolean admin) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true));
			admin = (admin == null ? false : true);
			username = username.trim();
			password = password.trim();
			bufferedWriter.write(username + SEPARATOR + password + SEPARATOR + admin + SEPARATOR + Calendar.getInstance().getTimeInMillis() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
//		writeInFile("John", "Doe", null);
//		readFromFile("John", "Doe");
//		writeInFile("John", "Doe", true);
//		readFromFile("John", "Doe");

		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith("cred");
			}
		};

		List<FileOrder> list = new ArrayList<FileOrder>();
		File dir = new File("/tmp/");
		for (File file : dir.listFiles(filter)) {
			list.add(new FileOrder(file.getName(), file.lastModified()));
		}

		Collections.sort(list);
		
		System.out.println(list);
		System.out.println("Last updated file : " + (list != null ? list.get(0) : null));

	}

	static class FileOrder implements Comparable<FileOrder> {
		private String fileName;
		private Long updationTIme = 0l;

		@Override
		public String toString() {
			return "FileOrder [fileName=" + fileName + ", updationTIme=" + updationTIme + "]";
		}

		public FileOrder(String fileName, Long updationDate) {
			super();
			this.fileName = fileName;
			this.updationTIme = updationDate;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public Long getUpdationDate() {
			return updationTIme;
		}

		public void setUpdationDate(Long updationDate) {
			this.updationTIme = updationDate;
		}

		@Override
		public int compareTo(FileOrder o) {
			return o.getUpdationDate().compareTo(this.getUpdationDate());
		}

	}

	static class Credntials {
		private String username;
		private String password;

		public Credntials(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Credntials other = (Credntials) obj;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

}
