


interface Chair {
    void sit();
}


class VictorianChair implements Chair {
    private int age;

    VictorianChair(int age) {
        this.age = age;
    }

    @Override
    public void sit() {
        System.out.println("Sitting on a Victorian chair");
    }

    public int getAge() {
        return age;
    }
}


class MagicChair implements Chair {
    public void doMagic() {
        System.out.println("Performing magic on the chair");
    }

    @Override
    public void sit() {
        System.out.println("Sitting on a magic chair");
    }
}


class FunctionalChair implements Chair {
    int sum(int a, int b) {
        return a + b;
    }

    @Override
    public void sit() {
        System.out.println("Sitting on a functional chair");
    }
}


interface AbstractChairFactory {
    VictorianChair createVictorianChair();
    MagicChair createMagicanChair();
    FunctionalChair createFunctionalChair();
}


class ChairFactory implements AbstractChairFactory {
    @Override
    public VictorianChair createVictorianChair() {
        return new VictorianChair(getAge());
    }

    @Override
    public MagicChair createMagicanChair() {
        return new MagicChair();
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }

    private int getAge() {

        return 5;
    }
}

// Класс клиента
class Client {
    private Chair chair;

    void sit() {
        chair.sit();
    }

    void setChair(Chair chair) {
        this.chair = chair;
    }

    Chair getChair() {
        return chair;
    }
}


public class Main1 {
    public static void main(String[] args) {

        AbstractChairFactory factory = new ChairFactory();


        VictorianChair victorianChair = factory.createVictorianChair();
        MagicChair magicChair = factory.createMagicanChair();
        FunctionalChair functionalChair = factory.createFunctionalChair();


        Client client = new Client();


        client.setChair(victorianChair);
        client.sit();

        client.setChair(magicChair);
        client.sit();

        client.setChair(functionalChair);
        client.sit();
    }
}
