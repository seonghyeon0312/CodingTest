import sys
input = sys.stdin.readline

def power(a, b, c):
    if b == 1:
        return a % c
    
    half = power(a, b // 2, c)  
    half = (half * half) % c

    if b % 2 == 1: 
        half = (half * a) % c

    return half

a, b, c = map(int,input().split())

print(power(a,b,c))