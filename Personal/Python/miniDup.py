def sol(a):   
    min_d = None
    min_i = float('inf')
    aux = []
    for i in range(len(a)):
        num = a[i]
        if num in aux:
            if i < min_i:
                min_i = i
                min_d = num
        else:
            aux.append(num)
    return min_d
a = [2, 1, 3, 5, 3, 2]
print(sol(a))
