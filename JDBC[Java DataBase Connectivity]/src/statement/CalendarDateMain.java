package statement;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDateMain {

	public static void main(String[] args) throws Exception{
		long startTime = System.currentTimeMillis();
		
		System.out.println("-------Calendar.get---------");
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1);
		int year = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH);
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		int hour = cal1.get(Calendar.HOUR);
		int minute = cal1.get(Calendar.MINUTE);
		int sec = cal1.get(Calendar.SECOND);
		int msec = cal1.get(Calendar.MILLISECOND);
		
		System.out.println(year+"/"+(month+1)+"/"+day+" "+hour+":"+minute+":"+sec+"."+msec);
		System.out.println("-------Calendar.set---------");
		Calendar cal2=Calendar.getInstance();
		cal2.clear();
		cal2.set(Calendar.YEAR,2019);
		cal2.set(Calendar.MONTH, 11);
		cal2.set(Calendar.DAY_OF_MONTH,31);
		cal2.set(Calendar.HOUR,11);
		cal2.set(Calendar.MINUTE,30);
		cal2.set(Calendar.SECOND,59);
		cal2.set(Calendar.MILLISECOND,999);
		
		year = cal2.get(Calendar.YEAR);
		month = cal2.get(Calendar.MONTH);
		day = cal2.get(Calendar.DAY_OF_MONTH);
		hour = cal2.get(Calendar.HOUR);
		minute = cal2.get(Calendar.MINUTE);
		sec = cal2.get(Calendar.SECOND);
		msec = cal2.get(Calendar.MILLISECOND);
		System.out.println(">>>> 1. "+year+"/"+(month+1)+"/"+day+" "+hour+":"+minute+":"+sec+"."+msec);
		
		Calendar cal3=Calendar.getInstance();
		cal3.set(2012, 5, 12, 11, 59, 58);
		System.out.println(">>>> 2. "+cal3);
		
		Calendar cal4=Calendar.getInstance();
		cal4.setTimeInMillis(System.currentTimeMillis());
		System.out.println(">>>> 3."+cal4);
		//System.out.println(System.currentTimeMillis());
		//System.out.println(System.currentTimeMillis());
		
		System.out.println("-------------SimpleDateFormat(Date(Calendar)-->text )-----------------");
		//System.out.println(new Date());
		SimpleDateFormat sdf1=
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		SimpleDateFormat sdf2=
				new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(sdf1.format(new Date()));
		System.out.println(sdf1.format(new Date(System.currentTimeMillis())));
		System.out.println(sdf1.format(new Date(cal3.getTimeInMillis())));
		System.out.println(sdf2.format(new Date()));
		System.out.println(sdf2.format(new Date(System.currentTimeMillis())));
		System.out.println(sdf2.format(new Date(cal3.getTimeInMillis())));
		System.out.println("---------java.util.Date(java.sql.Date)-----");
		Date date1=new Date();
		System.out.println(date1);
		Date date2=new Date(System.currentTimeMillis());
		System.out.println(date2);
		
		java.sql.Date date3=
				new java.sql.Date(System.currentTimeMillis());
		System.out.println(date3);
		System.out.println("-------------SimpleDateFormat(text-->Date)-----------------");
		
		SimpleDateFormat sdf3=new SimpleDateFormat();
		sdf3.applyPattern("yyyy-MM-dd");
		
		Date date4 = sdf3.parse("2012-03-01");
		System.out.println(date4);
		sdf3.applyPattern("yyyy/MM/dd HH:mm:ss");
		Date date5 = sdf3.parse("2011/03/04 12:23:33");
		System.out.println(date5.toLocaleString());
		long ms=date5.getTime();
		System.out.println("Date.getTime():"+ms);
		Calendar cal5 = Calendar.getInstance();
		cal5.setTime(date5);
		cal5.setTimeInMillis(date5.getTime());
		System.out.println("-------------SimpleDateFormat(Date-->text)-----------------");
		SimpleDateFormat sdf4=new SimpleDateFormat();
		sdf4.applyPattern("yyyy");
		System.out.println("yyyy-->"+sdf4.format(date5));
		sdf4.applyPattern("MM");
		System.out.println("MM-->"+sdf4.format(date5));
		sdf4.applyPattern("dd");
		System.out.println("dd-->"+sdf4.format(date5));
		sdf4.applyPattern("HH");
		System.out.println("HH-->"+sdf4.format(date5));
		sdf4.applyPattern("mm");
		System.out.println("mm-->"+sdf4.format(date5));
		sdf4.applyPattern("ss");
		System.out.println("ss-->"+sdf4.format(date5));
		
		System.out.println("-----------------compare--------------");
		Calendar c1=Calendar.getInstance();
		c1.clear();
		c1.set(2019,5,20);
		
		Calendar c2=Calendar.getInstance();
		c2.clear();
		c2.set(2019,5,20);
		Calendar c3=Calendar.getInstance();
		c3.clear();
		c3.set(2022,5,21);
		int result = c1.compareTo(c2);
		System.out.println("c1 , c2 -->"+result);
		result = c1.compareTo(c3);
		System.out.println("c1 , c3 -->"+result);
		boolean isSame = c1.equals(c2);
		System.out.println(isSame);
		System.out.println("-------------------------------------");
		Calendar c4=Calendar.getInstance();
		c4.clear();
		c4.set(2020,0,9,11,13,20);
		SimpleDateFormat sdf5=
				new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		System.out.println(sdf5.format(new Date(c4.getTimeInMillis())));
		//c4.add(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		//System.out.println(sdf5.format(new Date(c4.getTimeInMillis())));
		
		c4.add(Calendar.DATE, 5);
		System.out.println(sdf5.format(new Date(c4.getTimeInMillis())));
		c4.add(Calendar.DATE, -5);
		System.out.println(sdf5.format(new Date(c4.getTimeInMillis())));
		c4.add(Calendar.YEAR, 1);
		System.out.println(sdf5.format(new Date(c4.getTimeInMillis())));
		c4.add(Calendar.MONTH, 6);
		System.out.println(sdf5.format(new Date(c4.getTimeInMillis())));
		c4.add(Calendar.HOUR, 3);
		System.out.println(sdf5.format(new Date(c4.getTimeInMillis())));
		
		Thread.sleep(345);
		long endTime = System.currentTimeMillis();
		long duration = endTime-startTime;
		
		System.out.println("took "+duration+" ms...");
		
		
		
	}

}








