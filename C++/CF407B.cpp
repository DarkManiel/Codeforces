#include <vector>
#include <iostream>
using namespace std;
int mod = 1000000007;

long long dp(int numRooms, vector<int> rooms) {
    vector<long long> curCache(numRooms);
    vector<long long> sumCache(numRooms);
    
    curCache[0] = 2;
    sumCache[0] = 2;
    for (int i = 1; i < numRooms; ++ i) {
        int adjustedRoom = rooms[i] - 1;
        if (adjustedRoom == i) {
            curCache[i] = 2;
        } else {
            curCache[i] = (2 + (curCache[adjustedRoom]) + (((sumCache[i - 1]) - (sumCache[adjustedRoom])))) % mod;
        }
        sumCache[i] = ((curCache[i]) + (sumCache[i - 1]));
    }
    
    return sumCache[numRooms - 1] % mod;
}

int main(int argc, const char * argv[]) {
    static int numRooms;
    scanf("%d", &numRooms);
    vector<int> rooms(numRooms);
    
    for (int i = 0; i < numRooms; ++i) {
        int v = 0;
        if (i < numRooms - 1) {
            scanf("%d ", &rooms[i]);
        } else {
            scanf("%d", &rooms[i]);
        }
    }
    
    cout << dp(numRooms, rooms);
    
    return 0;
}
