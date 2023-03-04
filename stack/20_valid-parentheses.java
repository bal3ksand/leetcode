class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c))
                stack.push(c);
            else {
                if (stack.isEmpty() || map.get(c) != stack.pop())
                    return false;
            }
        }
        return stack.size() == 0;
    }
}