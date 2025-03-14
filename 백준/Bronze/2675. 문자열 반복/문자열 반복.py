test = int(input())

for i in range(0,test):
    temp = input().split()
    
    repeat = int(temp[0])
    target = temp[1]
    result = ""
    for n in target:
        result += (repeat*n)
        
    print(result)
