def z_order(n, x, y, r, c, count):
    if n == 0:
        return count
    
    size = 2 ** (n - 1) 
    half = size ** 2 
    
    if r < x + size and c < y + size: 
        return z_order(n - 1, x, y, r, c, count)
    elif r < x + size and c >= y + size:
        return z_order(n - 1, x, y + size, r, c, count + half)
    elif r >= x + size and c < y + size:
        return z_order(n - 1, x + size, y, r, c, count + 2 * half)
    else:
        return z_order(n - 1, x + size, y + size, r, c, count + 3 * half)

N, r, c = map(int, input().split())

print(z_order(N, 0, 0, r, c, 0))