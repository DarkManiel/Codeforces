#include <iostream>
#include <vector>
#include <utility>
#include <map>
#include <set>
using namespace std;
const int edgeLen = 8;

int countStrokes(char grid[edgeLen][edgeLen + 1] , int edgeLen, pair<int, int> whitePoint) {
    int numStrokes = 0;
    set<int> curRow;
    set<int> curCol;
    set<int> rowStrokes;
    set<int> colStrokes;
    
    for (int i = 0; i < edgeLen; ++i) {
        if (grid[whitePoint.first][i] == 'B') {
            colStrokes.insert(i);
        }
    }
    
    for (int i = 0; i < edgeLen; ++i) {
        if (grid[i][whitePoint.second] == 'B') {
            rowStrokes.insert(i);
        }
    }
    
    return rowStrokes.size() + colStrokes.size();
}

int main(int argc, const char * argv[]) {
    
    char grid[edgeLen][edgeLen + 1];
    char newline;
    string row;
    bool allBlack = true;
    pair<int, int> whitePoint;
    
    for (int i = 0; i < edgeLen; ++i) {
        scanf("%s", grid[i]);
        if (allBlack) {
            for (int j = 0; j < edgeLen; ++j) {
                if (allBlack && grid[i][j] == 'W') {
                    whitePoint = make_pair(i, j);
                    allBlack = false;
                    break;
                }
            }
        }
    }
    
    if (allBlack) {
        cout << 8 << endl;
    } else {
        cout << countStrokes(grid, edgeLen, whitePoint) << endl;
    }
}