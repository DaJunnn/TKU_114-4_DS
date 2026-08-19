interface MessageSender {
    void send(String receiver, String message);
}

class EmailSender implements MessageSender {
    @Override
    public void send(String receiver, String message) {
        System.out.println("Email to " + receiver + ": " + message);
    }
}

class SmsSender implements MessageSender {
    @Override
    public void send(String receiver, String message) {
        System.out.println("SMS to " + receiver + ": " + message);
    }
}

class ConsoleSender implements MessageSender {
    @Override
    public void send(String receiver, String message) {
        System.out.println("Console to " + receiver + ": " + message);
    }
}

public class MessageSenderSystem {

    public static void notify(MessageSender sender, String receiver, String message) {
        if (receiver == null || receiver.trim().isEmpty()) {
            System.out.println("錯誤：receiver 不可為空白");
            return;
        }

        if (message == null || message.trim().isEmpty()) {
            System.out.println("錯誤：message 不可為空白");
            return;
        }

        sender.send(receiver, message);
    }

    public static void main(String[] args) {
        MessageSender email = new EmailSender();
        MessageSender sms = new SmsSender();
        MessageSender console = new ConsoleSender();

        notify(email, "user@example.com", "Hello Email");
        notify(sms, "0912345678", "Hello SMS");
        notify(console, "User", "Hello Console");

        notify(email, "", "Test");
        notify(sms, "0912345678", "");
    }
}