def solution(s):
    # while the length of the string is greater than 1
    while len(s) > 1:
        # create an empty list to store the prefixes
        pref = []
        # iterate through the string and add each prefix to the list
        for i in range(len(s)):
            pref.append(s[:i+1])
        # initialize the longest palindrome prefix
        max_pali = ""
        # iterate through the prefixes
        for pre in pref:
            # if the prefix is a palindrome and is longer than the current longest palindrome prefix
            if pre == pre[::-1] and len(pre) > len(max_pali):
                # update the longest palindrome prefix
                max_pali = pre
        # if the longest palindrome prefix has a length greater than 1
        if len(max_pali) > 1:
            # cut the longest palindrome prefix from the string
            s = s[len(max_pali):]
        # if the longest palindrome prefix has a length of 1 or less
        else:
            # end the loop
            break
    # return the final string
    return s
