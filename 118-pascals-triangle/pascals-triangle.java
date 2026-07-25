class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // edges are always 1
                } else {
                    int above1 = result.get(i - 1).get(j - 1);
                    int above2 = result.get(i - 1).get(j);
                    row.add(above1 + above2);
                }
            }
            
            result.add(row);
        }
        
        return result;
    }
}