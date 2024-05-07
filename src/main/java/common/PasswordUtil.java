package common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtil {
	public static String hashPassword(String userId, String password) {
		String hashedPassword = null;
		try {
			// ユーザIDをバイト配列に変換してソルトとして使用
			byte[] salt = userId.getBytes();
			// ソルトとパスワードを組み合わせてハッシュ化
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(salt);
			byte[] hashedBytes = digest.digest(password.getBytes());
			// ハッシュ化されたパスワードとソルトを結合してBase64でエンコード
			hashedPassword = Base64.getEncoder().encodeToString(concatenateArrays(salt, hashedBytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			hashedPassword = null;
		}
		return hashedPassword;
	}

	// 2つのバイト配列を結合するメソッド
	private static byte[] concatenateArrays(byte[] a, byte[] b) {
		byte[] result = new byte[a.length + b.length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}
}
