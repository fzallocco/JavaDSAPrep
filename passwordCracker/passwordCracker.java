import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class passwordCracker {

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
    // Write your code here
        /*passwords[ozkxyhkcst, xvglh, hpdnb, zfzahm]
        loginAttempt = "ozkxyhkcstxvglhhpdnbzfzahm"
        output = "ozkxyhkcst xvglh hpdnb zfzahm"
        */
        /*int pointer = 0;
        String outPutString = "";
        for(int i = 0; i<passwords.size()-1; i++)
        {
            String currentPassword = passwords.get(i);
            if(loginAttempt.startsWith(currentPassword))
            { //say you only find the first half of login attempt, and you want to find the second half
                outPutString = currentPassword+" "; //concatenate first half of password in output string
                pointer = currentPassword.length() + 1; //get index of new passowrd inside the list
                String subLogin = loginAttempt.substring(pointer); //create a shortended login attempt 
                while(subLogin.length()>=0){ //as long as the length of the new login attempt is greater than or equal to 0
                    currentPassword = passwords.get(i+1);
                    if(subLogin.startsWith(currentPassword))
                    {
                        outPutString = subLogin+" ";
                        pointer = currentPassword.length() + 1;
                        subLogin = loginAttempt.substring(pointer);
                        //subLogin.length--;
                    }
                }
                return outPutString;
            }elseif(loginAttempt.startsWith(passwords.get(passwords.size()-1)){}

        }
        return "WRONG PASSWORD";*/

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < loginAttempt.length()) {
            boolean matched = false;

            for (String password : passwords) {
                if (loginAttempt.startsWith(password, i)) {
                    result.append(password).append(" ");
                    i += password.length();
                    matched = true;
                    break;
                }
            }

            // If no match was found at this position, the string cannot be fully resolved
            if (!matched) {
                return "WRONG PASSWORD";
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args){
        // Test case 1: Matching elements with repetitions
        List<String> stringList1 = List.of("apple", "banana", "cherry", "date");
        String input1 = "bananacherryapplecherry";
        System.out.println(passwordCracker(stringList1, input1)); // Output: banana cherry apple cherry

        // Test case 2: No matches found
        List<String> stringList2 = List.of("hello", "planet");
        String input2 = "helloworld";
        System.out.println(passwordCracker(stringList2, input2)); // Output: WRONG PASSWORD
    }
}
