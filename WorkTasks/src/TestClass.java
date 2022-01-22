public class TestClass {
    
    public static void main(String[] args) {
        //Кормим кота
        sayHello("Пиксель");
        double[] feedExpensesCat = {100.50, 236.0, 510.6, 150.20, 80.0, 172.0, 135.4};
    
        double maxFeedExpenseCat = findMaxExpense(feedExpensesCat);
        System.out.println("Твой самый дорогой корм стоил " + maxFeedExpenseCat);
    
        double sumFeedCat = findExpensesSum(feedExpensesCat);
        System.out.println("Всего на корм было потрачено " + sumFeedCat);
        
        sayEnjoyMeal("Пиксель");
        
        //Кормим хомяка
        sayHello("Байт");
        double[] feedExpensesHamster = {70.50, 146.0, 710.6, 250.20, 83.0, 19.0, 55.4};
    
        double maxFeedExpenseHamster = findMaxExpense(feedExpensesHamster);
        System.out.println("Твой самый дорогой корм стоил " + maxFeedExpenseHamster);
    
        double sumFeedHamster = findExpensesSum(feedExpensesHamster);
        System.out.println("Всего на корм было потрачено " + sumFeedHamster);
        
        sayEnjoyMeal("Байт");
    }
    
    private static double findExpensesSum(double[] feedExpenses) {
        double sumFeed = 0;
        for (int i = 0; i < feedExpenses.length; i++) {
            sumFeed = sumFeed + feedExpenses[i];
        }
        return sumFeed;
    }
    
    private static double findMaxExpense(double[] expenses) {
        double maxFeedExpense = 0;
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] > maxFeedExpense) {
                maxFeedExpense = expenses[i];
            }
        }
        return maxFeedExpense;
    }
    
    private static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }
    
    private static void sayEnjoyMeal(String name) {
        System.out.println("Приятного аппетита, " + name + "!");
    }
    
    
}
