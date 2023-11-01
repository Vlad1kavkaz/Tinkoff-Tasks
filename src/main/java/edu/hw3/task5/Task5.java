package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Task5 {
    private static final Comparator<Contact> COMPARATOR = Contact::compareTo;

    private enum SortingOrder {
        ASC, DESC
    }

    private Task5() {
    }

    public static List<Contact> parseContacts(String[] names, @NotNull String order) {
        if (names == null || names.length == 0) {
            return new ArrayList<>();
        }

        List<Contact> resultContacts = new ArrayList<>(names.length);
        String[] nameAndSurname;

        for (String person : names) {
            nameAndSurname = person.trim().split(" ");

            switch (nameAndSurname.length) {
                case 2:
                    resultContacts.add(new Contact(nameAndSurname[0], nameAndSurname[1]));
                    break;
                case 1:
                    resultContacts.add(new Contact(nameAndSurname[0]));
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Input strings must contain name and surname or name without surname");
            }
        }

        SortingOrder sortingOrder = SortingOrder.valueOf(order);
        switch (sortingOrder) {
            case ASC -> resultContacts.sort(COMPARATOR);
            case DESC -> resultContacts.sort(COMPARATOR.reversed());
            default -> throw new IllegalArgumentException("Order must be 'ASC' or 'DESC'");
        }

        return resultContacts;
    }
}
