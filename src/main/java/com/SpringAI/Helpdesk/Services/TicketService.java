package com.SpringAI.Helpdesk.Services;

import com.SpringAI.Helpdesk.entities.Ticket;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    Ticket getTicketById(Long id);
    Ticket updateTicket(Long id, Ticket ticket);
    void deleteTicket(Long id);

}
