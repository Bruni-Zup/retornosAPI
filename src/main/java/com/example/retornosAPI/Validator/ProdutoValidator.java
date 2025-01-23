package com.example.retornosAPI.validator;

import com.example.retornosAPI.model.Produto;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@Component
public class ProdutoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, BindingResult result) {
        Produto produto = (Produto) target;

        if (produto.getCategoria() == null || !produto.getCategoria().matches("Eletrônicos|Roupas|Alimentos")) {
            result.rejectValue("categoria", "categoria.invalid", "Categoria deve ser Eletrônicos, Roupas ou Alimentos");
        }
    }
}
