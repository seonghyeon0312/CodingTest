N = int(input())

fibo = list()
fibo.append(0)
fibo.append(1)

mod = 15746
for i in range(2,N+2):
    base = fibo[i-1]+fibo[i-2]
    fibo.append(base%mod)

print(fibo[N+1])