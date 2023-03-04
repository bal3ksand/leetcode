class Solution {
    public List<String> result = new ArrayList<String>();
    public int n;
    
    public void dfs (String s, int nOpen) {
        if (s.length() == this.n)
            result.add(s);
        else {
            if (nOpen < n - s.length())
                dfs(s.concat("("), nOpen + 1);
            if (nOpen > 0) 
                dfs(s.concat(")"), nOpen - 1);
        }
    }
    
    public List<String> generateParenthesis (int n) {
        this.n = 2 * n;
        dfs("", 0);
        return result;
    }
}