package epam_week3;

import java.util.*; 
import java.io.BufferedReader;
import java.io.*;
public class Descending_weights
    {            
            public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) // function to sort hashmap by values 
            { 
                List<Map.Entry<Integer, Integer> > list = new LinkedList< >(hm.entrySet());   // Create a list from elements of HashMap 
                Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> -((o1.getValue()).compareTo(o2.getValue())));           
            HashMap<Integer, Integer> temp = new LinkedHashMap<>(); 
            list.stream().forEach((aa) -> {
                temp.put(aa.getKey(), aa.getValue());
            }); 
            return temp; 
            } 
    public static void main(String[] args) throws Exception 
    { 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());        
        int[] a=new int[n];
        String st1 = br.readLine();
        String[] st2=st1.split(" ");
        for(int i=0;i<st2.length;i++)
        {
            a[i]=Integer.valueOf(st2[i]);
        }
        int[] b=new int[n];
        for(int i=0;i<n;i++)
        {
            b[i]=a[i]%k;
        }
        HashMap<Integer, Integer> hm = new HashMap<>(); 
        for(int i=0;i<n;i++)
        {
            hm.put(a[i],b[i]);
        }
        Map<Integer, Integer> hm1 = sortByValue(hm); 
        hm1.entrySet().stream().forEach((en) -> {
            System.out.print(en.getKey()+" ");
        });
    }
    
}
