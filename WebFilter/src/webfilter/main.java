package webfilter;

import java.util.Scanner;

import org.apache.commons.lang3.*;

public class main {
	
	public static void main(String[] args) {
		
		String message;
		String filterMessage;
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("input message : ");
			message = scan.nextLine();
			
			System.out.println("Original : " + message);
			filterMessage = StringEscapeUtils.escapeHtml4(message);
			System.out.println("Filter : " + filterMessage);
		}

	}

}
