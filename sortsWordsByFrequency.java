class Solution {
    class Pair
    {
        char ele;
        int freq;
        Pair(char ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
        
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((o1,o2)->o2.freq-o1.freq);
    for(Character c:h.keySet())
    {
        pq.add(new Pair(c,h.get(c)));
    }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
           int d=p.freq;
            char c=p.ele;
            for(int j=0;j<d;j++)
            {
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////bucket sort//////////////////////////////
class Solution {
    class Pair
    {
        char ele;
        int freq;
        Pair(char ele,int freq)
        {
            this.ele=ele;
            this.freq=freq;
        }
        
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
        }
        //bucket sort
        int n=s.length();
        //ArrayList<ArrayList<Character>> a=new ArrayList<ArrayList<Character>>();
        ArrayList<Character> a[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
           // a.add(new ArrayList<Character>());
            a[i]=new ArrayList<>();
        
        for(char c:h.keySet())
        {
            int f=h.get(c);
            //a.get(f).add(c);
            a[f].add(c);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=n;i>=0;i--)
        {
            for(int j=0;j<a[i].size();j++)
            {
                int ff=i;
               // char ee=a.get(i).get(j);
                char ee=a[i].get(j);
                for(int k=0;k<ff;k++)
                {
                    sb.append(ee);
                }
                
                
            }
        }
       return sb.toString(); 
}
}