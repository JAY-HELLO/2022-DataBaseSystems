import javax.naming.NamingEnumeration;
import java.io.InputStream;
import java.sql.*;
import java.io.InputStream;
import java.util.Scanner;

public class Test {

    public static void main(String args[])
    {

        Connection con;
        Statement stmt;
        ResultSet rs;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.3:4567/madang",
                    "jjlee","root");

            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM Book");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+
                        " "+rs.getString(3));
            con.close();

            Scanner scan = new Scanner(System.in);
            Integer menu = 0;
            Integer tmp = 4;
            do{
                System.out.println("원하는 번호를 입력하세요\n");

                System.out.println("1. 데이터 삽입\n");
                System.out.println("2. 데이터 삭제\n");
                System.out.println("3. 데이터 검색\n");
                System.out.println("0. 종료\n");
                menu = scan.nextInt();

                if(menu==0){
                    break;
                }else if(menu==1){
                    insert();
                    select_All();
                }else if(menu==2){
                    delete();
                    select_All();
                }else if (menu==3){
                    search();
                }

            }while(true);

        }catch(Exception e){ System.out.println(e);}


    }
    public static void insert() {

        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        String id;
        String bookname;
        String publisher;
        String price;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.3:4567/madang",
                    "jjlee", "root");

            String sql = "insert into Book values(?,?,?,?)";
            stmt = con.prepareStatement(sql);

            Scanner scan = new Scanner(System.in);
            System.out.println("추가할 책 id를 입력하세요 : ");
            id = scan.nextLine();
            System.out.println("추가할 책 name을 입력하세요 : ");
            bookname = scan.nextLine();
            System.out.println("추가할 책 publisher 입력하세요 : ");
            publisher = scan.nextLine();
            System.out.println("추가할 책 price를 입력하세요 : ");
            price = scan.nextLine();

            stmt.setInt(1, Integer.parseInt(id));
            stmt.setString(2, bookname);
            stmt.setString(3, publisher);
            stmt.setString(4, price);

            int result = stmt.executeUpdate();
            if(result ==1) System.out.println("inset 저장 성공!");
            else System.out.println("저장 실패");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void delete() {

        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        String id;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.3:4567/madang",
                    "jjlee", "root");

            String sql = "delete from Book where bookid=?";
            stmt = con.prepareStatement(sql);

            Scanner scan = new Scanner(System.in);
            System.out.println("삭제 책 id를 입력하세요 : ");
            id = scan.nextLine();
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void select_All() {

        Connection con;
        Statement stmt= null;
        ResultSet rs;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.3:4567/madang",
                    "jjlee", "root");
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM Book");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+
                        " "+rs.getString(3));
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void search(){
        Connection con;
        Statement stmt;
        ResultSet rs;

        String name;

        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("검색할 책 name을 입력하세요 : ");
            name = scan.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.3:4567/madang",
                    "jjlee", "root");

            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM Book WHERE bookname LIKE '%"+name+"%'");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+
                        " "+rs.getString(3));
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
