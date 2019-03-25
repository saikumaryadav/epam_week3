/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam_week3;
    import java.util.*;
    import java.io.*;
         
         
        class InputReader {
            private final InputStream stream;
            private final byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;
            private SpaceCharFilter filter;
         
            public InputReader(InputStream stream) {
                this.stream = stream;
            }
         
            public static boolean isWhitespace(int c) {
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }
         
            public int read() {
                if (numChars == -1)
                    throw new InputMismatchException();
                if (curChar >= numChars) {
                    curChar = 0;
                    try {
                        numChars = stream.read(buf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (numChars <= 0)
                        return -1;
                }
                return buf[curChar++];
            }
         
            public int nextInt() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                int res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
         
            public long nextLong() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                long res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
         
            public String nextToken() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = read();
                } while (!isSpaceChar(c));
                return res.toString();
            }
         
            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return isWhitespace(c);
            }
         
            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }
         
         
        public class glowing_bulb {
        public static void main(String args[])
        {
        	InputReader s=new InputReader(System.in); 
            try (PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out))) {
                int a[]={2,3,5,7,11,13,17,19,23,29,31,37};
                int map[]=new int[40];
                for(int i=0;i<a.length;i++)
                {
                    map[a[i]]=i;
                }
                int n=a.length;
                int lim=1<<n;
                long dp[]=new long[lim];
                Arrays.fill(dp,1);
                for(int i=0;i<n;i++)
                {
                    dp[1<<i]=a[i];
                }
                for(int mask=0;mask<lim;mask++)
                {
                    int last;
                    long val=1;
                    for(last=0;last<n;last++)
                    {
                        if(((1<<last)&mask)!=0)
                        {
                            val=lcm(val,a[last]);
                        }
                    }
                    dp[mask]=val;
                }
                int t=s.nextInt();
                while(t-->0)
                {
                    String st=s.nextToken();
                    ArrayList<Integer> aa=new ArrayList<>();
                    HashSet<Integer> hs=new HashSet<>();
                    int m=0;
                    for(int i=0;i<st.length();i++)
                    {
                        if(st.charAt(i)=='1')
                        {
                            aa.add(map[i+1]);
                            m+=(1<<map[i+1]);
                        }
                    }
                    double val=0;
                    ArrayList<Long> as=new ArrayList<>();
                    for(int mask=0;mask<lim;mask++)
                    {
                        if((m&mask)==0 || ((~m)&mask)!=0)continue;
                        
                        if(count(mask)%2==0)
                        {
                            as.add(-dp[mask]);
                        }
                        else
                        {
                            as.add(dp[mask]);  
                        }
                    }
                    long k=s.nextLong();
                    long  lo = 1, hi =(long)(1e18), ret = -1;
                    while (lo <= hi) {
                        long mid = lo + (hi - lo) / 2;
                        long x=0;
                        x = as.stream().map((a1) -> mid / a1).reduce(x, (accumulator, _item) -> accumulator + _item);
                        if (x < k) lo = mid + 1;
                        else {
                            ret = mid;
                            hi = mid - 1;
                        }
                    }
                    out.println(ret);
                }   }
        
        }
        static int count(int a)
        {
        	int count=0;
        	 while(a>0)
        	  {
        	    count += a & 1;
        	    a >>= 1;
        	  }
        	  return count;
        }
        
         static long lcm(long a, long b)
        {
            return a * (b / gcd(a, b));
        }
    	static long gcd(long num1, long num2){
    	    if(num1 > num2){
    	        long temp = num1;
    	        num1 = num2;
    	        num2 = temp;
    	    }
    	    while(num1 != 0){
    	        long temp = num1;
    	        num1 = num2 % num1;
    	        num2 = temp;
    	    }
    	    return num2;
    	}
    }
