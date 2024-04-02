#include <stdio.h>

long long int find_extra_people(long long int n) {
    long long int m = 1;
    // Find the next triangular number that allows equal division
    while (((m * (m + 1)) / 2) < n) 
    {
        m++;
    }
    // Calculate the difference between this triangular number and n
    return ((m * (m + 1)) / 2) - n;
}

int main() {
    long long int n;
    scanf("%lld", &n);
    long long int extra = find_extra_people(n);
    printf("%lld", extra);
    return 0;
}
