package epam_week3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
public class help_out_the_indian_army {
        public static void main(String args[] ) throws Exception {
            FastReader s = new FastReader();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = s.nextInt();
            long start = s.nextLong();
            long end = s.nextLong();
            long lrange[]=new long[n];
            HashMap<Long,Long> RRange = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                long x = s.nextLong();
                long p = s.nextLong();
                lrange[i]=x-p;
                RRange.put(lrange[i],x+p);
            }
            merge_sort(lrange,0,lrange.length-1);
            long area = 0;
            int i=0;
            while(start<end&&i<lrange.length)
            {
                if(lrange[i]-start>0)
                {
                    if(end<lrange[i]){
                        area = area + end - start;
                        start = end;
                        break;
                    }
                    else
                        area = area + lrange[i] - start;
                }
                if(start<RRange.get(lrange[i]))
                    start = RRange.get(lrange[i]);
                i++;
            }
            if(start<end)
            {
                area = area + end - start;
            }
            out.write(Long.toString(area));
            out.flush();
        }
        public static void merge_sort(long arr[],int lo,int hi)
        {
            if(lo<hi)
            {
                int mid = (lo+hi)/2;
                merge_sort(arr,lo,mid);
                merge_sort(arr,mid+1,hi);
                merge(arr,lo,hi,mid);
            }
        }
        public static void merge(long arr[],int lo,int hi,int mid)
        {
            long b[]=new long[hi-mid];
            long a[]=new long[mid-lo+1];
            int j=0;
            int k=0;
     
            for(int i=lo;i<=mid;i++)
                a[j++]=arr[i];
     
            for(int i=mid+1;i<=hi;i++)
                b[k++]=arr[i];
     
            int i=0;
            j=0;
            k=lo;
     
            while(i<a.length&&j<b.length)
            {
                if(a[i]<=b[j])
                {
                    arr[k]=a[i];
                    i++;
                }
                else
                {
                    arr[k]=b[j];
                    j++;
                }
                k++;
            }
     
            while(i<a.length)
            {
                arr[k]=a[i];
                i++;
                k++;
            }
     
            while(j<b.length)
            {
                arr[k]=b[j];
                j++;
                k++;
            }
        }
    }
    class FastReader{
        BufferedReader br;
        StringTokenizer st;
     
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
     
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                }
            }
            return st.nextToken();
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
     
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
     
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
            }
            return str;
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
    }
