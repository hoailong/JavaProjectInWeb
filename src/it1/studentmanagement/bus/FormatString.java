package it1.studentmanagement.bus;

public class FormatString {
	// Hàm chuẩn hóa chuôi
	public static String formatName(String s) {
		s = s.trim();
		String specialChar = "`~!@#$%^&*()-+=:;[] {}<>?/\\|";
		for (int i = 0; i < s.length(); i++) {
			if (specialChar.indexOf(s.charAt(i)) != -1) {
				s = s.replace(s.charAt(i), ' ');
			}
		}
		s = s.toLowerCase();
		while (s.indexOf("  ") != -1) s = s.replaceAll("  "," ");
		s = s.trim();
		String[] arr = s.split(" ");
		s = "";
		for (String i : arr) {
			s+= String.valueOf(i.charAt(0)).toUpperCase() + i.substring(1) + " ";
		}
		return s.trim();
	}
}
