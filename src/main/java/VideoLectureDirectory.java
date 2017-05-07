import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoLectureDirectory {

	public static void main(String[] args) {
		File node = new File("/home/raghunandangupta/Downloads/buks");
		DirectoryS directoryS = new DirectoryS();

		displayIt(node, directoryS);

		System.out.println(directoryS);
	}

	public static void displayIt(File node, DirectoryS directoryS) {
		if (node.isDirectory()) {
			DirectoryS tempDirectoryS = new DirectoryS();
			tempDirectoryS.setDirectory(node.isDirectory());
			tempDirectoryS.setDirectoryName(node.getName());
			tempDirectoryS.setDirectoryPath(node.getAbsolutePath());
			directoryS.getDirectoryList().add(tempDirectoryS);
			String[] subNote = node.list();
			for (String filename : subNote) {
				displayIt(new File(node, filename), directoryS);
			}
		} else {
			DirectoryS tempDirectoryS = new DirectoryS();
			tempDirectoryS.setDirectory(node.isDirectory());
			tempDirectoryS.setDirectoryName(node.getName());
			tempDirectoryS.setDirectoryPath(node.getAbsolutePath());
			directoryS.getDirectoryList().add(tempDirectoryS);
		}
	}

	static class DirectoryS {
		private String directoryName;
		private List<DirectoryS> directoryList = new ArrayList<DirectoryS>();
		private boolean directory;
		private String directoryPath;

		public String getDirectoryName() {
			return directoryName;
		}

		public void setDirectoryName(String directoryName) {
			this.directoryName = directoryName;
		}

		public List<DirectoryS> getDirectoryList() {
			return directoryList;
		}

		public void setDirectoryList(List<DirectoryS> directoryList) {
			this.directoryList = directoryList;
		}

		public boolean isDirectory() {
			return directory;
		}

		public void setDirectory(boolean directory) {
			this.directory = directory;
		}

		public String getDirectoryPath() {
			return directoryPath;
		}

		public void setDirectoryPath(String directoryPath) {
			this.directoryPath = directoryPath;
		}

		@Override
		public String toString() {
			return "DirectoryS [directoryName=" + directoryName + ", directoryList=" + directoryList + ", directory="
					+ directory + ", directoryPath=" + directoryPath + "]";
		}

	}
}
