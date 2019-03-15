/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbexample.DAO;

import Entities.Register;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pmotel
 */
public class SelectBd {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public List<Register> allRegisters() throws SQLException {

        List<Register> registers = null;

        try {

            String FIND_ALl_QUERY = "SELECT * FROM register";
            conn = ConexaoBd.getConexaoMySQL();
            ps = conn.prepareStatement(FIND_ALl_QUERY);
            rs = ps.executeQuery();

            if (rs.first()) {
                registers = new ArrayList<>();
                do {
                    Register register = new Register(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                    registers.add(register);

                } while (rs.next());
            }
        } catch (SQLException e) {
            out.println(e);
        }
        return registers;
    }
}
