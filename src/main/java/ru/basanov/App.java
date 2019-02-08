package ru.basanov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.basanov.config.ApplicationConfig;
import ru.basanov.model.Ad;
import ru.basanov.model.Category;
import ru.basanov.model.Company;
import ru.basanov.service.AdService;
import ru.basanov.service.CategoryService;
import ru.basanov.service.CompanyService;

/*
 * @author Mingiyan Basanov
 */

public class App {
    public static void main(String[] args) {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final AdService adService = ctx.getBean(AdService.class);
        final CategoryService categoryService = ctx.getBean(CategoryService.class);
        final CompanyService companyService = ctx.getBean(CompanyService.class);

        final Category category = new Category("Новое");
        final Company company = new Company("ОТР2000");
        company.setAddress("Дмитровское шосее д. 60А");
        company.setDescription("Консультационные услуги");

        final Ad ad = new Ad();
        ad.setContent("Основые Spring");
        ad.setCategory(category);
        ad.setCompany(company);
    }
}
