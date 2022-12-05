package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket (1, 1_299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket (2, 2_199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket (3, 3_000, "SVO", "KZN", 95);
    Ticket ticket4 = new Ticket (4, 1_000, "SVO", "KZN", 205);
    Ticket ticket5 = new Ticket (5, 2_199, "SVO", "KZN", 100);
    Ticket ticket6 = new Ticket (6, 1_299, "SVO", "KZN", 205);
    Ticket ticket7 = new Ticket (7, 2_300, "SVO", "KZN", 120);

    @Test
    public void fewTicketsFound() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = {ticket4, ticket1, ticket6, ticket5, ticket7, ticket3};
        Ticket[] actual = manager.searchBy("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);

    }
        @Test
        public void oneTicketsFound() {

            manager.add(ticket1);
            manager.add(ticket2);
            manager.add(ticket3);
            manager.add(ticket4);
            manager.add(ticket5);
            manager.add(ticket6);
            manager.add(ticket7);


            Ticket[] expected = {ticket2};
            Ticket[] actual = manager.searchBy("VKO", "KZN");

            Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void nullTicketsFound() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("KZN", "VKO");

        Assertions.assertArrayEquals(expected, actual);

    }

}