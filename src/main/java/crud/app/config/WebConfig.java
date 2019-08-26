package crud.app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "crud.app.controller")  // укажем где лежат контроллеры
public class WebConfig extends WebMvcConfigurerAdapter {
    // надо сконфигурить:
    // 1) вью резолвер - будет обрабатывать/искать наши вьюшки в папке WEB-inf
    //

    @Bean
    public ViewResolver getViewResolver() {
        // поставщик отображения
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();

        // === настраиваем
        // указываем очерёдность загрузки
        freeMarkerViewResolver.setOrder(1);
        // расщирения файлов для вьюх
        freeMarkerViewResolver.setSuffix(".ftl");
        // пустой, так как есть FreeMarkerConfigurer
        freeMarkerViewResolver.setPrefix("");

        return freeMarkerViewResolver;
    }

    // тут скажем где будут лежить наши шаблоны отображения
    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "WEB-INF/views");

        return freeMarkerConfigurer;
    }
}
