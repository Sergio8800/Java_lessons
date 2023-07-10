package lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class phoneDict {
    public static void main(String[] args) {

    }
    Map<Character,Character> simpol = new HashMap<>();
        simpol.put('}','{');
        simpol.put(')','(');
        simpol.put(']','[');
        simpol.put('>','<');
    Stack<Character> stack = new Stack<>();
        for (Character ch: strg.toCharArray()
            ) {if (simpol.containsValue(ch)){
        stack.add(ch);

    }else if (simpol.containsKey(ch)){
        if (stack.isEmpty() || stack.pop() != simpol.get(ch));
    }

    }
