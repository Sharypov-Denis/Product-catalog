package den.product.web;

import den.product.model.Products;
import den.product.repository.ProductsRepository;
import den.product.util.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class ProductsController {

    @Autowired
    private ProductsRepository repository;
    @Autowired
    private ProductValidation productValidation;

    @GetMapping("/")
    public String getAll(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        List<Products> filterProducts = new ArrayList<>();
        List<Products> productsList;

        if (filter != null && !filter.isEmpty()) {
            productsList = repository.getAll().stream().filter(p -> p.getName().contains(filter)).collect(Collectors.toList());
            System.out.println("тест" + productsList);
        } else {
            productsList = repository.getAll();
        }
        model.addAttribute("products", productsList);
        model.addAttribute("filter", filterProducts);
        return "products";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        repository.delete(getId(request));
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Products("", ""));
        return "productForm";
    }

    @GetMapping("/update")
    public String update(Model model, HttpServletRequest request) {
        model.addAttribute("product", repository.get(getId(request)));
        return "productForm";
    }

    @PostMapping
    public String updateOrCreate(@RequestParam(value = "id") Integer id, @Valid @ModelAttribute("product") Products products, BindingResult result) {
        if (products.isNew()) {
            productValidation.validate(products, result);
            if (result.hasErrors()) {
                return "productForm";
            }
            repository.save(products);
        } else {
            repository.update(products);
        }
        return "redirect:/";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
