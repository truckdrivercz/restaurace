import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Restaurace U Edy");
        Scanner sc = new Scanner(System.in);
        double cena = 0;
        int rokNarozeni = 0;
        Boolean verified = null;
        boolean drinkOrdered = false;
        String currency = "Kč";

        List<Drink> drinks = drinks();
        List<Meal> meals = meals();
        List<Soup> soups = soups();
        List<MainDish> mainDishes = mainDishes();
        List<CzechSpecialities> specialities = specialities();
        List<Salat> salats = salats();
        List<Pizza> pizzas = pizzas();
        List<Coffee> coffees = coffees();
        List<Dessert> desserts = desserts();

        boolean foodOrder = false;
        boolean coffeeOrder = false;
        boolean dessertOrder = false;
        Map<String, Integer> orderedItems = new LinkedHashMap<>();
        Map<String, Double> orderedPrices = new LinkedHashMap<>();

        while (!drinkOrdered) {
            System.out.println("Dáte si nápoj? (ano/ne)");

            String napoj = sc.nextLine();

            if (napoj.equalsIgnoreCase("ano")) {
                while (true) {
                    System.out.println("Vyberte nápoj:");

                    drinks.forEach(drink -> {
                        System.out.println(drink.order() + ". " + drink.name() + " - " + drink.price() + " " + currency);
                    });

                    System.out.println("5. další");

                    String vyberNapoje = sc.nextLine();

                    if (vyberNapoje.equals("5")) {
                        drinkOrdered = true;
                        break;
                    }

                    switch (vyberNapoje) {
                        case "1":
                            cena += 35;
                            orderedItems.merge("Kofola", 1, Integer::sum);
                            orderedPrices.put("Kofola", 35.0);
                            break;
                        case "2":
                            cena += 40;
                            orderedItems.merge("Čaj", 1, Integer::sum);
                            orderedPrices.put("Čaj", 40.0);
                            break;
                        case "3":
                            if (Objects.isNull(verified)) {
                                System.out.println("Zadejte rok narození:");
                                rokNarozeni = Integer.parseInt(sc.nextLine());
                                if (!isAdult(rokNarozeni)) {
                                    System.out.println("Bohužel vám nemůžeme dát víno, nejste plnoletý.");
                                    continue;
                                }
                                verified = true;
                            }

                            if (verified) {
                                cena += 100;
                                orderedItems.merge("Víno", 1, Integer::sum);
                                orderedPrices.put("Víno", 100.0);
                            }
                            break;
                        case "4":
                            if (Objects.isNull(verified)) {
                                System.out.println("Zadejte rok narození:");
                                rokNarozeni = Integer.parseInt(sc.nextLine());
                                if (!isAdult(rokNarozeni)) {
                                    System.out.println("Bohužel vám nedáme pivo, nejste plnoletý.");
                                    continue;
                                }
                                verified = true;
                            }
                            cena += 35;
                            orderedItems.merge("Pivo", 1, Integer::sum);
                            orderedPrices.put("Pivo", 35.0);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                drinkOrdered = true;
            }
        }

        while (!foodOrder) {
            System.out.println("Dáte si jídlo? (ano/ne)");

            String jidlo = sc.nextLine();

            if (jidlo.equalsIgnoreCase("ano")) {
                while (true) {
                    System.out.println("Vyberte jídlo:");

                    meals.forEach(meal -> {
                        System.out.println(meal.order() + ". " + meal.category());
                    });

                    System.out.println("6. další");

                    String vyberJidla = sc.nextLine();

                    if (vyberJidla.equals("6")) {
                        foodOrder = true;
                        break;
                    }

                    switch (vyberJidla) {
                        case "1":
                            while (true) {
                                System.out.println("Polévky:");

                                soups.forEach(soup -> {
                                    System.out.println(soup.order() + ". " + soup.name() + " - " + soup.price() + " " + currency);
                                });

                                System.out.println("4. další");

                                String polEvka = sc.nextLine();

                                if (polEvka.equals("4")) {
                                    break;
                                }

                                switch (polEvka) {
                                    case "1":
                                        cena += 75;
                                        orderedItems.merge("Hovězí vývar", 1, Integer::sum);
                                        orderedPrices.put("Hovězí vývar", 75.0);
                                        break;
                                    case "2":
                                        cena += 60;
                                        orderedItems.merge("Rajská", 1, Integer::sum);
                                        orderedPrices.put("Rajská", 60.0);
                                        break;
                                    case "3":
                                        cena += 60;
                                        orderedItems.merge("Dršťková", 1, Integer::sum);
                                        orderedPrices.put("Dršťková", 60.0);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        case "2":
                            while (true) {
                                System.out.println("Hotová jídla:");

                                mainDishes.forEach(mainDish -> {
                                    System.out.println(mainDish.order() + ". " + mainDish.name() + " - " + mainDish.price() + " " + currency);
                                });

                                System.out.println("5. další");

                                String hotovky = sc.nextLine();

                                if (hotovky.equals("5")) {
                                    break;
                                }

                                switch (hotovky) {
                                    case "1":
                                        cena += 579;
                                        orderedItems.merge("Svíčková omáčka", 1, Integer::sum);
                                        orderedPrices.put("Svíčková omáčka", 579.0);
                                        break;
                                    case "2":
                                        cena += 150;
                                        orderedItems.merge("Špenát s houskovým knedlíkem", 1, Integer::sum);
                                        orderedPrices.put("Špenát s houskovým knedlíkem", 150.0);
                                        break;
                                    case "3":
                                        cena += 120;
                                        orderedItems.merge("Knedlo vepřo zelo", 1, Integer::sum);
                                        orderedPrices.put("Knedlo vepřo zelo", 120.0);
                                        break;
                                    case "4":
                                        cena += 120;
                                        orderedItems.merge("Křenová omáčka", 1, Integer::sum);
                                        orderedPrices.put("Křenová omáčka", 120.0);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        case "3":
                            while (true) {
                                System.out.println("České speciality:");

                                specialities.forEach(specialities1 -> {
                                    System.out.println(specialities1.order() + ". " + specialities1.name() + " - " + specialities1.price() + " " + currency);
                                });

                                System.out.println("4. další");

                                String speciality = sc.nextLine();

                                if (speciality.equals("4")) {
                                    break;
                                }

                                switch (speciality) {
                                    case "1":
                                        cena += 425;
                                        orderedItems.merge("Confit z kachny", 1, Integer::sum);
                                        orderedPrices.put("Confit z kachny", 425.0);
                                        break;
                                    case "2":
                                        cena += 355;
                                        orderedItems.merge("Hovězí svíčková na smetaně", 1, Integer::sum);
                                        orderedPrices.put("Hovězí svíčková na smetaně", 355.0);
                                        break;
                                    case "3":
                                        cena += 475;
                                        orderedItems.merge("Smažený telecí řízky", 1, Integer::sum);
                                        orderedPrices.put("Smažený telecí řízky", 475.0);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        case "4":
                            while (true) {
                                System.out.println("Saláty:");

                                salats.forEach(salat -> {
                                    System.out.println(salat.order() + ". " + salat.name() + " - " + salat.price() + " " + currency);
                                });

                                System.out.println("5. další");

                                String salaty = sc.nextLine();

                                if (salaty.equals("5")) {
                                    break;
                                }

                                switch (salaty) {
                                    case "1":
                                        cena += 279;
                                        orderedItems.merge("Caesar", 1, Integer::sum);
                                        orderedPrices.put("Caesar", 279.0);
                                        break;
                                    case "2":
                                        cena += 275;
                                        orderedItems.merge("Čekankový salát", 1, Integer::sum);
                                        orderedPrices.put("Čekankový salát", 275.0);
                                        break;
                                    case "3":
                                        cena += 345;
                                        orderedItems.merge("Salát panzanella", 1, Integer::sum);
                                        orderedPrices.put("Salát panzanella", 345.0);
                                        break;
                                    case "4":
                                        cena += 330;
                                        orderedItems.merge("Salát se zapečeným kozím sýrem", 1, Integer::sum);
                                        orderedPrices.put("Salát se zapečeným kozím sýrem", 330.0);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        case "5":
                            while (true) {
                                System.out.println("Pizza:");

                                pizzas.forEach(pizza -> {
                                    System.out.println(pizza.order() + ". " + pizza.name() + " - " + pizza.price() + " " + currency);
                                });

                                System.out.println("5. další");

                                String pizza = sc.nextLine();

                                if (pizza.equals("5")) {
                                    break;
                                }

                                switch (pizza) {
                                    case "1":
                                        cena += 170;
                                        orderedItems.merge("Salame", 1, Integer::sum);
                                        orderedPrices.put("Salame", 170.0);
                                        break;
                                    case "2":
                                        cena += 190;
                                        orderedItems.merge("Roma", 1, Integer::sum);
                                        orderedPrices.put("Roma", 190.0);
                                        break;
                                    case "3":
                                        cena += 235;
                                        orderedItems.merge("Quattro formaggi", 1, Integer::sum);
                                        orderedPrices.put("Quattro formaggi", 235.0);
                                        break;
                                    case "4":
                                        cena += 185;
                                        orderedItems.merge("Hawai", 1, Integer::sum);
                                        orderedPrices.put("Hawai", 185.0);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            } else {
                foodOrder = true;
            }
        }

        while (!coffeeOrder) {
            System.out.println("Dáte si kafe? (ano/ne)");

            String nabidkaKafe = sc.nextLine();

            if (nabidkaKafe.equalsIgnoreCase("ano")) {
                while (true) {
                    System.out.println("Vyberte kafe:");

                    coffees.forEach(coffee -> {
                        System.out.println(coffee.order() + ". " + coffee.name() + " - " + coffee.price() + " " + currency);
                    });

                    System.out.println("7. další");

                    String kava = sc.nextLine();

                    if (kava.equals("7")) {
                        coffeeOrder = true;
                        break;
                    }

                    switch (kava) {
                        case "1":
                            cena += 50;
                            orderedItems.merge("Presso", 1, Integer::sum);
                            orderedPrices.put("Presso", 50.0);
                            break;
                        case "2":
                            cena += 40;
                            orderedItems.merge("Cappuccino", 1, Integer::sum);
                            orderedPrices.put("Cappuccino", 40.0);
                            break;
                        case "3":
                            cena += 40;
                            orderedItems.merge("Laté", 1, Integer::sum);
                            orderedPrices.put("Laté", 40.0);
                            break;
                        case "4":
                            cena += 40;
                            orderedItems.merge("Turek", 1, Integer::sum);
                            orderedPrices.put("Turek", 40.0);
                            break;
                        case "5":
                            cena += 60;
                            orderedItems.merge("Vídeňská káva", 1, Integer::sum);
                            orderedPrices.put("Vídeňská káva", 60.0);
                            break;
                        case "6":
                            cena += 60;
                            orderedItems.merge("Alžírská káva", 1, Integer::sum);
                            orderedPrices.put("Alžírská káva", 60.0);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                coffeeOrder = true;
            }
        }

        while (!dessertOrder) {
            System.out.println("Dáte si dezert? (ano/ne)");

            String vyberDezert = sc.nextLine();

            if (vyberDezert.equalsIgnoreCase("ano")) {
                while (true) {
                    System.out.println("Vyberte dezert:");

                    desserts.forEach(dessert -> {
                        System.out.println(dessert.order() + ". " + dessert.name() + " - " + dessert.price() + " " + currency);
                    });

                    System.out.println("5. další");

                    String vyberDezertu = sc.nextLine();

                    if (vyberDezertu.equals("5")) {
                        dessertOrder = true;
                        break;
                    }

                    switch (vyberDezertu) {
                        case "1":
                            cena += 100;
                            orderedItems.merge("Horká malina", 1, Integer::sum);
                            orderedPrices.put("Horká malina", 100.0);
                            break;
                        case "2":
                            cena += 60;
                            orderedItems.merge("Medovník", 1, Integer::sum);
                            orderedPrices.put("Medovník", 60.0);
                            break;
                        case "3":
                            cena += 60;
                            orderedItems.merge("Cheesecake", 1, Integer::sum);
                            orderedPrices.put("Cheesecake", 60.0);
                            break;
                        case "4":
                            cena += 50;
                            orderedItems.merge("Domácí koláč", 1, Integer::sum);
                            orderedPrices.put("Domácí koláč", 50.0);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                dessertOrder = true;
            }
        }

        System.out.println("Budete platit hotově nebo kartou?");
        System.out.println("1. hotově");
        System.out.println("2. kartou");

        String platba = sc.nextLine();

        switch (platba) {
            case "1":
                break;
            case "2":
                break;
            default:
                break;
        }

        double cenaBezDPH = cena / 1.21;
        double dph = cena - cenaBezDPH;



        System.out.println("Seznam zakoupených položek:");
        orderedItems.forEach((item, count) -> {
            double price = orderedPrices.get(item);
            double priceWithoutVAT = price / 1.21;
            System.out.printf("%s x%d - Bez DPH: %.2f Kč, S DPH: %.2f Kč\n", item, count, priceWithoutVAT, price);
        });
        System.out.printf("Cena bez DPH: %.2f Kč\n", cenaBezDPH);
        System.out.printf("Cena s DPH: %.2f Kč\n", cena);
        sc.close();
    }

    public static boolean isAdult(int dateOfBirth) {
        int age = 2024 - dateOfBirth;
        return age >= 18;
    }

    public static List<Drink> drinks() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink(1, "Kofola", 40));
        drinks.add(new Drink(2, "Čaj", 40));
        drinks.add(new Drink(3, "Víno", 100));
        drinks.add(new Drink(4, "Pivo", 35));
        return drinks;
    }

    public static List<Meal> meals() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal(1, "Polévky"));
        meals.add(new Meal(2, "Hotová jídla"));
        meals.add(new Meal(3, "České speciality"));
        meals.add(new Meal(4, "Saláty"));
        meals.add(new Meal(5, "Pizza"));
        return meals;
    }

    public static List<Soup> soups() {
        List<Soup> soups = new ArrayList<>();
        soups.add(new Soup(1, "Hovězí vývar", 75));
        soups.add(new Soup(2, "Rajská", 60));
        soups.add(new Soup(3, "Dršťková", 60));
        return soups;
    }

    public static List<MainDish> mainDishes() {
        List<MainDish> mainDishes = new ArrayList<>();
        mainDishes.add(new MainDish(1, "Svíčková omáčka", 576));
        mainDishes.add(new MainDish(2, "Špenát s houskovým knedlíkem", 150));
        mainDishes.add(new MainDish(3, "Knedlo vepřo zelo", 120));
        mainDishes.add(new MainDish(4, "Křenová omáčka", 120));
        return mainDishes;
    }

    public static List<CzechSpecialities> specialities() {
        List<CzechSpecialities> specialities = new ArrayList<>();
        specialities.add(new CzechSpecialities(1, "Confit z kachny", 425));
        specialities.add(new CzechSpecialities(2, "Hovězí svíčková na smetaně", 355));
        specialities.add(new CzechSpecialities(3, "Smažený telecí řízky", 475));
        return specialities;
    }

    public static List<Salat> salats() {
        List<Salat> salats = new ArrayList<>();
        salats.add(new Salat(1, "Caesar", 279));
        salats.add(new Salat(2, "Čekankový salát", 275));
        salats.add(new Salat(3, "Salát panzanella", 345));
        salats.add(new Salat(4, "Salát se zapečeným kozím sýrem", 330));
        return salats;
    }

    public static List<Pizza> pizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(1, "Salame", 170));
        pizzas.add(new Pizza(2, "Roma", 190));
        pizzas.add(new Pizza(3, "Quattro formaggi", 235));
        pizzas.add(new Pizza(4, "Hawai", 185));
        return pizzas;
    }

    public static List<Coffee> coffees() {
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee(1, "presso", 50));
        coffees.add(new Coffee(2, "cappucino", 40));
        coffees.add(new Coffee(3, "laté", 40));
        coffees.add(new Coffee(4, "turek", 40));
        coffees.add(new Coffee(5, "vídeňská káva", 60));
        coffees.add(new Coffee(6, "alžírská káva", 60));
        return coffees;
    }

    public static List<Dessert> desserts() {
        List<Dessert> desserts = new ArrayList<>();
        desserts.add(new Dessert(1, "Horká malina", 100));
        desserts.add(new Dessert(2, "Medovník", 60));
        desserts.add(new Dessert(3, "Cheesecake", 60));
        desserts.add(new Dessert(4, "Domácí koláč", 50));
        return desserts;
    }
}