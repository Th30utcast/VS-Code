def almostIncreasingSequence(arr):
    # Initialize a variable to keep track of whether a single element has been removed or not
    removed = False
    for i in range(len(arr)-1):
        # Check if the current element is greater than or equal to the next element
        if arr[i] >= arr[i+1]:
            # Check if we have already removed an element before
            if removed:
                return False
            if (i-1 >= 0 and arr[i] >= arr[i-1]):
                # Check if the next element is less than or equal to the previous element
                if (i+1 < len(arr) and arr[i+1] <= arr[i-1]):
                    # set the next element equal to current element
                    arr[i+1] = arr[i]
                else:
                    # set current element equal to previous element
                    arr[i] = arr[i-1]
            removed = True
    # If the function completes the iteration without returning False, it returns True
    # indicating that it is possible to remove a single element to make the sequence increasing
    return True

arr = [1, 2, 3, 4, 3, 6]
print(almostIncreasingSequence(arr))
print(arr)