#include <bits/stdc++.h>
#define pb push_back
#define mod 1000000007
#define Rie register
#define get() (ch = getchar())
#define fr(i,j) for(long long int y=i;y<j;y++)
#define FIO ios::sync_with_stdio(false)
using namespace std;
using da = long long;
/*                         for cin   and cout                 */
static struct IO {
    char tmp[1 << 10];
 
    // fast input routines
    char cur;
 
//#define nextChar() (cur = getc_unlocked(stdin))
//#define peekChar() (cur)
    inline char nextChar() { return cur = getc_unlocked(stdin); }
    inline char peekChar() { return cur; }
 
    inline operator bool() { return peekChar(); }
    inline static bool isBlank(char c) { return (c < '-' && c); }
    inline bool skipBlanks() { while (isBlank(nextChar())); return peekChar() != 0; }
 
    inline IO& operator >> (char & c) { c = nextChar(); return *this; }
 
    inline IO& operator >> (char * buf) {
        if (skipBlanks()) {
            if (peekChar()) {
                *(buf++) = peekChar();
                while (!isBlank(nextChar())) *(buf++) = peekChar();
            } *(buf++) = 0; } return *this; }
 
    inline IO& operator >> (string & s) {
        if (skipBlanks()) { s.clear(); s += peekChar();
            while (!isBlank(nextChar())) s += peekChar(); }
        return *this; }
 
    inline IO& operator >> (double & d) { if ((*this) >> tmp) sscanf(tmp, "%lf", &d); return *this; }
 
#define defineInFor(intType) \
    inline IO& operator >>(intType & n) { \
        if (skipBlanks()) { \
            int sign = +1; \
            if (peekChar() == '-') { \
                sign = -1; \
                n = nextChar() - '0'; \
            } else \
                n = peekChar() - '0'; \
            while (!isBlank(nextChar())) { \
                n += n + (n << 3) + peekChar() - 48; \
            } \
            n *= sign; \
        } \
        return *this; \
    }
 
defineInFor(int)
defineInFor(unsigned int)
defineInFor(long long)
 
    // fast output routines
 
//#define putChar(c) putc_unlocked((c), stdout)
    inline void putChar(char c) { putc_unlocked(c, stdout); }
    inline IO& operator << (char c) { putChar(c); return *this; }
    inline IO& operator << (const char * s) { while (*s) putChar(*s++); return *this; }
 
    inline IO& operator << (const string & s) { for (int i = 0; i < (int)s.size(); ++i) putChar(s[i]); return *this; }
 
    char * toString(double d) { sprintf(tmp, "%lf%c", d, '\0'); return tmp; }
        inline IO& operator << (double d) { return (*this) << toString(d); }
 
 
#define defineOutFor(intType) \
    inline char * toString(intType n) { \
        char * p = (tmp + 30); \
        if (n) { \
            bool isNeg = 0; \
            if (n < 0) isNeg = 1, n = -n; \
            while (n) \
                *--p = (n % 10) + '0', n /= 10; \
            if (isNeg) *--p = '-'; \
        } else *--p = '0'; \
        return p; \
    } \
    inline IO& operator << (intType n) { return (*this) << toString(n); }
 
defineOutFor(int)
defineOutFor(long long)
 
#define endl ('\n')
#define cout __io__
#define cin __io__
} __io__;
/*                                  end of cin and cout                           */




/*         gcd        */
da x,y,p,o;
da gcdExtended(da a, da b) 
{ 
	if (a == 0) 
	{ 
		x = 0; 
		y = 1; 
		return b; 
	}  
	da gcd = gcdExtended(b%a, a); 
	x = p - (b/a) * o; 
	y = o; 

	return gcd; 
} 
/*        gcd end        */



/* fast integer input */
inline int Fastin() {
	Rie int N; Rie char ch;
	for(get(); ch < 48; get()); N = ch ^ 48;
	for(get(); ch > 47; get()) N = N * 10 + (ch ^ 48);
	return N;
}


/* fast integer input  end*/
/*                segment tree  start                   */
da N = 100000;  
da n; 
da tree[2 * 100000]; 
void build(da arr[])  
{  
    for (da i=0; i<n; i++)     
        tree[n+i] = arr[i]; 
    for (da i = n - 1; i > 0; --i)      
        tree[i] = tree[i<<1] + tree[i<<1 | 1];     
} 
void updateTreeNode(da p,da value)  
{  
    tree[p+n] = value; 
    p = p+n; 
    for (da i=p; i > 1; i >>= 1) 
        tree[i>>1] = tree[i] + tree[i^1]; 
} 
da query(da l, da r)  
{  
    da res = 0; 
    for (l += n, r += n; l < r; l >>= 1, r >>= 1) 
    { 
        if (l&1)  
            res += tree[l++]; //sum + operation for xor ^ etc
      
        if (r&1)  
            res += tree[--r]; //sum + operation for xor ^ etc
    } 
      
    return res; 
}



/*                  segment tree stop                       */



/*                 fast powering                            */
da power(da x, da y,da p) 
{ 
    da res = 1;      // Initialize result 
  
    x = x % p;  // Update x if it is more than or  
                // equal to p 
  
    while (y > 0) 
    { 
        // If y is odd, multiply x with result 
        if (y & 1) 
            res = (res*x) % p; 
  
        // y must be even now 
        y = y>>1; // y = y/2 
        x = (x*x) % p;   
    } 
    return res; 
} 


/*                fast power end               */






/*               longest common subsequance in 2 strings         */
da lcs( char *X, char *Y, da m, da n ) 
{ 
   da L[m+1][n+1]; 
   da i, j; 
   for (i=0; i<=m; i++) 
   { 
     for (j=0; j<=n; j++) 
     { 
       if (i == 0 || j == 0) 
         L[i][j] = 0; 
   
       else if (X[i-1] == Y[j-1]) 
         L[i][j] = L[i-1][j-1] + 1; 
   
       else
         L[i][j] = max(L[i-1][j], L[i][j-1]); 
     } 
   } 
   return L[m][n]; 
} 


/*               longest common subsequance in 2 strings stop         */





/*                SieveOfEratosthenes start             */
vector<da> pr;
bool prime[1000000];
void SieveOfEratosthenes(da n) 
{  
    memset(prime, true, sizeof(prime)); 
  
    for (da p=2; p*p<=n; p++) 
    { 
        if (prime[p] == true) 
        {  
            for (da i=p*p; i<=n; i += p) 
                prime[i] = false; 
        } 
    } 
    for (da p=2; p<=n; p++) 
       if (prime[p]) 
          pr.pb(p); 
} 


/*                SieveOfEratosthenes start end             */


/*                divisors of a number to a vector start            */
vector<da> divisors;
void printDivisors(da n) 
{ 
    // Note that this loop runs till square root 
    for (da i=1; i<=sqrt(n); i++) 
    { 
        if (n%i == 0) 
        { 
            // If divisors are equal, print only one 
            if (n/i == i) 
                divisors.pb(i); 
            else // Otherwise print both
            {
            divisors.pb(i);
            divisors.pb(n/i);
            }
        } 
        } 
} 


/*                divisors of a number to a vector stop            */




/* ncr start  */
da ncr(da n,da r){
    da o=n,v=1,i,j;
    for(i=1;i<=r;i++){
        v*=(o--);
        v=v%mod;
       // cout<<v<<endl;
        v/=i;
    }
    return v;
}



/* ncr stop  */




/* npr start */
da npr(da n,da r){
    da o=n,v=1,i,j;
    for(i=n;i<=r+1;i++){
        v*=i;
        v=v%mod;
    }
    return v;
}

/*npr stop */

/* pow with module  */
da powe(da n,da k,da m){
    da i=k;
    da o=1;
    while(i--){
        o=(o*n)%m;
    }
    return o;
}
/* pow wit module end */

/* basic recursion start  */
da c=0;
void find(da a[],da sum,da in,da n,da m){
    if(in>n){
       // cout<<a<<" "<<sum<<" "<<in+1<<" "<<n<<" "<<m<<endl;
        if(sum%m==0)
        c++;
        return ;
    }
    find(a,sum,in+1,n,m);
    find(a,(sum+a[in])%m,in+1,n,m);
}




/* basic recursion stop   */




/* implicit binary search forimp is required function  */
da forimp(da n){
    da y=n*(n+1);
    return y/2;
}
da impbi(da l,da r,da v){
    da mid=(l+r)/2,k=forimp(mid),u=forimp(mid+1);
    if(k<=v&&u>v){
        return mid;
    }
    else if(k<=v&&u==v){
        return mid+1;
    }
    else if(k<v){
        return impbi(mid+1,r,v);
    }
    else{
        return impbi(l,mid-1,v);
    }
}


/* implicit binary search forimp is required function end   */



/* binarySearch start */
da binarySearch(da arr[], da l,da r,da x) 
{ 
    if (r >= l) { 
        da mid = l + (r - l) / 2; 
        if (arr[mid] == x) 
            return mid; 
        if (arr[mid] > x) 
            return binarySearch(arr, l, mid - 1, x); 
        return binarySearch(arr, mid + 1, r, x); 
    } 
    return -1; 
} 




/*  binarySearch stop */





/*    lenOfLongIncSubArr start */
da lenOfLongIncSubArr(da arr[], da n) 
{ 
    da max = 1, len = 1; 
    for (da i=1; i<n; i++) 
    { 
        if (arr[i] > arr[i-1]) 
            len++; 
        else
        { 
            if (max < len)     
                max = len;   
            len = 1;     
        }     
    } 
    if (max < len) 
        max = len; 
    return max; 
} 

/*    lenOfLongIncSubArr stop */



/* sum of all combinations till k of a array i.e for arry (1,2,3),k=3------>(1+2+3+1*2+1*3+2*3+1*2*3)  start */
da sumofmul(da ni,da ki ,da *data){
   da dynamicpograming[ki][ni + 1],c=0,sum=0,v,u;
   for(da i = 0; i < ki; i++)
   for(da j = 0; j <= ni; j++)
   dynamicpograming[i][j]=0;
   for(da i = 1; i <= ni; i++){
       dynamicpograming[ki - 1][i] = data[i - 1];
   }
   for(da i = ki - 2; i >= 0; i--){
       c=0;
       for(da j = 1 ; j <= ni; j++){
           for(da m = j + 1 ; m <= ni; m++){
               dynamicpograming[i][j] += (data[j - 1]*dynamicpograming[i + 1][m])%1000000007;
           }
           c+=(dynamicpograming[i][j])%1000000007;
       }
       sum+=c%1000000007;
       ni--;
   }
    /*for(long long int i = 1; i < ki; i++){
   for(long long int j = 0; j <= ni; j++){
   cout<<dynamicpograming[i][j]<<" ";}
        cout<<endl;
    }*/
   return (++sum)%1000000007;
}

/* sum of all combinations till k of a array i.e for arry (1,2,3),k=3------>(1*2*3)  start */
da solofmulofn(da ni,da lev,da *data){
    da ki = lev;
   da dynamicpograming[ki][ni + 1],c=0,sum=0,v,u;
   for(da i = 0; i < ki; i++)
   for(da j = 0; j <= ni; j++)
   dynamicpograming[i][j]=0;
   for(da i = 1; i <= ni; i++){
       dynamicpograming[ki - 1][i] = data[i - 1];
   }
   for(da i = ki - 2; i >= 0; i--){
       c=0;
       for(da j = 1 ; j <= ni; j++){
           for(da m = j + 1 ; m <= ni; m++){
               dynamicpograming[i][j] += (data[j - 1]*dynamicpograming[i + 1][m])%1000000007;
           }
           c+=(dynamicpograming[i][j])%1000000007;
       }
       ni--;
   }
   for(da j = 0; j <= ni; j++){
   sum+=dynamicpograming[lev][j];
    }
   return sum;
}
/* sum of all combinations till k of a array i.e for arry (1,2,3),k=3------>(1*2*3) stop */


/* lower boundery of given element in array 1,2,2,2,3,3,4,4,5,5,6 lower boundery of 5 will return 8*/
da lb(da t[],da in,da end,da va){
    return lower_bound(t+in,t+end,va)-t;
}


/* lower boundery of given element in array 1,2,2,2,3,3,4,4,5,5,6 lower boundery of 5 will return 10*/
da up(da t[],da in,da end,da va){
    return upper_bound(t+in,t+end,va)-t;
}

/* quick sort start */
void swap(da* a, da* b)  
{  
    da t = *a;  
    *a = *b;  
    *b = t;  
}  


da partition (da arr[], da low,da high)  
{  
    da pivot = arr[high]; // pivot  
    da i = (low - 1); // Index of smaller element  
  
    for (da j = low; j <= high - 1; j++)  
    {    
        if (arr[j] < pivot)  
        {  
            i++; 
            swap(&arr[i], &arr[j]);  
        }  
    }  
    swap(&arr[i + 1], &arr[high]);  
    return (i + 1);  
}  
void quickSort(da arr[], da low, da high)  
{  
    if (low < high)  
    {  
        /* pi is partitioning index, arr[p] is now  
        at right place */
        int pi = partition(arr, low, high);  
  
        // Separately sort elements before  
        // partition and after partition  
        quickSort(arr, low, pi - 1);  
        quickSort(arr, pi + 1, high);  
    }  
}  
  
/* Function to print an array */
void printArray(da arr[],da size)  
{  
    da i;  
    for (i = 0; i < size; i++)  
        cout << arr[i] << " ";  
    cout << endl;  
}
/* end of quick sort */
//www.codechef.com/certification
//stack <int> s;      s.push(10); s.empty() s.size() s.top() s.pop() 
//queue <int> gquiz;     gquiz.push(10); gquiz.size() gquiz.front() gquiz.back() gquiz.pop() g.empty()
/*    merge sort    */
void merge(da arr[], da l, da m, da r) 
{ 
    da i, j, k; 
    da n1 = m - l + 1; 
    da n2 =  r - m; 
    da L[n1], R[n2]; 
    for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
    i = 0; 
    j = 0;  
    k = l;
    while (i < n1 && j < n2) 
    { 
        if (L[i] <= R[j]) 
        { 
            arr[k] = L[i]; 
            i++; 
        } 
        else
        { 
            arr[k] = R[j]; 
            j++; 
        } 
        k++; 
    } 
    while (i < n1) 
    { 
        arr[k] = L[i]; 
        i++; 
        k++; 
    } 
    while (j < n2) 
    { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 
void mergeSort(da arr[], da l, da r) 
{ 
    if (l < r) 
    { 
        da m = l+(r-l)/2; 
        mergeSort(arr, l, m); 
        mergeSort(arr, m+1, r); 
  
        merge(arr, l, m, r); 
    } 
} 
/* merge sort end  */
/*              prime factorization                */
da spf[1000000]; 
void sieveFactorization() 
{ 
    spf[1] = 1; 
    for (da i=2; i<1000000; i++) 
        spf[i] = i; 
    for (da i=4; i<1000000; i+=2) 
        spf[i] = 2; 
  
    for (da i=3; i*i<1000000; i++) 
    { 
        if (spf[i] == i) 
        { 
            for (da j=i*i; j<1000000; j+=i) 
                if (spf[j]==j) 
                    spf[j] = i; 
        } 
    } 
} 
vector<da> getFactorization(da x) 
{ 
    vector<da> ret; 
    while (x != 1) 
    { 
        ret.push_back(spf[x]); 
        x = x / spf[x]; 
    } 
    return ret; 
    //for prime factors
    /*sieveFactorization(); for prime factorization
    vector<da> f=getFactorization(1000);
    for(auto t=f.begin();t<f.end();t++)
    cout<<*t<<endl;*/
} 
/*                        end of prime fractorization                  */


/*                         fast expo                           */
da fast_exp(da base, da exp)
{
    if(exp==1)
    return base;
    else
    {
        if(exp%2 == 0)
        {
            da ret = fast_exp(base, exp/2);
            da base1 = ret * ret;
            return base1 % 1000000007;
        }
        else
        {
            da ret = fast_exp(base, (exp-1)/2);
            da ans = base * ret;
            ans %= 1000000007; 
            ans *= ret;
            return ans % 1000000007;
        }
    }
}



/*                           end of fast expo                  */


/*                 Naiv  string algo start                   */


void search(char* pat, char* txt) 
{ 
    da M = strlen(pat); 
    da N = strlen(txt); 
  
    /* A loop to slide pat[] one by one */
    for (da i = 0; i <= N - M; i++) { 
        da j; 
  
        /* For current index i, check for pattern match */
        for (j = 0; j < M; j++) 
            if (txt[i + j] != pat[j]) 
                break; 
  
        if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1] 
            cout << "Pattern found at index "
                 << i << endl; 
    } 
} 



/*                naiv string algo stop                 */



/*                    all permutaions of string              */
void permute(string a, da l, da r)  
{  
    // Base case  
    if (l == r)  
        cout<<a<<endl;  
    else
    {  
        // Permutations made  
        for (da i = l; i <= r; i++)  
        {  
  
            // Swapping done  
            swap(a[l], a[i]);  
  
            // Recursion called  
            permute(a, l+1, r);  
  
            //backtrack  
            swap(a[l], a[i]);  
        }  
    }  
}

/*                    all permutaions of string end         */
void printit(da at[],da n){
    fr(0,n)
    cout<<at[y]<<" ";
}
void sit(da a[],da n,da k){
    da v=k/n;
    if(v>0&&n%2==1)
    a[n/2]=0;
    da p;
    if(v%3==2){
              for(p=0;p<n/2;p++){
            da o=a[n-p-1];
            a[n-p-1]=a[p]^a[n-p-1];
            a[p]=o;
        }  
    }
    else if(v%3==1){
        for(p=0;p<n/2;p++){
            da o=a[p];
            a[p]=a[p]^a[n-p-1];
            a[n-p-1]=o;
        }
    }
    for(p=0;p<k%n;p++){
            a[p]=a[p]^a[n-p-1];
        }  
    printit(a,n);
    cout<<endl;
}
int main() {
    FIO;
    da i,j,k,l,m,n,o;
    cin>>m;
    while(m--){
        cin>>k>>l;
        da a[k];
        for(i=0;i<k;i++)
        cin>>a[i];
       sit(a,k,l);
    }
	return 0;
}
