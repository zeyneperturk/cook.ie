package cookie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class HttpSessionConfig {
	@Bean
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("JSESSIONID");
		serializer.setSameSite("Lax");
		serializer.setUseHttpOnlyCookie(true);
		serializer.setUseSecureCookie(false);
		serializer.setCookieMaxAge(1800);
		return serializer;
	}
}
