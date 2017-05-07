//http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
public class MinLengthPalindrome {

	public static void main(String[] args) {
//		String str = "abab";
		String str = "babanas";
//		String str = "geeks";
		
		maxSuffixLength(str);
		System.out.println();
		int maxLength  = maxSuffixLength(str+""+new StringBuffer(str).reverse());
		if(maxLength != 0 && maxLength != str.length()){
			System.out.println(new StringBuilder(str).reverse().substring(0, str.length()-maxLength)+""+str);
		}else{
			System.out.println(str);
		}
	}
	
	private static int maxSuffixLength(String str){
		System.out.println(str);
		int i=0,j=1;
		int arr[] = new int[str.length()];
		arr[0] = 0;
		int max = 0;
		while(i < str.length() && j < str.length()){
			if(str.charAt(i) == str.charAt(j)){
				arr[j] = i +1;
				if(max < arr[j]){
					max = arr[j];
				}
				i++;
				j++;
			}else if(i == 0){
				arr[j++] = 0;
			}else{
				 i = arr[i-1];
			}
		}
		for(i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		return arr[str.length()-1];
	}
}
