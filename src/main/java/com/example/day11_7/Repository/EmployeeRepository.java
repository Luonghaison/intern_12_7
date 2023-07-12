package com.example.day11_7.Repository;

import com.example.day11_7.Model.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //sử dụng annotation @Modifying để đánh dấu rằng phương thức updateEmployee() sẽ thực hiện các thao tác cập nhật dữ liệu
//    @Modifying
//    @Query("UPDATE Employee e SET e.name = :name, e.email = :email,e.department = :department WHERE e.id = :id")
//    void updateEmployee(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("department") String department);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE %:name%")
    List<Employee> findByNameContainingIgnoreCase(String name);
}
