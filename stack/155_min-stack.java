class MinStack {
    List<Integer> s;
    List<List<Integer>> mins;

    public MinStack() {
        s = new ArrayList<Integer>();
        mins = new ArrayList<List<Integer>>();
    }
    
    public void push(int val) {
        s.add(val);
        if (mins.isEmpty() || val < this.getMin())
            mins.add(Arrays.asList(new Integer[]{val, s.size()}));
    }
    
    public void pop() {
        if (s.size() == mins.get(mins.size() - 1).get(1))
            mins.remove(mins.size() - 1);
        s.remove(s.size() - 1);
    }
    
    public int top() {
        return s.get(s.size() - 1);
    }
    
    public int getMin() {
        return mins.get(mins.size() - 1).get(0);
    }
}