package cn.tedu.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
public class Order {
}
