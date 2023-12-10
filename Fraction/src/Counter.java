
    import java.text.DecimalFormat;

    public class Counter {
        private int Limit; // Upper limit on the counter
        public int CValue; // Current value
        private int DEFAULT_LIMIT = 12;  // the default counter limit


        /**
         * Constructor for the Counter class, with initial value 0 and limit 12.
         */
        public Counter() {
            Limit = DEFAULT_LIMIT;
            CValue = 0;
        }


        /**
         * Constructor for the Counter class, with initial value 0 and given limit.
         *
         * @param limit - the upper bound for the counter
         */
        public Counter(int limit) {
            Limit = limit;
            CValue = 0;
        }

        /**
         * Increment the value of the Counter, wrapping back to 0 when it reaches limit.
         */
        public void tick() {
            CValue++;
            if (CValue == Limit) // Has it hit the limit?
                CValue = 0;          // Wrap if it has
        }

        /**
         * Sets the value of the Counter to newValue.
         * If newValue is too large or is negative sets it to 0.
         * (We will learn better ways to handle errors later!)
         *
         * @param newValue the value to reset the counter to
         */
        public void set(int newValue) {
            if (newValue >= 0 && newValue < Limit)
                CValue = newValue;
            else
                CValue = 0;
        }

        /**
         * Resets the value of the Counter to 0
         */
        public void reset() {
            set(0);
        }

        /**
         * return the value of the Counter.
         *
         * @return the current value of the counter.
         */
        public int getValue() {
            return CValue;
        }

        /**
         * returns a String representation with at least 2 digits, padding with a leading 0 if necessary.
         *
         * @return a String representation of the counter with at least 2 digits.
         */
        public String toString() {
            DecimalFormat fmt = new DecimalFormat("00"); // Use at least 2 digits
            return fmt.format(CValue);
        }


    }
