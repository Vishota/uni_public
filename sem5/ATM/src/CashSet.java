import java.util.Objects;

public final class CashSet {
    private int cash20;
    private int cash50;
    private int cash100;

    public CashSet(int cash20, int cash50, int cash100) {
        this.cash20 = cash20;
        this.cash50 = cash50;
        this.cash100 = cash100;
    }

    int toNumber() {
        return this.cash20 * 20 + this.cash50 * 50 + this.cash100 * 100;
    }

    public void add(CashSet cash) {
        this.cash100 += cash.cash100;
        this.cash50 += cash.cash50;
        this.cash20 += cash.cash20;
    }

    public int cash20() {
        return cash20;
    }

    public int cash50() {
        return cash50;
    }

    public int cash100() {
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
    public int hashCode() {
        return Objects.hash(cash20, cash50, cash100);
    }

    @Override
    public String toString() {
        return "CashSet[" +
                "cash20=" + cash20 + ", " +
                "cash50=" + cash50 + ", " +
                "cash100=" + cash100 + ']';
    }

}
