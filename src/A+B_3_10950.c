/* 두 정수 A와 B를 입력받은 다음,
 * A+B를 출력하는 프로그램을 작성하시오.
첫째 줄에 테스트 케이스의 개수 T가 주어진다. */

#include <stdio.h>
int main() {
    int T;
    int A, B;

    scanf("%d\n", &T);
    for(int i = 0; i < T; i++) {
        scanf("%d %d", &A, &B);
        printf("%d\n", A+B);
    }
    return 0;
}
