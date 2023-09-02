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
            if(storage.cash50() == 0) return (new TakeCashResult(false, null));
            cash.add(new CashSet(0, 1, 0));
            this.storage.add(new CashSet(0, -1, 0));
        }
        // добавляем по 100, по 2х50, а затем по 20, пока не будет норм
        while (cash.toNumber() != amount) {
            // разница от 100 и есть 100 - даем 100
            if(amount - cash.toNumber() >= 100 && storage.cash100() > 0) {
                cash.add(new CashSet(0, 0, 1));
                this.storage.add(new CashSet(0, 0, -1));
            }
            // разница от 100 и есть 2х50 - даем 2х50
            else if (amount - cash.toNumber() >= 100 && storage.cash50() > 1) {
                cash.add(new CashSet(0, 1, 0));
                this.storage.add(new CashSet(0, -1, 0));
            }
            // даем 20, если есть
            else if(storage.cash20() > 0) {
                cash.add(new CashSet(1, 0, 0));
                this.storage.add(new CashSet(-1, 0, 0));
            }
            // денег нет блин
            else {
                this.storage = memory;
                return (new TakeCashResult(false, null));
            }
            // когда денег хватает - цикл заканчивается
        }
        return (new TakeCashResult(true, Optional.of(cash)));
    }


}
