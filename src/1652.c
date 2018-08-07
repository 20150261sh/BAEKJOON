#include <stdio.h>
#include <stdlib.h>

int main() {
	int N;
	scanf("%d", &N);
	char room[101][101];
	int row = 0;
	int col = 0;
	int check = 0;

	for (int i = 0; i < N; i++) {
		check = 0;
		scanf("%s", room[i]);
		for (int j = 0; j < N; j++) {
			if (room[i][j] == '.') {
				check++;
				if (check == 2) {
					row++;
				}
			}
			else
				check = 0;
		}
		
	}

	for (int i = 0; i < N; i++) {
		check = 0;
		for (int j = 0; j < N; j++) {
			if (room[j][i] == '.') {
				check++;
				if (check == 2) {
					col++;
				}
			}
			else
				check = 0;
		}

	}

	printf("%d %d\n", row, col);
	return 0;
}