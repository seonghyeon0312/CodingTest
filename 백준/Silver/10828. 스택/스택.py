import sys
input = sys.stdin.readline

N = int(input().strip())
stack = []

for _ in range(N):
    order = input().split()
    
    if order[0] == "push":
        stack.append(int(order[1]))  # push는 따로 함수 호출 없이 직접 append
    elif order[0] == "pop":
        print(stack.pop() if stack else -1)
    elif order[0] == "size":
        print(len(stack))
    elif order[0] == "empty":
        print(0 if stack else 1)
    elif order[0] == "top":
        print(stack[-1] if stack else -1)