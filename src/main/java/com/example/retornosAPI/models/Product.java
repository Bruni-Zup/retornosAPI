package com.example.retornosAPI.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public record Product(
        Long id,

        @NotBlank(message = "O nome do produto é obrigatório.")
        @Size(min = 3, max = 100, message = "O nome do produto deve ter entre 3 e 100 caracteres.")
        String name,

        @NotNull(message = "O preço é obrigatório.")
        @Positive(message = "O preço deve ser maior que 0.")
        Double price,

        @NotNull(message = "A quantidade em estoque é obrigatória.")
        @Positive(message = "A quantidade em estoque deve ser maior ou igual a 0.")
        Integer stockQuantity,

        @NotBlank(message = "A categoria é obrigatória.")
        @Size(min = 3, max = 50, message = "A categoria deve ter entre 3 e 50 caracteres.")
        String category,

        @NotBlank(message = "A descrição não pode estar em branco.")
        @Size(max = 500, message = "A descrição não pode ter mais de 500 caracteres.")
        String description
) {
}
