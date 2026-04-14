package se.iths.lw.mailfunctionlibrary.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email extends Message {

    @NotBlank(message ="Subject is required.")
    private String subject;

    @Override
    public String getType() {
        return "email";
    }
}
