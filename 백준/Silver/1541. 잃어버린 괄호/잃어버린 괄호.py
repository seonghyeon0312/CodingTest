formula = input().strip()
# '-'를 기준으로 수식을 분리
parts = formula.split('-')

result = sum(map(int, parts[0].split('+')))

for part in parts[1:]:
    result -= sum(map(int, part.split('+')))

print(result)