def solution(s):
        pref = []
        #Getting all the possible prefexis from the string
        for i in range(len(s)):
            pref.append(s[:i+1])
        pali = []
        print("prefexies", pref)
        #Getting all the possible palindromes form the prefixes
        for i in range(len(pref)):
            #if the prefix is less than 2 charectes skip it and append the word itself so we can have a full word that is a prefix
            if (len(pref[i])>1):
                #initalize a new string that is i and we check if it's a palindrom or not
                s3 = pref[i]
                s2 = s3[::-1]
                #if it is a palindrom then add it to the list
                if s2 == pref[i]:
                    pali.append(s2)
            else:
                if (s == s[::-1]):
                    pali.append(s)
                else:
                    continue
        print("Palindromes ", pali)
        #check if the list is empty, if so return nothing 
        if len(pali)==0:
            return ""
        #other wise continue
        else:
            max=0
            j=0
            #check for the maximum length palindrome in the list
            for i in range(len(pali)):
                if len(pali[i])>max:
                    max = len(pali)
                    i=j
            #return the max
            return pali[j]
print(solution("aaacodedoc"))