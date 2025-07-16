package pl.coderslab;

import jakarta.servlet.FilterRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException{
        AnnotationConfigWebApplicationContext ctx =
                new AnnotationConfigWebApplicationContext(); // tworzy kontekst aplikacji

        ctx.register(AppConfig.class); // rejestruje klasę konfiguracyjną
        ctx.setServletContext(container); // ustawia kontekst aplikacji w kontenerze serwletów
        ServletRegistration.Dynamic servlet =
                container.addServlet("dispatcher", new DispatcherServlet(ctx)); // tworzy i rejestruje serwlet DispatcherServlet
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/"); // ustawia servlet na przechwytywanie naszej aplikacji

        // Ustawienie filtra odpowiedzalnego za prawidłowe kodowanie znaków
        FilterRegistration.Dynamic fr = container.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
    }
}
