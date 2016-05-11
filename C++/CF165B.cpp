//
//  main.cpp
//  Exercise5_midnight
//
//  Created by mark daniel on 2/23/16.
//  Copyright © 2016 com.rentrshare.tigernadodemo. All rights reserved.
//

#include <iostream>
#include <utility>
#include <math.h>
using namespace std;

long long int accumulate(long long int maybeFirst, long long int k) {
    long long int sum = 0;
    long long int i = 0;
    long long int curCodeSprint;
    
    while ((curCodeSprint = maybeFirst / (pow(k, i))) >= 1) {
        sum += curCodeSprint;
        ++i;
    }
    
    return sum;
}

long long int binarySearch(long long int n, long long int k) {
    
    long long int lo = 0;
    long long int hi = n;
    while (lo <= hi) {
        long long int mid = lo + (hi-lo)/ 2;
        if (accumulate(mid, k) < n) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return hi + 1;
}

int main(int argc, const char * argv[]) {
    long long int n, k;
    scanf("%d%d", &n, &k);
    cout << binarySearch(n, k) << endl;
}
