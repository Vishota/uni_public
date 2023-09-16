import java.util.Optional;

public record TakeCashResult(boolean success, Optional<CashSet> cash) {
}
