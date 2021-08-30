package com.example.demo.config;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.toArray;


/**
 * @NAME: CustomerSpecs
 * @USER: 77027
 * @DATE: 2020/12/3
 * @TIME: 10:54
 */
public class CustomerSpecs {
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        //获取当前实体类对象类的类型
        final Class<T> type = (Class<T>) example.getClass();

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //新建Predicate列表存储构造的查询条件
                List<Predicate> predicates = new ArrayList<>();
                //获取实体类的EntityType
                EntityType<T> entity = entityManager.getMetamodel().entity(type);
                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                    Object attrValue = getValue(example, attr);
                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(attrValue)) {
                                predicates.add(criteriaBuilder.like(root.get(attribute(entity, attr.getName(), String.class)), pattern((String) attrValue)));

                            }
                        }else {
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())), attrValue));

                        }
                    }
                }

                return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(toArray(predicates, Predicate.class));
            }

            private <T> Object getValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
            }
        };
    }



    private static String pattern(String str) {
        return "%" + str + "%";
    }
}
