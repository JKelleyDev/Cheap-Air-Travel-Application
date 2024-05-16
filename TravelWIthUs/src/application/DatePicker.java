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

public class DatePicker {

    public static JDatePickerImpl createDatePicker() {
        SqlDateModel model = new SqlDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private static final long serialVersionUID = 5025323442693479022L;
        private String datePattern = "yyyy-MM-dd";
        private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            try {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                return GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            } catch (DateTimeParseException e) {
                throw new ParseException("Invalid date format", 0);
            }
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                LocalDate localDate = cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return dateFormatter.format(localDate);
            }
            return "";
        }
    }
}
