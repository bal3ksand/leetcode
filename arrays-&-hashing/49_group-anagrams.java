class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (map.containsKey(sorted))
                map.get(sorted).add(s);
            else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(sorted, l);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (Map.Entry<String, List<String>> e : map.entrySet())
            result.add(e.getValue());
        return result;
    }
}