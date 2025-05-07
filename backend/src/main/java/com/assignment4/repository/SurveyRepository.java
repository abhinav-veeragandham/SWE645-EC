// TEAM MEMBERS:

// Abhinav Veeragandham - G01515455
// Pranav Vangavety - G01511443
// Charan Sri Sai Devalla - G01504177
// Bhogeswara Pathakamudi - G01507114
// Durga Shankar Kondaveeti - G01510533
// Chinmaya Raz Vaiisshnav Maddi - G01504185
// Naga Venkata Sai Chennu - G01514409
// Abhiram Kolisetty - G01506075

// This is a Java Interface which is used to interact with MySQL database directly.

package com.assignment4.repository;

import com.assignment4.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}