import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test1 {
	
    /***、
     * 我是分支1
     * 获取某段时间内 所有月份的最后一天   参数2018-1 2018-5  返回 2018-01-31 2018-02-28 2018-03-31 2018-04-31 2018-05-31
     * @param minDate
     * @param maxDate
     * @return
     * 
     */
	private static List<String> getMonthBetween(String minDate, String maxDate) {
	    ArrayList<String> result = new ArrayList<String>();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  //格式化为年月
	    Calendar min = Calendar.getInstance();
	    Calendar max = Calendar.getInstance();
	 
	    try {
			min.setTime(sdf.parse(minDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
	 
	    try {
			max.setTime(sdf.parse(maxDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
	 
	    Calendar curr = min;
	    while (curr.before(max)) {
	      result.add(sdf.format(curr.getTime()));
	      curr.add(Calendar.MONTH, 1);
	    }
	    
		List<String> lastDayOfMonthList = new ArrayList<>();
		for(String s : result) {
			String[] year_Month_Str = s.split("-");
			int year = Integer.parseInt(year_Month_Str[0]);
			int month = Integer.parseInt(year_Month_Str[1]);
			Calendar cal = Calendar.getInstance();
	        //设置年份
	        cal.set(Calendar.YEAR,year);
	        //设置月份
	        cal.set(Calendar.MONTH, month-1);
	        //获取某月最大天数
	        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	        //设置日历中月份的最大天数
	        cal.set(Calendar.DAY_OF_MONTH, lastDay);
	        //格式化日期
	        SimpleDateFormat sdfFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String lastDayOfMonth = sdfFormat.format(cal.getTime());
	        lastDayOfMonthList.add(lastDayOfMonth);
		}
	    return lastDayOfMonthList;
	}


	private static boolean isCurrenMonth(){
		String t="2018-08";//给定的日期
		Calendar cal = Calendar.getInstance();
		cal.add(cal.MONTH, 0);
		Date currentTime=cal.getTime();//当前时间的上个月时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String curTime=sdf.format(currentTime);
		if(t.equals(curTime)){
			System.out.println("是当前时间的上个月！");
			return false;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
		Test1.isCurrenMonth();
		
		/*List<String>  ss = Test1.getMonthBetween("2019-1", "2019-5");
		for(String s1 : ss) {
			System.out.println( s1);
		}*/
	
	}

}
