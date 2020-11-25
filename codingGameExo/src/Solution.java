import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Pattern pattern = Pattern.compile("[A-Z]");

    public boolean isValid(char c){
        Matcher matcher = pattern.matcher(String.valueOf(c));
        return matcher.find();
    }

    /*
     * this function will return the number of valid occurrence in a String
     * a is the same as A
     * valid occurrence : belong to [a-zA-Z]
     * exmaple : "aaab2à'Ad" return 4
     */
    public int numberOfValidOcc(String str){
        str = str.toUpperCase();
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if(this.isValid(c)){

                if(! map.containsKey(c) ){
                    map.put(c,1);
                    if(max < 1) max = 1;
                } else {
                    int new_occ = map.get(c)+1;
                    map.replace(c,new_occ);
                    if(max < new_occ ) max = new_occ;
                }
            }
        }
        return max;
    }


    /*
     * Example :
     *   input : [1,2,3]
     *   output : [
     *               [1,2,3],
     *               [1,3,2],
     *               [2,1,3],
     *               [2,3,1],
     *               [3,1,2],
     *               [3,2,1]
     *            ]
     */
    public List<List<Integer>> permute(int [] numbers){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        int factorial = factorial(numbers.length,1);

        for(int i = 0; i<factorial; i++){

            if( i%numbers.length == 0){
                result.add(subList);
                subList.clear();
            }
        }
        return result;
    }

    private int factorial(int n, int result){
        return (n > 0) ? result : factorial(n-1,n*result);
    }

    /*
    Input: ["flower","flow","flight"]
    Output: "fl"

    Input: ["dog","racecar","car"]
    Output: ""
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String base = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(base) != 0) {
                base = base.substring(0, base.length() - 1);
                if (base.isEmpty()) return "";
            }
        }
        return base;
    }

    /*
        exemple pour n = 4
        nbr d'element dans 4 = 1, 2, 3, 4
        nombre de pair est "6" => 12, 13, 14, 23, 24, 43
     */
    public int nombreDePaireSansDoublon(int n){
        return 0;
    }

    /* --------------------------------------------------- */

    /*
    reverse k first element in array "tab"
     */
    public static void flip(int [] tab, int k){
        k--;
        for(int i = 0; i<tab.length; i++){
            if(i == k || i > k) break;
            int tmp = tab[i];
            int tmp2 = tab[k];
            tab[i] = tmp2;
            tab[k] = tmp;
            k--;
        }
    }

    /*
    sort tab using flip function
     */
    public static int[] pancakeSort(int [] tab){
        if (tab == null || tab.length < 2) return tab;

        for(int i = tab.length -1; i >= 0; i--){

            int maxElementIndex = i;
            for(int j = i; j >= 0; j--){
                if(tab[j] > tab[maxElementIndex]){
                    maxElementIndex = j;
                }
            }

            flip(tab, maxElementIndex+1);
            flip(tab, i+1);
        }
        return tab;
    }

    /*
    function return the smallest non negative integer that does not exist int the array
    without modifying the array
        ex 1 : [0,1,2,3] -> 4
        ex 2 : [0, 3, 4, 5] -> 1
        ex 3 : [3, 42, 2 , 1] -> 0
     */
    public static int getSmallestNumberNotExistingInArray(int [] tab){
        //List list = List.of(tab);

        /*if(tab.length == 1 && tab[0] != Integer.MAX_VALUE) return tab[0]+1;

        Arrays.sort(tab);
        for(int i = 0; i<tab.length; i++){
            if(i+1 < tab.length) {
                if (tab[i + 1] != tab[i] + 1) return tab[i] + 1;
            }
        }
        return tab[tab.length-1]+1;*/
        return 0;
    }
    /*
    return n'th root of  a number within an error of 0.001
    example : x = 7, n = 3 -> 1,913
           explanation = (1,913)^3 = 7

    example : x = 9, n = 2 -> 3
           explanation = (3)^3 = 9
     */
    static double root(double x, int n){
        return -1;
    }

    /*
    smallest substring of all characters
    given an array of unique characters and string.

    example : arr = ['x','y','z'], string = "xyyzyzyx"
                -> zyx

     */
    /*public static String getShortestUniqueSubstring(char[] arr, String str){
        int counter = 0;

        String minimum = "";
        HashMap<Integer, String> map = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            minimum += str.charAt(i);
            if(contains(minimum, arr)){
                map.put(minimum.length(),minimum);
                minimum = "";
                counter++;
                i = counter;
            }
        }
        System.out.println(map.size());
        return map.get(Collections.min(map.keySet()));
    }

    public static boolean contains(String str, char arr[]){
        for(int i = 0; i<arr.length; i++){
            if(!str.contains(arr[i]+"")) return false;
        }
        return true;
    }*/



        public boolean isAlienSorted(String[] words, String order) {

            if (words.length == 1 || words.length == 0) return true;

            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i<order.length(); i++){
                map.put(order.charAt(i),i);
            }

            int index = 0;

            while(index < words.length - 1){

                if(compare(words[index], words[index+1], map)){
                    index++;
                } else return false;

            }
            return true;
        }

        public boolean compare(String s1, String s2, HashMap<Character, Integer> map){
            int size = Math.min(s1.length(), s2.length());
            int index = 0;
            while(index < size){
                if(map.get(s1.charAt(index)) < map.get(s2.charAt(index))) return true;
                if(map.get(s1.charAt(index)) > map.get(s2.charAt(index))) return false;
                if(map.get(s1.charAt(index)).equals(map.get(s2.charAt(index)))) {
                    index++;
                }
            }
            return true;
        }



        public double Pi(int[][] tab){
            double counter = 0.0;
            for (int[] ints : tab) {
                if (Math.pow(ints[0], 2) + Math.pow(ints[1], 2) <= 1) {
                    counter++;
                }
            }
            return counter*4/tab.length;
        }

        /*
        if n = 4 then we are considering [1,2,3,4]
        so the possible peers are
            [1,2] [1,3] [1,4] [2,3] [2,4] [3,4]
            so the number of peers is 6
         */
        public int nombrePaireSansDoublon(int n){
            int cpt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i != j){
                        cpt++;
                    }
                }
            }
            return cpt/2;
        }

        /*
        Given an array of non-negative integers, you are initially positioned at the first index of the array.
        Each element in the array represents your maximum jump length at that position.
        Determine if you are able to reach the last index.

        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
         */
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            if (nums.length == 1) return true;

            int max_idx = nums[0];
            int idx = 1;
            while (idx <= max_idx) {
                if (nums[idx] + idx >= nums.length - 1) {
                    return true;
                } else {
                    max_idx = Math.max(max_idx, nums[idx] + idx);
                }
                idx++;
            }
            return false;
        }


    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap();

        for(int i = 0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i),1);
            }
        }
        int counter = 0;
        for (Character key : s.toCharArray()) {
            if(map.get(key) == 1) return counter;
            counter++;
        }
        return -1;
    }

    public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int counter = 0;

        for(int i = s.length()-1, j = s2.length()-1; i>=0 && j>=0 ;i--,j--){
            if(s.charAt(i) != s2.charAt(j)) counter++;
        }
        return counter + Math.abs(s.length() - s2.length());
    }

    /*
    Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    Input: grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    Output: 3
     */
    class Range {
        int start;
        int end;

        Range(int s, int e){
            this.start = s;
            this.end = e;
        }

        boolean isBetween(int i){
            return (i >= start && i <= end);
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int numberOfIslands = 0;

        List<Range> previousLine = new ArrayList<>();
        List<Range> currentLine = new ArrayList<>();

        for(int i =0; i<grid.length; i++){

            int start = -1, end = -1;

            for(int j = 0; j<grid[i].length; j++){

                if(i == 0){

                    if(grid[i][j] == '1' && start == -1){
                        start = j;
                    }
                    if(grid[i][j] == '0' && start != -1 && end == -1){
                        end = j - 1;
                        Range r = new Range(start,end);
                        previousLine.add(r);
                        start = -1;
                        end = -1;
                        numberOfIslands++;
                    }
                    if (j == grid[i].length -1  && start != -1){
                        end = j;
                        Range r = new Range(start,end);
                        previousLine.add(r);
                        numberOfIslands++;
                    }

                } else {
                    if(grid[i][j] == '1' && start == -1){
                        if(previousLine.isEmpty()){
                            numberOfIslands++;
                        } else {
                            for (Range r : previousLine) {
                                if (!r.isBetween(j) )
                                    numberOfIslands++;
                                break;
                            }
                        }
                        start = j;
                    }
                    if(grid[i][j] == '0' && start != -1 && end == -1){
                        end = j - 1;
                        Range r = new Range(start,end);
                        currentLine.add(r);
                        start = -1;
                        end = -1;
                    }
                    if (j == grid[i].length-1){
                        if(start != -1){
                            end = j;
                            Range r = new Range(start,end);
                            currentLine.add(r);
                        }
                        previousLine = currentLine;
                    }
                }

            }
        }
        return numberOfIslands;
    }

    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int max = 0;;
        int indexMax = 0;
        for(int i = 0; i<arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
                indexMax = i;
            }
        }
        if(indexMax == arr.length-1 || indexMax == 0) return false;

        int j = 0;
        while(j < indexMax){
            if(arr[j++] > max) return false;
        }
        if(indexMax == arr.length-1) return false;
        indexMax++;
        while(indexMax < arr.length){
            if(arr[indexMax++] >= max) return false;
        }
        return true;
    }


    public HashMap<Character, Integer> makeMapFromString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                int newOcc = map.get(c) + 1;
                map.put(c, newOcc);
            }
        }
        return map;
    }



    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i<nums1.length; i++){
                for(int j = 0; j<nums2.length; j++){
                    int sum = nums1[i] + nums2[j];

                    if(!map.containsKey(sum)){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        map.put(sum, list);
                    } else {
                        List<Integer> list = map.get(sum);
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        map.replace(sum, list);
                    }
                }
            }

            Object[] keys = map.keySet().toArray();
            Arrays.sort(keys);

            List<List<Integer>> result = new ArrayList<>();
            int mapCounter = 0;
            int i = 0;
            while(i < k - 1){
                List<Integer> list = map.get(keys[mapCounter]);
                List<Integer> subList = new ArrayList<>();
                int j = 0;
                while( j < list.size()){
                    subList.add(list.get(j));
                    j++;
                    if(j%2 == 0 && j != 0){
                        result.add(subList);
                        subList = new ArrayList<>();
                        i++;
                    }
                }
                mapCounter++;
            }
            return result;
    }

    /*
        intput -> (s = "salut tout le monde" , n = 4)

        output -> (result = "salu
                             ttou
                             tlem
                             onde" )
     */
    public String changeSentenceToLinesAfterRemovingSpaces(String s, int n){

        int counter = 0;
        String newS = s.replaceAll("\\s","");
        String result = "";
        while (counter < newS.length()){
            int min = Math.min(counter+n, newS.length());
            result += newS.substring(counter, min);
            result += '\n';
            counter += n;
        }
        return result;
    }

    public int [] enleverDoublon(int [] tab){

        Set<Integer> integerSet = new HashSet<>();
        for(int element : tab){
            integerSet.add(element);
        }
        int i = 0;
        int [] result = new int[integerSet.size()];
        for(int element : integerSet){
            result[i++] = element;
        }
        return result;
    }

    public int closestToZero(int[] data){
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(data);

        // find the element nearest to zero
        for (int datum : data) {
            int distance = Math.abs(datum);
            if (min >= distance) {
                result = datum;
                min = distance;
            }
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        /*HashMap<Character, Integer> map1 = makeMapFromString(s);
        HashMap<Character, Integer> map2 = makeMapFromString(t);
        return map1.equals(map2);*/
        if(s.length() != t.length()) return false;

        char [] tab1 = s.toCharArray();
        char [] tab2 = t.toCharArray();

        Arrays.sort(tab1);
        Arrays.sort(tab2);

        return Arrays.equals(tab1, tab2);
    }

    /*
    adding 7 days to a date in JS
        var tomorrow = new Date();
        tomorrow.setDate(tomorrow.getDate() + 1);

        var today = new Date(); // Or Date.today()
        var tomorrow = today.add(1).day();
     */

    /**
     * exemple :
     *  input : [7, 3, 3, 2, 4, 5, 48, 4, 4, 5, 10]
     *  output: [7, 3, 2, 4, 5, 48, 10]
     * @param array input array
     * @return
     */
    public int[] removeDuplicateElementsWhileKeepingSameOrder(int [] array){
        // Integer : element
        // boolean : visited or not
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int element : array){
            if(!map.containsKey(element)){
                map.put(element,true);
            }
        }
        int [] result = new int [map.size()];
        int index = 0;

        for(int element : array){
            if(map.get(element)){
                result[index++] = element;
                map.replace(element,false);
            }
        }

        return result;
    }
    
    public int[] removeDuplicateV2(int [] array){
        Set<Integrer> set = New LinkedHashSet<>();
        for(int elt : array)
            set.add(elt);
        int[] result = new int[set.size()];
        int index = 0;
        for(Integrer elt : set)
            result[i++] = elt;
        return result;
    }

    // reecrire la methode concate optimisé de deux chaine de caractere
    public String oneFromTwo(String s1, String s2){
        /*
        mause réponse return s1 + s2 ; // le + consomme bcp en memoire vu qu'il fait un new String a chaque fois
         */
        // bonne reponse
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s2);
        return sb.toString();
    }
}
