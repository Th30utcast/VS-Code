from typing import List


def twoSum(nums: List[int], target: int) -> List[int]:
    l = []
    for i in range(len(nums)):
        for j in range(i+1,len(nums)):
            if nums[i]+nums[j] == target:
                l.append(i)
                l.append(j)
                return l
            
def twoSum_OnePass(nums: List[int], target: int) -> List[int]:
    hashmap = {} # value : index
    for index,value in enumerate(nums):
        diff = target - value
        if diff in hashmap:
            return [hashmap[diff], index]
        hashmap[value] = index

nums = [2,7,11,15]
target = 9

print(f'sum = {twoSum(nums,target)}')
print(f'sum one pass = {twoSum_OnePass(nums,target)}')