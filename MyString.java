/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("sap", "space"));
        System.out.println(subsetOf("spa", "space"));
        System.out.println(subsetOf("pass", "space"));
        System.out.println(subsetOf("c", "space"));
        System.out.println(randomStringOfLetters(5));
        System.out.println(remove("committee", "meet"));
        System.out.println(remove("abc", "abc"));
        System.out.println(remove("abc", "b"));
        System.out.println(remove("hello", ""));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int countChar=0;
       for(int i=0; i<str.length(); i++){
        if(str.charAt(i)==ch){
            countChar++;
        }
       }
        return countChar;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         if(str2.length()<str1.length())
        return false;
        if(str1=="")
        return true;   
        for(int i= 0; i<str1.length(); i++) {
            char ch = str1.charAt(i);
            if(str2.indexOf(ch)==-1)
            return false;
            if (countChar(str2, ch) < countChar(str1, ch)) {
                return false;
            }
        }
        return true;  
    }
    

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if(str.length()<=1)
        return str;
       String newstring="";
       for(int i=0; i<str.length()-1;i++){
        newstring= newstring+str.charAt(i)+" ";
       }
       newstring=newstring+str.charAt(str.length()-1);
        return newstring;
    }
  
    
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomabc="";
        while(randomabc.length()<n){
            // 0<=random<1  ASCI- lower letters are between 97-122  122-97=26 
            randomabc=randomabc+(char)(Math.random()*(26)+97);
        }
        return randomabc;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        if(str2==""||str1=="")
        return str1;
        String newstr=""; 
            for(int j=0;j<str1.length();j++){
                char ch = str1.charAt(j);
                if(countChar(str1, ch)>countChar(str2, ch)){
                  if(newstr.indexOf(ch)==-1)
                    newstr+=ch;
                    else if(countChar(newstr, ch)<(countChar(str1, ch)-1))
                    newstr+=ch;

                } 
            else if(str2.indexOf(ch)==-1)
            newstr+=ch;
        }
      
        return newstr;
    }



    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex,str.length()-1);
         return result;
    }    
}
