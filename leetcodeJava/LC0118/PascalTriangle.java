class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i<numRows; i++)
        {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<i+1;j++)
            {
                if(j == 0 || j == i) row.add(j,1);
                else
                {
                    int sum = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    row.add(j,sum);
                }
            }
            result.add(i,row);
        }
        return result;
    }
}