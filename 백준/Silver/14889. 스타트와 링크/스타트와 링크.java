import java.util.Collection;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    static int[][] board;
    static Team start = new Team();
    static Team link = new Team();
    static int minResult = Integer.MAX_VALUE;
    static List<Team[]> teamList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] person = new int[n+1];
        board = new int[n+1][n+1];
        int team = n/2;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                board[i][j] = sc.nextInt();
            }
        }
        List<Integer> index = new ArrayList<>();
        for(int i=1;i<=n;i++){
            index.add(i);
        }

        Combi com = new Combi(n);
        boolean[] visited = new boolean[n+1];
        com.teamMaker(1,0,visited);

        for (Team[] teams : teamList) {
            minResult = Math.min(minResult, Math.abs(teams[0].TeamRate() - teams[1].TeamRate()));
        }

        System.out.println(minResult);
    }

    private static class Combi{
        int num;
        Combi(int n){
            this.num = n;
        }

        public void teamMaker(int index, int peopleCount, boolean[] visited){
            if(this.num/2 == peopleCount){
                Team[] teams = new Team[2];
                teams[0] = new Team(new ArrayList<>(start.people));
                for(int i=1;i<=num;i++){
                    if(!visited[i]){
                        link.people.add(i);
                    }
                }
                teams[1] = new Team(new ArrayList<>(link.people));
                teamList.add(teams);
                link.people.clear();
                return;
            }

            for(int j=index;j<=num;j++){
                start.people.add(j);
                visited[j] = true;
                teamMaker(j+1,peopleCount+1, visited);
                visited[j]=false;
                start.people.remove(start.people.size()-1);
            }
        }

    }

    private static class Team{
        List<Integer> people = new ArrayList<>();

        Team(){}
        Team(List<Integer> person){
            this.people = person;
        }

        public int TeamRate(){
            int result = 0;
            for (Integer person : people) {
                for (Integer i : people) {
                    result += board[person][i];
                }
            }
            return result;
        }

    }
}