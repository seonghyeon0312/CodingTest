N = int(input())

result = ["YES","NO"]

for i in range(N):
    vps = input()
    stack = []
    for ch in vps:
        if len(stack)!=0:
            if ch == ")" and stack[-1] == "(":
                stack.pop()
            else:
                stack.append(ch)
        else:
            stack.append(ch)
            
    if stack:
        print("NO")
    else:
        print("YES")