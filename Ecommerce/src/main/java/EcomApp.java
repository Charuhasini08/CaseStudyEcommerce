package app;

import dao.*;
import entity.*;
import java.util.*;

public class EcomApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderProcessorRepository repo = new OrderProcessorRepositoryImpl();
        // Show menu, call respective repo methods, handle exceptions
    }
}
