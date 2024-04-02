# Part I:

l = [1, 2, 1, 3, 1, 4]
set_k = set(l)
print(f"set : {set_k} | length of the set: {len(set_k)}")
set_f = set(i for i in range(10) if i not in set_k)
print(f"set : {set_f} | length of the set: {len(set_f)}")

# Part II:

# string_s = "I like Sets and sets And dictionaries"
# split_s = string_s.split()
# set_s = set(split_s)
# # print(f"set : {set_s} | length of the set: {len(set_s)}")
# set_l_s = set(i.lower() for i in split_s)
# # print(f"set : {set_l_s} | length of the set: {len(set_l_s)}")
# set_s_2 = set(str(i) for i in split_s)
# print(f"set : {set_s_2} | length of the set: {len(set_s_2)}")

words = "I like Sets and sets And dictionaries".split()
word_set = set(w.lower() for w in words)

appearances = []
seen = set()
for i, w in enumerate(words):
    lower = w.lower()
    if lower not in seen:
        appearances.append((i + 1, w))
        seen.add(lower)
print(", ".join(f"{i}: {w}" for i, w in appearances))