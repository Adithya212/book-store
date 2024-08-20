package com.orders.order.service;


import com.orders.order.client.BookClient;
import com.orders.order.client.CustomerClient;
import com.orders.order.dto.Book;
import com.orders.order.dto.Customer;
import com.orders.order.model.Order;
import com.orders.order.repository.OrderRepo;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    OrderRepo orderRepo;
    @Autowired
    CustomerClient customerClient;
    @Autowired
    BookClient bookClient;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
//        this.customerClient = customerClient;
//        this.bookClient = bookClient;
    }

    @Override
    public Order createOrder(Order order) {
        validateOrder(order);
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Order updateById(Long id, Order order) {
        Order existingOrder=orderRepo.findById(id).orElseThrow();
        existingOrder.setId(order.getId());
        existingOrder.setCustomerId(order.getCustomerId());
        existingOrder.setBookId(order.getBookId());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setStatus(order.getStatus());
        return orderRepo.save(order);
    }
    private void validateOrder(Order order) {
        try {
            Customer customer = customerClient.getCustomerById(order.getCustomerId());
            if (customer == null) {
                throw new RuntimeException("Customer not found");
            }

            Book book = bookClient.getBookById(order.getBookId());
            if (book == null) {
                throw new RuntimeException("Book not found");
            }

            if (book.getStock() < order.getQuantity()) {
                throw new RuntimeException("Insufficient stock");
            }
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("AAAAAAA Resource not found", e);
        } catch (FeignException e) {
            throw new RuntimeException("AAAAAa Feign client error", e);
        }

    }
        // Validate customer
//
//        Customer customer = customerClient.getCustomerById(order.getCustomerId());
//        if (customer == null) {
////            throw new OrderNotFoundException("Customer not found with id " + order.getCustomerId());
//            throw  new RuntimeException("Order not found");
//        }
//
//
//        // Validate book and stock
//        Book book = bookClient.getBookById(order.getBookId());
//        if (book == null) {
////            throw new OrderNotFoundException("Book not found with id " + order.getBookId());
//            throw  new RuntimeException("Order not found");
//        }
//
//        if (book.getStock() < order.getQuantity()) {
////            throw new InsufficientStockException("Not enough stock available for book id " + order.getBookId());
//            throw  new RuntimeException("Order not found");
//        }
//    }
}
