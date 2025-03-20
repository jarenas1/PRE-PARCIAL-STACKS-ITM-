package com.company.services;

import com.company.models.Prenda;

import java.util.Scanner;
import java.util.Stack;

public interface IPrendaService {
    Stack<Prenda> createPrenda(Stack<Prenda> prendas, Scanner scanner);
    void findPrendaById(Scanner scanner, Stack<Prenda> prendas);
    Stack<Prenda> updatePrenda(Stack<Prenda> prendas, Scanner scanner);
    Stack<Prenda> sellPrenda(Stack<Prenda> prendas, Scanner scanner);
    void findStockById(Scanner scanner, Stack<Prenda> prendas);
    void FindAll(Stack<Prenda> prendaStack);
}
