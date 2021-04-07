class MedianFinder {
     PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public MedianFinder() {
        max=new PriorityQueue<>(Collections.reverseOrder());
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.size()==0 || max.peek()>=num)
        {
            max.add(num);
        }
        else
            min.add(num);
        rebalance();
        
    }
    
    public double findMedian() {
        if(max.size()>min.size())
            return (double)max.peek();
        else
        {
            return max.peek()/2.0 +min.peek()/2.0;
        }
        
    }
    
    public void rebalance()
    {
        if(max.size()>min.size()+1)
        {
            min.add(max.poll());
        }
        else if(min.size()>max.size())
        {
            max.add(min.poll());
        }
            
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */