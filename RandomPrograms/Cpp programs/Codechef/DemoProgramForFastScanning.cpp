#include <bits/stdc++.h>

#if (__WIN32__ || __WIN64__)
        #define getch getchar
#else
        #define getch getchar_unlocked
#endif
typedef long long ll;
#define SEED srand(chrono::duration_cast<chrono::nanoseconds>(chrono::high_resolution_clock::now() - chrono::high_resolution_clock::time_point()).count());
#define rand() ((rand () << 16) | rand ())
#define all(T) T.begin (), T.end ()
#define NAME ""
#define pb push_back
#define pi pair<int,int>
#define repu(v,s,e) for(ll v=s;v<e;v++)
#define repd(v,s,e) for(ll v=s;v>e;v--)
using namespace std;

typedef long long ll;
typedef long double ld;

inline void scan (int &very_long_variable_name);

const int inf = (int) 1e9;
const int mod = (int) 1e9 + 7;
const int N = (int) 1e5 + 5;

int lf[N], a[N], n, k, q, cnt[2], sleva, fp[N];
ll s[N];
void swap(char *a, char *b){
    if(*a==*b){
        return;
    }
    *a ^= *b;
    *b ^= *a;
    *a ^= *b;
}
//For reading characters fast
long long read2()
{
        long long n=0;
        char c;int f=0;
        //fast method to read character
        c=getchar_unlocked();
        while(c<'0'||c>'9')
        {
        
        if(c=='-')
        f=1;
        	c=getchar_unlocked();
        }
        while(c>='0'&&c<='9')
        {
        	n=n*10+c-'0';
        	c=getchar_unlocked();
        }
        if(!f)
        return n;
        else
        return -n;
}
inline int read()
{
	char c;
	int n = 0;
	while ((c = getchar_unlocked()) < 48)	;
	n += (c - '0');
	while ((c = getchar_unlocked()) >= 48)
		n = n * 10 + (c - '0');
	return n;
}

inline void write(int a)
{
	char snum[20];
	int i=0;
	do
	{
		snum[i++]=a%10+48;
		a=a/10;
	}while(a!=0);
	i=i-1;
	while(i>=0)
	putchar_unlocked(snum[i--]);
	putchar_unlocked(' ');
}
inline void Solve () {
        //Initialize cnt array to 0
        memset (cnt, 0, sizeof cnt); 
		sleva = 1;
		//Taking values for n, k and q
        scan (n); scan (k); scan (q);
		//Iterating to scan the given string character by character
		//String s = "011010001" for example
        for (int i = 1; i <= n; i++) {
                a[i] = getch () - 48;
				//increasing count to track frequency
                cnt[a[i]]++;
				
                while (cnt[0] > k || cnt[1] > k) {
                        cnt[a[sleva]]--;
                        sleva++;
                }
                lf[i] = sleva;
                s[i] = i - sleva + 1;
        }
        sleva = 1;
        for (int i = 1; i <= n; i++) {
                for (; sleva < lf[i]; sleva++) {
                        fp[sleva] = i - 1;
                }
        }
        for (; sleva <= n; sleva++) {
                fp[sleva] = n;
        }
        for (int i = 2; i <= n; i++) {
                s[i] += s[i - 1];
        }
        while (q--) {
                int L, R;
                scan (L); scan (R);
                if (fp[L] >= R) {
                        int len = R - L + 1;
                        printf ("%lld\n", len * 1LL * (len + 1) / 2);
                } else if (fp[L] < L) {
                        printf ("%lld\n", s[R] - s[L - 1]);
                } else {
                        int len = fp[L] - L + 1;
                        printf ("%lld\n", len * 1LL * (len + 1) / 2 + s[R] - s[fp[L]]);
                }
        }
}

int tests = 1;

int main () {
	#ifdef FILE
		freopen (NAME".in", "r", stdin);
		freopen (NAME".out", "w", stdout);
	#endif
	
	//Use this in case number of test cases are not given
	//***************
	//while(scanf("%d",&n)!=EOF){
	//}
	//********************
        //This will provide value for number of tests available
        scan (tests);
        //Iterating over all tests
        while (tests--) {
		//Calling solve method
                Solve ();
        }

        return 0;
}
//For fast scanning pass a variable reference 
inline void scan (int &very_long_variable_name) {
        very_long_variable_name = 0;
		//Gets the first character 
        char c = getch ();
        //Bypass empty spaces
        while (c < '0' || c > '9'){
                c = getch ();
        }
		//Reading the whole stream
        while (c >= '0' && c <= '9') {
                very_long_variable_name = (very_long_variable_name << 1) + (very_long_variable_name << 3) + c - '0';
                c = getch ();
        }
}


