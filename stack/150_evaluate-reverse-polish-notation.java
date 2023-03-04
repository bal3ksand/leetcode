class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> s = new ArrayDeque<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i].charAt(tokens[i].length() - 1)))
                s.push(Integer.parseInt(tokens[i]));
            else {
                int c1, c2;
                c2 = s.pop();
                c1 = s.pop();
                if (tokens[i].charAt(0) == '+')
                    s.push(c1 + c2);
                else if (tokens[i].charAt(0) == '-')
                    s.push(c1 - c2);
                else if (tokens[i].charAt(0) == '*')
                    s.push(c1 * c2);
                else if (tokens[i].charAt(0) == '/')
                    s.push(c1 / c2);
            }
        }
        return s.pop();
    }
}