/* �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�.
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
