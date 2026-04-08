package se.iths.lw.mailfunctionlibrary.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email extends Message {
    @NotBlank(message="Recipient is required.")
    private String recipient;

    @NotBlank(message="Subject is required.")
    private String message;


    @NotBlank(message ="Message body is required.")
    private String subject;


    @Override
    public String getType() {
        return "email";
    }
}
