import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
diction = dict()

for _ in range(N):
    word = input().strip()
    if len(word) not in diction:
        diction[len(word)] = [word]
    else:
        if word not in diction[len(word)]:
            diction[len(word)].append(word)

for key in diction.keys():
    diction[key] = sorted(diction[key])

for i in range(1,51):
    if i in diction:
        for word in diction[i]:
            print(f"{word}\n")