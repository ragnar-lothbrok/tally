
public class WH {

	public static void main(String[] args) {
		// System.out.println(new WH().stripHtmlTags("<h1>Hello World!</h1>
		// <p>something</p>"));
		int[] input = new int[] {3};
		int result[] = new WH().product(input);
		if (result != null && result.length > 0) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + "\t");
			}
			System.out.println();
		}
	}

	public String stripHtmlTags(String html) {
		if (html != null && html.trim().length() > 0) {
			while (html.indexOf("<") != -1) {
				int startIndex = html.indexOf("<");
				int endIndex = startIndex;
				while (html.charAt(endIndex) != '>') {
					endIndex++;
				}
				String startingTag = html.substring(startIndex, endIndex + 1);
				String endTag = startingTag.charAt(0) + "/" + startingTag.substring(1, startingTag.length());
				html = html.replaceAll(startingTag, "");
				html = html.replaceAll(endTag, "");
			}
		}
		return html;
	}

	//int[] input = new int[] { 3, 1, 6, 4 };
	//int[] output = new int[] { 24,  72, 12, 18 };
	public int[] product(int[] input) {
		if (input != null && input.length > 0) {
			int result[] = new int[input.length];
			int firstMul = 1;
			for (int i = 1; i < input.length; i++) {
				firstMul *= input[i];
			}
			result[0] = firstMul;
			for (int i = 1; i < input.length; i++) {
				result[i] = (result[0] / input[i]) * input[0];
			}
			return result;
		}
		return null;
	}

}
