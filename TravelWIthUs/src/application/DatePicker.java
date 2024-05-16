package application;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
*
* @author Jordan Kelley
* @author Esteban Naranjo
* 
* @version 2024.05.24.001
* 
* @see
* 	References:<br>
*         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
*         Retrieved from {@link https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving}
* 
*
* <br><br>
* Responsibilities of class:<br>
* 
* Creates a date picker object that can be instinated throughout the program as needed
* 
*/
public class DatePicker 
{

	/**
	 * Purpose: creates the datepicker 
	 * @return JDatePicker
	 */
    public static JDatePickerImpl createDatePicker() 
    {
        SqlDateModel model = new SqlDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    /** 
     * Purpose: formats the date in the display and return of the J Date Picker
     */
    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter 
    {
        private static final long serialVersionUID = 5025323442693479022L;
        private String datePattern = "MM/dd/yyyy";
        private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException 
        {
            try {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                return GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            } catch (DateTimeParseException e) {
                throw new ParseException("Invalid date format", 0);
            }
        }

        @Override
        public String valueToString(Object value) throws ParseException 
        {
            if (value != null) {
                Calendar cal = (Calendar) value;
                LocalDate localDate = cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return dateFormatter.format(localDate);
            }
            return "";
        }
    }
}
