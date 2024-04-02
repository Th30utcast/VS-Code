/*
In this problem the code determines if there's a combination of recipes
satisfying all judges preferences in a baking contest using a brute force
recursive approach. Each judge has a set of preferred recipes, denoted by
integers, where positive values indicate a preference for the recipe and
negative values indicate a disfavor. The program reads the number of recipes (m)
and judges (n), followed by each judges preferences, ending with a zero. It
generates all possible combinations of recipes recursively, seeking at least one
that meets all judges criteria. If such a combination exists, it prints "yes";
otherwise, "no".
*/

#include <stdbool.h>
#include <stdio.h>

#define MAX_RECIPES 25
#define MAX_JUDGES 100

// Stores judges preferences
int judges_preferences[MAX_JUDGES][MAX_RECIPES + 1];
// Tracks the number of preferences per judge.
int num_preferences[MAX_JUDGES] = {0};

int m, n;

// Checks if a given combination satisfies all judges' preferences.
bool satisfies_all_judges_optimized(int combination[]) {
  for (int j = 0; j < n; j++) {
    bool judge_satisfied = false;
    for (int p = 0; p < num_preferences[j]; p++) {
      for (int c = 0; c < m; c++) {
        if (judges_preferences[j][p] == combination[c]) {
          judge_satisfied = true;
          break;
        }
      }
      if (judge_satisfied)
        break;
    }
    if (!judge_satisfied)
      return false;
  }
  return true;
} 

// Recursively generates all possible combinations of recipes
void generate_combinations_optimized(int index, int current[], bool *found,
                                     int valid_combination[]) {
  if (*found)
    return;

  if (index == m) {
    if (satisfies_all_judges_optimized(current)) {
      for (int i = 0; i < m; i++) {
        valid_combination[i] = current[i];
      }
      *found = true;
    }
    return;
  }

  // Each recipe can be chosen in two ways (1 or -1).
  int choices[] = {1, -1};
  for (int i = 0; i < 2; i++) {
    if (!*found) {
      current[index] = index + 1;
      current[index] *= choices[i];
      generate_combinations_optimized(index + 1, current, found,
                                      valid_combination);
    }
  }
}

int main() {
  scanf("%d %d", &m, &n);

  // Reading judges' preferences.
  int preference, judge_index = 0;
  for (int i = 0; i < n && judge_index < MAX_JUDGES; i++) {
    int p = 0;
    while (scanf("%d", &preference) && preference != 0 && p < MAX_RECIPES) {
      judges_preferences[judge_index][p++] = preference;
    }
    num_preferences[judge_index++] = p;
  }

  int current[MAX_RECIPES] = {0}, valid_combination[MAX_RECIPES] = {0};
  bool found = false;
  generate_combinations_optimized(0, current, &found, valid_combination);

  if (found) {
    printf("yes\n");
  } else {
    printf("no\n");
  }

  return 0;
}
