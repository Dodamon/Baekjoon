# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # LinkedList의 길이가 0 또는 1 또는 2 일때 
        if head is None or head.next is None or head.next.next is None:
            return head
        
    
        even_head = head.next
        odd = head
        even = head.next
        # odd -> even -> odd -> even
        
        while even and even.next:
            odd.next, even.next = odd.next.next, even.next.next
            odd, even = odd.next, even.next
        
        odd.next = even_head
        return head