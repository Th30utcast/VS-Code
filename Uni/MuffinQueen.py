"""
In this code i use a brute force appraoch in orde to get all possible combinations 
of the prefrences of the judges, i do so recursivley through the generate_combinations
function, the function takes in the index until it reaches the number of bakers
otherwise it checks each judges prefrences and appends to a list, this is done recurivley
in order to achieve all combinations.
"""


def generate_combinations(index, current, m, combinations):
    if index == m:
        combinations.append(current.copy())
        return
    # For each baker, choose either the first or the second recipe
    for choice in [1, -1]:
        current.append(choice)
        generate_combinations(index + 1, current, m, combinations)
        current.pop()


def satisfies_all_judges(combination, judges_preferences):
    # Check if a combination satisfies all judges preferences
    for preferences in judges_preferences:
        if not any(recipe in preferences for recipe in combination):
            return False
    return True


def main():
    m, n = map(int, input().split())
    judges_preferences = []
    for _ in range(n):
        # Read each judges preferences, excluding the last 0
        preferences = list(map(int, input().split()[:-1]))
        judges_preferences.append(preferences)

    combinations = []
    generate_combinations(0, [], m, combinations)

    for index, combination in enumerate(combinations):
        combinations[index] = [
            i + 1 if combination[i] > 0 else -(i + 1) for i in range(m)
        ]

    for combination in combinations:
        if satisfies_all_judges(combination, judges_preferences):
            print("yes")
            return
    print("no")


main()
