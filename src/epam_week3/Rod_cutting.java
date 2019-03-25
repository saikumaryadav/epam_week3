package epam_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Rod_cutting {
    static int count=0;
        public static int len(int n)
        {
            if(n==0 || n==1)
            {
                return 0;
            }
            return (1+len(n>>1));
        }
        public static void main(String args[] ) throws Exception
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ArrayList<Integer> l=new ArrayList<Integer>();
                String str1 = br.readLine(); 
                int test=Integer.parseInt(str1);
                int temp=test;
                while(test!=0)
                {
                    String str21 = br.readLine();
                    int length_of_rod=Integer.parseInt(str21);
                    length_of_rod=length_of_rod+1;
                    int a=len(length_of_rod)-1;
                    l.add(a);
                    count=0;
                    test--;
                }
                for(int i=0;i<temp;i++)
                {
                    System.out.println(l.get(i));
                }
 
    }
}
