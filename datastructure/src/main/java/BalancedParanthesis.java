import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String... args) {
        Boolean balancedParanthesis = isBalancedParanthesis("{[)]}");
        System.out.println("valid paranthesis:: " + balancedParanthesis);
    }

    public static boolean isBalancedParanthesis(String str) {
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('{', '}');
        characterMap.put('[', ']');
        characterMap.put('(', ')');
        Stack<Character> characterStack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            char currCharacter = str.charAt(i);
            if (characterMap.keySet().contains(currCharacter)) {
                characterStack.push(currCharacter);
            } else if (characterMap.values().contains(currCharacter)) {
                if (!characterStack.isEmpty() && characterMap.get(characterStack.peek()) == currCharacter) {
                    characterStack.pop();
                } else {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    public static boolean isValid(String str) {

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
