package pl.coderslab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

import java.nio.charset.StandardCharsets;


@Configuration
@EnableWebMvc
@ComponentScan("pl.coderslab")
public class AppConfig implements WebMvcConfigurer {
    // Bean odpowiedzialny za ustawienie kodowania znaków UTF-8 dla odpowiedzi tekstowych (np. @ResponseBody)
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setWriteAcceptCharset(false); // wyłącza dodawanie nagłówka Accept-Charset
        return converter;
    }

    // Pozwala serwerowi obsługiwać statyczne zasoby, takie jak pliki CSS, JS, obrazy itp.
    // 2 sposób ładowania widoków pod adresem /src/main/webapp/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    // aby Spring wiedział, jak serializować obiekty do JSON.
    // potrzebny przy wykorzystaniu biblioteki Jackson
    @Bean
    public org.springframework.http.converter.json.MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        return new org.springframework.http.converter.json.MappingJackson2HttpMessageConverter();
    }
}
