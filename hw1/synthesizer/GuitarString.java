// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;

import java.util.HashSet;
import java.util.Set;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new ArrayRingBuffer<Double>((int)Math.round(SR / frequency));
        while(!buffer.isFull()) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        while(!buffer.isEmpty()) {
            buffer.dequeue();
        }
        Set<Double> dSet = new HashSet<>(buffer.capacity());
        while(dSet.size() != buffer.capacity()) {
            double number = Math.random() - 0.5;
            dSet.add(number);
        }
        for(double item : dSet) {
            buffer.enqueue(item);
        }
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        double popNumber = buffer.dequeue();
        double lastNumber = 0.5*(popNumber + buffer.peek()) * DECAY;
        buffer.enqueue(lastNumber);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
