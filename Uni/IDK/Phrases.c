#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(char *first, char *second, int n, int m) 
{
    int r = 0;
    for (int i = 0; i <= m - n; i++) 
    {
        int result = 0;
        for (int j = 0; j < n; j++) 
        {
            if (first[j] == second[i + j]) 
            {
                result++;
            }
            else 
            {
                break;
            }
        }
        if (result == n) 
        {
            r++;
        }
    }
    return r;
}

int main() 
{
    int n, m;
    scanf("%d", &n);
    scanf("%d", &m);

    char *One = (char*) malloc((n + 1) * sizeof(char));
    scanf("%s", One);

    while (getchar() != '\n');

    char *Two = (char *)malloc((m + 1) * sizeof(char));
    fgets(Two, m + 1, stdin);

    int result = compare(One, Two, n, m);
    printf("%d\n", result);

    free(One);
    free(Two);

    return 0;
}