package Amzon;


public class removeVowels {
    public static String removeVowels(final String s){
        final String vowels = "AaEeIiOoUu";
        StringBuilder builder = new StringBuilder();
        for(final char c : s.toCharArray())
            if(vowels.indexOf(c) < 0)
                builder.append(c);
        return builder.toString();
    }
}
