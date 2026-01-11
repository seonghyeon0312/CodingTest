import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        int year = 1;
        Earth earth = new Earth();
        Sun sun = new Sun();
        Moon moon = new Moon();
        while(true){
            if(earth.date == e && sun.date == s && moon.date == m){
                break;
            }

            earth.up();
            sun.up();
            moon.up();
            year++;
        }

        System.out.println(year);
    }

    private static class Earth{
        int date;

        public Earth(){
            this.date = 1;
        }

        public void up(){
            this.date++;
            if(date > 15) this.date = 1;
        }
    }

    private static class Sun{
        int date;

        public Sun(){
            this.date = 1;
        }

        public void up(){
            this.date++;
            if(this.date > 28) this.date = 1;
        }

    }

    private static class Moon{
        int date;

        public Moon(){
            this.date = 1;
        }

        public void up(){
            this.date++;
            if(this.date > 19) this.date = 1;
        }
    }
}
