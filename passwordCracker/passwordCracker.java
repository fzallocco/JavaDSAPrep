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

/*HackerRank link: https://www.hackerrank.com/contests/math-495r-09-blitz-2/challenges/password-cracker/problem*/
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
        /*loginAttempt = "helloworld" & passwords = ["hello", "helloworld"]*/
        //sort array of passwords from longest to shortest
        while (i < loginAttempt.length()) { //i is updated to the last index of the first passowrd
            boolean matched = false;

            for (String password : passwords) { //first inner test = hello, second inner test = planet
                if (loginAttempt.startsWith(password, i)) { //if both login and passwords' first element match, if no match skip everything till next iteration
                    result.append(password).append(" "); //append "hello" to result string
                    i += password.length(); //i is updated to the total numbers of characters in the first password
                    matched = true; //boolean is set to true
                    break; //exits inner loop
                }
            }

            // If no match was found at this position, the string cannot be fully resolved
            if (!matched) { //if no match or no more matches, return wrong password
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
