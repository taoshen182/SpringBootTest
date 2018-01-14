package com.wangtao.data.jpa;

import com.google.common.collect.Lists;
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

import static com.google.common.collect.Iterators.toArray;


/**
 * Created by want on 2018-1-14.
 * 结合Specification和Repository
 */
public class CustomerSpec {
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                List<Predicate> predicateList = new ArrayList<>();
                ArrayList<Predicate> predicateList = Lists.newArrayList();
                EntityType<T> entity = entityManager.getMetamodel().entity(type);

                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                    Object value = getValue(example, attr);
                    if (value != null) {
                        if (attr.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(value)) {
                                predicateList.add(cb.like(root.get(attribute(entity, attr.getName(), String.class)), pattern((String) value)));
                            }
                        } else {
                            predicateList.add(cb.equal(root.get(attribute(entity, attr.getName(), value.getClass())), value));
                        }
                    }
                }

                return predicateList.isEmpty() ? cb.conjunction() : cb.and(toArray(predicateList.iterator(), Predicate.class));
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
        System.out.println("str = " + str);
        return "%" + str + "%";
    }
}
