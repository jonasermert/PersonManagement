package de.jonasermert.personmanagement;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class MainView extends VerticalLayout {


    public MainView(@Autowired PersonRepository personRepository) {
        long quantity = 0;
        String titel = "Persons (" + quantity + ")";
        add(new Text(titel));

        Button insertButton = new Button(new Icon(VaadinIcon.PLUS));
        insertButton.addClickListener(event -> {
            Person person = new Person();
            person.setName("Jonas Ermert");
            personRepository.insert(person);
        });
        add(insertButton);

        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(personRepository.findAll());
        grid.setColumns("id", "name");
        add(grid);
    }
}
