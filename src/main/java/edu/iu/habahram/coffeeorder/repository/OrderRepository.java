package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class OrderRepository {

    private static final String DATABASE_NAME = "db.txt";
    private static final AtomicInteger receiptCounter = new AtomicInteger(initializeCounter());
    private static int initializeCounter() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(DATABASE_NAME));
            if (!lines.isEmpty()) {
                String lastLine = lines.get(lines.size() - 1);
                String[] parts = lastLine.split(",");
                return Integer.parseInt(parts[0].trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to initialize receipt counter: " + e.getMessage());
        }
        return 0;
    }

    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }

        int receiptNumber = receiptCounter.incrementAndGet();
        Receipt receipt = new Receipt(receiptNumber, beverage.getDescription(), beverage.cost());
        String receiptOutput = receipt.id() + ", " + receipt.cost() + ", " + receipt.description();
        try (FileWriter writer = new FileWriter(DATABASE_NAME, true)) {
            writer.write(receiptOutput + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receipt;
    }
}
