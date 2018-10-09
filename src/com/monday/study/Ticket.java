package com.monday.study;

/**
 * Created by mcpark on 10/8/18
 */
public class Ticket implements TicketStateMachine {
    private TicketType type;
    private String title;
    private String description;

    @Override
    public void change(TicketType ticketType) {
        this.type = ticketType;
    }

    public static class TicketType {
        public static TicketType BUG = new TicketType("B", "Bug");
        public static TicketType NEW_FEATURE = new TicketType("N", "NewFeature");
        public static TicketType REQUIRE = new TicketType("R", "Require");

        private String code;
        private String desc;

        TicketType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
