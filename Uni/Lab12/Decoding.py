def check_for_non_number(s):
    s1 = s.replace("l","1").replace("O","0").split()
    sum = 0
    print(s1)
    for i in s1:
        sum += int(i)
    average = sum/len(s1)
    print(average)
s = "10 1l 12"
check_for_non_number(s)