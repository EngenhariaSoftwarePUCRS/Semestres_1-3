#include <stdio.h>

int main() {
    char greeting[6] = { 'H', 'e', 'l', 'l', 'o', '\0'};
    char betterGreeting[] = "Hello";

    printf("%s\n", greeting);
    printf("%s\n", betterGreeting);
    return 0;
}
