package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===TEST1: Seller findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: insert =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update =====");
        department = departmentDao.findById(1);
        department.setName("Carros");
        departmentDao.update(department);
        System.out.println("Update Complete!");

        System.out.println("\n=== TEST 5: seller delete =====");
        System.out.println("Selecione id para deleção");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete complete");
    }
}
