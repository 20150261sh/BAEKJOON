/* 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 */

#include <stdio.h>
int main() {
    int A, B;
    int tmp;

    while((tmp = scanf("%d %d", &A, &B)) == 2) {
        printf("%d\n", A+B);
    }

    return 0;
}
