package edu.awieclawski.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateTimeUtils {
	private final static Logger LOGGER = Logger.getLogger(DateTimeUtils.class.getName());

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//	private SimpleDateFormat timestampFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static String getStringFromTimestamp(Timestamp dateTime) {
		String dateString = "";
		dateString = dateFormatter.format(new Date((dateTime).getTime()));
		return dateString;
	}

	public static Timestamp getTimestampFromString(String dateString) {
		Timestamp dateTime = null;
		try {
			dateTime = new Timestamp(dateFormatter.parse(dateString).getTime());
		} catch (ParseException e) {
			LOGGER.log(Level.SEVERE, dateString, e);
		}
		return dateTime;
	}

	/**
	 * Add / substract days to Timestamp
	 * 
	 * @param String strDate,
	 * @param int    days
	 * @return String
	 */
	public static String getAddDaysFromStringToString(String strDate, int days) {
		String resultString = "";
		String oldDate = strDate;
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormatter.parse(oldDate));
		} catch (ParseException e) {
			LOGGER.log(Level.SEVERE, oldDate, e);
		}
		// Incrementing the date by days
		cal.add(Calendar.DAY_OF_MONTH, days);
		resultString = dateFormatter.format(cal.getTime());
		return resultString;
	}

	/**
	 * Get Strings startDateIN, String endDateIN
	 * 
	 * @return List<String> String List of dates in format yyyy-MM-dd
	 */
	public static List<String> getListOfStringDatesFromStringPeriod(String startDateIN, String endDateIN) {
		List<String> dateList = new ArrayList<>();
		Date startDate = getDateFromString(startDateIN);
		Date endDate = getDateFromString(endDateIN);

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		if (startDate.compareTo(endDate) < 0) {
			start.setTime(startDate);
			end.setTime(endDate);
		} else {
			start.setTime(endDate);
			end.setTime(startDate);
		}
		end.add(Calendar.DATE, 1); // includes last day of the dates interval

		for (Date thisDate = (Date) start.getTime(); start.before(end); start.add(Calendar.DATE,
				1), thisDate = (Date) start.getTime()) {

			String thisDateFormatted = dateFormatter.format(thisDate);
			dateList.add(thisDateFormatted);
		}
		return dateList;
	}

	/**
	 * @param String strDate
	 * 
	 * @return Date
	 */
	public static Date getDateFromString(String strDate) {
		Date resultDate = null;
		try {
			resultDate = (Date) dateFormatter.parse(strDate);
		} catch (ParseException e) {
			LOGGER.log(Level.SEVERE, "strDate " + strDate + ", startDateIN " + resultDate, e);
		}
		return resultDate;
	}

}
