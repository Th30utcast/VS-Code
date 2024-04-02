"""
In this problem, i started with taking the input excluding the last element (which is 0) to ensure the amount of muffins liked by the judges.
After collecting all the judges perfrences, i then list the prefrences in a set, which is then compared with each other using the intersection function
which in return represents the common prefrences shared by all judges. If the set is empty then that means there is no common prefrences, otherwise
the program will ouput the common prefrence
"""

def read_preferences(n):
    judges_preferences = []
    for _ in range(n):
        line = input()

        # exclude the last element first
        split_line = line.split()[:-1] 
        preferences = []
        for item in split_line:
            preferences.append(int(item))

        judges_preferences.append(preferences)
    return judges_preferences

def check_common_recipe(judges_preferences):
    # convert each judges preferences to a set
    judges_sets = [set(pref) for pref in judges_preferences]
    '''
    Refrence: https://www.w3schools.com/python/ref_set_intersection.asp
    '''
    # find the intersection of all sets
    common_recipes = set.intersection(*judges_sets)
    # If the intersection is not empty, there is at least one common recipe
    return 'yes' if common_recipes else 'no'
def main():
    string_s = input()
    numbers = string_s.split()
    # number of judges
    n = int(numbers[1])
    judges_preferences = read_preferences(n)
    print(check_common_recipe(judges_preferences))
    
main()
