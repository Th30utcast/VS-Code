#include <stdio.h>
#include <math.h>

// Function to calculate the total winning probability
double winning_probability(int n, double p) {
    double probability = 1.0;
    for (int i = 1; i <= n; i++) {
        probability *= 1.0 - pow((1.0 - p), i);
    }
    return probability;
}

double find_max_probability(int n, int c, int r) {
    double low = 0.0, high = 1.0, mid, w;
    while (high - low > 1e-6) { // Loop until the precision is less than 10^-6
        mid = (low + high) / 2;
        w = winning_probability(n, mid) * r;
        if (w - c > 0) { // Adjust the bounds based on the condition W * r - c
            high = mid;
        } else {
            low = mid;
        }
    }
    return mid;
}

int main() {
    int n, c, r;
    double p;

    scanf("%d %d %d", &n, &c, &r);

    p = find_max_probability(n, c, r);

    printf("%.6f\n", p);

    return 0;
}
