package String;

public class removeVowels {
    public static String removeVowels(final String string){
        final String vowels = "AaEeIiOoUu";
        final StringBuilder builder = new StringBuilder();
        for(final char c : string.toCharArray())
            if(vowels.indexOf(c) < 0)
                builder.append(c);
        return builder.toString();
    }
}
