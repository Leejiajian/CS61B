public class ExamPrep {
    public static int[] flat(int[][] x) {
        int totalLength = 0;
        for(int[] row : x) {
            totalLength += row.length;
        }
        int[] result = new int[totalLength];
        int position = 0;
        for(int[] row : x) {
            for(int col : row){
                result[position++] = col;
            }
        }
        return result;
    }
    public static void printArr(int[] Arr) {
        for(int i = 0; i < Arr.length; ++i)
            System.out.print(Arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] originalArr = new int[][]{{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        ExamPrep.printArr(flat(originalArr));
    }


}
