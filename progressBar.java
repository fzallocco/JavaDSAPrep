import java.util.*;
import java.lang.*;
import java.time.*;
class progressBar
{
	public static void calculateBar(int num)
	{
		for(int rows = 1; rows<=10; rows++)
		{
			for(int columns = 1; columns<=rows; columns++)
			{
				/*while on the same row...*/
				System.out.print("#");
				try {
                    Thread.sleep(300); // Adding delay to simulate progress
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
			/*Before moving on to the next row*/
			num += 1;
			System.out.print(": "+rows*10+"%\n");
			System.out.println("");
			/*if(num == 10)
			{
				num = 0;
				calculateBar(num); //recursive function is called only when num reaches 10
			}*/
		}
	}

	public static void main(String[] args){
		
		System.out.println("Progress bar program:\n");
		int userInput = 1;
		calculateBar(userInput);
		System.out.println("End Program");
	}
}