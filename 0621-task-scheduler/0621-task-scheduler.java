class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:tasks){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);
        for(char ch:hm.keySet()){
            pq.offer(new Pair(ch,hm.get(ch)));
        }
        int time=0;
        while(pq.size()>0){
            int nCpy=n+1;
            int work=0;
            ArrayList<Pair> al=new ArrayList<>();
            while(nCpy>0&&!pq.isEmpty()){
                Pair curr=pq.poll();
                curr.freq--;
                al.add(curr);
                nCpy--;
                work++;
            }
            
            for(Pair obj:al){
                if(obj.freq>0)
                    pq.offer(obj);
            }
            if(pq.isEmpty()){
                time+=work;
            }else{
                time+=n+1;
            }
        }
        return time;
    }
}
class Pair{
    char ch;
    int freq;
    Pair(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}