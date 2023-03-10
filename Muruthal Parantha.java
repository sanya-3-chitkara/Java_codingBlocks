#include <algorithm>
#include <iostream>
using namespace std;

int tym(int rank, int par) {
    return (par * (par + 1) / 2) * rank;
}
bool mintym(int par, int cooks, int ranks[], int m) {
    int mintime, j = 0, tm = 0, i = 1;
    while (par) {
        if (tym(ranks[j], i) <= m) {
            i++;
            par--;
        } else {
            j++;
            if (j == cooks)
                return false;
            i = 1;
            tm = 0;
        }
    }
    return true;
}
int calc(int par, int cooks, int ranks[]) {
    int s = tym(ranks[0], 1), e = tym(ranks[cooks - 1], par), m, ans;
    while (s <= e) {
        
        m = (s + e) / 2;
        if (mintym(par, cooks, ranks, m)) {
            ans = m;
            e = m - 1;
        }
        else {
            s = m + 1;
        }
    }
    return ans;
}

int main() {
    int par, cooks;
    cin >> par >> cooks;
    int ranks[cooks];
    for (int i = 0; i < cooks; i++) cin >> ranks[i];
    sort(ranks, ranks + cooks);
    cout << calc(par, cooks, ranks);
}
