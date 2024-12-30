package test;
import java.util.Date;

import java.util.Date;

public class Message {
    public final byte[] data;

    public Message(byte[] data, String asText, double asDouble, Date date) {
        this.data = data;
        this.asText = asText;
        this.asDouble = asDouble;
        this.date = date;
    }

    public final String asText;
    public final double asDouble;
    public final Date date;


}
