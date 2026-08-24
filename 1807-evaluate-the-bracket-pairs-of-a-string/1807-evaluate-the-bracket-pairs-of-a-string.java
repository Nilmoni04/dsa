class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String , String> map = new HashMap<>();
        for(int i = 0; i < knowledge.size(); i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            String key = "";
            if(ch == '('){
                while(ch != ')'){
                    ch = s.charAt(++i);
                    if(ch != ')'){
                        key += ch;
                    }
                }

                if(map.containsKey(key)){
                    res.append(map.get(key));
                } else{
                    res.append("?");
                }
            } else{
                res.append(ch);
            }
        }

        return res.toString();
    }
}