
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.stream.Stream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] farm;
            int result=0;
            int farmSize=sc.nextInt();
            int point=farmSize/2;
            farm=new int[farmSize][farmSize];
            
            for(int j=0;j<farmSize;j++){
                String num_list=sc.next();
                farm[j]=Stream.of(num_list.split("")).mapToInt(Integer::parseInt).toArray();

            }
            for(int j=0;j<=point;j++){
                for(int k=point-j;k<=point+j;k++){
                    result+=farm[j][k];
                    if(j==point) continue;
                    result+=farm[farmSize-1-j][k];
                }
            }
            System.out.println("#"+test_case+" "+result);
		}
	}
}