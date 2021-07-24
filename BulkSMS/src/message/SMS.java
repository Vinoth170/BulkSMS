package message;
/**
 * @author Vinoth N
 * 
 * Bulk SMS project
 */

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
/*
 * Communicate with bunch of people via SMS using this project with your API key
 */

public class SMS {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
//		String message=scan.nextLine();//Enter the message you would like to send
//		String numbers=scan.nextLine();//Enter the numbers to share message, to separate number use comma
//		sendSMS(message,numbers);
		sendSMS();
	}
	
//	private static void sendSMS(String message,String numbers)
	private static void sendSMS(){
		try {
		
		String apiKey =  System.getenv("APIKEY");
		String sender = "TXTIND";
		String message = "Hi! Welcome the world of technology."
				+ "\nThis is my bulk SMS project. You can easily get the code from my github."
				+ "\nMy GitHub url is https://github.com/Vinoth170";
		String language="english";
		String route="v3";
		String numbers = System.getenv("NUMBER");
		String flash="0";
		
		String code="UTF-8";
		
		String data="authorization="+URLEncoder.encode(apiKey,code)
		+"&sender_id="+URLEncoder.encode(sender,code)
		+"&message="+URLEncoder.encode(message,code)
		+"&language="+URLEncoder.encode(language,code)
		+"&route="+URLEncoder.encode(route,code)
		+"&numbers="+URLEncoder.encode(numbers,code)
		+"&flash="+URLEncoder.encode(flash,code);
		
		//Creating connection object
		HttpURLConnection conn=(HttpURLConnection)new URL("https://www.fast2sms.com/dev/bulkV2/?"+data).openConnection();
		conn.setDoOutput(true);
		
		if(conn.getResponseMessage().equalsIgnoreCase("OK"))
			System.out.println("Your message sent successfully...");//If the message sent to the receiver successfully this line will printed
		else
			System.out.println("Your message not send...");//If the message is not received by the receiver this message will printed.
		conn.disconnect();
		
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}