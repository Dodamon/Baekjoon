# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        root = prev = ListNode(None)
        root.next = head
        a = head

        # root -> a -> b
        # root -> b -> a
        while a and a.next:

            # b가 a를 가리키도록 한다
            b = a.next
            a.next = b.next
            b.next = a

            # prev 가 b를 가리키도록 한다
            prev.next = b

            # 다음 연산을 위해 a 와 prev를 설정한다
            prev = a
            a = a.next
        
        return root.next
            