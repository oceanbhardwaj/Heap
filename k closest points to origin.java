class Solution {
    class Pair
    {
        int x;
        int y;
        double val;
        Pair(int x,int y,double val)
        {
            this.x=x;
            this.y=y;
            this.val=val;
        
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> (((Double) a.val).compareTo((Double) b.val)));
        for(int a[]:points)
        {
            int x1=a[0];
            int y1=a[1];
            double val1=Math.sqrt((x1*x1+y1*y1));
            pq.add(new Pair(x1,y1,val1));
        }
        int arr[][]=new int[k][2];
        int index=0;
        while(!pq.isEmpty() && k>0)
        {
            Pair p=pq.poll();
            arr[index][0]=p.x;
            arr[index++][1]=p.y;
            k--;
        }
        return arr;
    }
}
//////////////////////////////////////////////////////class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        
        int arr[][]=new int[k][2];
        int index=0;
        
            Comparator co=new Comparator<int[]>()
        {
            public int compare(int p1[],int p2[])
            {
                int x1=p1[0];
                int y1=p1[1];
                int val1=x1*x1+y1*y1;
                int x2=p2[0];
                int y2=p2[1];
                int val2=x2*x2+y2*y2;
                return val1-val2;
            }
                
                
        };
        Arrays.sort(points,co);
        for(int i=0;i<k;i++)
        {
            arr[i][0]=points[i][0];
            arr[i][1]=points[i][1];
        }
        return arr;
        
    }
}