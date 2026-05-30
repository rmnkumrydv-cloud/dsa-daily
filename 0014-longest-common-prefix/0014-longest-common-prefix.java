class Solution {
    class node{
     node[] link;
     boolean flag;
     node(){
        link =new node[26];
        flag=false; 
     }
    }
    class trie{
        node root;
        trie(){
            root=new node();
        }
        void insert(String s ){
            node temp=root;
            for(int i=0;i<s.length();i++){
                char c =s.charAt(i);
                if(temp.link[c-'a']==null){
                    node ser=new node();
                    temp.link[c-'a']=ser;
                    
                }
                temp=temp.link[c-'a'];
                
            }
            temp.flag=true;
        }
        int match( String s){
            node temp=root;
            int count=0;
            for(int i=0;i<s.length();i++){
                char c =s.charAt(i);
                if(temp.link[c-'a']==null){
                    break;
                }
                else {count++;temp=temp.link[c-'a'];}
                
            }
            return count ;

        }

    }
    public String longestCommonPrefix(String[] strs) {
        String s =strs[0];
        if(strs.length==1) return s;
        trie t =new trie();
        t.insert(strs[0]);
        int res=Integer.MAX_VALUE;
        for(int i=1;i<strs.length;i++){
            res=Math.min(res,t.match(strs[i]));
        }
        return strs[0].substring(0, res);
        
    }
}