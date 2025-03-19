import sys
input = sys.stdin.readline

def power(a, b, c):
    if b == 1:  # base case
        return a % c
    
    half = power(a, b // 2, c)  # a^(b//2) % c 를 구함
    half = (half * half) % c  # 제곱해서 모듈러 연산

    if b % 2 == 1:  # b가 홀수라면 추가적으로 a 한 번 더 곱함
        half = (half * a) % c

    return half

a, b, c = map(int,input().split())

print(power(a,b,c))