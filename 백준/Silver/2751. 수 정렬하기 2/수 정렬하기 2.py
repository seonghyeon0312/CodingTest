import sys
input = sys.stdin.readline
print = sys.stdout.write

N=int(input())

numbers = [int(input()) for _ in range(N)]
numbers.sort()
[print(f"{number}\n") for number in numbers]