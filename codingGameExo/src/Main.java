import java.util.Arrays;

public class Main {

    private static class Employee {
        String name;
        int age;

        public String toString(){
            return "my name is "+name+", & i m "+age+"yo";
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        /*String str1 = "ffaafjiAAAdifiaaaAruef3332323222333";
        String str2 = "3333333aaaaaabbb4444rrrrrrr";
        //String str3 = "sssEEEEEE";

        System.out.println("nbOcc in str1 : "+str1+" is "+solution.numberOfValidOcc(str1));
        System.out.println("nbOcc in str2 : "+str2+" is "+solution.numberOfValidOcc(str2));/*


        //String [] tab = new String []{"flower","flow","flight"};
        //System.out.println(solution.longestCommonPrefix(tab));
        Employee e = new Employee();
        e.name = "steph";
        e.age = 10;
        Employee b = e;
        b.name = "bob";
        System.out.println(e.toString());*/


        //int [] tab = {1, 2, 39, 33, 23, 11, 303, 4,900,474,22};
        int [] tab = {3, 4, 2, -2, 2, 4, 3, 29, 4, 33, 29};
        System.out.println(Arrays.toString(solution.enleverDoublon(tab)));
        /*Solution.flip(tab,6);
        Arrays.stream(tab).forEach(System.out::println);
        System.out.println("before sort");
        int [] result = solution.pancakeSort(tab);
        System.out.println("res len : "+result.length);
        Arrays.stream(result).forEach(System.out::println);
        System.out.println("end");
        //System.out.println(Arrays.stream(tab).forEach(););*/


        /*char[] arr = {'x','y','z'};
        String str = "xyyzyzyx";
        String res = Solution.getShortestUniqueSubstring(arr, str);
        System.out.println("res : "+res);*/
        /*String[] arr = {"hello","leetcode"};
        String s = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(arr, s));*/

        //String s = "loveleetcode";
        //solution.firstUniqChar(s);

        //solution.hammingDistance(1,4);

        //System.out.println(solution.nombrePaireSansDoublon(4));
        char[][] array = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};

        char[][] array2 = {{'1','1','0','0','0'},
                           {'1','1','0','0','0'},
                           {'0','0','1','0','0'},
                           {'0','0','0','1','1'}};

        char[][] array3 = {{'1','0','0'},
                           {'0','0','0'},
                           {'0','0','1'}};

        char[][] array4 = {{'0','1','0'},
                           {'1','0','1'},
                           {'0','1','0'}};

        char[][] array5 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] array6 = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};

        /*System.out.println(solution.numIslands(array5));

        System.out.println(solution.validMountainArray(new int []{3,5,5}));*/

        //System.out.println(solution.kSmallestPairs(new int []{1,1,2}, new int []{1,2,3}, 10));

        System.out.println(solution.isAnagram("vaja","aavj"));

        /*String s = "salut tout   le  monde";
        String replacedS = s.replaceAll("\\s","");
        System.out.println("S is : "+replacedS);*/

        //System.out.println(solution.changeSentenceToLinesAfterRemovingSpaces("hello tout lemonde  frfr4",5));

        int [] array10 = {7, 3, 3, 2, 4, 5, 48, 4, 4, 5, 10};
        System.out.println(Arrays.toString(solution.removeDuplicateElementsWhileKeepingSameOrder(array10)));

    }
}
