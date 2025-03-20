package com.company.services;

import com.company.models.Prenda;

import javax.security.auth.callback.PasswordCallback;
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
        return prendas;
    }

    @Override
    public Prenda findPrendaById(Scanner scanner, Stack<Prenda> prendas) {
        System.out.println("Ingrese el id de la prenda");
        String id = scanner.nextLine();

        Prenda foundedPrenda = (Prenda) prendas.stream().filter((prenda -> prenda.getId().equals(id)));

        if(foundedPrenda != null){
            System.out.println("Prenda encontrada:");
            System.out.println(foundedPrenda.toString());
        }else{
            System.out.println("Prenda con id: "+ id + " no encontrada");
        }
        return foundedPrenda;

    }

    @Override
    public Stack<Prenda> updatePrenda(Stack<Prenda> prendas, Scanner scanner) {
        System.out.println("Actualizar prenda:");
        System.out.println("Ingrese el id de la prenda. se le pedira nuevamente, asegurese de añadir el mismo");
        String id = scanner.nextLine();

        //getting prenda:
        Prenda prendafounded = findPrendaById(scanner, prendas);
        boolean stopper = true;
        while (stopper){
            System.out.println("selecciones una opcion:");
            System.out.println("1. modificar id");
            System.out.println("2. modificar marca");
            System.out.println("3. modificar referencia");
            System.out.println("4. modificar precio");
            System.out.println("5. modificar las unidades");
            System.out.println("6. salir");
            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt){
                case 1:
                    System.out.println("Ingrese el nuevo id:");
                    String newId = scanner.nextLine();
                    prendafounded.setId(newId);
                    break;
                case 2:
                    System.out.println("Ingrese la nueva marca de la prenda:");
                    String newBrand = scanner.nextLine();
                    prendafounded.setBrand(newBrand);
                    break;
                case 3:
                    System.out.println("Ingrese la nueva referencia de la prenda:");
                    String newReference = scanner.nextLine();
                    prendafounded.setReference(newReference);
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo precio de la prenda:");
                    BigDecimal newPrice = scanner.nextBigDecimal();
                    scanner.nextLine();
                    prendafounded.setPrice(newPrice);
                    break;
                case 5:
                    System.out.println("Ingrese la nueva cantidad de la prenda:");
                    Long newUnits = scanner.nextLong();
                    scanner.nextLine();
                    prendafounded.setUnits(newUnits);
                    break;
                case 6:
                    System.out.println("Saliendo ....");
                    stopper = false;
                    break;
                default:
                    System.out.println("INGRESE UNA OPCION EXISTENTE");
            }
            if (opt < 0 && opt<6){
                System.out.println("Actualizando ...");
                prendas.forEach( (prenda -> {
                    if (prenda.getId().equals(id)){
                        prenda = prendafounded;
                    }
                }));
            }
        }
        return prendas;
    }

    @Override
    public Stack<Prenda> sellPrenda(Stack<Prenda> prendas, Scanner scanner) {
        System.out.println("VENDER:");
        Prenda prendaFounded = findPrendaById(scanner, prendas);
        System.out.println("Ingrese las unidades de la prenda de la prenda");
        Long units = scanner.nextLong();
        scanner.nextLine();
        //Check if prenda has the units required
        if (prendaFounded.getUnits() > units){
            System.out.println("No se puede vender la prenda debido a que no se tiene suficiente estock, stock actual: "+prendaFounded.getUnits());
            System.out.println("Desea modificar el stock de la prenda? 1: si, 2: no");
            int opt = scanner.nextInt();
            scanner.nextLine();
            if (opt == 1){
                System.out.println("Ingrese el nuevo stock de la prenda");
                Long newUnits = scanner.nextLong();
                scanner.nextLine();
                prendaFounded.setUnits(newUnits);
            }
        }else{
            System.out.println("Vendiendo ...");
            prendaFounded.setUnits(prendaFounded.getUnits()-units);
        }
        prendas.forEach( (prenda -> {
            if (prenda.getId().equals(prendaFounded.getId())){
                prenda = prendaFounded;
            }
        }));
        return prendas;
    }

    @Override
    public void findStockById(Scanner scanner, Stack<Prenda> prendas) {
        Prenda foundedPrenda = findPrendaById(scanner, prendas);
        System.out.println("STOCK: "+ foundedPrenda.getUnits());
    }

    @Override
    public void FindAll(Stack<Prenda> prendaStack) {
        prendaStack.forEach( (prenda -> {
            System.out.println(prenda.toString());
            System.out.println("------------------------------");
        }));
    }
}
