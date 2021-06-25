package com.kodigo.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    static Map<String, Robot> factoryRobot = new HashMap<String, Robot>();

    public static synchronized Robot getRobotFomFactory(String robotType) throws Exception {
        Robot robotCategory = factoryRobot.get(robotType);

        if (robotCategory == null) {
            switch (robotType) {
                case "small":
                    System.out.println("We do not have small robot at present. So we are going to create" +
                            "a small robot now.");
                    robotCategory = new SmallRobot();
                    break;
                case "large":
                    System.out.println("We do not have large robot at present. So we are going to create" +
                            "a large robot now.");
                    robotCategory = new LargeRobot();
                    break;
                case "fixed":
                    System.out.println("We do not have fixed size robot at present. So we are going to create" +
                            "a fixed size robot now.");
                    robotCategory = new FixedSizeRobot();
                    break;
                default:
                    throw new Exception("Robot factory only can create small, large or fixed size robots.");
            }
            factoryRobot.put(robotType, robotCategory);
        } else {
            System.out.print("\n \t Using existing " + robotType + " robot" +
                    " and coloring it");
        }
        return robotCategory;
    }

    public int totalObjectsCreated() {
        return factoryRobot.size();
    }
}
