import jdk.incubator.vector.VectorOperators.Test;
import vo222dq_assign1.Anagram;
import vo222dq_assign1.ArmstrongNumber;
import vo222dq_assign1.Codestrip;
import vo222dq_assign1.ISBN;
import vo222dq_assign1.InvoiceTest;
import vo222dq_assign1.Point;
import vo222dq_assign1.SquareRoot;
import vo222dq_assign1.TextProcessor;
import vo222dq_assign1.Time;

public class App {
    public static void main(String[] args) throws Exception {
        /* ISBN isbn = new ISBN();
        isbn.calculateISBNNumber();
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        armstrongNumber.calculateArmstrongNumbers(); */
        /* SquareRoot squareRoot = new SquareRoot();
        squareRoot.estimateSquareRoot(); */
        /* TextProcessor textProcessor = new TextProcessor();
        textProcessor.processSentence(); */
        /* Anagram anagram = new Anagram();
        anagram.checkForAnagrams(); */
        /* Codestrip codestrip = new Codestrip();
        codestrip.stripCode(); */
        /* pointStarter(); */
        /* InvoiceTest invoiceTest = new InvoiceTest();
        invoiceTest.testInvoice(); */
        Time t1 = new Time(1, 3, 1);
        Time t2 = new Time(2, 0, 0);

        Time t3 = t1.subtractTime(t2);

        System.out.println(t1);

    }

    private static void pointStarter() {
        Point p1 = new Point();
        Point p2 = new Point(3,4);

        System.out.println(p1.toString()); // ==> (0,0)
        System.out.println(p2.toString()); // ==> (3,4)

        if (p1.isEqualTo(p2)) // False!
            System.out.println("The two points are equal");
        
        double dist = p1.distanceTo(p2);

        System.out.println("Point Distance: "+dist);
        
        p2.move(5,-2); // ==> (8,2)
        p1.moveToXY(8,2); // ==> (8,2)

        if (p1.isEqualTo(p2)) // True!
            System.out.println("The two points are equal");
    }
}
