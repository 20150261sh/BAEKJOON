#include <stdio.h>
#include <stdlib.h>

char col[5][2];
int num[5];
int four, triple, pair, twopair;
int twopairof[2];
int isSameColor();
int isStraight();
int compare(const void*, const void*);
int isFourCard();
int isTripleCard();
int isPairCard();
int isTwoPairCard();

int main() {
    int max = 0;
    int score = 0;
    for(int i = 0; i < 5; i++) {
        scanf("%s %d", col[i], &num[i]);
        if(num[i] >= max)
            max = num[i];
    }
    for(int i = 0; i < 5; i++) {
        if(num[i] == 0)
            return 0;
    }
    for(int i = 0; i < 5; i++) {
        if(col[i][0] == 'R' || col[i][0] == 'B' || col[i][0] == 'Y' || col[i][0] == 'G') 
            ;
        else 
            return 0;
    }

    if(isSameColor()) {
        if(isStraight()) 
            score = max + 900;
        else 
            score = max + 600;
    }
    else if(isFourCard()) {
        score = four + 800;
    }
    else if(isPairCard() && isTripleCard()) {
        score = triple * 10 + pair + 700;
    }
    else if(isStraight()) {
        score = max + 500;
    }
    else if(isTripleCard()) {
        score = max + 400;
    }
    else if(isTwoPairCard()) {
        score = twopairof[1] * 10 + twopairof[0] + 300;
    }
    else if(isPairCard()) {
        score = pair + 200;
    }
    else
        score = max + 100;
    printf("%d\n", score);
    return 0;
}

int isSameColor() {
    int color[4];
    for(int i = 0; i < 5; i++) {
        if(col[i][0] == 'R')
            color[0]++;
        else if(col[i][0] == 'B')
            color[1]++;
        else if(col[i][0] == 'Y')
            color[2]++;
        else if(col[i][0] == 'G')
            color[3]++;
    }
    for(int i = 0; i < 5; i++) {
        if(color[i] >= 5)
            return 1;
    }
    return 0;
}

int isStraight() {
    qsort(num, sizeof(num) / sizeof(int), sizeof(int), compare);
    for(int i = 4; i > 0; i--) {
        if(num[i] - num[i-1] != 1)
            return 0;
    }
    return 1;
}

int compare(const void *a, const void *b)
{
    int num1 = *(int *)a;
    int num2 = *(int *)b;

    if (num1 < num2)
        return -1;  

    if (num1 > num2)
        return 1;  

    return 0;    
}

int isFourCard() {
    int number[9] = {0};
    for(int i = 0; i < 5; i++) {
        number[num[i]-1]++;
    }
    for(int i = 0; i < 9; i++) {
        if(number[i] == 4) {
            four = i + 1;
            return 1;
        }
    }
    return 0;
}

int isTripleCard() {
    int number[9] = {0};
    for(int i = 0; i < 5; i++) {
        number[num[i]-1]++;
    }
    for(int i = 0; i < 9; i++) {
        if(number[i] == 3) {
            triple = i + 1;
            return 1;
        }
    }
    return 0;
}

int isPairCard() {
    int number[9] = {0};
    for(int i = 0; i < 5; i++) {
        number[num[i]-1]++;
    }
    for(int i = 0; i < 9; i++) {
        if(number[i] == 2) {
            pair = i + 1;
            return 1;
        }
    }
    return 0;
}

int isTwoPairCard() {
    int check = 0;
    int k = 0;
    int number[9] = {0};
    for(int i = 0; i < 5; i++) {
        number[num[i]-1]++;
    }
    for(int i = 0; i < 9; i++) {
        if(number[i] == 2) {
            twopairof[k++] = i+1;
            check++;
        }
    }
    if(check == 2) {
        qsort(twopairof, sizeof(twopairof) / sizeof(int), sizeof(int), compare);
        return 1;
    }
    else 
        return 0;
}
