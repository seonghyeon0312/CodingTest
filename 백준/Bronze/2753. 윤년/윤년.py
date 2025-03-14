year=int(input())

firstCondition = (year%4==0) and (year%100 != 0)
secondCondition = year%400 == 0

if firstCondition or secondCondition:
    print(1)
else:
    print(0)