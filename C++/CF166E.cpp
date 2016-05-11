#include <iostream>
using namespace std;
const int mod = 1000000007;


int main(int argc, const char * argv[]) {
    int n;
    int prev = 0;
    int dp[2][4] = {0};
    scanf("%d", &n);

    dp[0][4 - 1] = 1;
    
    for(int i = 1; i <= n; ++i) {
        for (int j = 1; j <= 4; ++j) {
            dp[!prev][j - 1] = (((dp[prev][(j >= 2 ? 1 : 2) - 1] + dp[prev][(j >= 3 ? 2: 3) - 1]) % mod) + dp[prev][(j >= 4 ? 3 : 4) - 1]) % mod;
        }
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 4; ++j) {
                printf("%d%s", dp[i][j], " ");
            }
            printf("\n");
        }
        
        prev = !prev;
    }
    
    printf("%d\n", dp[prev][4 - 1]);
}
