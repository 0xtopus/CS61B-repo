import static org.junit.Assert.*;
import org.junit.Test;

/** @Sourece StudentArrayDequeLauncher */
public class TestArrayDequeGold {
    @Test
    public void arrayDequeTest() {
        StudentArrayDeque<Integer> stuArrDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solArrDeque = new ArrayDequeSolution<>();
        
        String oprationSequence = ""; // Record all operations until sth goes wrong

        // Loop until sth goes wrong
        while (true) {
            // Generate a random number
            double numberBetweenZeroAndOne = StdRandom.uniform();
            Integer temp = (int) (10 * numberBetweenZeroAndOne);

            // Execute aan operation due to the value the random number
            if (numberBetweenZeroAndOne < 0.25) {
                stuArrDeque.addFirst(temp);
                solArrDeque.addFirst(temp);
                // Add latest operation to the String sequence
                oprationSequence += "addFirst(" + temp + ")" + "\n";
                assertEquals(
                    oprationSequence, 
                    solArrDeque.get(0), 
                    stuArrDeque.get(0)
                );
            } else if (
                numberBetweenZeroAndOne >= 0.25 
                && numberBetweenZeroAndOne < 0.5
            ) {
                stuArrDeque.addLast(temp);
                solArrDeque.addLast(temp);
                // Add latest operation to the String sequence
                oprationSequence += "addLast(" + temp + ")" + "\n";
                assertEquals(
                    oprationSequence, 
                    solArrDeque.get(solArrDeque.size() - 1), 
                    stuArrDeque.get(stuArrDeque.size() - 1)
                );
            } else if (
                solArrDeque.size() != 0 
                && numberBetweenZeroAndOne < 0.75 
                && numberBetweenZeroAndOne >= 0.5
            ) {
                // Add latest operation to the String sequence
                oprationSequence += "removeFirst()" + "\n";
                assertEquals(
                    oprationSequence, 
                    solArrDeque.removeFirst(), 
                    stuArrDeque.removeFirst()
                );
            } else if (
                solArrDeque.size() != 0 
                && numberBetweenZeroAndOne >= 0.75
            ) {
                // Add latest operation to the String sequence
                oprationSequence +=  "removeLast()" + "\n";
                assertEquals(
                    oprationSequence, 
                    solArrDeque.removeLast(), 
                    stuArrDeque.removeLast()
                );
            }
        }

    }
}
