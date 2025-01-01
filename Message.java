package test;
import java.util.Date;


public class Message {
    public final byte[] data;//3 ways to save a message
    public final String asText;
    public final double asDouble;
    public final Date date;

    public Message(byte[] data) {
        this.data = data;
        this.asText = new String(data,java.nio.charset.StandardCharsets.UTF_8);
        this.asDouble = tryparseFromText(this.asText);
        this.date = new Date();//Initializes the date field with the current date and time
    }

    public Message(String asText) {
        this(asText.getBytes());
        //This constructor takes a String as an argument and converts it to
        // a byte array using getBytes(). It then calls the first constructor, passing the byte array.
    }

    public Message(double asDouble) {
        this(Double.toString(asDouble));
        //This constructor takes a double as an argument, converts it to a
        // String using Double.toString(), and then calls the second constructor (which accepts a String).
    }

    private double tryparseFromText(String text)  {
        try {
            return Double.parseDouble(text);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe.getMessage());
        }
        return Double.NaN;
    }
}
