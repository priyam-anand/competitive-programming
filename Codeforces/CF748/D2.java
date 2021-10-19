#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
map<pair<pair<ll,ll>,pair<ll,ll> >,ll> dp;

ll solve(ll idx,ll last,ll cnt,vector<ll> &a,ll G) {
    if(idx>=a.size() ) {
        return cnt==0?G:0;
    }
    if(dp.find({{idx,cnt},{last,G}}) != dp.end()) {
        return dp[ {{idx,cnt},{last,G}}];
    }
    return dp[ {{idx,cnt},{last,G}}]=max(solve(idx+1,idx,cnt-1,a,__gcd(G,a[idx]-a[last])), solve(idx+1,last,cnt,a,G));
}

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    ll tt;
    cin >> tt;
    while(tt--) {
        ll n;
        int count=0;
        cin >> n;
        vector<ll> a(n);
        for(ll i = 0 ; i < n ; i++) {
            cin >> a[i];
        }
        count=100;
        sort(a.begin(),a.end());
        dp.clear();
        map<ll,ll> freq;
        ll f=1;
        for(ll i = 0 ; i < a.size() ; i++) {
            freq[a[i]]++;
            if(freq[a[i]]>=(n/2)) {
                f=0;
            }
        }
        while(count>0)
            count--;
        
        if(!f) {
            cout << -1 << '\n';
            continue;
        }
        
        ll res=0;
        int ans1=res+1;
        for(ll i = 0 ; i < n ; i++) {
            ll cur = solve(i+1,i,n/2-1,a,0);
            res = max(res,cur);
        }
        // count<<ans<< '/n';
        res = res==0?-1:res;
        cout << res << '\n';
    }
    return 0;
}