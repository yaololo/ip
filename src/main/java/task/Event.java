package task;

public class Event extends Task {
    protected String at;

    public Event(String description,  String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + "[" + this.getStatusIcon() + "] " + this.description + " (by: " + at + ")";
    }

    @Override
    public String toDataFormat() {
        String status = this.isDone ? "1" : "0";
        return "E"+ "|" + status + "|" + this.description + "|" +this.at;
    }
}
