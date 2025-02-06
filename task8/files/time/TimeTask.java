package task8.files.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import exceptions.taskexception.TaskException;
import utility.TaskUtility;

public class TimeTask {

	public 	String getDateTimePattern(ZonedDateTime zdt,int format) throws TaskException{
		TaskUtility.validateNullValue(zdt);
		TaskUtility.validateNullValue(format);
		DateTimeFormatter dtf;
		switch(format) {
			case 1:
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
				break;
			case 2:
				dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
				break;
			case 3:
				dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
				break;
			case 4:
				dtf=DateTimeFormatter.ofPattern("yyyyMMdd");
				break;
			case 5:
				dtf=DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy");
				break;
			case 6:
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				break;
			case 7:
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
				break;
			case 8:
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
				 break;
			case 9:
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
				break;
			case 10:
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
				break;
			default:
				throw new TaskException("Enter valid Date-Time format");
		}
		return formatDateTime(dtf, zdt);
	}
	
	public String formatDateTime(DateTimeFormatter dtf, ZonedDateTime zdt) throws TaskException{
		return zdt.format(dtf);
	}

	public DayOfWeek getDayOfWeek(ZonedDateTime zdt) throws TaskException{
		TaskUtility.validateNullValue(zdt);
		return zdt.getDayOfWeek();
	}
	
	public ZoneId getZoneId(ZonedDateTime zdt) throws TaskException{
		TaskUtility.validateNullValue(zdt);
		return zdt.getZone();
	}
	
	public int getDayOfMonth(ZonedDateTime zdt) throws TaskException{
		TaskUtility.validateNullValue(zdt);
		return zdt.getDayOfMonth();
	}
	
	public int getDayOfYear(ZonedDateTime zdt) throws TaskException{
		TaskUtility.validateNullValue(zdt);
		return zdt.getDayOfYear();
	}
	
	public Month getMonthName(ZonedDateTime zdt)throws TaskException{
		TaskUtility.validateNullValue(zdt);
		return zdt.getMonth();
	}
	
	public long getMillisByInstant(){
		return Instant.now().toEpochMilli();
	}
	
	public long getMillisBySystem(){
		return System.currentTimeMillis();
	}
	
	public long getTimeInNanos(){
		return System.nanoTime();
	}
	
	public static ZonedDateTime getZoneDateTime(ZoneId zoneId) throws TaskException{
		TaskUtility.validateNullValue(zoneId);
		return ZonedDateTime.now(zoneId);	
	}
	
	public ZonedDateTime convertMillisToZonedDateTime(long millis, String timeZone) throws TaskException {
        TaskUtility.validateNullValue(millis);
		TaskUtility.validateNullValue(timeZone);
        return Instant.ofEpochMilli(millis).atZone(ZoneId.of(timeZone));
    }
	
	public int getYear(ZonedDateTime ldt) throws TaskException {
        TaskUtility.validateNullValue(ldt);
        return ldt.getYear();
    }
	
	public ZoneOffset getZoneOffset (ZoneId dstZone,String dstDate) throws TaskException{
		TaskUtility.validateNullValue(dstZone);
		TaskUtility.validateNullValue(dstDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		ZonedDateTime zdt = LocalDate.parse(dstDate, formatter).atStartOfDay(dstZone);
		return zdt.getOffset();
	}
}
