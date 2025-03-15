import math

def sieve(N):
    prime = [True for _ in range(N+1)]
    prime[0]=prime[1]=False
    sqrt = int(math.sqrt(N))
    for i in range(2, sqrt+1):
        if prime[i]:
            for j in range(i*i,N+1,i):
                prime[j]= False
                
    return [i for i, isPrime in enumerate(prime) if isPrime]

def partition():
    N = int(input())
    
    prime = sieve(N)
    first, second = 0,0
    left, right= 0, len(prime)-1
    minDiff = N
    
    while left<=right:
        num1, num2 = prime[left], prime[right]
        total = num1+num2
        if total == N:
            if abs(num1-num2) < minDiff:
                first = num1
                second = num2
                minDiff = abs(num1-num2)
            left+=1
            right-=1
        elif total<N:
            left+=1
        else:
            right-=1
                
    print(min(first,second),max(first,second))
        

test = int(input())

for i in range(0,test):
    partition()