package com.SpringAI.Helpdesk.Services.Impl;

import com.SpringAI.Helpdesk.Repositories.TicketRepository;
import com.SpringAI.Helpdesk.Services.TicketService;
import com.SpringAI.Helpdesk.entities.Ticket;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Getter
@Setter
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    @Transactional
    public Ticket createTicket(Ticket ticket) {
        // we are setting null by-default because we want to auto generate the id for the ticket by Db not by AI.
        ticket.setTicket_id(null);
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return this.ticketRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Ticket updateTicket(Long id, Ticket ticket) {
        Ticket updateTicket = this.ticketRepository.findById(id).orElse(null);
        if (updateTicket != null) {
            this.ticketRepository.save(updateTicket);
        }
        return updateTicket;
    }

    @Override
    public void deleteTicket(Long id) {
        this.ticketRepository.deleteById(id);
    }
}
