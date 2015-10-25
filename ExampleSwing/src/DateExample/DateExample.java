package DateExample;

import java.util.Calendar;
import java.util.Date;

public class DateExample {
	public static void main(String[] argv){
		Date nDate = new Date();
				
		Calendar cal = Calendar.getInstance() ;
		cal.setTime(nDate);
		
		
		int range = 100;
		//Set to the first day of a month
		//cal.add (Calendar.DATE, -cal.get(Calendar.DATE)+1 );
		//add a month
		//cal.add(Calendar.MONDAY, 1);
		//add an year
		//cal.add(Calendar.YEAR, 1);
		
		int curDay = cal.get(Calendar.DATE);
		int curDate = cal.get(Calendar.DAY_OF_WEEK);
		int curMonth = cal.get(Calendar.MONTH)+1;
		int curYear = cal.get(Calendar.YEAR);
		
		String day = "";
		
		switch(curDate){
        case 1:
            day = "일";
            break ;
        case 2:
            day = "월";
            break ;
        case 3:
            day = "화";
            break ;
        case 4:
            day = "수";
            break ;
        case 5:
            day = "목";
            break ;
        case 6:
            day = "금";
            break ;
        case 7:
            day = "토";
            break ;
             
		}
		
		System.out.println("Today is "+curYear+"/"+curMonth+"/"+curDay+"("+day+")");
		
		int curDayNum = cal.get(Calendar.DAY_OF_WEEK) ;	
		
		for(int i = 0 ; i < curDayNum ; i++)
			System.out.print("\t");
		
		System.out.print(cal.get(Calendar.DATE));
		
		
		int prevMonth = cal.get(Calendar.MONTH) ;
		for(int i = 0 ; i < range ; i++){
			cal.add ( Calendar.DATE, 1 ); // 다음날로 바뀜
			if(prevMonth != cal.get(Calendar.MONTH)) break;
			
			System.out.print("\t"+cal.get(Calendar.DATE));
			int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
			if(dayNum == 7) System.out.println("");
			
			//System.out.println(dayNum);	
		}
		
		
		
	}
}
