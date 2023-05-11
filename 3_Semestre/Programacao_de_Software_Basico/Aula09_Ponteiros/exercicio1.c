#include <stdio.h>

/*
int main()
{
    int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int* ptr = nums;
    int i, bytes;
    for(i=0, bytes=0; i<10; i++, bytes+=4)
        printf("%d: %p + %d bytes = %p ==> %d\n",
            i, ptr, bytes, (ptr+i), *(ptr+i));
    return 0;
}

    Você consegue alterar o código, fazendo que ele exiba o conteúdo de cada byte do array?
*/

int main()
{
    int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    unsigned char* ptr = (char *)nums;
    int i, bytes;
    for(i = 0, bytes = 0; i < sizeof(int)*10; i++, bytes++)
        printf("%d: %p + %d bytes = %p ==> %d\n",
            i, ptr, bytes, (ptr+i), *(ptr+i));
    return 0;
}
