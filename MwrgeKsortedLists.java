/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode a=new ListNode(1);
        ListNode b=a;
        ArrayList<Integer> arr=new ArrayList<>();
        for(ListNode a1:lists)
        {
            ListNode head=a1;
            while(head!=null)
            {
               
               arr.add(head.val);
                head=head.next;
            }
        }
        Collections.sort(arr);
        for(int i:arr)
        {
            b.next=new ListNode(i);
            b=b.next;
            
        }
        return a.next;
    }
}

////////////////////////////////////////////////////////////////////////////////////////// merge lists one by one
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        {System.out.println("jjjjjjjj");
            return null;
        }
        if(lists.length==1)
            return lists[0];
       ListNode left=lists[0];
        ListNode right=lists[1];
       ListNode mer= Merge(left,right);
        for(int i=2;i<lists.length;i++)
        {
            mer=Merge(mer,lists[i]);
        }
        return mer;
        
    }
    public ListNode Merge(ListNode left,ListNode right)
    {
        ListNode head1=left;
        ListNode head2=right;
        ListNode a=new ListNode(1);
        ListNode b=a;
        while(head1!=null || head2!=null)
        {
          while(head1!=null && head2!=null)
          {
              if(head1.val<head2.val)
              {
                  b.next=head1;
                  b=b.next;
                  head1=head1.next;
              }
              else
              {
                  b.next=head2;
                  b=b.next;
                  head2=head2.next;
              }
          }
            while(head1!=null)
            {
                b.next=head1;
                head1=null;
            }
            while(head2!=null)
            {
                b.next=head2;
                    head2=null;
            }
           
        
        
        }
         return a.next;
        
        
        
        
        
        
    
}
}
//////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        if(lists.length==0)
            return null;
        ListNode a=new ListNode(1);
        ListNode b=a;
        for(int i=0;i<lists.length;i++)
        {
          if(lists[i]!=null)
              pq.add(lists[i]);
        }
        while(!pq.isEmpty())
        {
            ListNode i=pq.poll();
            b.next=i;
            b=b.next;
            if(i.next!=null)
            pq.add(i.next);
        }
        return a.next;
        
    }
}
/////////////////////////////////////merge sort///////////////////////////////////////////////////
o(nlogk)
o(1) space