package DAO;
import DTO.userDTO;

import java.sql.SQLException;
import java.util.List;
import dbconnect.userCommon;
public interface userDAO {
    int insert(userDTO userDTO) throws SQLException;
    List<userDTO> select() throws SQLException;

}
