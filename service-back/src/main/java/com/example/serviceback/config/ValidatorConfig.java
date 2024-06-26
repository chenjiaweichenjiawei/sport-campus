package com.example.serviceback.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 校验规则配置
 * @author CJW
 * @since 2024/4/11
 */
@Configuration
public class ValidatorConfig {

    /**
     * validation默认会校验完所有字段，然后返回所有的验证失败信息。
     * 开启Fail Fast模式，只要有一个验证失败就立即返回
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation
                .byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
