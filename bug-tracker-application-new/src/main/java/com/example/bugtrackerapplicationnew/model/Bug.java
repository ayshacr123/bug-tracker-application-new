package com.example.bugtrackerapplicationnew.model;
import javax.persistence.*;


    @Entity
    @Table(name = "bugs")
    public class Bug {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @ManyToOne
        @JoinColumn(name = "project_id", nullable = false)
        private Project project;

        @Column(nullable = false)
        private String status;

        public Bug(Long id, String name, Project project, String status) {
            this.id = id;
            this.name = name;
            this.project = project;
            this.status = status;
        }

        public Bug() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        // Constructors, getters, and setters

        // ...
    }


