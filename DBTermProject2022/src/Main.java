import java.sql.*;
import java.util.List;
import java.util.Scanner;

import DAO.userDAOImpl;
import DTO.userDTO;

public class Main {
    static userDAOImpl dimpl = new userDAOImpl();
    static List<userDTO> result;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        Integer menu = 0;
        do{
            System.out.println("///////////////////////////////////////////////");
            System.out.println("WITH Double_J 관심종목 프로그램에 오신 것을 환영합니다.");
            System.out.println("1. 사용자 생성");
            System.out.println("2. 사용자 목록보기");
            System.out.println("///////////////////////////////////////////////");

            menu = scan.nextInt();
            if(menu==0){
                break;
            }else if(menu == 1){

            }else if(menu == 2){
                result = dimpl.select();
                for(userDTO i:result){
                    System.out.print("사용자 고유번호 : "+i.getUssn());
                    System.out.print("// 사용자 이름 : "+i.getName());
                    System.out.print("// 사용자 번호 : "+i.getPhone());
                    System.out.println(" ");
                }

            }
        }while(true);

    }
    /*
    public static List<userDTO> selectAll() throws SQLException, ClassNotFoundException {

            Connection con;
            Statement stmt;
            ResultSet rs;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.3:4567/db_project",
                    "jjlee","root");

            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM user");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+
                        " "+rs.getString(3));
            con.close();

        return dimpl.select();
    }
    */
}