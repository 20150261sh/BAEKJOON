//
//  11718.c
//  
//
//  Created by songhee on 2018. 7. 24..
//

/* 입력 받은 대로 출력하는 프로그램을 작성하시오. */

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
