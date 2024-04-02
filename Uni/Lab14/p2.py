#               Part I:

dic = {"hello": "Hallo", "goodbye": "Auf Wiedersehen", "university": "Universität", "computer":"Computer","dictionary": "Wörterbuch", "book": "Buch"}
#print(f"dictionary is: {dic}")

dic["i"] = "Ich"
#print(f"updated dictionary is: {dic}")

# for keys in dic.keys(): 
#     print(f"{keys} transaltes to {dic[keys]}")
inp_s = input("Enter your string: ")
inp_s = inp_s.lower().split()

dics = {i:dic[i] for i in inp_s if i in dic}

def printd(dics):
    for key in dics:
        print(f"{dics[key]}",end=" ")
    print()
printd(dics)

set_s = set(word for word in inp_s if word not in dics)
print(f"set s: {set_s}")

# #           Part II:
# input_string = "Hello hello I say HELLO"
# # get the inputs and place them in a list

# set_v = {"a","o","e","u","i"}
# input_string = input_string.split()

# set_temp = set(i for i in input_string if i.lower not in input_string)
# print(f"set: {set_temp}")
# # compare the strings to the set, if they have add them into another list removing that vowel
