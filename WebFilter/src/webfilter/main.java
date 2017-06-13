package webfilter;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.commons.lang3.*;


public class main {
	
	public static void main(String[] args) {
		String message;
		String escapeMessage;
		String unescapeMessage;
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("input message : ");
			message = scan.nextLine(); // 테스트 값 입력
			
			System.out.println("Original : " + message);
			escapeMessage = escape(message);
			System.out.println("Escape : " + escapeMessage);
			unescapeMessage = unescape(escapeMessage);
			System.out.println("Unescape : " + unescapeMessage + "\n");
		}

	}
	
	public static String escape(String value) {
		Pattern escapePattern = Pattern.compile("'");
		
		if (value == null) {
			return null;
		}

		String trustValue = StringEscapeUtils.escapeHtml4(value); // &lt;, &gt;, &quot; 문자 치환
		
		Matcher matcher = escapePattern.matcher(trustValue);
		if (matcher.find()) {
			return matcher.replaceAll("&#39"); // &#39 치환
		}
		
		return trustValue;
	}

	public static String unescape(String value) {
		Pattern unescapePattern = Pattern.compile("&#39;");
		
		if (value == null) {
			return null;
		}
		
		String originalValue = StringEscapeUtils.unescapeHtml4(value); // <, >, " 치환
		
		Matcher matcher = unescapePattern.matcher(originalValue);
		if (matcher.find()) {
			return matcher.replaceAll("'"); // 싱글쿼터로 치환
		}
		return originalValue;
	}
}
