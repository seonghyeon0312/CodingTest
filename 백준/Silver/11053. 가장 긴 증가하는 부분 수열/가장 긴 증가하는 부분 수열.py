N = int(input())
numbers=list(map(int,input().split()))

result = list()

def binary_search(arr, num):
    left, right = 0, len(arr)-1
    while left<=right:
        mid = (left+right)//2
        if arr[mid] < num:
            left=mid+1
        else:
            right-=1
    return left

for num in numbers:
    idx = binary_search(result, num)
    if idx == len(result):
        result.append(num)
    else:
        result[idx]=num
        
print(len(result))