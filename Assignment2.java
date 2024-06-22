import java.util.*;
interface Animal1{
    void addAnimal();
    void updateAnimal();
    void removeAnimal();
}
interface Attraction1{
    void addAttraction();
    void modify();
    void remove();
}
class AttractionAnimal {
    private String animal;
    private String type;
    private String sound;
    private String details;

    public AttractionAnimal(String animal, String type, String sound, String details) {
        this.animal = animal;
        this.type = type;
        this.sound = sound;
        this.details = details;

    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

class Animals_opp extends Admins implements Animal1 {
    private String valid;
    private Scanner sc = new Scanner(System.in);

    private String isValidCategory(String category) {
        if (category.equalsIgnoreCase("Mammals") || category.equalsIgnoreCase("Amphibians")
                || category.equalsIgnoreCase("Reptiles")) {
            return category;
        } else {
            return "Not";
        }
    }

    private static int c_mammals = 0;
    private static int c_amphibians = 0;
    private static int c_reptiles = 0;

    public void beforeAddAnimal() {
        if(c_mammals < 2 || c_amphibians < 2 || c_reptiles < 2) {
            while (c_mammals < 2 || c_amphibians < 2 || c_reptiles < 2) {
                addAnimal();
            }
        }
        else if(c_mammals >=2 || c_amphibians >= 2 || c_reptiles >= 2){
            addAnimal();
        }
    }

    public void addAnimal() {
        System.out.println("Enter the name of animal!");
        String name = sc.nextLine();
        System.out.println("Enter The category");
        String category = sc.nextLine();
        String valid = isValidCategory(category);
        if (valid.equalsIgnoreCase("Not")) {
            System.out.println("Invalid category. Please choose from Mammals, Amphibians, or Reptiles.");
            return;
        }
        System.out.println("Enter the sound of animal:");
        String sound = sc.nextLine();
        System.out.println("Enter the details of animal:");
        String details = sc.nextLine();
        if (category.equalsIgnoreCase("Mammals")) {
            c_mammals++;
        } else if (category.equalsIgnoreCase("Amphibians")) {
            c_amphibians++;
        } else if (category.equalsIgnoreCase("Reptiles")) {
            c_reptiles++;
        }
        AttractionAnimal newAnimal = new AttractionAnimal(name, category, sound, details);
        my_animal.add(newAnimal);
    }

    public void updateAnimal() {
        if (my_animal.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }
        System.out.println("Enter the name of the animal you want to update:");
        String name = sc.nextLine();
        boolean found = false;
        for (AttractionAnimal animal : my_animal) {
            if (animal.getAnimal().equalsIgnoreCase(name)) {
                found = true;
                System.out.println("Enter the new details of the animal:");
                String newDetails = sc.nextLine();
                animal.setDetails(newDetails);

                System.out.println("Animal details updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Animal not found with the given name");
        }
    }

    public void removeAnimal() {
        if (my_animal.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }
        System.out.println("Enter the name of the animal you want to remove.");
        String name = sc.nextLine();
        boolean found = false;
        for (Iterator<AttractionAnimal> iterator = my_animal.iterator(); iterator.hasNext();) {
            AttractionAnimal animal = iterator.next();
            if (animal.getAnimal().equalsIgnoreCase(name)) {
                String category = animal.getType();
                if(category.equalsIgnoreCase("Mammals") && c_mammals<=2){
                    System.out.println("Cannot remove. There must be at least 2 Mammals.");
                    return;
                }
                else if(category.equalsIgnoreCase("Amphibians") && c_amphibians<=2){
                    System.out.println("Cannot remove. There must be at least 2 Amphibians.");
                    return;
                }
                else if(category.equalsIgnoreCase("Reptiles") && c_reptiles<=2){
                    System.out.println("Cannot remove. There must be at least 2 Reptiles.");
                    return;
                }
                iterator.remove();
                found = true;
                System.out.println("Animal removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Animal not found with the given name");
        }
    }

    public static void viewAnimals() {
        if (my_animal.isEmpty()) {
            System.out.println("No animals available.");
        } else {
            System.out.println("List of Animals:");
            for (AttractionAnimal animal : my_animal) {
                System.out.println("Animal Name : " + animal.getAnimal() + " Category: " + animal.getType());
            }
        }
    }

    public static void visitAnimals() {
        System.out.println("Enter the name of animals which you want to visit");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int flag = 0;
        for (AttractionAnimal a : my_animal) {
            if (a.getAnimal().equals(name)) {
                flag = 1;
                System.out.println("Enter whether you want to feed or read\n" +
                        "1.feed" +
                        "2.read");
                int b = sc.nextInt();
                if (b == 1) {
                    System.out.println("Animal sound: " + a.getSound());
                } else if (b == 2) {
                    System.out.println("Animal Description: " + a.getDetails());
                } else {
                    System.out.println("Wrong Option!!!!");
                }
                break;
            }
        }
        if (flag == 0) {
            System.out.println("There is no such Animal!");
        }
    }
}

class Discount {
    private static double student = 0;
    public static double minor = 10;

    private static double senior = 20;
    private static boolean st1 = false;
    private static boolean st2 = false;

    private static double st_1 = 15;// for special deals when more than 2 tickets buy
    private static double st_2 = 30;// for special deals when more than 3 tickets buy

    public static double getStudent() {
        return student;
    }

    public static void setStudent(double stu) {
        student = stu;
    }

    public static double getMinor() {
        return minor;
    }

    public static void setMinor(double min) {
        minor = min;
    }

    public static double getSenior() {
        return senior;
    }

    public static void setSenior(double sen) {
        senior = sen;
    }

    public static double getSt_1() {
        return st_1;
    }

    public static void setSt_1(double st_1) {
        Discount.st_1 = st_1;
    }

    public static double getSt_2() {
        return st_2;
    }

    public static void setSt_2(double st_2) {
        Discount.st_2 = st_2;
    }

    public static boolean isSt1() {
        return st1;
    }

    public static void setSt1(boolean st1) {
        Discount.st1 = st1;
    }

    public static boolean isSt2() {
        return st2;
    }

    public static void setSt2(boolean st2) {
        Discount.st2 = st2;
    }
}

class Discount_opp extends Admins {
    public void addDiscount() {
        System.out.println(
                "Enter the name, you want to set discount for the following:\n1.Student\n2.minor\n3.Senior\n4.Attraction");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Enter the discount percentage you want to set:");
        double b = sc.nextDouble();
        sc.nextLine();
        if (a == 1) {
            Discount.setStudent(b);
        } else if (a == 2) {
            Discount.setMinor(b);
        } else if (a == 3) {
            Discount.setSenior(b);
        } else if (a == 4) {
            System.out.println("Enter the name of attraction:");
            String name = sc.nextLine();
            int flag = 0;
            for (Attraction att : my_attraction) {
                if (att.getName().equals(name) && att.isSchedule()) {
                    flag = 1;
                    att.setDiscount(b);
                    System.out.println("Discount added successfully!");
                    break;
                }

            }
            if (flag == 0) {
                System.out.println("This name of attraction is neither exist nor scheduled");
            }
        }

    }

    public void modifyDiscount() {
        System.out.println(
                "Enter the name you want to change discount for the following:\n1.Student\n2.minor\n3.Senior\n4.Attraction");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Enter the discount percentage you want to change:");
        double b = sc.nextDouble();
        if (a == 1) {
            Discount.setStudent(b);
            System.out.println("Discount Modified successfully!");
        } else if (a == 2) {
            Discount.setMinor(b);
            System.out.println("Discount Modified successfully!");
        } else if (a == 3) {
            Discount.setSenior(b);
            System.out.println("Discount Modified successfully!");
        } else if (a == 4) {
            System.out.println("Enter the name of attraction:");
            String name = sc.nextLine();
            for (Attraction att : my_attraction) {
                if (att.getName().equals(name)) {
                    att.setDiscount(b);
                    System.out.println("Discount added successfully to attraction!");
                    break;
                }
            }
        }
    }

    public void removeDiscount() {
        System.out.println("Enter the of category of which you want to set discount zero:");
        System.out.println("1.Student");
        System.out.println("2.Minor");
        System.out.println("3.Senior");
        System.out.println("4.Attraction");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a == 1) {
            Discount.setStudent(0);
            System.out.println("Discounts for Students set to zero.");
            return;
        } else if (a == 2) {
            Discount.setMinor(0);
            System.out.println("Discounts for Minors set to zero.");
            return;
        } else if (a == 3) {
            Discount.setSenior(0);
            System.out.println("Discount for Seniors set to zero.");
            return;
        } else if (a == 4) {
            System.out.println("Enter the name of attraction:");
            String name = sc.nextLine();
            boolean found = false;
            for (Attraction att : my_attraction) {
                if (name.equals(att.getName())) {
                    att.setDiscount(0);
                    found = true;
                    System.out.println("Discount for Attraction set to zero.");
                    break;
                }
            }
            if(!found){
                System.out.println("Attraction not found with the given name.");
            }
        }else{
            System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    public void printDiscount() {
        System.out.println("The discount given to the different category is as follows:");
        System.out.println("Student: " + Discount.getStudent());
        System.out.println("Minor: " + Discount.getMinor());
        System.out.println("Senior: " + Discount.getSenior());
        // System.out.println("Attraction: " + Discount.getStudent());
    }

    public void setSpecialDeals() {
        Discount.setSt1(true);
        Discount.setSt2(true);
        System.out.println(
                "Special deals are set according to their values which is given in the question\n Buy two tickets get 15% additional discount\n Buy more than 3 tickets get 30% additional discounts");
    }

}

class Admins {

    private static final String userName = "name";
    private static final String passWord = "1234";
    public static double revenue = 0;

    public static boolean verifiedCredential(String name, String pw) {
        return (name.equals(userName) && pw.equals(passWord));
    }

    public static List<Visitor> my_visitor = new ArrayList<>();
    public static List<Attraction> my_attraction = new ArrayList<>();
    public static List<Discount> my_discount = new ArrayList<>();
    public static List<AttractionAnimal> my_animal = new ArrayList<>();
    int flag = 0;
    public int count_v = 0;
    public void count_no_of_visitor(){
        for(Visitor v: my_visitor){
            count_v++;
        }
    }
//    public int max = 0;

    public void viewVisitorStats() {
        count_no_of_visitor();
        System.out.println("Number of visitors are: " + count_v + " Total revenue: " + revenue);
        System.out.println("Visitors list are:");
        for (Visitor v : my_visitor) {
            flag = 1;
            System.out.println("Name: " + v.getName() + " Age: " + v.getAge() + " Phone Number: " + v.getPhoneNumber()
                    + " Balance: " + v.getBalance() + " Email: " + v.getEmail());
        }
        if (flag == 0) {
            System.out.println("No registered members!");
        }
    }
}

class Attraction {
    private static int att_count = 1;
    private String name;
    private String description;
    private boolean schedule;
    private String id;
    private double price;
    private double discount = 0;
    private double ticket = 0;

    public Attraction(String name, String Description, boolean sch, double discount, double price, int ticket) {
        this.name = name;
        this.description = Description;
        this.schedule = sch;
        this.discount = discount;
        this.price = price;
        this.ticket = ticket;
        this.id = "A" + att_count;
        att_count++;
    }

    public double getTicket() {
        return ticket;
    }

    public void setTicket(double ticket) {
        this.ticket = ticket;
    }

    public static int getAtt_count() {
        return att_count;
    }

    public static void setAtt_count(int att_count) {
        Attraction.att_count = att_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSchedule() {
        return schedule;
    }

    public void setSchedule(boolean schedule) {
        this.schedule = schedule;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Attraction_opp extends Admins implements Attraction1 {

    // public static List<AttractionM> my_attraction = new ArrayList<>();
    private boolean schedule;

    public void addAttraction() {
        double at_pr = 0;
        Scanner an = new Scanner(System.in);
        System.out.println("Enter Attraction Name:");
        String at_name = an.nextLine();
        System.out.println("Enter Attraction Description:");
        String at_des = an.nextLine();
        System.out.println("Enter the ticket price for the attraction:");
        at_pr = an.nextDouble();
        an.nextLine();
        Attraction att = new Attraction(at_name, at_des, false, 0, at_pr, 0);
        my_attraction.add(att);
        System.out.println("Attraction Added Successfully!");
    }

    public static void viewEvents() {
        System.out.println("Attractions in the Zoo:");
        for (Attraction attraction : my_attraction) {
            // System.out.println("ID: "+ attraction.getId());
            System.out.println("Attraction Name: " + attraction.getName() + " Attraction Id: " + attraction.getId());
            // System.out.println("Description: "+ attraction.getDescription());
        }
    }

    public void modify() {
        viewEvents();
        System.out
                .println("If You Want To Edit Id, Name and Description Then Enter The Id Of Which You Want To Change:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for (Attraction attraction : my_attraction) {
            if (attraction.getId().equals(input)) {
                System.out.println("Do You Want To Change The Name With The Old Name:\nEnter 'Yes' or 'No'");
                String change_name = sc.nextLine();
                if (change_name.equalsIgnoreCase("Yes")) {
                    System.out.println("Current Name: " + attraction.getName());
                    System.out.println("Enter the new Name:");
                    String new_name = sc.nextLine();
                    attraction.setName(new_name);
                } else if (change_name.equalsIgnoreCase("No")) {
                    System.out.println("Okay!");
                }
                System.out.println("Do You Want To Change The Description\nEnter 'yes' or 'No'");
                String change_description = sc.nextLine();
                if (change_description.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter the new description");
                    String new_description = sc.nextLine();
                    attraction.setDescription(new_description);
                } else if (change_description.equalsIgnoreCase("No")) {
                    System.out.println("Okay!");
                }
            }
            System.out.println("Attraction details updated successfully!");
            return;

        }
    }

    public void remove() {
        System.out.println("Enter The Id Of The Attraction Which You Want To Remove:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        for (Attraction attraction : my_attraction) {
            if (attraction.getId().equals(id)) {
                my_attraction.remove(attraction);
                System.out.println("Attraction with Id " + id + "removed successfully!");
                return;
            }
        }
        System.out.println("Attraction with Id " + id + " not found");
    }

    public void scheduleEvents() {
        System.out.println("Enter The Name Of The Attraction Which You Want To Schedule:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int flag = 0;
        for (Attraction attraction : my_attraction) {
            if (attraction.getName().equals(name)) {
                attraction.setSchedule(true);
                System.out.println("Attraction is scheduled successfully!");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("The given name is not in The Attraction list!");
        }

    }

    public void printScheduleEvents() {
        System.out.println("The Schedule Events are:");
        for (Attraction attraction : my_attraction) {
            if (attraction.isSchedule() == true) {
                System.out.println("Attraction Name:" + attraction.getName() + "Ticket Price: ");
            }
        }
    }

    public static void visitAttraction() {
        System.out.println("Enter the Attraction name which you want to visit:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int flag = 0;
        for (Attraction a : my_attraction) {
            if (a.getName().equals(name) && a.getTicket() != 0) {
                flag = 1;
                System.out.println("you can visit Attraction , you have the ticket");
                break;
            }
        }
        if (flag == 0) {
            System.out.println("ether this attraction name is not present or may be you do not have tickets!");
        }
    }
}

class Visitor extends Admins {
    private String name;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private String password;
    private int memberShip;
    private double ticketPrice;
    // private static List<Visitor> my_visitor = new ArrayList<>();
    private String feedback;
    private HashMap<String, Integer> my_tickted_map;

    public void setMy_tickted_map(HashMap<String, Integer> my_tickted_map) {
        this.my_tickted_map = my_tickted_map;
    }

    public HashMap<String, Integer> getMy_tickted_map() {
        return my_tickted_map;
    }

    //    public static double revenue = 0;
    public Visitor(String name, int age, String phoneNumber, double balance, String email, String password,
                   int memberShip, double ticketPrice, String feed, HashMap<String, Integer> map) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.memberShip = memberShip;
        this.ticketPrice = ticketPrice;
        this.feedback = feed;
        this.my_tickted_map = map;
    }

    public int getMemberShip() {
        return memberShip;
    }

    public void setMemberShip(int memberShip) {
        this.memberShip = memberShip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public static boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Visitor Email:");
        String email = sc.nextLine();
        System.out.println("Enter Visitor Password:");
        String ps = sc.nextLine();
        int flag = 0;
        for (Visitor v : Admins.my_visitor) {
            if (v.getEmail().equals(email) && v.getPassword().equals(ps)) {
                System.out.println("Login successfully!");
                v.start_visitor_loop();
                flag = 1;
                return true;
                /*
                 */
            }
        }
        if(flag==0){
            System.out.println("Login details are wrong!!!!!");
        }
        return false;
    }

    public void start_visitor_loop() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Visitor Menu:");
            System.out.println("1.Explore the Zoo");
            System.out.println("2.Buy Membership");
            System.out.println("3.Buy Tickets");
            System.out.println("4.View Discounts");
            System.out.println("5.View Special Deals");
            System.out.println("6.Visit Animal");
            System.out.println("7.Visit Attractions");
            System.out.println("8.Leave Feedback");
            System.out.println("9.Log Out");
            System.out.println("-------------------------------------------------------\n");
            int b5 = sc.nextInt();
            if (b5 == 1) {
                while (true) {
                    System.out.println("1.View Attractions");
                    System.out.println("2.View Animals");
                    System.out.println("3.Exit");
                    int b6 = sc.nextInt();
                    if (b6 == 1) {
                        Attraction_opp.viewEvents();
                    } else if (b6 == 2) {
                        Animals_opp.viewAnimals();
                    } else {
                        break;
                    }
                }
            } else if (b5 == 2) {
                System.out.println("1.Basic Membership(Rs 20)");
                System.out.println("2.Premium Membership(Rs 50)");
                int b6 = sc.nextInt();
                if (b6 == 1) {
                    basicMembership();
                    // flag = 1;
                } else if (b6 == 2) {
                    premiumMembership();
                    // flag = 1;
                }
            } else if (b5 == 3) {
                if (flag == 1) {
                    System.out.println("Buy Tickets:");
                    buyTickets();
                } else {
                    System.out.println("You have to buy the membership first!");
                }
            } else if (b5 == 4) {
                viewDiscounts();
            } else if (b5 == 5) {
                System.out.println("Get 2 Tickets and get 15% additional discounts");
                System.out.println("Get 3 or more Tickets and get 30% additional discounts");
            } else if (b5 == 6) {
                if (this.getMemberShip() == 0) {
                    // has no mem yet
                    System.out.println("Buy a Membership First!!!");
                    continue;
                }
                Animals_opp.visitAnimals();
            } else if (b5 == 7) {
                //Attraction_opp.visitAttraction();
                visitor_visit_attraction();
            } else if (b5 == 8) {
                giveFeedback();
            } else if (b5 == 9) {
                break;
            } else {
                System.out.println("Wrong Option!!!");
            }
        }
    }

    public void basicMembership() {
        // 1 for basic
        if (this.getBalance() >= 20) {
            // valid to buy membership
            double balance = this.getBalance();
            this.setBalance(balance - 20);
            System.out.println(" Basic Membership Purchased :)");
            this.setMemberShip(1);
            flag = 1;
        } else {
            System.out.println("Balance Not enough!!");
        }
    }

    public void premiumMembership() {
        // 2 for premium
        if (this.getBalance() >= 50) {
            // valid to buy membership
            double balance = this.getBalance();
            this.setBalance(balance - 50);
            System.out.println(" Premium Membership Purchased :)");
            this.setMemberShip(2);
            flag = 1;
        } else {
            System.out.println("Balance Not enough!!");
        }
    }

    public void buyTickets() {
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        double price = 0;
        System.out.println();
        if (this.getMemberShip() == 2) {
            System.out.println("You don't need tickets as u are a premium member.....");
            return;
        }
        System.out.println("Enter the number of tickets you want to buy:");
        int not = sc.nextInt();
        sc.nextLine();
        if (not <= 0) {
            System.out.println("Wrong Option for Tickets!!");
            return;
        }
        System.out.println("These are the list of Attraction according to their ticket price:");
        for (Attraction a : my_attraction) {
            if (a.isSchedule() == true) {
                System.out.println(
                        "Name: " + a.getName() + "\nId: " + a.getId() + "\nDescription: " + a.getDescription()
                                + "\nPrice of Ticket: " + a.getPrice() + "\nDiscount: " + a.getDiscount() + "%");
            }
        }
        System.out.println("Enter The Name of attraction for which you want to buy ticket :");
        String name = sc.nextLine();
        double visitor_balance = this.getBalance();
        for (Attraction attraction : my_attraction) {
            if (attraction.getName().equals(name)) {
                flag = 1;
                double attraction_price = attraction.getPrice();
                if (not == 1) {
                    // only discount coupans , no deal
                    System.out.println("Coupon codes, enter according to their number:");
                    viewDiscounts();
                    System.out.println("4. None");
                    int option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        // student
                        if(this.age < 15){
                            double total_price = not*attraction_price;
                            double student_discount = ((Discount.getStudent())/100)*total_price;
                            double net_price = total_price - student_discount;
                            if(this.getBalance()>=net_price){
                                this.setBalance(visitor_balance-net_price);
                                this.my_tickted_map.put(attraction.getName(),not);
                                revenue =  revenue + net_price;
                                System.out.println("Tickets purchased successfully!");
                                System.out.println("Your Balance is now: " + this.getBalance());
                            }
                            else {
                                System.out.println("Not Enough Balance!!");
                                return;
                            }
                        }
                        else{
                            System.out.println("Can't apply this code!!!!!");
                        }
                    } else if (option == 2) {
                        // minor
                        if (this.getAge() < 18) {
                            // valid minor here
                            double total_price = not * attraction_price;
                            double minor_discount = ((Discount.getMinor()) / 100) * total_price;
                            double net_price = total_price - minor_discount;
                            // now check whether he has money or not or maybe he is gareeb for now
                            if (this.getBalance() >= net_price) {
                                // ameer h visitor
                                this.setBalance(visitor_balance - net_price);
                                this.my_tickted_map.put(attraction.getName(), not);
                                revenue =  revenue + net_price;
                                System.out.println("Tickets Purchased successfully");
                                System.out.println("Your Balance is Now: " + this.getBalance());
                            } else {
                                // garreb h visitor
                                System.out.println("Not Enough Balance!!");
                                return;
                            }

                        } else {
                            System.out.println("Cant Apply this code!!!!!");
                            return;
                        }
                    } else if (option == 3) {
                        // senior
                        if (this.getAge() > 60) {
                            // valid minor here
                            double total_price = not * attraction_price;
                            double senior_discount = ((Discount.getSenior()) / 100) * total_price;
                            double net_price = total_price - senior_discount;
                            // now check whether he has money or not or maybe he is gareeb for now
                            if (this.getBalance() >= net_price) {
                                // ameer h visitor
                                this.setBalance(visitor_balance - net_price);
                                this.my_tickted_map.put(attraction.getName(), not);
                                revenue =  revenue + net_price;
                                System.out.println("Tickets Purchased successfully");
                                System.out.println("Your Balance is Now: " + this.getBalance());
                            } else {
                                // garreb h visitor
                                System.out.println("Not Enough Balance!!");
                                return;
                            }
                        } else {
                            System.out.println("Cant Apply this code!!!!!");
                            return;
                        }
                    } else if (option == 4) {
                        // none
                        double total_price = not * attraction_price;
                        // now check whether he has money or not or maybe he is gareeb for now
                        if (this.getBalance() >= total_price) {
                            // ameer h visitor
                            this.setBalance(visitor_balance - total_price);
                            this.my_tickted_map.put(attraction.getName(), not);
                            revenue =  revenue + total_price;
                            System.out.println("Ticktes Purchased successfully");
                            System.out.println("Your Balance is Now: " + this.getBalance());
                        } else {
                            // garreb h visitor
                            System.out.println("Not Enough Balance!!");
                            return;
                        }

                    } else {
                        System.out.println("Wrong option!!!");
                        return;
                    }

                } else {
                    // discount + deal
                    if (not == 2) {
                        System.out.println("Hello");
                        // 15% deal here
                        viewDiscounts();
                        System.out.println("4. None");
                        int option = sc.nextInt();
                        sc.nextLine();
                        if (option == 1) {
                            // student
                            if(this.getAge()<15){
                                double total_price = not*attraction_price;
                                System.out.println("Total price: " + total_price);
                                double student_discount = ((Discount.getStudent())/100)*total_price;
                                System.out.println("student_discount: " + student_discount);
                                double net_Price = total_price - student_discount;
                                System.out.println("net_price: " + net_Price);
                                //now apply deal
                                double deal_discount = (15.0/100)*net_Price;
                                System.out.println("deal_discount: " + deal_discount);
                                double final_price = net_Price - deal_discount;
                                System.out.println("final price: " + final_price);
                                // now check whether he has money or not maybe he is gareeb for now
                                if(this.getBalance()>=final_price){
                                    this.setBalance(visitor_balance-final_price);
                                    this.my_tickted_map.put(attraction.getName(),not);
                                    revenue =  revenue + final_price;
                                    System.out.println("Tickets purchased successfully!!");
                                    System.out.println("Your Balance is Now: " + this.getBalance());
                                }
                                else{
                                    System.out.println("Not Enough Balance!!!!!");
                                    return;
                                }
                            }
                            else{
                                System.out.println("Can't apply this code!!!!!");
                                return;
                            }
                        } else if (option == 2) {
                            // minor
                            if (this.getAge() < 18) {
                                // valid minor here
                                double total_price = not * attraction_price;
                                double minor_discount = ((Discount.getMinor()) / 100.0) * total_price;
                                double net_price = total_price - minor_discount;
                                // now apply deal
                                double deal_discount = (15.0 / 100.0) * net_price;
                                double final_price = net_price - deal_discount;
                                // now check whether he has money or not or maybe he is gareeb for now
                                if (this.getBalance() >= final_price) {
                                    // ameer h visitor
                                    this.setBalance(visitor_balance - final_price);
                                    this.my_tickted_map.put(attraction.getName(), not);
                                    revenue =  revenue + final_price;
                                    System.out.println("Ticktes Purchased successfully");
                                    System.out.println("Your Balance is Now: " + this.getBalance());
                                } else {
                                    // garreb h visitor
                                    System.out.println("Not Enough Balance!!");
                                    return;
                                }

                            } else {
                                System.out.println("Cant Apply this code!!!!!");
                                return;
                            }
                        } else if (option == 3) {
                            // senior
                            if (this.getAge() > 60) {
                                // valid minor here
                                double total_price = not * attraction_price;
                                double senior_discount = ((Discount.getSenior()) / 100.0) * total_price;
                                double net_price = total_price - senior_discount;
                                // now deal here
                                double deal_discount = (15.0 / 100) * net_price;
                                double final_price = net_price - deal_discount;
                                // now check whether he has money or not or maybe he is gareeb for now
                                if (this.getBalance() >= net_price) {
                                    // ameer h visitor
                                    this.setBalance(visitor_balance - final_price);
                                    this.my_tickted_map.put(attraction.getName(), not);
                                    revenue =  revenue + final_price;
                                    System.out.println("Ticktes Purchased successfully");
                                    System.out.println("Your Balance is Now: " + this.getBalance());
                                } else {
                                    // garreb h visitor
                                    System.out.println("Not Enough Balance!!");
                                    return;
                                }

                            } else {
                                System.out.println("Cant Apply this code!!!!!");
                                return;
                            }
                        } else if (option == 4) {
                            // none
                            double total_price = not * attraction_price;
                            double deal_discount = (15.0 / 100) * total_price;
                            double final_price = total_price - deal_discount;
                            // now check whether he has money or not or maybe he is gareeb for now
                            if (this.getBalance() >= total_price) {
                                // ameer h visitor
                                this.setBalance(visitor_balance - total_price);
                                this.my_tickted_map.put(attraction.getName(), not);
                                revenue =  revenue + final_price;
                                System.out.println("Ticktes Purchased successfully");
                                System.out.println("Your Balance is Now: " + this.getBalance());
                            } else {
                                // garreb h visitor
                                System.out.println("Not Enough Balance!!");
                                return;
                            }

                        } else {
                            System.out.println("Wrong option!!!");
                            return;
                        }

                    } else {
                        // 30% deal here
                        viewDiscounts();
                        System.out.println("4. None");
                        int option = sc.nextInt();
                        sc.nextLine();
                        if (option == 1) {
                            // student

                        } else if (option == 2) {
                            // minor
                            if (this.getAge() < 18) {
                                // valid minor here
                                double total_price = not * attraction_price;
                                double minor_discount = ((Discount.getMinor()) / 100.0) * total_price;
                                double net_price = total_price - minor_discount;
                                // now apply deal
                                double deal_discount = (30 / 100.0) * net_price;
                                double final_price = net_price - deal_discount;
                                // now check whether he has money or not or maybe he is gareeb for now
                                if (this.getBalance() >= final_price) {
                                    // ameer h visitor
                                    this.setBalance(visitor_balance - final_price);
                                    this.my_tickted_map.put(attraction.getName(), not);
                                    System.out.println("Ticktes Purchased successfully");
                                    revenue =  revenue + final_price;
                                    System.out.println("Your Balance is Now: " + this.getBalance());
                                } else {
                                    // garreb h visitor
                                    System.out.println("Not Enough Balance!!");
                                    return;
                                }

                            } else {
                                System.out.println("Cant Apply this code!!!!!");
                                return;
                            }
                        } else if (option == 3) {
                            // senior
                            if (this.getAge() > 60) {
                                // valid minor here
                                double total_price = not * attraction_price;
                                double senior_discount = ((Discount.getSenior()) / 100.0) * total_price;
                                double net_price = total_price - senior_discount;
                                // now deal here
                                double deal_discount = (30 / 100.0) * net_price;
                                double final_price = net_price - deal_discount;
                                // now check whether he has money or not or maybe he is gareeb for now
                                if (this.getBalance() >= net_price) {
                                    // ameer h visitor
                                    this.setBalance(visitor_balance - final_price);
                                    this.my_tickted_map.put(attraction.getName(), not);
                                    revenue =  revenue + final_price;
                                    System.out.println("Tickets Purchased successfully");
                                    System.out.println("Your Balance is Now: " + this.getBalance());
                                } else {
                                    // garreb h visitor
                                    System.out.println("Not Enough Balance!!");
                                    return;
                                }

                            } else {
                                System.out.println("Cant Apply this code!!!!!");
                                return;
                            }
                        } else if (option == 4) {
                            // none
                            double total_price = not * attraction_price;
                            double deal_discount = (30 / 100.0) * total_price;
                            double final_price = total_price - deal_discount;
                            // now check whether he has money or not or maybe he is gareeb for now
                            if (this.getBalance() >= total_price) {
                                // ameer h visitor
                                this.setBalance(visitor_balance - total_price);
                                this.my_tickted_map.put(attraction.getName(), not);
                                revenue =  revenue + final_price;
                                System.out.println("Ticktes Purchased successfully");
                                System.out.println("Your Balance is Now: " + this.getBalance());
                            } else {
                                // garreb h visitor
                                System.out.println("Not Enough Balance!!");
                                return;
                            }

                        } else {
                            System.out.println("Wrong option!!!");
                            return;
                        }

                    }

                }

            }
        }
    }

    public static void viewDiscounts() {

        System.out.println("1. Student Discount: " + Discount.getStudent());
        System.out.println("2. Minor Discount: " + Discount.getMinor());
        System.out.println("3. Senior Discount: " + Discount.getSenior());
    }

    public void giveFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your feedback here :");
        String feedback = sc.nextLine();
        this.setFeedback(feedback);
        System.out.println("Thank you!");
    }

    public static void returnFeedback() {
        int flag = 0;
        for (Visitor v : my_visitor) {
            flag = 1;
            System.out.println("Name: " + v.getName() + "Email: " + v.getEmail() + "Feedback: " + v.getFeedback());
        }
        if (flag == 0) {
            System.out.println("No feedback");
        }
    }

    public void visitor_visit_attraction() {
        System.out.println("The Attraction name:");
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        HashMap<String, Integer> visitor_ka_hash_map = this.getMy_tickted_map();
        int value = -1;
        for (Attraction a : my_attraction) {
//            if (a.getName().equals(name)) {
            // now see whether he has a ticket or not
            if (visitor_ka_hash_map.containsKey(a.getName())) {
                // he has a ticket
                if (visitor_ka_hash_map.get(a.getName()) != 0) {
                    System.out.println("Welcome to the Attraction!");
                    System.out.println("Tickets Used");
                    flag = 1;
                    value = visitor_ka_hash_map.get(a.getName());
                } else {
                    System.out.println("You don't have a ticket for this attraction!!!");
                    return;
                }
                if (flag == 1) {
                    //replace the map with updated values
                    this.my_tickted_map.replace(a.getName(), value - 1);
                } else {
                    System.out.println("either this attraction name is not present or may be you do not have tickets!");
                }
                break;

            }
//                else if()
//                else {
//                    System.out.println("You Don't Have a Ticket for this Attraction!!");
//                    return;
//                }
        }
        for(Visitor v: my_visitor){
            if(name.equals(v.getName()) && v.getMemberShip()==2){
                System.out.println("Welcome to the Attraction!");
                break;
            }
        }
    }
}
public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attraction_opp a_opp = new Attraction_opp();
        Animals_opp animals_opp = new Animals_opp(); // Added instance of Animals_opp
        Admins admins = new Admins();
        Discount_opp d_opp = new Discount_opp();
        Admins ad = new Attraction_opp();// USE OF ONLY Attraction_opp CLASS AS A Admins CLASS METHODS ONLY!
        int flag = 0;

        int c = 1;
        while (true) {
            System.out.println("WELCOME TO ZOOTOPIA!");
            System.out.println("Enter the three of the given below:");
            System.out.println("1.Enter as Admin");
            System.out.println("2.Enter as Visitor");
            System.out.println("3.View special deals");
            int a = sc.nextInt();
            if (a == 1) {
                System.out.println("Enter your UserName:");
                String name = sc.next();
                System.out.println("Enter your PassWord:");
                String password = sc.next();
                if (admins.verifiedCredential(name, password)) {
                    while (true) {
                        System.out.println("1.Manage Attraction");
                        System.out.println("2.Manage Animals");
                        System.out.println("3.Schedule Events");
                        System.out.println("4.Set Discounts");
                        System.out.println("5.Set Special Deals");
                        System.out.println("6.View Visitors Stats");
                        System.out.println("7.View Feedback");
                        System.out.println("8.Exit");
                        int b = sc.nextInt();
                        sc.nextLine();
                        if (b == 1) {
                            while (true) {
                                System.out.println("Manage Attraction:");
                                System.out.println("1.Add Attraction");
                                System.out.println("2.View Attraction");
                                System.out.println("3.Modify Attraction");
                                System.out.println("4.Remove Attraction");
                                System.out.println("5.Exit");
                                int b1 = sc.nextInt();
                                sc.nextLine();
                                if (b1 == 1) {
                                    a_opp.addAttraction();
                                } else if (b1 == 2) {
                                    a_opp.viewEvents();
                                } else if (b1 == 3) {
                                    a_opp.modify();
                                } else if (b1 == 4) {
                                    a_opp.remove();
                                } else if (b1 == 5) {
                                    break;
                                }
                            }

                        } else if (b == 2) {
                            Scanner sc12 = new Scanner(System.in);
                            while (true) {
                                System.out.println("1.Add Animal");
                                System.out.println("2.Update Animal");
                                System.out.println("3.Remove Animal");
                                System.out.println("4.Exit");
                                int b2 = sc12.nextInt();
                                if (b2 == 1) {
                                    animals_opp.beforeAddAnimal();
                                } else if (b2 == 2) {
                                    animals_opp.updateAnimal();
                                } else if (b2 == 3) {
                                    animals_opp.removeAnimal();
                                } else if (b2 == 4) {
                                    // animals_opp.printAnimals();
                                    break;
                                }
                            }
                        } else if (b == 3) {
                            a_opp.scheduleEvents();
                        } else if (b == 4) {
                            // a_opp.printScheduleEvents();
                            while (true) {
                                System.out.println("Set Discounts:");
                                System.out.println("1.Add Discount");
                                System.out.println("2.Modify Discount");
                                System.out.println("3.Remove Discount");
                                System.out.println("4.Exit");
                                int b4 = sc.nextInt();
                                if (b4 == 1) {
                                    d_opp.addDiscount();
                                } else if (b4 == 2) {
                                    d_opp.modifyDiscount();
                                } else if (b4 == 3) {
                                    d_opp.removeDiscount();
                                } else if (b4 == 4) {
                                    // d_opp.printDiscount();
                                    break;
                                } else {
                                    break;
                                }
                            }

                        } else if (b == 5) {
                            d_opp.setSpecialDeals();
                        } else if (b == 6) {
                            ad.viewVisitorStats();
                        } else if (b == 7) {
                            Visitor.returnFeedback();
                        } else if (b == 8) {
                            break;
                        }
                    }
                } else {
                    System.out.println("You have entered the wrong username or password");
                }
            }
            while (a == 2) {
                System.out.println("1.Resister");
                System.out.println("2.Login");
                System.out.println("3.Exit");
//                    Scanner sc3 = new Scanner(System.in);
                int b3 = sc.nextInt();
                sc.nextLine();
                if (b3 == 1) {
                    System.out.println("Enter Visitor Name");
                    String name = sc.nextLine();
                    System.out.println("Enter Visitor Age:");
                    int age = sc.nextInt();
                    sc.nextLine(); // for consume next line
                    System.out.println("Enter Visitor Phone Number");
                    String ph = sc.nextLine();
                    System.out.println("Enter Visitor Balance:");
                    double bal = sc.nextDouble();
                    sc.nextLine(); // for consume next line
                    System.out.println("Enter Visitor Email:");
                    String email = sc.nextLine();
                    System.out.println("Enter Visitor Password:");
                    String ps = sc.nextLine();
                    HashMap<String , Integer> map= new HashMap<>();
                    Visitor v = new Visitor(name, age, ph, bal, email, ps, 0, 0, "no feedback",map);
                    Admins.my_visitor.add(v);
                }
                if (b3 == 2) {
                    boolean res=Visitor.login();
                    //res can be used
                    continue;
                }
                if (b3 == 3) {
                    break;
                }
            }
            while(a==3){
                System.out.println("Special deals are: ");
                System.out.println("Get 2 Tickets and get 15% additional discounts");
                System.out.println("Get 3 or more Tickets and get 30% additional discounts");
                break;
            }
        }
    }
}

