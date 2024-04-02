#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <ctype.h>

void read_input(double *v, double *g, double *t) 
{
    char input[50]; // Increased buffer size for larger numbers
    if (fgets(input, 50, stdin) == NULL) 
    {
        fprintf(stderr, "Error reading input\n");
        exit(1);
    }
    // Attempt to parse three double values
    if (sscanf(input, "%lf %lf %lf", v, g, t) != 3)
    {
        fprintf(stderr, "Invalid input format\n");
        exit(1);
    }
}

int main() 
{
    double v, g, t;
    read_input(&v, &g, &t);
    if (v <= 0 || g <= 0 || v >= t) 
    {
        return 1;
    }
    double minutes = (log(t)-log(v))/log(1 + g);
    int result = (int)ceil(minutes);
    printf("%d", result);
    return 0;
}
