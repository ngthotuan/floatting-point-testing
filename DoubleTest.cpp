#include <stdio.h>
int main() {
    int limit = 10;
    long a = 0b0100000'00000000'00000000'00000000'00000000'00000000'00000000L; // 2^53
    long b = 0b1000000'00000000'00000000'00000000'00000000'00000000'00000000L; // 2^54
    printf("a: %ld, b: %ld\n", a, b);

    for (long d = a; d <= b && limit-- >= 0; d++) {
        printf("d:%08ld, float:%8.1lf\n", d, (double)d);
    }
    return 0;
}
