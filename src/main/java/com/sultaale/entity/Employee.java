package com.sultaale.entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "staff")  //AP : в pojo классе желательно переопределять equals / hashcode
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;  //АР для id предпочтительнее использование long

        @Column(name = "name")
        private String name;

        @Column(name = "surname")
        private String surname;

        @ManyToOne
        @JoinColumn(name = "role_id", referencedColumnName = "id")
        private Role role;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "staff_projects",
        joinColumns = @JoinColumn(name= "staff_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id"))
        private List<Project> projects;

        public Employee() {}

        public Employee(int id, String name, String surname,Role role) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.role = role;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Role getRole() {
            return role;  }

        public void setRole(Role role) {
            this.role = role;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                '}';
    }
}
