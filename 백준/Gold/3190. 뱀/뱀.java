    import java.io.InputStreamReader;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.util.*;

    public class Main {
        private static Integer N;
        private static Integer K;
        private static Queue<Change> queue = new LinkedList<>();
        private static int[][] table;
        private static int[] dx = {0,1, 0, -1};
        private static int[] dy = {1, 0, -1, 0};
        private static Integer overTime = 0;
        private static boolean status = true;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            K = Integer.parseInt(st.nextToken());

            Snake snake = new Snake();

            snake.deque.add(new Point(0, 0));

            table = new int[N][];
            for (int i = 0; i < N; i++) {
                table[i] = new int[N];
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                table[x][y] = 1;
            }

            st = new StringTokenizer(bf.readLine());
            Integer D = Integer.parseInt(st.nextToken());
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(bf.readLine());
                final Change change = new Change(Integer.parseInt(st.nextToken()), st.nextToken());
                queue.add(change);
            }

            int direction =0;

            /*
             *  움직이기 시작
             * */
            while (true) {
                overTime++;

                int nextX= snake.deque.peek().x+dx[direction];
                int nextY= snake.deque.peek().y+dy[direction];

                if(nextX<0 || nextX>=N || nextY<0 || nextY>=N){
                    break;
                }

                snake.isContain(nextX,nextY);
                if(!status) break;

                snake.deque.addFirst(new Point(nextX,nextY));

                if(table[nextX][nextY]!=1){
                    snake.deque.pollLast();
                }else{
                    table[nextX][nextY]=0;
                }

                if(queue.isEmpty()){continue;}

                if(queue.peek().time.equals(overTime)){
                    final Change change = queue.poll();

                    if(change.direction.equals("D")){
                        direction+=1;
                        if(direction==4){
                            direction=0;
                        }
                    }else{
                        direction-=1;
                        if(direction==-1){
                            direction=3;
                        }
                    }
                }
            }

            System.out.println(overTime);
        }
        static class Snake {
            private Deque<Point> deque = new ArrayDeque<>();

            public Snake() {
                this.deque = new ArrayDeque<>();
            }

            public void isContain(int nx,int ny){
                for (Point point : deque) {
                    if(point.x == nx && point.y == ny){
                        status=false;
                    }
                }
            }
        }

        static class Point {
            private Integer x;
            private Integer y;

            public Point(Integer x, Integer y) {
                this.x = x;
                this.y = y;
            }
        }

        static class Change {
            private Integer time;
            private String direction;

            public Change(Integer x, String s) {
                this.time = x;
                this.direction = s;
            }
        }
    }