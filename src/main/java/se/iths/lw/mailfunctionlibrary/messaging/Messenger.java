package se.iths.lw.mailfunctionlibrary.messaging;

import se.iths.lw.mailfunctionlibrary.model.Message;

public interface Messenger {
    void send(Message message);
}
