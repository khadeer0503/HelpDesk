package com.SpringAI.Helpdesk.Services.Impl;

import com.SpringAI.Helpdesk.Repositories.TicketRepository;
import com.SpringAI.Helpdesk.Services.TicketService;
import com.SpringAI.Helpdesk.entities.Ticket;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    @Transactional
    public Ticket createTicket(Ticket ticket) {
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
