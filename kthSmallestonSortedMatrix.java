class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                pq.add(matrix[i][j]);
            }
        }
        while(!pq.isEmpty() && k-1>0)
        {
            pq.poll();
            k--;
        }
        return pq.peek();
        
    }
}