import sys

N = int(input())
cards= dict()
lst = input().split()
cards = cards.fromkeys(lst, True)
del lst

M=int(input())
target = input().split()
result = list()
for t in target:
    if cards.__contains__(t):
        result.append("1")
    else:
        result.append("0")

print(" ".join(result))