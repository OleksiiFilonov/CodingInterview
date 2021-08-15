package oleksii.filonov.interview.tasks.string;

import static java.lang.System.out;

import java.util.Scanner;

public class TokenSplitter {
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        String trimmed = s.trim();
        if(trimmed.length() == 0) {
        	out.println(0);
        } else {
        	String [] tokens = trimmed.split("[ !,?.\\_'@]+");
        	out.println(tokens.length);
        	for(String token: tokens) {
        		out.println(token);
        	}
        }
    }

}
