package se.iths.lw.mailfunctionlibrary.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Message {

    @NotBlank(message="Recipient is required.")
    private String recipient;


    @NotBlank(message="Message body is required.")
    private String message;

    public abstract String getType();
}
