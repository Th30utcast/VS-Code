from typing import List

def rob(nums: List[int]) -> int:
    total = 0
    for i in range(0,len(nums),2):
        total += nums[i]
        print(f'i: {i} | total: {total}')
    return total

print(f"{rob([1,2,3,1])}")