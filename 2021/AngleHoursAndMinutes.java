/*


Problem :: 


Given the time in hours and minutes, you need to calculate the angle between the hour hand and the minute hand.
Note :
There can be two angles between the hour hand and minute hand, you need to print the minimum of two. Also, print the floor value of angle i.e. if the angle is 15.2, you need to print 15.
Input Format:
The first line of input contains an integer ‘T’ denoting the number of test cases.

The first and only line of each test case contains two integers H and M denoting the time in hours and minutes.
Output Format:
For each test case, print the smaller angle between the hour hand and minute hand.
Note:
You do not need to print anything, it has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 50
1 <= H <= 12
0 <= M <= 59
Sample Input 1:
2
6 30
8 55
Sample Output 1:
15
62
Explanation For Input 1:
For test case 1: when the time is 6:30 the two angles between the hour hand and the minute hand is 15 degree and 345 degrees. As 15 is the smallest so the ans is 15.

For test case 1: when the time is 8:55 the two angles between the hour hand and the minute hand is 62.5 degree and 297.5 degrees. As 62.75 is the smallest so the ans is 62.
Sample Input 2:
2
3 30
12 0
Sample Output 2:
75
0


Solution
===============
Using reference time
The idea is to take the 12:00 i.e. H = 12  and M = 0 as reference time.
First,  calculate the angle made by the hour hand with respect to 12:00 in H hours and M minutes. In 12 hours the hour hand moves by 360 degrees i.e. 30 degrees in 1 hour and 0.5 degrees in 1 minute. So in H hours and M minutes, the angle moved by hour hand is  0.5 * (H*60 + M).
Then, calculate the angle made by minute hand with respect to 12:00 in H hours and M minutes. In 60 minutes the minute hand moves by 360 degrees i.e. 6 degrees in 1 minute. So in H hours and M minutes, the angle moved by minute hand is  6 * M.
The difference between the two angles is the required angle.
Time Complexity
O(1) per test case.

In the worst case, we are calculating the values using formulas.


*/



public class Solution {

    public static double absoluteDiff(double a, double b){
        if(a > b){
            return a - b;
        }
        else{
            return b - a;
        }
    }

    public static int findAngle(int hour, int minute) {
        if (hour == 12){
            hour = 0;
        }

        double hourAngle = 0.5 * (hour * 60 + minute);
        double minuteAngle = 6 * (minute);

        double angle = absoluteDiff(hourAngle, minuteAngle);

        angle = Math.min(angle, 360 - angle);

        return (int)angle;
    }

}
