package com.company.services;

import com.company.models.Prenda;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrendaService implements IPrendaService{
    private void runMethod(){
        Scanner scanner = new Scanner(System.in);
        Stack<Prenda> prendas = new Stack<>();

    }
    private void menu(){

    }


    @Override
    public Stack<Prenda> createPrenda(Stack<Prenda> prendas, Scanner scanner) {
        System.out.println("Ingrese el codigo de barras de la prenda");
        String id = scanner.nextLine();
        System.out.println("Ingrese la marca de la prenda");
        String brand = scanner.nextLine();
        System.out.println("Ingrese la referencia de la prenda");
        String reference = scanner.nextLine();
        System.out.println("Ingrese el precio de la prenda");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Ingrese las unidades de la prenda de la prenda");
        Long units = scanner.nextLong();
        scanner.nextLine();
        AtomicBoolean exists = new AtomicBoolean(false);

        //CHECK IF PRENDA ALREADY EXISTS
        prendas.forEach((prenda -> {
            if (prenda.getId().equals(id)) {
                System.out.println("La prenda ya existe, sumando stock...");
                prenda.setUnits(prenda.getUnits()+units);
                exists.set(true);
            }
        }));
        if (exists.equals(false)){
            System.out.println("añadiendo prenda al stock...");
            Prenda createdPrenda = new Prenda(id, brand, reference, price, units);
            prendas.add(createdPrenda);
        }
        return null;
    }

    @Override
    public void findPrendaById(Scanner scanner, Stack<Prenda> prendas) {
        System.out.println("Ingrese el id de la prenda");
        String id = scanner.nextLine();

        Prenda foundedPrenda = (Prenda) prendas.stream().filter((prenda -> prenda.getId().equals(id)));

        if(foundedPrenda != null){
            System.out.println("Prenda encontrada:");
            System.out.println(foundedPrenda.toString());
        }else{
            System.out.println("Prenda con id: "+ id + " no encontrada");
        }

    }

    @Override
    public Stack<Prenda> updatePrenda(Stack<Prenda> prendas, Scanner scanner) {
        return null;
    }

    @Override
    public Stack<Prenda> sellPrenda(Stack<Prenda> prendas, Scanner scanner) {
        return null;
    }

    @Override
    public void findStockById(Scanner scanner, Stack<Prenda> prendas) {

    }

    @Override
    public void FindAll(Stack<Prenda> prendaStack) {

    }
}
