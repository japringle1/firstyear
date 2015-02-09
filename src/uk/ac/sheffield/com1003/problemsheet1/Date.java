package uk.ac.sheffield.com1003.problemsheet1;

/**
 * A class to represent a Date in the Gregorian Calendar
 * 
 */
public class Date {

	// useful constants
	private static final int FIRST_MONTH = 1, LAST_MONTH = 12, FIRST_DAY = 1,
			DAYS_IN_NON_LEAP_YEAR = 365;

	// instance variables representing the day, month and year of the date
	private int day, month, year;

	/**
	 * Constructor
	 * 
	 * @param day
	 *            the day number of the month
	 * @param month
	 *            the month, in the range 1-12
	 * @param year
	 *            the year
	 */
	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	/**
	 * Set the day of the month. Correct the day to the lower or upper limit if
	 * it is out of range (the upper limit depends on the month of course)
	 * 
	 * @param day
	 *            the day of the month
	 */
	public void setDay(int day) {
		this.day = day;

		// correct day if out of range
		int daysInMonth = numberOfDaysInMonth(month, year);
		if (this.day < FIRST_DAY) {
			this.day = FIRST_DAY;
		} else if (this.day > daysInMonth) {
			this.day = daysInMonth;
		}
	}

	/**
	 * Set the month. Correct the month to the lower or upper limit if it is out
	 * of range.
	 * 
	 * @param month
	 *            the month, in the range 1-12
	 */
	public void setMonth(int month) {
		this.month = month;

		// correct month if out of range
		if (this.month < FIRST_MONTH) {
			this.month = FIRST_MONTH;
		} else if (month > LAST_MONTH) {
			this.month = LAST_MONTH;
		}
	}

	/**
	 * Set the year of the date instance
	 * 
	 * @param year
	 *            the year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Getter method for the day of the Date instance
	 * 
	 * @return the day of the current instance
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Getter method for the month of the Date instance
	 * 
	 * @return the month of the current instance
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Getter method for the year of the Date instance
	 * 
	 * @return the year of the current instance
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Finds the number of days between this instance and another date
	 * 
	 * @param anotherDate
	 *            the date with which to find the days between
	 * @return the number of days between this instance and another date
	 */
	public int daysBetween(Date anotherDate) {
		Date earlier = this;
		Date later = anotherDate;

		// date1 should be before date2 for the calculation to work, so swap
		// them if they are not
		if (later.before(earlier)) {
			Date temp = earlier;
			earlier = later;
			later = temp;
		}

		// calculate the number of days between the two instances
		int days = 0; // this variable is used to count the days difference
		if (earlier.month == later.month && earlier.year == later.year) {
			// the same month and year, so just need the difference between the
			// days in the month
			days = later.day - earlier.day;
		} else {
			// get the days difference between the two months:
			// 1) find the number of days to the end of the month for date1
			days += numberOfDaysInMonth(earlier.month, earlier.year)
					- earlier.day;
			// 2) add the day of the month for date2
			days += later.day;

			if (earlier.year == later.year) {
				// the dates are in the same year, so we just need to add the
				// days of the months
				// in the months in-between the two dates to the days variable
				for (int m = earlier.month + 1; m <= later.month; m++) {
					days += numberOfDaysInMonth(m, earlier.year);
				}
			} else {
				// the dates are not in the same year
				// first, add the days to the end of the year for date1
				for (int m = earlier.month + 1; m <= LAST_MONTH; m++) {
					days += numberOfDaysInMonth(m, earlier.year);
				}

				// second add the days from the start of the year to the date of
				// date2
				for (int m = 1; m < later.month; m++) {
					days += numberOfDaysInMonth(m, later.year);
				}

				// finally, add the days for the years in-between the two dates
				for (int y = earlier.year + 1; y < later.year; y++) {
					days += DAYS_IN_NON_LEAP_YEAR;
					if (isLeapYear(year)) {
						days++;
					}
				}
			}
		}

		return days;
	}

	/**
	 * Checks if the current instance is before some other date
	 * 
	 * @param anotherDate
	 *            the date with which to compare the current instance
	 * @return true if the current instance is before anotherDate, else false
	 */
	public boolean before(Date anotherDate) {
		if (year == anotherDate.year) {
			if (month == anotherDate.month) {
				if (day == anotherDate.day) {
					return false;
				} else {
					return day < anotherDate.day;
				}
			} else {
				return month < anotherDate.month;
			}
		} else {
			return year < anotherDate.year;
		}
	}

	/**
	 * Format the date as a string
	 * 
	 * @return the Date as a String
	 */
	public String toString() {
		return day + "/" + month + "/" + year;
	}

	/**
	 * Gives the number of days in a given month (and year, in the special case
	 * of February)
	 * 
	 * @param month
	 *            the month
	 * @param year
	 *            the year
	 * @return the number of days in the supplied month and year combination
	 */
	public static int numberOfDaysInMonth(int month, int year) {
		// each array element corresponds to the number of days in each month in
		// sequence
		// for a non-leap year
		int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// if the month February, and it's a leap year, return 29 instead of 28
		if (month == 2 && isLeapYear(year)) {
			return 29;
		} else {
			// return the number of days for the month
			return daysInMonth[month - 1];
		}
	}

	/**
	 * Tests if a supplied year is a leap year
	 * 
	 * @param year
	 *            the year to test
	 * @return true if the year is a leap year, else false
	 */
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
}
