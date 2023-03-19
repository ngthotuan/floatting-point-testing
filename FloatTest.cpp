#include <stdio.h>
int main() {
    int limit = 10;
    int a = 0b00000001'00000000'00000000'00000000; // 2^24
    int b = 0b00000010'00000000'00000000'00000000; // 2^25
    printf("a: %d, b: %d\n", a, b);

    for (int d = a; d <= b && limit-- >= 0; d++) {
        printf("d:%08d, float:%8.1f\n", d, (float)d);
    }
    return 0;
}
