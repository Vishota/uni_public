import java.util.Objects;

public final class CashSet {
    private long cash20;
    private long cash50;
    private long cash100;

    public CashSet(long cash20, long cash50, long cash100) {
        this.cash20 = cash20;
        this.cash50 = cash50;
        this.cash100 = cash100;
    }

    long toNumber() {
        return this.cash20 * 20 + this.cash50 * 50 + this.cash100 * 100;
    }

    public void add(CashSet cash) {
        this.cash100 += cash.cash100;
        this.cash50 += cash.cash50;
        this.cash20 += cash.cash20;
    }
    public void subtract(CashSet cash) {
        this.cash100 -= cash.cash100;
        this.cash50 -= cash.cash50;
        this.cash20 -= cash.cash20;
    }

    public long cash20() {
        return cash20;
    }

    public long cash50() {
        return cash50;
    }

    public long cash100() {
        return cash100;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CashSet) obj;
        return this.cash20 == that.cash20 &&
                this.cash50 == that.cash50 &&
                this.cash100 == that.cash100;
    }

    @Override
    public String toString() {
        return "CashSet[" +
                "cash20=" + cash20 + ", " +
                "cash50=" + cash50 + ", " +
                "cash100=" + cash100 + ']';
    }

}
