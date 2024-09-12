# JavaFX User Management System

##  Description

This project is a user management system developed in Java that uses JavaFX for the user interface, JPA (Hibernate) for data persistence, and MySQL as a database. The system is designed to manage users with different roles and provides customized views depending on the user's role.

## Main Features

- User Authentication**: Users can log into the system with their credentials.
- Role Management**: The system supports multiple user roles with different access levels:
  - **Regular User**: You can view a list of existing users and upload new users.
  - Administrator**: In addition to the functionality of a regular user, you can update data, delete users, create new users and log out of the system.
- Dynamic User Interface**: The view adjusts dynamically according to the user's role, displaying different options and functionalities.
- Data Persistence**: Uses JPA with Hibernate to handle data persistence in a MySQL database.
- Design with SceneBuilder**: The user interface is built using SceneBuilder to facilitate the visual design of the views.

## Technologies Used

- JavaFX**: For the creation of the graphical user interface.
- JPA (Hibernate)**: For persistence and data management.
- MySQL**: As database management system.
- SceneBuilder**: For the design and layout of the application views.

## Project Structure

1. **User Interface (JavaFX)**: 
   - Views and controllers defined in FXML files.
   - Visual design made with SceneBuilder.

2. **Data Persistence (JPA/Hibernate)**:
   - Entities mapped to database tables.
   - CRUD (Create, Read, Update, Delete) operations implemented through JPA.

3. **Database (MySQL)**:
   - Database schema with tables for users and roles.
   - Connection configuration and data management through Hibernate.
     
## Images

 ![Screenshot 2024-09-12 011642](https://github.com/user-attachments/assets/c7a26507-21e8-48f1-846c-c0e6311ef0ac)

![Screenshot 2024-09-12 012749](https://github.com/user-attachments/assets/cf2bea2e-d1f0-47bf-b682-a509d20caf90)

![Screenshot 2024-09-12 011700](https://github.com/user-attachments/assets/345289d6-7895-4dce-bbc1-f661fff6f9e3)

![Screenshot 2024-09-12 011728](https://github.com/user-attachments/assets/70dc19ae-6cfe-4b92-be89-9c4c00486335)

![Screenshot 2024-09-12 012756](https://github.com/user-attachments/assets/fe835703-d236-4477-bf65-006265a28fa4)
