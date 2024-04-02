from ast import List


def topKFrequent(nums: List[int], k: int) -> List[int]:
    if len(nums) == 1:
        return nums
    nums.sort()
    freq = {}
    for key in nums:
        if key in freq:
            freq[key] += 1
        else:
            freq[key] = 1
    freq = sorted(freq, key = freq.get, reverse=True)
    output = []
    for i in range(k):
        output.append(freq[i])
    return output


print(f"{topKFrequent([1,1,1,2,2,3],2)}")
