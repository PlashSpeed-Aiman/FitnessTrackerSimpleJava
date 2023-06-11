import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void updateGoals(){
        Scanner input = new Scanner(System.in);
        PrintWriter printWriter;
        var goal = getGoals();
        goal[2] = input.nextLine();
        try {
            printWriter = new PrintWriter("goals.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printWriter.println(goal[0]);
        printWriter.println(goal[1]);
        printWriter.println(goal[2]);
        printWriter.close();

    }
    public static String[] getGoals(){
        File file = new File("goals.txt");
        String[] goal = new String[3];
        Scanner input;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //get string and process
        for (int i = 0; i < goal.length ; i++) {
            goal[i] = input.nextLine();
        }
        return goal;
    }
    public static String[] setGoals(){
        //simple data structure representing goals
        //name of goal,target,current value
        String[] goal = new String[]{"","",""};
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Goals ie Running 10k miles, with no Spaces");
        goal[0] = input.nextLine();
        System.out.println("Insert Target ie 10000");
        goal[1] = input.nextLine();
        goal[2] = "0";
        System.out.println("Current Value is: " + goal[2]);
        return goal;
    }
    public static void storeGoals(String[] goals){
        File file = new File("goals.txt");
        PrintWriter printWriter;
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0 ; i < goals.length;i++){
            printWriter.println(goals[i]);


        }
        printWriter.close();
    }
    public static void storeUserInfo(String[] user){
        File file = new File("user.txt");
        PrintWriter printWriter;
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0 ; i < user.length;i++){
            printWriter.println(user[i]);
        }
        printWriter.close();

    }
    public static String[] setUserInfo(){
        //simple data structure representing a user
        //name,weight,height,age,gender
        String[] user = new String[5];
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Name");
        user[0] = input.nextLine();
        System.out.println("Insert Weight");
        user[1] = input.nextLine();
        System.out.println("Insert Height");
        user[2] = input.nextLine();
        System.out.println("Insert Age");
        user[3] = input.nextLine();
        System.out.println("Insert Gender");
        user[4] = input.nextLine();
        return user;
    }

    public static void runProgram(){
        var res = setUserInfo();
        storeUserInfo(res);
        var goal = setGoals();
        storeGoals(goal);
        var retrivedGoal = getGoals();
        System.out.println("Your Goal is "+ retrivedGoal[0]);
        System.out.println("Your Target is "+ retrivedGoal[1]);
        System.out.println("Your Current Value is "+ retrivedGoal[2]);
        System.out.println("You are " + (Integer.parseInt(retrivedGoal[1]) - Integer.parseInt(retrivedGoal[2])) + " away from your goal");
        updateGoals();
        var anotherGoal = getGoals();
        System.out.println("Your Goal is "+ retrivedGoal[0]);
        System.out.println("Your Target is "+ retrivedGoal[1]);
        System.out.println("Your Current Value is "+ retrivedGoal[2]);
        System.out.println("You are " + (Integer.parseInt(anotherGoal[1]) - Integer.parseInt(anotherGoal[2])) + " away from your goal");
    }
    public static void main(String[] args) {


runProgram();    }



}