
public class sample1 {
	
	
	public static void main(String[] args) 
	{			
				 int x=5,y=4,k=86;
				 int x1;
				
				System.out.println(helpingBob(x,y,k));
	}
	
	static String helpingBob(int x, int y, int k) {
		
		int totalLength = x+y;
		char[] finalString = new char[totalLength];
		
		getSubstring(x,y,k,totalLength,finalString);
		
		return new String(finalString);
	}
	
	
	private static int getSubstring(int localX, int localY, int k, int totalLength, char[] finalString) {
		
		int localCount=0;
		
		int x1=localX;
		 for (int i = totalLength-(localX+localY); i < finalString.length; i++) {
			finalString[i] = x1>0 ? 'H': 'V'; 
			x1--;
		}
		 
		if(localX==0 || localY==0 || localCount == k)
		{
			return localCount;
		}		
		
		int countReturned = getSubstring(localX - 1, localY, k - localCount, totalLength, finalString);
		localCount += countReturned;
		
		if(localCount < k)
		{
			finalString[totalLength-(localX+localY)] = 'V';
			localCount++;
			countReturned = getSubstring(localX, localY-1, k - localCount, totalLength, finalString);
			localCount += countReturned;
		}
		
		return localCount;
	}
}
