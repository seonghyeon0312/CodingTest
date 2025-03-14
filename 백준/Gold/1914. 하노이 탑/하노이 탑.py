import sys
print = sys.stdout.write
def hanoiWithProcedure(n, start, end, temp):
    if n==1:
        print(f"{start} {end}\n")
        return
    hanoiWithProcedure(n-1,start,temp,end)
    print(f"{start} {end}\n")
    hanoiWithProcedure(n-1,temp,end,start)

n = int(input())
count = [0]
print(str(2**n-1)+"\n")
if n<=20:
    hanoiWithProcedure(n,1,3,2)