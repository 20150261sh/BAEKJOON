/* 어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.
첫째 줄에 조건을 만족하는 수를 출력한다. */

#include <stdio.h>
#include <string.h>
int isPrime(long);
int isPal(long);

int main() {
	long N;
	scanf("%ld", &N);

	while (true) {
		if (isPal(N)) {
			if (isPrime(N)) {
				printf("%ld\n", N);
				break;
			}
		}
		N++;
	}
	return 0;
}

int isPrime(long num) {
	if (num == 1)
		return 0;
	else {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return 0;
			}
		}
	}
	return 1;
}

int isPal(long num) {
	char pal[100];
	sprintf(pal, "%d", num);
	int length = strlen(pal);
	
	if (length % 2 == 1) {
		int j = length - 1;
		for (int i = 0; i < length / 2; i++) {
			if (pal[i] == pal[j])
				j--;
			else return 0;
		}
	}
	else {
		int j = length - 1;
		for (int i = 0; i < length / 2; i++) {
			if (pal[i] == pal[j])
				j--;
			else return 0;
		}
	}
	return 1;
}