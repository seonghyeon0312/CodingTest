import sys
print = sys.stdout.write

N, B = map(int,input().split())
MOD = 1000

procession = [list(map(int,input().split())) for _ in range(N)]

def multiply_matrix(A, B,MOD):
    N = len(A)
    result = [[0]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            for k in range(N):
                result[i][j] += A[i][k] * B[k][j]
            result[i][j] %= MOD
    
    return result

def mat_pow(matrix, power, mod):
    if power == 1:
        return [[x % mod for x in row] for row in matrix]
    half = mat_pow(matrix, power // 2, mod)
    half_squared = multiply_matrix(half, half,mod)
    if power % 2 == 0:
        return half_squared
    else:
        return multiply_matrix(half_squared, matrix, mod)
    
result = mat_pow(procession, B, MOD)

for row in result:
    for col in row:
        print(str(col)+" ")
    print("\n")    