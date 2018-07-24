//
//  A+B_9_15740.c
//  
//
//  Created by songhee on 2018. 7. 24..
//

/* 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 첫째 줄에 A와 B (-10^10000 ≤ A, B ≤ 10^10000)가 주어진다. */

#include <stdio.h>
int main() {
    long long A, B;
    scanf("%lld %lld", &A, &B);
    printf("%lld\n", A+B);
    return 0;
}
