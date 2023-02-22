//8th-prblm
class TweetCounts {

    Map<String, TreeSet<Integer>> map = new HashMap();
    Map<String, Integer> meta = new HashMap();
    public TweetCounts() {
        
        meta.put("minute", 60);
        meta.put("hour", 3600);
        meta.put("day", 86400);
    }
    
    public void recordTweet(String tweetName, int time) {
        
        map.computeIfAbsent(tweetName, t -> new TreeSet<Integer>()).add(time);
        
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        TreeSet<Integer> subset = (TreeSet) map.getOrDefault(tweetName, new TreeSet<Integer>()).subSet(startTime, true, endTime, true);
        
        List<Integer> out = new ArrayList();
        
        int chunk = meta.get(freq);
            
        for(int i = startTime; i <= endTime; i = i + chunk ) {

            out.add(subset.subSet(i, true, Math.min(i + chunk-1, endTime), true).size());
        }
        return out;
    }
}
