/*
In the provided program, I take input from stdin using `getchar`. After that, I
check if the input has 'p' or 's'. If the mode is 'p', then the program reads
the characters, converts them to lowercase to ensure uniformity, records the
frequency of each character, and finally outputs each character's frequency
followed by the character itself. If the mode is 's', the program directly
prints each letter according to its specified count without calculating the
frequency, since the input is an integer followed by a character, and that
integer is the count of the character.
*/
#include <ctype.h>
#include <stdio.h>

int main() {
  int n;
  char mode, ch;
  scanf("%d %c", &n, &mode);
  getchar(); // Consume the newline after mode input

  if (mode == 'p') {
    int count = 1;
    char current, prev = getchar(); // Read the first character
    for (int i = 1; i < n; i++) {
      current = getchar();
      if (current == prev) {
        count++;
      } else {
        printf("%d%c", count, prev);
        count = 1; // Reset count for the new character
      }
      prev = current;
    }
    printf("%d%c\n", count, prev); // Print the last character and its count
  } else if (mode == 's') {
    while ((ch = getchar()) != EOF && ch != '\n') {
      if (isdigit(ch)) {
        int count = ch - '0';
        // Handle multi-digit numbers
        while (isdigit(ch = getchar())) {
          count = count * 10 + (ch - '0');
        }
        for (int i = 0; i < count; i++) {
          printf("%c", ch);
        }
      }
    }
    printf("\n");
  }

  return 0;
}