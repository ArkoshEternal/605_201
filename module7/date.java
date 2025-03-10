/**
 * Class which represents a date
 * 
 * Consists of a month, day, and year
 * and provides methods to manipulate and display the date
 */
package module7;

public class date {

    // Constructor
    // Throws an error if impossible values are passed
    // Doesn't guarantee valid date
    public date(int date, int month, int year) { 
        if(date < 1 || date > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if(year < 1900) {
            throw new IllegalArgumentException("Birthday must be after 1900");
        }
        if(year > 2020) {
            throw new IllegalArgumentException("Year must be before 2020");
        }

        this.day = date;
        this.month = month;
        this.year = year;
    }
    
    
    // Getters 
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setDay(int day) {
        if(day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        this.day = day;
    }

    public void setMonth(int month) {
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        this.month = month;
    }
    
    public void setYear(int year) {
        if(year < 1900) {
            throw new IllegalArgumentException("Birthday must be after 1900");
        }
        if(year > 2020) {
            throw new IllegalArgumentException("Year must be before 2020");
        }
        this.year = year;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        date other = (date) obj;
        return day == other.day && month == other.month && year == other.year;
    }
    
    // Class Members
    private int day; 
    private int month; 
    private int year; 
} // end class date
