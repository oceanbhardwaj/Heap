method--1-->>>o(nlogn)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
        
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
method-2----max heap---->O(nlogk)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)
    pq.add(i);
        int d=0;
        while(k>0)
        {
            d=pq.poll();
            k--;
        }
         return d;   
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
method-3---->min heap---->o(nlogk) o(k)space
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:nums)
    pq.add(i);
        
        while(pq.size()>k)
        {
           pq.poll();
        }
         return pq.peek();   
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
method-4 quick select--o(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        // using quick select
        
        return quickSort(nums,n-k,0,n-1);
        
    }
    public int quickSort(int nums[],int k,int i,int j)
    {
        int pi=partition(nums,i,j);
       // System.out.println(pi);
        if(pi==k)
            return nums[pi];
        else if(pi>k)
            return quickSort(nums,k,i,pi-1);
        else
            return quickSort(nums,k,pi+1,j);
    }
    public int partition(int nums[],int low,int high)
    {
        int mid=(low+high)/2;
       int pivot=nums[mid];
        swap(nums,mid,high);
       int i=low-1;
        for(int j=low;j<high;j++)
        {
            if(nums[j]<pivot)
            {
                i++;
                swap(nums,i,j);}
            
            
        }
        swap(nums,i+1,high);
        return i+1;




        
        
        
        
        
    }
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        
        
    }
}

