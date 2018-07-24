/* 알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오. */

#include <stdio.h>
#include <string.h>

int main() {
	int len = 0;
	int cri = 9;
	char input[100] = "\0";
	scanf("%s", input);

	while(len < strlen(input)) {
		printf("%c", input[len]);
		if(len == cri) {
			cri += 10;
			printf("\n");
		}
		len++;
	}
	printf("\n");
	return 0;
}