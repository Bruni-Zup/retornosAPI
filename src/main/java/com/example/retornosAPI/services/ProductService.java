import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public record Product(
        Long id,

        @NotBlank(message = "Nome do produto é obrigatório.")
        @Size(min = 3, max = 100, message = "Nome do produto deve ter entre 3 e 100 caracteres.")
        String name,

        @NotNull(message = "Preço é obrigatório.")
        @Positive(message = "Preço deve ser maior que 0.")
        Double price
) {}
