/* 그대로 출력하기2 */

#include <stdio.h>
int main() {
	char c;

	while(1) {
		c = getchar();
		if(c == EOF)
			break;
		putchar(c);
	}

	return 0;
}