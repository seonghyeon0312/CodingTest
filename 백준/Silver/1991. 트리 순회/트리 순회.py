from collections import deque
import sys
print = sys.stdout.write
class Node:
    def __init__(self, value, left = None, right = None):
        self.value = value
        self.left = None if left == "." or not left else Node(left)
        self.right = None if right == "." or not right else Node(right)

class Tree:
    def __init__(self):
        self.root = None
        self.maxSize = None

    @classmethod
    def Tree(cls, root, size = None):
        obj = cls()
        if obj.root:
            raise ValueError("이미 루트가 존재하고 있습니다.")
        obj.root = root
        obj.maxSize = size
        return obj

    def preOrder(self):
        stack=deque()
        stack.append(self.root)

        while stack:
            root = stack.pop()
            print(root.value)
            if root.right:
                stack.append(root.right)
            if root.left:
                stack.append(root.left)

    def postOrder(self):
        root = self.root
        self._postOrder(root)

    def _postOrder(self, root):
        if root.left:
            self._postOrder(root.left)
        if root.right:
            self._postOrder(root.right)
        print(root.value)

    def inOrder(self):
        root = self.root
        self._inOrder(root)

    def _inOrder(self, root):
        if root.left:
            self._inOrder(root.left)
        print(root.value)
        if root.right:
            self._inOrder(root.right)

    def push(self, node):
        queue = deque()
        queue.append(self.root)
        while queue:
            root = queue.popleft()

            if root.value == node.value:
                root.left= node.left
                root.right = node.right
                return
            else:
                if root.left:
                    queue.append(root.left)
                if root.right:
                    queue.append(root.right)


N = int(input())
root = input().split()
tree = Tree.Tree(Node(root[0],root[1],root[2]), N)
for _ in range(1,N):
    root, left, right = input().split()
    node = Node(root,left,right)
    tree.push(node)

tree.preOrder()
print("\n")
tree.inOrder()
print("\n")
tree.postOrder()
print("\n")