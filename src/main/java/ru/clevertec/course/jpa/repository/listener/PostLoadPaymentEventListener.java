package ru.clevertec.course.jpa.repository.listener;

import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;
import ru.clevertec.course.jpa.model.domain.Payment;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class PostLoadPaymentEventListener implements PostLoadEventListener {

    private static final Set<String> baseEntityNames = Set.of("paymentTo", "paymentType", "paymentFrom");

    @Override
    public void onPostLoad(PostLoadEvent event) {
        Object entity = event.getEntity();
        if (entity instanceof Payment payment) {
            EntityPersister persister = event.getPersister();
            String[] propertyNames = persister.getPropertyNames();

            Map<String, Object> fieldsMap = new HashMap<>();
            for (String propertyName : propertyNames) {
                if (!baseEntityNames.contains(propertyName)) {
                    Object propertyValue = persister.getPropertyValue(payment, propertyName);
                    fieldsMap.put(propertyName, propertyValue);
                }

            }

            payment.setArgs(fieldsMap);
        }
    }
}