
public class Test123 {
	public static void main(String[] argv){
		//System.out.println(gcd(100, 15));
		int[] aa = {1, 3, 4};
		System.out.println(bSearch(aa, 1));
	}
	
	public static int gcd(int a, int b){
		System.out.println(a+", "+b);
		if(a == 0) return b;
		else return gcd(b%a, a);
	}
	
	
	public static int bSearch(int[] nums, int target){
		
		int min, max;
        min = 0;
        max = nums.length;
        int cur = (min+max)/2;
        
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        
        int insertPos = 0;
        while(min<=max){
            if(nums[cur] == target) return cur;
            
            System.out.println(target+", "+nums[cur]);
            if(target < nums[cur]){
                max = cur-1;
                insertPos = cur;
            }
                
            else{
                min = cur+1;
                insertPos = min;
            }
                
            
            cur = (min+max)/2;
        }
        
        System.out.println("??");
        
        return insertPos;
	}
}
