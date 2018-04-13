package com.devskill;



 class Spoon {
    private Scientist owner;

    public Spoon(Scientist s) {
        owner = s;
    }

    public Scientist getOwner() {
        return owner;
    }

    public synchronized void setOwner(Scientist s) {
        owner = s;
    }

    public synchronized void use() {
        System.out.printf("%s has eaten!", owner.getName());
    }
}

 class Scientist {
private Boolean isHungry = true;
private String name = "";

public Scientist(String name) {
    this.name = name;
}

public String getName(){
    return name;
}

public void eat(Spoon spoon, Scientist s)
{
    while (isHungry)
    {
        if (spoon.getOwner() != this)
        {
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                continue;
            }
            continue;
        }

        if (s.isHungry)
        {
            System.out.printf("%s: I'm giving you, %s, the spoon. ", name, s.getName());
            spoon.setOwner(s);
            continue;
        }

        spoon.use();

        isHungry = false;

        System.out.printf("%s: I'm not hungry anymore. ", name);

        spoon.setOwner(s);
    }
}

}

public class Main {

public static void main(String[] args) throws InterruptedException {
    final Scientist s1 = new Scientist("Charles");
    final Scientist s2 = new Scientist("Pier");
    final Scientist s3 = new Scientist("Bob");
    final Scientist s4 = new Scientist("Ivan");

    final Spoon spoon = new Spoon(s1);

    new Thread(new Runnable() {
            @Override
            public void run() {
                s1.eat(spoon, s2);
            }
        }
    ).start();
    new Thread(new Runnable() {
            @Override
            public void run() {
                s2.eat(spoon, s3);
            }
        }
    ).start();
    new Thread(new Runnable() {
            @Override
            public void run() {
                s3.eat(spoon, s4);
            }
        }
    ).start();
    new Thread(new Runnable() {
            @Override
            public void run() {
                s4.eat(spoon, s1);
            }
        }
    ).start();
}
}