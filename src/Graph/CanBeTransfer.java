package Graph;


import java.util.*;

//Design an algorithm which transforms a source word to a target word.
//for example: from head to tail, in each step, you just can replace one character,
//and the word must be valid. You'll be given a dictionary.
public class CanBeTransfer {

    static HashSet<String> dictionary = new HashSet<String>();
    static HashMap<String, String> parents = new HashMap<>();

    public static List<String> canTransfer(List<String> input, String start, String end) {
        char[] allCharacters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (String s : input) {
            dictionary.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (queue.size() > 0) {
            int count = queue.size();
            for (int k = 0; k < count; k++) {
                String s = queue.poll();
                for (int i = 0; i < s.length(); i++) {
                    for(char c : allCharacters) {
                        String newWord = s.replace(s.charAt(i),c);
                        if (dictionary.contains(newWord)) {
                            if (!parents.keySet().contains(newWord)) {
                                parents.put(newWord,s);
                                queue.add(newWord);
                            }
                        }
                        if (newWord.equals(end)) {
                            return ExtractPath(start, end);
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<String> ExtractPath(String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;
        path.add(end);
        while (!current.equals(start)) {
            current = parents.get(current);
            path.add(0,current);
        }
        return path;
    }
}
