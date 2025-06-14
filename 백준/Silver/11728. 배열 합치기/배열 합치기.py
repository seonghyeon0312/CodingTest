import sys
input = sys.stdin.readline

n,m=map(int,input().split())

arr1= list(map(int,input().split()))
arr2 = list(map(int,input().split()))
arr1.extend(arr2)
arr = sorted(arr1)

print(" ".join(map(str, arr)))    