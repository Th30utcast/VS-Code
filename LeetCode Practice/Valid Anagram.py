s = "anagram"
t = "nagaram"

def check(s: str, t: str)-> bool:
    if len(s) != len(t):
        return False
    
    dict_s = {}
    for char in s:
        if char in dict_s:
            dict_s[char]+=1
        else:
            dict_s[char]=1
            
    dict_t = {}
    for char in t:
        if char in dict_t:
            dict_t[char]+=1
        else:
            dict_t[char]=1
    for i in dict_s:
        if i not in dict_t or dict_s[i] != dict_t[i]:
            return False
    return True
print(check(s,t))