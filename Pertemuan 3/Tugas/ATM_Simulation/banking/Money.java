/*
 * ATM Example system - file Money.java
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */
package banking;

/**
 * Representation for money amounts
 */
public class Money {

    /**
     * Constructor
     *
     * @param rupiah whole rupiah amount
     */
    public Money(int rupiah) {
        this(rupiah, 0);
    }

    /**
     * Constructor
     *
     * @param rupiah rupiah part of amount
     * @param cents cents part of amount
     */
    public Money(int rupiah, int cents) {
        this.cents = 100L * rupiah + cents;
    }

    /**
     * Copy constructor
     *
     * @param toCopy the Money object to copy
     */
    public Money(Money toCopy) {
        this.cents = toCopy.cents;
    }

    /**
     * Create a string representation of this amount
     *
     * @return string representation of this amount
     */
    @Override
    public String toString() {
        String str = "Rp";
        long value;
        if (cents >= 100000000) {
            value = (long) (cents / 100000000);
            str = str + "." + value;
        }
        if (cents >= 100000) {
            value = (long) ((cents % 100000000) / 100000);
            if (!str.equals("Rp")) {
                if (value >= 100) {
                    str = str + "." + value;
                } else if (value >= 10) {
                    str = str + ".0" + value;
                } else if (value > 0) {
                    str = str + ".00" + value;
                } else if (value == 0) {
                    str = str + ".000";
                }
            } else {
                str = str + "." + value;
            }

        }
        if (cents >= 100) {
            value = (long) ((cents % 100000) / 100);
            if (value >= 100) {
                str = str + "." + value;
            } else if (value >= 10) {
                str = str + ".0" + value;
            } else if (value > 0) {
                str = str + ".00" + value;
            } else if (value == 0) {
                str = str + ".000";
            }
        }

        str = str + (cents % 100 >= 10 ? "." + cents % 100 : ".0" + cents % 100);

        return str;
    }

    /**
     * Add an amount of money to this
     *
     * @param amountToAdd the amount to add
     */
    public void add(Money amountToAdd) {
        this.cents += amountToAdd.cents;
    }

    /**
     * Subtract an amount of money from this
     *
     * @param amountToSubtract the amount to subtract
     *
     * Precondition: amount must be <= this amount
     */
    public void subtract(Money amountToSubtract) {
        this.cents -= amountToSubtract.cents;
    }

    /**
     * calculate modulo from this by a number
     *
     * @param number  the divisor
     * @return modulo from this by @param number
     * 
     */
    public long modulo(int number) {
        return this.cents % number;
    }

    /**
     * Compare this to another amount
     *
     * @param compareTo the amount to compare to
     * @return true if this amount is <= compareTo amount
     */
    public boolean lessEqual(Money compareTo) {
        return this.cents <= compareTo.cents;
    }

    public boolean Equal(Money compareTo) {
        return this.cents == compareTo.cents;
    }

    public boolean greatEqual(Money compareTo) {
        return this.cents >= compareTo.cents;
    }

    /**
     * Instance variable: this amount represented as a number of cents
     */
    private long cents;
}
