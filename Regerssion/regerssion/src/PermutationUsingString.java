import java.util.*;
public class PermutationUsingString {
    static void permutation(char[]ch,int index){
        if(index==ch.length){
            System.out.println(new String(ch));
            return;
        }
        for(int i=index;i<ch.length;i++) {
            char temp = ch[index];
            ch[index] = ch[i];
            ch[i]=temp;
            permutation(ch,index+1);
            temp=ch[index];
            ch[index]=ch[i];
            ch[i]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        char[]ch=str.toCharArray();
        permutation(ch,0);
        s.close();
    }
}