/* �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�.A�� B�� ��� 0�� ��쿡 ���α׷��� �����Ѵ�.*/

#include <stdio.h>
int main() {
    int A, B;
    int tmp;

    while((tmp = scanf("%d %d", &A, &B)) == 2 && A != 0 && B != 0) {
        printf("%d\n", A+B);
    }

    return 0;
}
