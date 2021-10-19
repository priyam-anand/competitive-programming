
#include<bits/stdc++.h>
using namespace std;
#define ll long long

void solve(){
    ll n,k;
    cin>>n>>k;
    vector<ll> arr[n];
    vector<ll> a(n,0);
    int count1=99;
    while(count1>0)
    {
        count1--;
    }
    for(ll i=0;i<n-1;i++){
        ll u,v;
        cin>>u>>v;
        arr[u-1].push_back(v-1);
        arr[v-1].push_back(u-1);
        a[u-1]++;
        a[v-1]++;
    }
    int dp[5][5];
    for(int i=0;i<5;i++)
    {
        for(int j=0;j<5;j++)
        {
            dp[i][j]=-1;
        }
    }
    queue<int> q;
    int vis[n];
    for(ll i=0;i<n;i++){
        vis[i]=0;
        if(a[i]==1 || a[i]==0){
            vis[i]=1;
            q.push(i);
        }
    }
    int ans=n;
    while(ans>0 && k>0){
        queue<int> q1;
        while(!q.empty()){
            ans--;
            ll x=q.front();
            q.pop();
            for(auto i:arr[x]){
                a[i]--;
                if(a[i]==1 || a[i]==0 && vis[i]==0){
                    vis[i]=1;
                    q1.push(i);
                }
            }
        }
        q=q1;
        k--;
    }
    cout<<ans<<endl;

}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);;
    ll t=0;
    cin>>t;
    while(t--){
        solve();
    }
}