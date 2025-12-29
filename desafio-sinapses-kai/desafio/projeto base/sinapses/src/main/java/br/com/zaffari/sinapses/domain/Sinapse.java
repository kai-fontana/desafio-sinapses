package br.com.zaffari.sinapses.domain;
import jakarta.persistence.*;

import java.time.LocalDate;

/*PRECISO FAZER UM DTO*/

@Entity(name = "sinapses")
@Table(name = "sinapses")
public class Sinapse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected Integer registration;
    protected String title;
    protected String description;
    protected String category;

    protected LocalDate date;

    protected String link;

    protected String keyword;

    public Sinapse() {}

    public Sinapse(Long id, Integer registration, String title, String description, String category, LocalDate date,
    String link, String keyword) {
        this.id = id;
        this.registration = registration;
        this.title = title;
        this.description = description;
        this.category = category;
        this.date = date;
        this.link = link;
        this.keyword = keyword;
    }


    public Sinapse(RequestSinapse requestSinapse){
        this.id = requestSinapse.id();
        this.title = requestSinapse.title();
        this.description = requestSinapse.description();
        this.registration = requestSinapse.registration();
        this.category = requestSinapse.category();
        this.date  = requestSinapse.date();
        this.link = requestSinapse.link();
        this.keyword = requestSinapse.keyword();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getRegistration() {
        return registration;
    }


    public void setRegistration(Integer registration) {
        this.registration = registration;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getLink() {
        return link;
    }


    public void setLink(String link) {
        this.link = link;
    }


    public String getKeyword() {
        return keyword;
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    

}