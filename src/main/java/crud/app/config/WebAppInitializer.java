package crud.app.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// это при старте приложения будет создавать контекст
// здесь сделаем Диспатчер Сервлет
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        // создаём контекст
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // регистрируем в нём конфиг классы
        context.register(SpringConfig.class, WebConfig.class);
        // ???
        context.setServletContext(servletContext);
        // создаём Диспатчер Сергвлет
        ServletRegistration.Dynamic dispatcher =
            servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");


    }
}
