def solution(a, k):
    # sort the array in ascending order
    a.sort()
    # initialize the max length to the last element in the array
    max_len = a[-1]
    # initialize the ribbon count to 0
    count = 0
    # iterate through the array
    for i in range(len(a)):
        # if the current element is less than or equal to the max length
        if a[i] <= max_len:
            # increment the ribbon count
            count += 1
        # if the ribbon count is equal to k
        if count >= k:
            # return the max length
            return max_len
        # if the current element is greater than the max length
        if a[i] > max_len:
            # update the max length
            max_len = a[i]
            # reset the ribbon count
            count = 1
    # if the function has not returned yet, return -1
    return -1
print(solution([5,2,7,4,9],4))