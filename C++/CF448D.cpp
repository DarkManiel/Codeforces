#include <iostream>
#include <utility>
#include <vector>
#include <map>
#include <list>
using namespace std;

long long int getCount(long long int n, long long int m, long long int mid, long long int k) {
    long long int count = 0;
    
    for (long long int i = 1; i <= n; ++i) {
        count += min(m, mid/i);
    }
    
    return count;
}


long long int binarySearch(long long int n, long long int m, long long int k) {
    if (k == 1) { return 1; }
    long long int lo = 1, hi = n * m;
    
    while (lo <= hi) {
        long long int mid = (lo + hi) / 2;
        long long int count = getCount(n, m, mid, k);
        if (count < k) {
            lo = mid + 1;
        }
        else {
            hi = mid - 1;
        }
    }
    
    return hi + 1;
}

int main(int argc, const char * argv[]) {
    long long int n, m, k;
    scanf("%I64d%I64d%I64d", &n, &m, &k);
    printf("%I64d\n",binarySearch(n, m, k));
}
