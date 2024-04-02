/*
In this code we are taking input from the user for the corners of the house and
using the shoelace equation in order to return the area of the layout. To
implement the shoelace equation in code for calculating the area of a house
layout based on user-input corners, first gather the ordered x and y coordinates
of the corners. Then, iteratively calculate cross-multiplications of adjacent
point coordinates, summing x_i * y_i+1 to one total and y_i * x_i+1 to another,
including a wrap-around to the first point to close the polygon. The area is
then determined by taking the absolute value of the difference between these two
sums, divided by 2.
*/
#include <stdio.h>
#include <stdlib.h>

float calculate_area(int cord[][2], int n) {
    float area = 0;
    for (int i = 0; i < n; i++) {
        int j = (i + 1) % n; // Loop around in a circular
        area += (cord[i][0] * cord[j][1]) -
            (cord[i][1] * cord[j][0]); // Shoelace equation
    }
    return abs(area) / 2.0;
}

int main() {
    int n;
    scanf("%d", &n);
    int cord[n][2];
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &cord[i][0], &cord[i][1]);
    }

    printf("%f\n", calculate_area(cord, n));
    return 0;
}