import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MD5Ecncryptor {

	public static final Integer saltLength = 62;

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		String passwordToHash = "abc123";
		String salt = "PSU7L4PYS09bw2l6tsmeKoXuVwg2ucBFO5QfUYVnt8hCko0Ebgjen2RMXqsIGk";

		salt = "14";

		// String securePassword = getSecurePassword(passwordToHash, salt);
		// System.out.println(encode(passwordToHash, salt));

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,String> nMap = new HashMap<String, String>();
		nMap.put("floorId", "1212");
		nMap.put("search", "1212");
		map.put("data", nMap);
		System.out.println(map);

	}

	static class Test {
		String floorId;
		String searchkey;

		@Override
		public String toString() {
			return "Test [floorId=" + floorId + ", searchkey=" + searchkey + "]";
		}

		public Test(String floorId, String searchkey) {
			super();
			this.floorId = floorId;
			this.searchkey = searchkey;
		}

		public String getFloorId() {
			return floorId;
		}

		public void setFloorId(String floorId) {
			this.floorId = floorId;
		}

		public String getSearchkey() {
			return searchkey;
		}

		public void setSearchkey(String searchkey) {
			this.searchkey = searchkey;
		}

	}

	private static String getSecurePassword(String passwordToHash, String salt) {

		Random r = new SecureRandom();
		byte[] salts = new byte[20];
		r.nextBytes(salts);

		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	public static String encode(CharSequence rawPassword, String salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt.getBytes());

			byte[] bytes = md.digest(rawPassword.toString().getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {

		}
		return generatedPassword;
	}

	// will generate random salt
	private static String getSalt(Integer len) {
		StringBuilder permutation = new StringBuilder("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
		Random random = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(permutation.charAt(random.nextInt(permutation.length())));
		return sb.toString();
	}

}
