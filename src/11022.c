/* �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. */

#include <stdio.h>
int main() {
    int T;
    int A, B;

    scanf("%d\n", &T);
    for(int i = 0; i < T; i++) {
        scanf("%d %d", &A, &B);
        printf("Case #%d: %d + %d = %d\n", i+1, A, B, A+B);
    }
    return 0;
}
