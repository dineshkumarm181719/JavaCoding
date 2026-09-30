import java.util.*;
public class MinmumNoSameParentheses {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int open = 0;
        int close = 0;
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('){
                open++;
            }
            else if (ch==')'){
                if(open>0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        System.out.println(open+close);
    }
}
