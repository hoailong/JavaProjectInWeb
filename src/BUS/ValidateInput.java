package BUS;

public class ValidateInput {
	private static String validateString(String s) {
		s = s.trim();
		String specialChar = "`~!@#$%^&*()-+=:;[] {}<>?/\\|";
		for (int i = 0; i < s.length(); i++) {
			if (specialChar.indexOf(s.charAt(i)) != -1) {
//				s = s.replace(s.charAt(i), "");
			}
		}
		return s;
	}
}
