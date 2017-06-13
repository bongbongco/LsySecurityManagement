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
			message = scan.nextLine(); // �׽�Ʈ �� �Է�
			
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

		String trustValue = StringEscapeUtils.escapeHtml4(value); // &lt;, &gt;, &quot; ���� ġȯ
		
		Matcher matcher = escapePattern.matcher(trustValue);
		if (matcher.find()) {
			return matcher.replaceAll("&#39"); // &#39 ġȯ
		}
		
		return trustValue;
	}

	public static String unescape(String value) {
		Pattern unescapePattern = Pattern.compile("&#39;");
		
		if (value == null) {
			return null;
		}
		
		String originalValue = StringEscapeUtils.unescapeHtml4(value); // <, >, " ġȯ
		
		Matcher matcher = unescapePattern.matcher(originalValue);
		if (matcher.find()) {
			return matcher.replaceAll("'"); // �̱����ͷ� ġȯ
		}
		return originalValue;
	}
}
