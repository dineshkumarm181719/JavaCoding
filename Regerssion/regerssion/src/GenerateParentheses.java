import java.util.*;
import java.util.ArrayList;
public class GenerateParentheses {
    static void generate(String str,int open,int close,int n,List<String>res) {
        if(str.length()==2*n){
            res.add(str);
            return;
        }
        if(open<n){
            generate(str+"(",open+1,close,n,res);
        }
        if(close<open){
            generate(str+")",open,close+1,n,res);
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        List<String> res=new ArrayList<>();
        generate("",0,0,n,res);
        for(String sc:res){
            System.out.println(sc);
        }
    }
}