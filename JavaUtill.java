package CommonUtills;

import java.util.Random;

public class JavaUtill {

 public int getRandomNumber() {
	 
	 Random r = new Random();
	 
	 int ran = r.nextInt(10);
	 
	 return ran;

	}

}
