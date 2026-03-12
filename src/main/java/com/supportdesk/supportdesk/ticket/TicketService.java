package com.supportdesk.supportdesk.ticket;

import com.supportdesk.supportdesk.ticket.dto.CreateTicketRequest;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(CreateTicketRequest request) {

        Ticket ticket = new Ticket();

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setPriority(request.getPriority());

        ticket.setStatus(TicketStatus.OPEN);

        return ticketRepository.save(ticket);
    }
}