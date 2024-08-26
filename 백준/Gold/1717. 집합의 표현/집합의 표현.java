    import java.io.IOException;
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main {

        static int[] node;
        static int n,m;

        public static void main(String[] args) throws IOException{
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            node= new int[n+1];

            for(int i=0;i<=n;i++){
                node[i]=i;
            }

            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());

                int num=Integer.parseInt(st.nextToken());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());

                if(num==0){
                    int min=Math.min(a,b);
                    int max=Math.max(a,b);
                    union(min,max);
                }else if(num==1){
                    if(unionFind(a,b)){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
        }

        public static void union(int a, int b){
            int newA=find(a);
            int newB=find(b);
            if(newA!=newB){
                node[newB]=newA;
            }
        }

        public static boolean unionFind(int a,int b){
            node[a]=find(a);
            node[b]=find(b);
            if(node[a]==node[b]){
                return true;
            }else{
                return false;
            }
        }

        public static int find(int a){
            if(node[a]==a){
                return a;
            }else{
                return node[a]=find(node[a]);
            }
        }
    }