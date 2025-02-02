import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
    public void tester() {
        // String lines[] = loadStrings("palindromes.txt");
        String[] lines = new String[6]; 
        try {
            File myFile = new File("palindromes.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String foobar = new String();
        System.out.println("there are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            foobar = onlyLetters(lines[i]).toLowerCase();
            if (palindrome(foobar)) {
                System.out.println(lines[i] + " IS a palindrome.");
            } else {
                System.out.println(lines[i] + " is NOT a palindrome.");
            }
        }
    }
    public boolean palindrome(String word) {
        return reverse(word).equals(word);
    }

    public String reverse(String str) {
        String foo = new String();
        for (int i = str.length()-1; i >= 0; i--) { foo += str.charAt(i); }
        return foo;
    }

    public String onlyLetters(String str) {
        String bar = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) bar += str.charAt(i);
        }
        return bar;
    }
}
