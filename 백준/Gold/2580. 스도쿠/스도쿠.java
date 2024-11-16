import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    private static int[][] sudoku = new int[9][9];
    private static int[] dx = {0,1,1,1,0,-1,-1,-1};
    private static int[] dy = {1,1,0,-1,-1,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<9;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<9;j++){
                sudoku[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0,0);
    }
    private static void backTracking(int row, int col){
        if (row == 9) { // 스도쿠를 모두 채운 경우
            printSudoku();
            System.exit(0); // 탐색 종료
        }

        if (col == 9) { // 현재 행(row)의 마지막 칸을 넘어가면 다음 행으로 이동
            backTracking(row + 1, 0);
            return;
        }

        if (sudoku[row][col] != 0) { // 이미 값이 채워진 칸은 넘어감
            backTracking(row, col + 1);
            return;
        }

        for (int num = 1; num <= 9; num++) { // 1부터 9까지 모든 숫자를 시도
            if (isAvailable(row, col, num)) {
                sudoku[row][col] = num; // 숫자를 넣고
                backTracking(row, col + 1);   // 다음 칸 탐색
                sudoku[row][col] = 0; // 백트래킹: 이전 상태로 되돌림
            }
        }

    }

    private static void printSudoku() {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isAvailable(int row,int col, int value) {
        boolean check = true;

        for(int i=0;i<9;i++){
            if(sudoku[row][i] == value)
                check =false;
            if(sudoku[i][col] == value)
                check = false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return check;
    }
}