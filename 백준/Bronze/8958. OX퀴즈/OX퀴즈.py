def calculateScore():
    ox = input()
    score = 0
    result = list()
    for n in ox:
        if n == "O":
            score+=1
            result.append(score)
        elif n == "X":
            score=0
            result.append(score)
            
    print(sum(result))

test = int(input())

for i in range(0,test):
    calculateScore()