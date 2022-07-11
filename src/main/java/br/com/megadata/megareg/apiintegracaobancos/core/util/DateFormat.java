package br.com.megadata.megareg.apiintegracaobancos.core.util;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import de.jollyday.HolidayManager;
import de.jollyday.parameter.UrlManagerParameter;


public class DateFormat {

	private Date date; 
    private String uf; 
    private HolidayManager holidayManager;
	
	public DateFormat(String date, String format) {
		try {
			this.date = new SimpleDateFormat(format).parse(date);
			holidayInstance();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DateFormat(Date date) {
		this.date = date;
		holidayInstance();
	}
	
	private void holidayInstance() {
		URL url = getClass().getClassLoader().getResource("Holidays-Brazil.xml");
		UrlManagerParameter urlManParam = new UrlManagerParameter(url, new Properties());
		holidayManager = HolidayManager.getInstance(urlManParam);
	}
	
	public DateFormat addSecond(int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.SECOND, seconds);
		this.date = calendar.getTime();
		return this;
	}
	
	public DateFormat addSecond() {
		return addSecond(1);
	}
	
	public DateFormat addDay(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		this.date = calendar.getTime();
		return this;
	}
	
	public DateFormat setDay(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		this.date = calendar.getTime();
		return this;
	}
	
	public DateFormat addDay() {
		return addDay(1);
	}
	
	public DateFormat addMonth(int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.MONTH, months);
		this.date = calendar.getTime();
		return this;
	}
	
	public DateFormat addMonth() {
		return addMonth(1);
	}
	
	public DateFormat addYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.YEAR, year);
		this.date = calendar.getTime();
		return this;
	}
	
	public DateFormat addYear() {
		return addYear(1);
	}
	
	public DateFormat addHour() {
		return addHour(1);
	}
	
	public DateFormat addHour(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.HOUR, hour);
		this.date = calendar.getTime();
		return this;
	}
	
	public DateFormat addMinute() {
		return addMinute(1);
	}
	
	public DateFormat addMinute(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.MINUTE, minute);
		this.date = calendar.getTime();
		return this;
	}
	
	public boolean checkWeekend() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		
		return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
	
	public boolean checkHoliday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		
		return (this.uf == null ? holidayManager.isHoliday(calendar) : holidayManager.isHoliday(calendar, this.uf));
	}
	
	public boolean checkWeekendOrHoliday() {
		return checkWeekend() || checkHoliday();
	}
	
	public DateFormat proximoDiaUtil() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
			
		while(checkWeekendOrHoliday()) {
			addDay();
		}
		
		return this;
	}
	
	public DateFormat ultimoDiaUtilDoMes() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		calendar.add(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - getDay());
		
		this.date = calendar.getTime();
		
		while(checkWeekendOrHoliday()) {
			addDay(-1);
		}
		
		return this;
	}
	
	public int getDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		return calendar.get(Calendar.MONTH);
	}
	
	public String getMonthDisplay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		return StringUtils.leftPad(""+(calendar.get(Calendar.MONTH)+1), 2, "0");
	}
	
	public int getYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.date);
		return calendar.get(Calendar.YEAR);
	}

	public String toString(String format) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format, new Locale("pt", "BR"));
        return dateFormat.format(this.date);
    }
	
	public Date getDate() {
		return date;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
