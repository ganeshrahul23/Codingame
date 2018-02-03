import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt(); // number of lines of ancestry
        if (in.hasNextLine()) {in.nextLine();}
        String ancestry = ""; // current ancestry
        int dots = -1; // ancestry hierarchy
        for (int i = 0; i < count; i++) {
            String line = in.nextLine(); // current person
            String add = line.replace(".",""); // name of person
            int level = line.length() - add.length(); // hierarchical level of person
            if (level<=dots) { 
                System.out.println(ancestry.substring(3)); // display ancestry
                ancestry = remove(ancestry,dots-level); // update ancestry
            }
            ancestry+=" > "+add; // add person
            dots = level; // update hierarchical level
        }
        System.out.println(ancestry.substring(3)); // display
    }
    
    public static String remove(String cnt,int remove) {
        for (int i = 0; i <= remove; i++) {
            cnt = cnt.substring(0,cnt.lastIndexOf(">")-1); // remove last person
        }
        return cnt; // return updated ancestry
    }
}
