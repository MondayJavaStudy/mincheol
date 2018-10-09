package com.monday.study;

/**
 * Created by mcpark on 10/9/18
 */
public interface TicketStateMachine {
    void change(Ticket.TicketType ticketType);
}
