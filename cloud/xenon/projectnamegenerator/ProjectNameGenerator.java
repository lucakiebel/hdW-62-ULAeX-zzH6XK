package cloud.xenon.projectnamegenerator;

import java.util.*;

public class ProjectNameGenerator {

    private static final Map<Character, List<Character>> speakabel = new TreeMap<>();
    private static final Random random = new Random(System.currentTimeMillis());
    
    private static String name() {
        // a b c d e f g h i j k l m n o p r s t u
        final char[] possibleStarts = new char[] {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'r', 'p', 's', 't', 'u'
        };
        speakabel.put('a', Arrays.asList('b', 'd', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'u'));
        speakabel.put('b', Arrays.asList('a', 'e', 'i', 'l', 'o', 'r', 'u'));
        speakabel.put('c', Arrays.asList('h'));
        speakabel.put('d', Arrays.asList('a', 'e', 'i', 'l', 'o', 'r', 'u'));
        speakabel.put('e', Arrays.asList('f', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'u'));
        speakabel.put('f', Arrays.asList('a', 'e', 'i', 'l', 'o', 'r', 'u'));
        speakabel.put('g', Arrays.asList('a', 'e', 'i', 'l', 'o', 'u'));
        speakabel.put('h', Arrays.asList('a', 'e', 'i', 'o', 'u'));
        speakabel.put('i', Arrays.asList('b', 'f', 'k', 'l', 'm', 'n', 'p', 'r', 'h', 's', 't'));
        speakabel.put('j', Arrays.asList('a', 'e', 'i', 'o', 'u'));
        speakabel.put('k', Arrays.asList('a', 'e', 'i', 'l', 'o', 'u'));
        speakabel.put('l', Arrays.asList('a', 'e', 'i', 'o', 'u'));
        speakabel.put('m', Arrays.asList('a', 'e', 'i', 'j', 'o', 'u'));
        speakabel.put('n', Arrays.asList('a', 'e', 'i', 'o', 'u'));
        speakabel.put('o', Arrays.asList('b', 'c', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't'));
        speakabel.put('p', Arrays.asList('a', 'e', 'i', 'l', 'o', 'r', 'u'));
        speakabel.put('r', Arrays.asList('a', 'i', 'e', 'o', 'u'));
        speakabel.put('s', Arrays.asList('a', 'e', 'c', 'i', 'o', 'u', 't'));
        speakabel.put('t', Arrays.asList('a', 'e', 'i', 'o', 'u'));
        speakabel.put('u', Arrays.asList('b', 'g', 'i', 'k', 'n', 'm', 'p', 'r', 's', 't'));
        
        
        
        final int length = 5 + random.nextInt(10);
        char last = possibleStarts[random.nextInt(possibleStarts.length)];
        StringBuilder name = new StringBuilder(length);
        name.append(Character.toUpperCase(last));
        for (int i = 0; i < length; i++) {
            List<Character> possibleChars = speakabel.get(last);
            last = possibleChars.get(random.nextInt(possibleChars.size()));
            name.append(last);
        }
        return name.toString();
    }
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(name());
        } else {
            int count = Integer.parseInt(args[0]);
            for (int i = 0; i < count; i++) {
                System.out.println(name());
            }
        }
        
    }
}
