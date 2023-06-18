package com.company;

import java.util.ArrayList;
import java.util.List;


// Singleton pattern
class Office {
    private static Office instance = null;

    private Office() {

    }

    public static Office getInstance() {
        if (instance == null) {
            instance = new Office();
        }
        return instance;
    }

    public void getRequest(String type) {
        PackageMachine packageMachine = new PackageMachine();
        Parcel parcel = packageMachine.getRequest(type);
        parcel.send();
        Counter.getInstance().addParcel(parcel);
    }
}

// Factory pattern
interface Parcel {
    void send();
}

class Plovdiv implements Parcel {
    @Override
    public void send() {
        System.out.println("Sending parcel to Plovdiv");
    }
}

class Bulgaria implements Parcel {
    @Override
    public void send() {
        System.out.println("Sending parcel to Bulgaria");
    }
}

class Abroad implements Parcel {
    @Override
    public void send() {
        System.out.println("Sending parcel abroad");
    }
}

class PackageMachine {
    public Parcel getRequest(String type) {
        if (type.equalsIgnoreCase("Plovdiv")) {
            return new Plovdiv();
        } else if (type.equalsIgnoreCase("Bulgaria")) {
            return new Bulgaria();
        } else if (type.equalsIgnoreCase("Abroad")) {
            return new Abroad();
        } else {
            throw new IllegalArgumentException("Invalid place to send");
        }
    }
}

// Counter
class Counter {
    private static Counter instance = null;
    private List<Parcel> parcels;

    private Counter() {
        parcels = new ArrayList<>();
    }

    public static Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }

    public void addParcel(Parcel parcel) {
        parcels.add(parcel);
    }

}

// Usage example
public clasMain {
    public static void main(String[] args) {
        Office bunny = Office.getInstance();
        Counter basket = Counter.getInstance();
        bunny.getRequest("quail");
        bunny.getRequest("chicken");
        bunny.getRequest("dinosaur");
        bunny.getRequest("quail");
        bunny.getRequest("chicken");
        bunny.getRequest("dinosaur");

    }
}


