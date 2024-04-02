arr = [[0, 1, 1, 2],[0, 5, 0, 0], [2, 0, 3, 3]]
row = len(arr)
col = len(arr)
sum = 0
flag = True
count = -1

aux = []
for i in range(len(arr)):
    rowlist = [-1]*int(len(arr)+1)
    aux.append(rowlist)

for i in range(row):
    if (arr[i][0]==0):
        aux[i][0] = 0
    for j in range(len(arr[i])):
        if (arr[i][j] == 0):
            aux[i][j] = j

for i in range(len(arr)):
    for j in range(len(arr[i])):
        if(arr[i][j]!=0 and aux[i][j]!=j):
            sum +=arr[i][j]
print("sum = ",sum)