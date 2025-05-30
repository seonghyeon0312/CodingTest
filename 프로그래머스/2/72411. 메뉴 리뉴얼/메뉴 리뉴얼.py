from itertools import combinations

def solution(orders, course):
    answer = []

    for i in range(len(orders)):
        orders[i] = list(orders[i])
    
    result = dict()
    temp = list()
    
    for c in course:
        result[c] = dict()
        for order in orders:
            order = sorted(order)
            for comb in combinations(order, c):
                menu = ''.join(comb)
                result[c][menu] = result[c].get(menu, 0) + 1
    
    for c in course:
        filtered = {menu: cnt for menu, cnt in result[c].items() if cnt >= 2}
        if not filtered:
            continue
        max_count = max(filtered.values())
        for menu, cnt in filtered.items():
            if cnt == max_count:
                answer.append(menu)
            
    return sorted(answer)