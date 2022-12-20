package domain.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String message, recipient, subject;

    public Email(String message, String recipient, String subject) {
        this.message = message;
        this.recipient = recipient;
        this.subject = subject;
    }

    public Email() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if(message == null || message.trim().isEmpty()){
            throw new IllegalArgumentException("Bericht mag niet zijn");
        }
        this.message = message;
    }

    public String getReceiver() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Email mag niet leeg");
        }
        String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(recipient);
        if (!m.matches()) {
            throw new IllegalArgumentException("Ontvanger email is niet geldig");
        }
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if(subject == null || subject.trim().isEmpty()){
            throw new IllegalArgumentException("Onderwerp mag niet leeg zijn");
        }
        this.subject = subject;
    }
}
