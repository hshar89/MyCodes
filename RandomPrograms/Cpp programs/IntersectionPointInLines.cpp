// C++ Implementation. To find the point of 
// intersection of two lines 
#include <bits/stdc++.h> 
using namespace std; 
  
// This pair is used to store the X and Y 
// coordinates of a point respectively 
#define pdd pair<double, double> 
#define f first
#define s second
struct Point 
{ 
    int x; 
    int y; 
};
// Function used to display X and Y coordinates 
// of a point 
void displayPoint(pdd P) 
{ 
    cout << "(" << P.first << ", " << P.second 
         << ")" << endl; 
}
// Given three colinear points p, q, r, the function checks if 
// point q lies on line segment 'pr' 
bool onSegment(Point p, Point q, Point r) 
{ 
    if (q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) && 
        q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y)) 
       return true; 
  
    return false; 
}  
// To find orientation of ordered triplet (p, q, r). 
// The function returns following values 
// 0 --> p, q and r are colinear 
// 1 --> Clockwise 
// 2 --> Counterclockwise 
int orientation(Point p, Point q, Point r) 
{ 
    // See https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
    // for details of below formula. 
    int val = (q.y - p.y) * (r.x - q.x) - 
              (q.x - p.x) * (r.y - q.y); 
  
    if (val == 0) return 0;  // colinear 
  
    return (val > 0)? 1: 2; // clock or counterclock wise 
} 
// The main function that returns true if line segment 'p1q1' 
// and 'p2q2' intersect. 
bool doIntersect(Point p1, Point q1, Point p2, Point q2) 
{ 
    // Find the four orientations needed for general and 
    // special cases 
    int o1 = orientation(p1, q1, p2); 
    int o2 = orientation(p1, q1, q2); 
    int o3 = orientation(p2, q2, p1); 
    int o4 = orientation(p2, q2, q1); 
  
    // General case 
    if (o1 != o2 && o3 != o4) 
        return true; 
  
    // Special Cases 
    // p1, q1 and p2 are colinear and p2 lies on segment p1q1 
    if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
  
    // p1, q1 and q2 are colinear and q2 lies on segment p1q1 
    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
  
    // p2, q2 and p1 are colinear and p1 lies on segment p2q2 
    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
  
     // p2, q2 and q1 are colinear and q1 lies on segment p2q2 
    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
  
    return false; // Doesn't fall in any of the above cases 
} 
pdd lineLineIntersection(pdd A, pdd B, pdd C, pdd D) 
{ 
    // Line AB represented as a1x + b1y = c1 
    double a1 = B.second - A.second; 
    double b1 = A.first - B.first; 
    double c1 = a1*(A.first) + b1*(A.second); 
  
    // Line CD represented as a2x + b2y = c2 
    double a2 = D.second - C.second; 
    double b2 = C.first - D.first; 
    double c2 = a2*(C.first)+ b2*(C.second); 
  
    double determinant = a1*b2 - a2*b1; 
    cout<<"determinant: "<<determinant<<"\n";
    if (determinant == 0) 
    { 
        // The lines are parallel. This is simplified 
        // by returning a pair of FLT_MAX 
        cout<<abs(c2 - c1)<<"\n";
        return make_pair(FLT_MAX, FLT_MAX); 
    } 
    else
    { 
        double x = (b2*c1 - b1*c2)/determinant; 
        double y = (a1*c2 - a2*c1)/determinant; 
        return make_pair(x, y); 
    } 
} 
  
// Driver code 
int main() 
{ 
    pdd A = make_pair(1, 1); 
    pdd B = make_pair(1, 8); 
    pdd C = make_pair(1, 2); 
    pdd D = make_pair(1, 5); 
    Point p1;
    p1.x = 1;
    p1.y = 1;
    Point p2;
    p2.x = 3;
    p2.y = 1;
    Point p3;
    p3.x = 2;
    p3.y = 1;
    Point p4;
    p4.x = 3;
    p4.y = 1;
    doIntersect(p1, p1, p3, p4)? cout << "Yes\n": cout << "No\n"; 
    pdd intersection = lineLineIntersection(A, B, C, D); 
  
    if (intersection.first == FLT_MAX && 
        intersection.second==FLT_MAX) 
    { 
        cout << "The given lines AB and CD are parallel.\n"; 
    } 
  
    else
    { 
        // NOTE: Further check can be applied in case 
        // of line segments. Here, we have considered AB 
        // and CD as lines 
        cout << "The intersection of the given lines AB "
                "and CD is: "; 
        displayPoint(intersection); 
    } 
  
    return 0; 
} 