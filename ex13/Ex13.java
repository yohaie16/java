
public class Ex13
/**
 * exam number 13
 *
 * @author yohaie elmakis
 * @version 03/01/2023
 */
{

    public static int binarySwap(String s, char c)
    {
        int howmuch=0;
        int size=s.length();
        for (int i=0; i<size; i++)
        {
            if (s.charAt(i) != c) 
            {
                howmuch++;
            }
            c = (c == '0') ? '1' : '0';
        }
        return howmuch;
    }

    /**
     * Q1
     * the method  return the minimum number of characters to switch in between  to make the string alternating
     * we can assume that it has an even amount of characters half ones half zeros and contains only ones and zeros
     * @param s which is a string 
     * @return howmuch which is an integer the minimum amount of switching between the ones and zeros required to make it alternating
     * Time Complexity: O(length)
     * Storage Space: O(1)
     */
    public static int alternating(String s)
    {
        if (s.length() <= 2)
            return 0;
        return Math.min(binarySwap(s,'1'), binarySwap(s,'0')) / 2;
    }

    /**
     * Q2
     * method find the maximum length of subarray which his sum of the subarray is even 
     * Time Complexity: O(N^3) ( loop inside loop inside loop with at least 1 time each loop run in the size of the array a )
     * Space Complexity: O(1) ( none of the method loops make new storage in the stack but only reassign values into existent ones  ) 
     * @param arary of integers (a) and n which is an integer
     * @return  length which is an integer
     * Time Complexity of my function is O(N). Because of two separated loops whose each complexity is n.
     * spcae Complexity of my function is O(1). because the memory is fixed and known in advanced.
     */
    private static int what(int a[], int n)
    {
        int sum = 0, length = 0;

        for (int i = 0; i < n; i++)
        {
            sum += a[i];
        }

        if (sum % 2 == 0) 
        {
            return n;
        }

        for (int i = 0; i < n; i++)
        {
            if (a[i] % 2 == 1)
            {
                length = Math.max(length, Math.max(n - i - 1, i));
            }
        }

        return length;
    }

    public static int what(int[] a)
    {
        return(what(a,a.length));
    }

    /**
     * Q3
     * a  method which returns if there is a valid path in the array to get from the first array cell to the last one only by mooving
     * forward and backward depends by the value in the specific array cell we step on the array contains only positive numbers without zero
     * @param array of int 
     * @return true if there is a valid way or false if not
     */
    public static boolean isWay(int[] a)
    {
        if (a.length==1)
            return true;
        return isWay(a, 0);
    }

    public static boolean isWay(int[] a, int i)
    {
        if (i > a.length-1 || i < 0 || a[i] == -1)
        {
            return false;
        }
        if (i == a.length-1)
        {
            return true; 
        }    
        int temp = a[i];
        a[i] = -1;
        boolean answer;
        answer =  isWay(a, i + temp) || isWay(a, i-temp);
        a[i] = temp;
        return answer;
    }

    /**
     * Q4
     * The method is Boolean recursive and returns the smallest number of steps that the prince need to do to the evil person If there is no path, then it returns -1
     * Where each number in the array represents the height of a roof and it can go to a roof at the same height or a height one higher or a height lower by one or two than the height it is at. 
     * when he is allowed to go in all directions except if its out of the array bounds if he is near the evil person he can jump on him not depends of the height
     * difference
     * @param drm (int [][]), i which is an integer, j which is an integer 
     * @return the numbers of steps to get to the evil person and if there no such legal route to him the method will return -1
     */
    public static int prince(int[][] drm, int i, int j)
    {
        int result = prince(drm, i, j, 1, drm[i][j]);
        if(result == Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return result;
        }
    }

    public static int prince(int[][] drm, int i, int j, int steps, int height)
    {
        if( i < 0 || i>= drm.length || j < 0 || j >= drm[0].length || drm[i][j] == Integer.MAX_VALUE || height > drm[i][j] + 2 || drm[i][j] > height + 1)
        {
            return Integer.MAX_VALUE;
        }
        if(drm[i][j] == -1)
        {   
            return steps;
        }
        if(NextToEvilMan(drm, i, j))
        {
            return steps + 1;
        }

        int temp = drm[i][j];
        drm[i][j] = Integer.MAX_VALUE;
        int up = prince(drm, i-1, j, steps+1, temp);
        int down = prince(drm, i+1, j,steps+1, temp);
        int left = prince(drm, i, j-1, steps+1,temp);
        int right = prince(drm, i, j+1, steps+1, temp);
        drm[i][j] = temp;
        return Math.min(Math.min(right, left), Math.min(up,down));
    }

    private static boolean NextToEvilMan(int[][] drm, int i, int j)
    {
        if(( i+1<=drm.length -1 && drm[i+1][j]  == -1) || (j-1 >= 0 && drm[i][j-1] == -1) || i -1 >= 0 && drm[i-1][j] == -1 || (j+1 <= drm[0].length -1 && drm[i][j+1] == -1))
        {
            return true;
        }
        return false;
    }
}
