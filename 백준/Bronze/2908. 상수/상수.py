def reverseNumber(num: int) -> int:
    one = num//100
    two = (num%100)//10
    three = num%10
    
    result=(three*100)+(two*10)+one
    return result

number = list(map(int,input().split()))

print(max(reverseNumber(number[0]),reverseNumber(number[1])))

