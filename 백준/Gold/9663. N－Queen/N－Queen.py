def solve(row, col, diag1, diag2, N):
    if row == N:
        return 1
    count = 0
    available_positions = ((1 << N) - 1) & ~(col | diag1 | diag2)
    while available_positions:
        position = available_positions & -available_positions  # 최하위 비트 선택
        available_positions -= position  # 해당 위치 사용
        count += solve(row + 1, col | position, (diag1 | position) << 1, (diag2 | position) >> 1, N)
    return count

N = int(input())
print(solve(0, 0, 0, 0, N))