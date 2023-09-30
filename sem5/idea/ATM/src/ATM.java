import java.util.Optional;

public class ATM {
    public CashSet getStorage() {
        return storage;
    }

    private CashSet storage;

    public ATM(CashSet cash) {
        this.storage = new CashSet(0,0,0);
        this.putCash(cash);
    }

    public void putCash(CashSet cash) {
        this.storage.add(cash);
    }

    public TakeCashResult takeCash(int amount) {
        // запоминаем, сколько денег было, чтобы вернуть в случае неудачи
        CashSet memory = storage;
        // не кратно 10 - бан
        if(amount % 10 != 0) {
            return (new TakeCashResult(false, null));
        }

        CashSet cash = new CashSet(0,0,0);
        // если amount / 10 нечетное, то нужно нечетное количество cash50
        if(amount % 20 != 0) {
            // 50 нет - смерть
            if (storage.cash50() == 0) return (new TakeCashResult(false, null));
            amount -= 50;
            cash.add(new CashSet(0, 1, 0));
        }

        long need100 = amount / 100;
        long take100 = Math.min(storage.cash100(), need100);
        need100 -= take100;
        long take50 = Math.min(storage.cash50() / 2 * 2, need100 * 2);
        amount -= take100*100 + take50*50;
        long take20 = amount / 20;

        if(take20 > storage.cash20()) {
            return new TakeCashResult(false, null);
        }

        cash.add(new CashSet( take20, take50, take100 ));

        storage.subtract(cash);

        return new TakeCashResult(true, Optional.of(cash));
    }
}
