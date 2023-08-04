# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        
        queue = collections.deque()
        queue.append(root)
        depth = 0
        
        while queue:
            depth += 1
            # 해당 depth에 있는 모든 노드를 꺼낸다
            for _ in range(len(queue)):
                cur = queue.popleft()
                
                # 자식노드가 있다면 자식노드를 큐에 삽입한다
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                    
        # BFS 반복횟수는 depth
        return depth