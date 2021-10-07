package com.example.demo.controllers;

import com.example.demo.domain.entities.Size;
import com.example.demo.repos.LabelRepository;
import com.example.demo.repos.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {

    private final LabelRepository labelRepository;
    private final ShampooRepository shampooRepository;

    @Autowired
    public AppController(LabelRepository labelRepository, ShampooRepository shampooRepository) {
        this.labelRepository = labelRepository;
        this.shampooRepository = shampooRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        switch (command) {
            case "1" -> selectShampoosBySize();
            case "2" -> searchShampooByBrand();
        }
    }

    public void selectShampoosBySize(){
        Scanner sc = new Scanner(System.in);
        Size size1 = Size.valueOf(sc.nextLine().toUpperCase());

          this.shampooRepository.findShampooBySizeOrderById(size1)
              .forEach(s -> System.out.print(String.format("%s %s %.2flv%n",
                     s.getBrand(),
                   s.getSize(),
                  s.getPrice())));
    }

    public void searchShampooByBrand(){
        Scanner sc = new Scanner(System.in);

        String brand = sc.nextLine();
        this.shampooRepository.searchByBrand(brand)
                .forEach(s -> System.out.printf("%s %s %.2flv%n",
                        s.getBrand(),
                        s.getSize(), s.getPrice()));
    }
}
