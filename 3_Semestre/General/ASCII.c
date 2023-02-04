#include <stdio.h>

int main() {
    char character;

    printf("\nType a character: ");
    scanf("%c", &character);
    printf("\n%c's ASCII value is %d", character, character);

    return 0;
}
